package Market.controller;

import java.util.ArrayList;
import java.util.List;

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

import Market.model.*;
import Market.repository.*;

@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:3000", "http://localhost:3001" })
@RestController
@RequestMapping("/api")

public class KhachHangController {	
	@Autowired
	KhachHangRepository repo;
	
	@Autowired
	GianHangRepository repo1;
	
	@Autowired
	DonHangRepository repo2;
	
	@GetMapping("/khachhang/gh_gannhat/{id}")
	public ResponseEntity<List<GianHang>> GianHangGanNhat(@PathVariable("id") String id){
		try {			
			KhachHang kh = new KhachHang();
			kh = repo.findById(id).get();
			List<GianHang> dsGianHang = new ArrayList<GianHang>();
			repo1.searchByWard(kh.getPhuongxa_kh(), kh.getQuanhuyen_kh(), kh.getThanhpho_kh()).forEach(dsGianHang::add);
			repo1.searchByDistrict(kh.getPhuongxa_kh(), kh.getQuanhuyen_kh(), kh.getThanhpho_kh()).forEach(dsGianHang::add);
			if (dsGianHang.isEmpty())
			{
				repo1.searchByCity(kh.getThanhpho_kh()).forEach(dsGianHang::add);
			}
			if (dsGianHang.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(dsGianHang, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@GetMapping("/khachhang/donhang/{id}")
	public ResponseEntity<List<DonHang>> LichSuMuaHang(@PathVariable("id") String id){
		try {
			List<DonHang> dsDonHang = new ArrayList<DonHang>();
			repo2.findByKhachHangId(id).forEach(dsDonHang::add);
			if (dsDonHang.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(dsDonHang, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/dangky")
	public ResponseEntity<KhachHang> DangKy(@RequestBody KhachHang khachhang){
		try {
			KhachHang _khachhang = repo.save(new KhachHang(khachhang.getMakhachhang(), khachhang.getHoten_kh(), khachhang.getCmnd_kh(),
					khachhang.getNgaysinh_kh(), khachhang.getGioitinh_kh(), khachhang.getSonha_kh(), khachhang.getPhuongxa_kh(),
					khachhang.getQuanhuyen_kh(), khachhang.getThanhpho_kh(), khachhang.getSodienthoai_kh(), khachhang.getTendangnhap(),
					khachhang.getMatkhau()));
			return new ResponseEntity<>(_khachhang, HttpStatus.CREATED);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
