package Market.controller;

import java.util.Optional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
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

import Market.model.DonHang;
import Market.model.GianHang;
import Market.model.NguoiGiaoHang;
import Market.repository.DonHangRepository;

@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:3000" })
@RestController
@RequestMapping("/api")

public class DonHangController {
	@Autowired
	DonHangRepository repo;

	@GetMapping("/donhang/khachhang/{id}")
	public ResponseEntity<List<DonHang>> XemLichSuMuaHang(@PathVariable("id") String id) {
		try {
			List<DonHang> dsDonHang = new ArrayList<DonHang>();
			repo.findByKhachHangId(id).forEach(dsDonHang::add);
			if (dsDonHang.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(dsDonHang, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/donhang/admin/getAll")
	public ResponseEntity<List<DonHang>> LayTatCaDonHangAdmin() {
		try {
			List<DonHang> dsDonHangs = new ArrayList<DonHang>();
			List<DonHang> repoDonHangs = repo.findAll();

			if (repoDonHangs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				for (Iterator<DonHang> donHangI = repoDonHangs.iterator(); donHangI.hasNext();) {
					DonHang donHang = (DonHang) donHangI.next();
					donHang.getHoaHongDonhang(donHang.getTongtien(), donHang.getTinhtrangdon());
					dsDonHangs.add(donHang);
				}
			}
			return new ResponseEntity<>(dsDonHangs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/donhang/shipper/hoahong/{id}")
	public ResponseEntity<BigDecimal> LayHoaHongDonHang(@PathVariable("id") String id) {
		try {
			DonHang donHang = repo.findByMaDonHang(id);
			System.out.println(donHang);
			if (donHang == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<BigDecimal>(
					donHang.getHoaHongDonhang(donHang.getTongtien(), donHang.getTinhtrangdon()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/donhang/shipper/{id}")
	public ResponseEntity<List<DonHang>> LayDanhSachDonHangTheoNguoiGiaoHang(@PathVariable("id") String id) {
		try {
			List<DonHang> dsDonHangs = repo.findByNguoiGiaoHangId(id);
			List<DonHang> resultDonHangs = new ArrayList<DonHang>();
			if (dsDonHangs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				for (Iterator<DonHang> donHangI = dsDonHangs.iterator(); donHangI.hasNext();) {
					DonHang donHang = (DonHang) donHangI.next();
					donHang.getHoaHongDonhang(donHang.getTongtien(), donHang.getTinhtrangdon());
					resultDonHangs.add(donHang);
				}
				return new ResponseEntity<List<DonHang>>(resultDonHangs, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/donhang/shipper/hoahong/sumAll/{id}")
	public ResponseEntity<BigDecimal> LayTongHoaHong(@PathVariable("id") String id) {
		try {
			List<DonHang> dsDonHang = repo.findByNguoiGiaoHangId(id);
			BigDecimal hoahong = new BigDecimal(0);
			if (dsDonHang.isEmpty()) {
				return new ResponseEntity<BigDecimal>(new BigDecimal(0), HttpStatus.OK);
			}
			for (Iterator<DonHang> i = dsDonHang.iterator(); i.hasNext();) {
				DonHang donHang = (DonHang) i.next();
				donHang.getHoaHongDonhang(donHang.getTongtien(), donHang.getTinhtrangdon());
				hoahong = donHang.getHoahong().add(hoahong);
			}
			return new ResponseEntity<BigDecimal>(hoahong, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/donhang/shipper/hoahong/sumMonth/{id}/{month}/{year}")
	public ResponseEntity<BigDecimal> LayTongHoaHongTheoThang(@PathVariable("id") String id,
			@PathVariable("month") Integer month, @PathVariable("year") Integer year) {
		if (id.isEmpty() || month == null || year == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		if (month < 1 || month > 12) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		if (year < 2019) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		try {
			List<DonHang> dsDonHang = repo.findByNguoiGiaoHangId(id);
			if (dsDonHang.isEmpty()) {
				return new ResponseEntity<BigDecimal>(new BigDecimal(0), HttpStatus.OK);
			}
			BigDecimal hoahong = new BigDecimal(0);
			for (Iterator<DonHang> i = dsDonHang.iterator(); i.hasNext();) {
				DonHang donHang = (DonHang) i.next();
				if (donHang.getNgaylapdon().getMonthValue() == month && donHang.getNgaylapdon().getYear() == year
						&& donHang.getCoTheNhanHoaHong() == true) {
					donHang.getHoaHongDonhang(donHang.getTongtien(), donHang.getTinhtrangdon());
					hoahong = donHang.getHoahong().add(hoahong);
				}
			}
			return new ResponseEntity<BigDecimal>(hoahong, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/donhang/khachhang/amountAll/{id}")
	public ResponseEntity<Integer> SoLuongSPTrongGioHang(@PathVariable("id") String id) {
		try {
			Integer amount = repo.countDonHangByKhachHang(id);
			return new ResponseEntity<Integer>(amount, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/donhang/kiemtra/{madonhang}")
	public ResponseEntity<Integer> KiemTraMaDonHangTonTai(@PathVariable("madonhang") String madonhang) {
		try {
			Integer amount = repo.checkMaDonHang(madonhang);
			return new ResponseEntity<Integer>(amount, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/donhang/huydonhang/{id}")
	public ResponseEntity<DonHang> UpdateGianHang(@PathVariable("id") String id) {
		DonHang DonHangData = repo.findByMaDonHang(id);
		if (DonHangData != null) {
			DonHang _DonHang = DonHangData;
			_DonHang.setMadonhang(DonHangData.getMadonhang());
			_DonHang.setHinhthucthanhtoan(DonHangData.getHinhthucthanhtoan());
			_DonHang.setNgaylapdon(DonHangData.getNgaylapdon());
			_DonHang.setTinhtrangdon("Đã hủy");
			_DonHang.setTongtien(DonHangData.getTongtien());
			_DonHang.setKhuyenmai(DonHangData.getKhuyenmai());
			_DonHang.setMakhachhang(DonHangData.getMakhachhang());
			_DonHang.setManguoigiaohang(DonHangData.getManguoigiaohang());
			_DonHang.setGianhang(DonHangData.getGianhang());
			_DonHang.setHoahong(DonHangData.getHoahong());
			return new ResponseEntity<>(repo.save(_DonHang), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/donhang/{madonhang}")
	public ResponseEntity<DonHang> LayTTDonHang(@PathVariable("madonhang") String madonhang) {
		try {
			if (madonhang.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			DonHang _DonHang = repo.findByMaDonHang(madonhang);
			if (_DonHang == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(_DonHang, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/ktdanhgia/{madonhang}")
	public ResponseEntity<Integer> KTDanhGia(@PathVariable("madonhang") String madonhang) {
		try {
			if (madonhang.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Integer i = repo.checkDanhGia(madonhang);
			return new ResponseEntity<Integer>(i, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
