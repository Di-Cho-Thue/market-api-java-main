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

import Market.model.SanPham;
import Market.repository.SanPhamRepository;

@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:3000", "http://localhost:3001" })
@RestController
@RequestMapping("/api")

public class SanPhamController {
	@Autowired
	SanPhamRepository repo;

	@GetMapping("/sanpham")
	public ResponseEntity<List<SanPham>> XemDanhSachSanPham() {
		try {
			List<SanPham> dssanpham = new ArrayList<SanPham>();
			repo.findAll().forEach(dssanpham::add);
			if (dssanpham.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(dssanpham, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/sanpham/{listid}")
	public ResponseEntity<List<SanPham>> XemDanhSachSanPhamTheoID(@PathVariable("listid") List<String> lmasp) {
		try {
			List<SanPham> dssanpham = new ArrayList<SanPham>();
			for (int i = 0; i < lmasp.size(); i++) {
				dssanpham.add(repo.SanPhamByMaSP(lmasp.get(i)));
			}
			if (dssanpham.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(dssanpham, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/sanpham/listsp")
	public ResponseEntity<List<SanPham>> XemDSSanPhamTheoID(@RequestBody List<SanPham> lmasp) {
		try {
			List<SanPham> dssanpham = new ArrayList<SanPham>();
			for (int i = 0; i < lmasp.size(); i++) {
				dssanpham.add(repo.SanPhamByMaSP((lmasp.get(i)).getMasanpham()));
			}
			if (dssanpham.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(dssanpham, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/sanpham/{id}")
	public ResponseEntity<List<SanPham>> XemDanhSachSanPhamTheoNguoiBan(@PathVariable("id") Iterable<String> id) {
		try {
			List<SanPham> dssanpham = new ArrayList<SanPham>();
			repo.findAllById(id).forEach(dssanpham::add);
			if (dssanpham.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(dssanpham, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/sanpham")
	public ResponseEntity<SanPham> CreateProduct(@RequestBody SanPham sanpham) {
		try {
			SanPham _sanpham = repo.save(new SanPham(sanpham.getMasanpham(), sanpham.getTensanpham(),
					sanpham.getGiasanpham(), sanpham.getDanhgiasanpham(), sanpham.getMotasanpham(),
					sanpham.getSoluongton(), sanpham.getTinhtrangduyet(), sanpham.getTinhtrangsanpham(),
					sanpham.getManhanvienduyet(), sanpham.getLoaisanpham(), sanpham.getGianhang(),
					sanpham.getHinhanh()));
			return new ResponseEntity<>(_sanpham, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/sanpham/file")
	public ResponseEntity<List<SanPham>> CreateListProduct(@RequestBody List<SanPham> dssanpham) {
		try {
			List<SanPham> _dssanpham = repo.saveAll(dssanpham);

			// SanPham _sanpham = repo.save(new
			// SanPham(sanpham.getMasanpham(),sanpham.getTensanpham(),
			// sanpham.getGiasanpham(),sanpham.getDanhgiasanpham(),sanpham.getMotasanpham(),
			// sanpham.getSoluongton(),sanpham.getTinhtrangduyet(),sanpham.getTinhtrangsanpham(),
			// sanpham.getManhanvienduyet(),sanpham.getLoaisanpham(),sanpham.getGianhang(),
			// sanpham.getHinhanh()));
			return new ResponseEntity<>(_dssanpham, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/sanpham/{id}")
	public ResponseEntity<SanPham> UpdateSanPham(@PathVariable("id") String id, @RequestBody SanPham sanpham) {
		Optional<SanPham> SanPhamData = repo.findById(id);
		if (SanPhamData.isPresent()) {
			SanPham _SanPham = SanPhamData.get();
			_SanPham.setMasanpham(sanpham.getMasanpham());
			_SanPham.setTensanpham(sanpham.getTensanpham());
			_SanPham.setGiasanpham(sanpham.getGiasanpham());
			_SanPham.setDanhgiasanpham(sanpham.getDanhgiasanpham());
			_SanPham.setMasanpham(sanpham.getMotasanpham());
			_SanPham.setSoluongton(sanpham.getSoluongton());
			_SanPham.setTinhtrangduyet(sanpham.getTinhtrangduyet());
			_SanPham.setTinhtrangsanpham(sanpham.getTinhtrangsanpham());
			_SanPham.setManhanvienduyet(sanpham.getManhanvienduyet());
			_SanPham.setLoaisanpham(sanpham.getLoaisanpham());
			_SanPham.setGianhang(sanpham.getGianhang());
			_SanPham.setHinhanh(sanpham.getHinhanh());
			return new ResponseEntity<>(repo.save(_SanPham), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/sanpham/{id}")
	public ResponseEntity<HttpStatus> DeleteOneSanPham(@PathVariable("id") String id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/sanpham/donhang/khachhang/{id}/{madonhang}")
	public ResponseEntity<List<SanPham>> XemDanhSachSanPhamTheoDonHang(@PathVariable("id") String id,
			@PathVariable("madonhang") String madonhang) {
		try {
			List<SanPham> dssanpham = new ArrayList<SanPham>();
			repo.listSanPhamByMaDonHang(id, madonhang).forEach(dssanpham::add);
			if (dssanpham.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(dssanpham, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
