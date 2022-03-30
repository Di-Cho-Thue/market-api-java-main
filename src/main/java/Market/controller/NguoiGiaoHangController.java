package Market.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Market.model.NguoiGiaoHang;
import Market.payload.response.MessageResponse;
import Market.repository.NguoiGiaoHangRepository;

@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:3000", "http://localhost:3001" })
@RestController
@RequestMapping("/api")
public class NguoiGiaoHangController {
    @Autowired
    NguoiGiaoHangRepository repo;

    @PostMapping("/nguoigiaohang/signup")
    public ResponseEntity<NguoiGiaoHang> DangKiNguoiGiaoHang(@RequestBody NguoiGiaoHang nguoigiaohang) {
        try {
            if (nguoigiaohang.getCmnd_ngh().isEmpty() || nguoigiaohang.getSonha_ngh().isEmpty()
                    || nguoigiaohang.getHoten_ngh().isEmpty() || nguoigiaohang.getPhuongxa_ngh().isEmpty()
                    || nguoigiaohang.getQuanhuyen_ngh().isEmpty() || nguoigiaohang.getThanhpho_ngh().isEmpty()
                    || nguoigiaohang.getSodienthoai_ngh().isEmpty() || nguoigiaohang.getGiaypheplaixe().isEmpty()
                    || nguoigiaohang.getGiayxacnhanamtinh().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            NguoiGiaoHang _NguoiGiaoHang = repo.save(new NguoiGiaoHang(UUID.randomUUID().toString().substring(0, 7),
                    nguoigiaohang.getHoten_ngh(), nguoigiaohang.getCmnd_ngh(), nguoigiaohang.getNgaysinh_ngh(),
                    nguoigiaohang.getGioitinh_ngh(), nguoigiaohang.getSonha_ngh(), nguoigiaohang.getPhuongxa_ngh(),
                    nguoigiaohang.getQuanhuyen_ngh(), nguoigiaohang.getThanhpho_ngh(),
                    nguoigiaohang.getSodienthoai_ngh(), 0, nguoigiaohang.getGiaypheplaixe().toString().substring(0, 10),
                    nguoigiaohang.getGiayxacnhanamtinh().toString().substring(0, 10), "Chưa duyệt", "Tạm nghỉ"));
            return new ResponseEntity<>(_NguoiGiaoHang, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);

            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/nguoigiaohang/update/{manguoigiaohang}")
    public ResponseEntity<?> ChapNhanNguoiGiaoHang(@PathVariable("manguoigiaohang") String manguoigiaohang,
            @RequestBody NguoiGiaoHang nguoigiaohang) {
        try {
            if (manguoigiaohang.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            NguoiGiaoHang _NguoiGiaoHang = repo.findByMaNguoiGiaoHang(manguoigiaohang);
            if (_NguoiGiaoHang == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            _NguoiGiaoHang.setTinhtrangduyet(nguoigiaohang.getTinhtrangduyet());
            _NguoiGiaoHang.setTinhtranghoatdong(nguoigiaohang.getTinhtranghoatdong());

            repo.save(_NguoiGiaoHang);
            return new ResponseEntity<NguoiGiaoHang>(_NguoiGiaoHang, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse("Số điện thoại hoặc số chứng minh đã tồn tại"));
        }
    }

    @GetMapping("/nguoigiaohang/{manguoigiaohang}")
    public ResponseEntity<NguoiGiaoHang> LayThongTinNguoiGiaoHang(
            @PathVariable("manguoigiaohang") String manguoigiaohang) {
        try {
            if (manguoigiaohang.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            NguoiGiaoHang _NguoiGiaoHang = repo.findByMaNguoiGiaoHang(manguoigiaohang);
            if (_NguoiGiaoHang == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(_NguoiGiaoHang, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
