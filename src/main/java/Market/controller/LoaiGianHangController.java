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

import Market.model.LoaiGianHang;
import Market.repository.LoaiGianHangRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")

public class LoaiGianHangController {
	@Autowired
	LoaiGianHangRepository repo;
	
	@GetMapping("/loaigianhang")
	public ResponseEntity<List<LoaiGianHang>> XemDanhSachLoaiGianHang() {
		try {
			List<LoaiGianHang> dsloaigianhang = new ArrayList<LoaiGianHang>();
			repo.findAll().forEach(dsloaigianhang::add);
			if (dsloaigianhang.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			return new ResponseEntity<>(dsloaigianhang, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			} 
		}
	
	@PostMapping("/loaigianhang")
	public ResponseEntity<LoaiGianHang> CreateProduct(@RequestBody LoaiGianHang loaigianhang) {
		try {
			LoaiGianHang _loaigianhang = repo.save(new LoaiGianHang(loaigianhang.getMaloaigianhang(),loaigianhang.getTenloaigianhang()
					));
			return new ResponseEntity<>(_loaigianhang, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
				} 
	}
	
	@PutMapping("/loaigianhang/{id}")
	public ResponseEntity<LoaiGianHang> UpdateLoaiGianHang(@PathVariable("id") String id, @RequestBody LoaiGianHang loaigianhang) {
		Optional<LoaiGianHang> LoaiGianHangData = repo.findById(id);
		if (LoaiGianHangData.isPresent()) {
		LoaiGianHang _LoaiGianHang = LoaiGianHangData.get();
		_LoaiGianHang.setMaloaigianhang(loaigianhang.getMaloaigianhang());
		_LoaiGianHang.setTenloaigianhang(loaigianhang.getTenloaigianhang());
		return new ResponseEntity<>(repo.save(_LoaiGianHang), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	@DeleteMapping("/loaigianhang/{id}")
	public ResponseEntity<HttpStatus> DeleteOneLoaiGianHang(@PathVariable("id") String id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				} 
		}
}
