package Market.controller;

import java.util.ArrayList;
import java.util.List;

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

import Market.model.GioHang;
import Market.repository.GioHangRepository;

@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:3000" })
@RestController
@RequestMapping("/api")

public class GioHangController {
	@Autowired
	GioHangRepository repo;
	
	@GetMapping("/giohang/khachhang/amountAll/{id}")
	public ResponseEntity<Integer> SoLuongSPTrongGioHang(@PathVariable("id") String id) {
		try {
			Integer amount = repo.countSanPhamByKhachHang(id);
			return new ResponseEntity<Integer>(amount, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/giohang/khachhang/sumDonGia/{id}")
	public ResponseEntity<Double> TongTienTrongGioHang(@PathVariable("id") String id) {
		try {
			Double sum = repo.sumDonGiaGioHang(id);
			return new ResponseEntity<Double>(sum, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/giohang/khachhang/{id}")
	public ResponseEntity<List<GioHang>> LayDanhSachGioHangTheoKhachHang(@PathVariable("id") String id) {
		try {
			List<GioHang> dsGioHang = new ArrayList<GioHang>();
			repo.listGioHang(id).forEach(dsGioHang::add);
			if (dsGioHang.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(dsGioHang, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/giohang")
	public ResponseEntity<GioHang> ThemGioHang(@RequestBody GioHang giohang) {
		try {
			List<GioHang> dsGioHang = new ArrayList<GioHang>();
			repo.GioHangByMaSanPham(giohang.getMakhachhang(), giohang.getMasanpham()).forEach(dsGioHang::add);
			if(dsGioHang.size() != 0)
			{
				repo.createSoLuongCuaGioHang(giohang.getMakhachhang(), giohang.getMasanpham(), giohang.getSoluong());
			}
			else
			{
				repo.addGioHang(giohang.getMakhachhang(), giohang.getMasanpham(), giohang.getSoluong());
			}
			return new ResponseEntity<>(giohang, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
			} 
	}
	
	@PutMapping("/giohang/soluong/{makhachhang}/{masanpham}/{soluong}")
	public ResponseEntity<HttpStatus> UpdateSoLuongSanPham(@PathVariable("makhachhang") String makhachhang,
			@PathVariable("masanpham") String masanpham, @PathVariable("soluong") int soluong) {
		try {
			List<GioHang> dsGioHang = new ArrayList<GioHang>();
			repo.GioHangByMaSanPham(makhachhang , masanpham).forEach(dsGioHang::add);
			if(dsGioHang.size() != 0)
			{
				repo.updateSoLuongCuaGioHang(makhachhang, masanpham, soluong);
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
			} 
		}
	
	@DeleteMapping("/giohang/{makhachhang}/{masanpham}")
	public ResponseEntity<HttpStatus> DeleteOneNhanVien(@PathVariable("makhachhang") String makhachhang,
			@PathVariable("masanpham") String masanpham) {
		try {
			List<GioHang> dsGioHang = new ArrayList<GioHang>();
			repo.GioHangByMaSanPham(makhachhang , masanpham).forEach(dsGioHang::add);
			if(dsGioHang.size() != 0)
			{
				repo.deleteSanPhamTrongGioHang(makhachhang, masanpham);
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			} 
	}
}
