package Market.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Market.model.NhanVien;
import Market.repository.NhanVienRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")

public class NhanVienController {
	@Autowired
	NhanVienRepository repo;
	
	@GetMapping("/nhanvien")
	public ResponseEntity<List<NhanVien>> XemDanhSachNhanVien() {
		try {
			List<NhanVien> dsnhanvien = new ArrayList<NhanVien>();
			repo.findAll().forEach(dsnhanvien::add);
			if (dsnhanvien.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			return new ResponseEntity<>(dsnhanvien, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			} 
		}
	
	@PostMapping("/nhanvien")
	public ResponseEntity<NhanVien> CreateBook(@RequestBody NhanVien nhanvien) {
		try {
			NhanVien _nhanvien = repo.save(new NhanVien(nhanvien.getManhanvien(), nhanvien.getHoten_nv(), nhanvien.getCmnd_nv(), nhanvien.getNgaysinh_nv(),
					nhanvien.getGioitinh_nv(),nhanvien.getSonha_nv(), nhanvien.getPhuongxa_nv(), nhanvien.getQuanhuyen_nv(), 
					nhanvien.getThanhpho_nv(), nhanvien.getBophan()));
			return new ResponseEntity<>(_nhanvien, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
				} 
	}
	
	@PutMapping("/nhanvien/{id}")
	public ResponseEntity<NhanVien> UpdateNhanVien(@PathVariable("id") String id, @RequestBody NhanVien nhanvien) {
		Optional<NhanVien> NhanVienData = repo.findById(id);
		if (NhanVienData.isPresent()) {
		NhanVien _NhanVien = NhanVienData.get();
		_NhanVien.setManhanvien(nhanvien.getManhanvien());
		_NhanVien.setHoten_nv(nhanvien.getHoten_nv());
		_NhanVien.setCmnd_nv(nhanvien.getCmnd_nv());
		_NhanVien.setNgaysinh_nv(nhanvien.getNgaysinh_nv());
		_NhanVien.setGioitinh_nv(nhanvien.getGioitinh_nv());
		_NhanVien.setSonha_nv(nhanvien.getSonha_nv());
		_NhanVien.setPhuongxa_nv(nhanvien.getPhuongxa_nv());
		_NhanVien.setQuanhuyen_nv(nhanvien.getQuanhuyen_nv());
		_NhanVien.setThanhpho_nv(nhanvien.getThanhpho_nv());
		_NhanVien.setBophan(nhanvien.getBophan());
		return new ResponseEntity<>(repo.save(_NhanVien), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	@DeleteMapping("/nhanvien/{id}")
	public ResponseEntity<HttpStatus> DeleteOneNhanVien(@PathVariable("id") String id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				} 
		}
	

}
