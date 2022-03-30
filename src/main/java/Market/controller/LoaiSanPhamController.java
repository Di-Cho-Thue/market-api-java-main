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

import Market.model.LoaiSanPham;
import Market.repository.LoaiSanPhamRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")

public class LoaiSanPhamController {
	@Autowired
	LoaiSanPhamRepository repo;
	
	@GetMapping("/loaisanpham")
	public ResponseEntity<List<LoaiSanPham>> XemDanhSachLoaiSanPham() {
		try {
			List<LoaiSanPham> dsloaisanpham = new ArrayList<LoaiSanPham>();
			repo.findAll().forEach(dsloaisanpham::add);
			if (dsloaisanpham.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			return new ResponseEntity<>(dsloaisanpham, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			} 
		}
	
	@PostMapping("/loaisanpham")
	public ResponseEntity<LoaiSanPham> CreateProduct(@RequestBody LoaiSanPham loaisanpham) {
		try {
			LoaiSanPham _loaisanpham = repo.save(new LoaiSanPham(loaisanpham.getMaloaisanpham(),loaisanpham.getTenloaisanpham(),
					loaisanpham.getHinhanhloaisanpham()));
			return new ResponseEntity<>(_loaisanpham, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
				} 
	}
	
	@PutMapping("/loaisanpham/{id}")
	public ResponseEntity<LoaiSanPham> UpdateLoaiSanPham(@PathVariable("id") String id, @RequestBody LoaiSanPham loaisanpham) {
		Optional<LoaiSanPham> LoaiSanPhamData = repo.findById(id);
		if (LoaiSanPhamData.isPresent()) {
		LoaiSanPham _LoaiSanPham = LoaiSanPhamData.get();
		_LoaiSanPham.setMaloaisanpham(loaisanpham.getMaloaisanpham());
		_LoaiSanPham.setTenloaisanpham(loaisanpham.getTenloaisanpham());
		_LoaiSanPham.setHinhanhloaisanpham(loaisanpham.getHinhanhloaisanpham());
		return new ResponseEntity<>(repo.save(_LoaiSanPham), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	@DeleteMapping("/loaisanpham/{id}")
	public ResponseEntity<HttpStatus> DeleteOneLoaiSanPham(@PathVariable("id") String id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				} 
		}
}
