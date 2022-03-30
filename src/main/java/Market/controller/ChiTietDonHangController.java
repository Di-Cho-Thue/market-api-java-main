package Market.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Market.model.ChiTietDonHang;
import Market.model.GioHang;
import Market.repository.ChiTietDonHangRepository;

@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:3000" })
@RestController
@RequestMapping("/api")

public class ChiTietDonHangController {
	@Autowired
	ChiTietDonHangRepository repo;
	
	@GetMapping("/chitietdonhang/sanpham/getAll")
	public ResponseEntity<List<ChiTietDonHang>> ThongKeMatHangThietYeu() {
		try {
			List<ChiTietDonHang> dsChiTietDonHangs = new ArrayList<ChiTietDonHang>();
			List<ChiTietDonHang> repoChiTietDonHangs = repo.findAll();

			if (repoChiTietDonHangs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				for (Iterator<ChiTietDonHang> chitietdonHangI = repoChiTietDonHangs.iterator(); chitietdonHangI.hasNext();) {
					ChiTietDonHang chitietdonHang = (ChiTietDonHang) chitietdonHangI.next();
					dsChiTietDonHangs.add(chitietdonHang);
				}
			}
			return new ResponseEntity<>(dsChiTietDonHangs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/chitietdonhang/donhang/{madonhang}")
	public ResponseEntity<List<ChiTietDonHang>> LayDanhSachSPCuaDH(@PathVariable("madonhang") String madonhang) {
		try {
			List<ChiTietDonHang> chitietdonhang = new ArrayList<ChiTietDonHang>();
			repo.findbyMaDH(madonhang).forEach(chitietdonhang::add);
			if (chitietdonhang.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} 
			return new ResponseEntity<>(chitietdonhang, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/chitietdonhang/{madonhang}/{masanpham}")
	public ResponseEntity<List<ChiTietDonHang>> LaySanPhamTheoDonHang(@PathVariable("madonhang") String madonhang,@PathVariable("masanpham") String masanpham) {
		try {
			List<ChiTietDonHang> chitietdonhang = new ArrayList<ChiTietDonHang>();
			repo.DonHangByMaSanPham(madonhang, masanpham).forEach(chitietdonhang::add);
			if (chitietdonhang.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(chitietdonhang, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
