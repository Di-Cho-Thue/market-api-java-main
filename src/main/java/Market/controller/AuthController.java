package Market.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Market.model.User;
import Market.payload.request.LoginRequest;
import Market.payload.request.SignupRequest;
import Market.payload.response.UserInfoResponse;
import Market.payload.response.MessageResponse;
import Market.repository.GianHangRepository;
import Market.repository.KhachHangRepository;
import Market.repository.NguoiGiaoHangRepository;
import Market.repository.UserRepository;
import Market.jwt.JwtUtils;
import Market.services.UserDetailsImpl;

import java.util.Random;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    GianHangRepository gianHangRepository;

    @Autowired
    KhachHangRepository khachHangRepository;

    @Autowired
    NguoiGiaoHangRepository nguoiGiaoHangRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        System.out.println("loginRequest: " + new BCryptPasswordEncoder().encode(loginRequest.getPassword()));
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponse(userDetails.getID(),
                        userDetails.getUsername(),
                        roles.toArray()[0].toString()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()));

        String strRoles = signUpRequest.getRole();
        user.setRole(strRoles);

        user.setId(null);

        System.out.println("User: " + user.getId());
        System.out.println("User: " + user.getUsername());
        System.out.println("User: " + user.getPassword());
        System.out.println("User: " + user.getRole());
        userRepository.save(user);
        user.setPassword(null);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUserId(@RequestBody User user) {
        System.out.println("User: " + user.getId());
        System.out.println("User: " + user.getUsername());
        System.out.println("User: " + userRepository.existsByUsername(user.getUsername()));
        if (!userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: username not found!"));
        }
        Optional<User> user1 = userRepository.findByUsername(user.getUsername());

        if (user1.isPresent()) {
            if (!Objects.equals(user1.get().getId(), null)) {
                if (user1.get().getRole().equals("ROLE_SHIPPER")) {
                    nguoiGiaoHangRepository.xoaNguoiGiaoHang(user.getId());
                }
                if (user1.get().getRole().equals("ROLE_CUSTOMER")) {
                    khachHangRepository.xoaKhachHang(user.getId());
                }
                if (user1.get().getRole().equals("ROLE_STORE")) {
                    gianHangRepository.xoaGianHang(user.getId());
                }
                return ResponseEntity.badRequest().body(new MessageResponse("Đã đăng ký trước đó"));
            }
            User user2 = user1.get();
            user2.setId(user.getId());
            userRepository.updateIdUser(user2.getUsername(), user2.getId());
            user2.setPassword(null);
            return ResponseEntity.ok(user2);
        }

        return ResponseEntity.ok("User updated");
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }
}