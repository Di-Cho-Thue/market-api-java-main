package Market.controller;

import java.time.LocalDateTime;
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

import Market.model.DonHangDanhGia;
import Market.repository.DonHangDanhGiaRepository;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000", "http://localhost:3001"})
@RestController
@RequestMapping("/api")

public class DonHangDanhGiaController {
	@Autowired
	DonHangDanhGiaRepository repo;
	
	@GetMapping("/khdanhgia")
	public ResponseEntity<List<DonHangDanhGia>> XemDanhSachDanhGia() {
		try {
			List<DonHangDanhGia> dsdanhgia = new ArrayList<DonHangDanhGia>();
			repo.findAll().forEach(dsdanhgia::add);
			if (dsdanhgia.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			return new ResponseEntity<>(dsdanhgia, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			} 
		}
	
	@GetMapping("/khdanhgia/{id}")
	public ResponseEntity<List<DonHangDanhGia>> XemDanhSachDanhGiaTheoNguoiBan(@PathVariable("id") Iterable<String> id) {
		try {
			List<DonHangDanhGia> dsdanhgia = new ArrayList<DonHangDanhGia>();
			repo.findAllById(id).forEach(dsdanhgia::add);
			if (dsdanhgia.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			return new ResponseEntity<>(dsdanhgia, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			} 
		}
	
	@PostMapping("/khdanhgia")
	public ResponseEntity<DonHangDanhGia> CreateCusRating(@RequestBody DonHangDanhGia danhgia) {
		try {
			DonHangDanhGia _danhgia = repo.save(new DonHangDanhGia(danhgia.getMadanhgia(),danhgia.getBinhluan_ngh(),
					danhgia.getBinhluan_sanpham(),LocalDateTime.now(),danhgia.getSosao_ngh(),
					danhgia.getSosao_sanpham(),danhgia.getMadonhang()));
			return new ResponseEntity<>(_danhgia, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
				} 
	}
	

	@PutMapping("/khdanhgia/{id}")
	public ResponseEntity<DonHangDanhGia> UpdateDanhGia(@PathVariable("id") String id, @RequestBody DonHangDanhGia danhgia) {
		Optional<DonHangDanhGia> DanhGiaData = repo.findById(id);
		if (DanhGiaData.isPresent()) {
		DonHangDanhGia _DanhGia = DanhGiaData.get();
		_DanhGia.setMadanhgia(danhgia.getMadanhgia());
		_DanhGia.setBinhluan_ngh(danhgia.getBinhluan_ngh());
		_DanhGia.setBinhluan_sanpham(danhgia.getBinhluan_sanpham());
		_DanhGia.setNgaydanhgia(LocalDateTime.now());
		_DanhGia.setSosao_ngh(danhgia.getSosao_ngh());
		_DanhGia.setSosao_sanpham(danhgia.getSosao_sanpham());
		_DanhGia.setMadonhang(danhgia.getMadonhang());
		return new ResponseEntity<>(repo.save(_DanhGia), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	@DeleteMapping("/khdanhgia/{id}")
	public ResponseEntity<HttpStatus> DeleteOneDanhGia(@PathVariable("id") String id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				} 
		}
	

}
