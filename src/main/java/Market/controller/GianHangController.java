package Market.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

import Market.model.GianHang;
import Market.model.NguoiGiaoHang;
import Market.model.Vung;

import Market.repository.GianHangRepository;
import Market.repository.PhieuCanhBaoRepository;
import Market.repository.VungRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")

public class GianHangController {
	@Autowired
	GianHangRepository repo;

	@Autowired
	PhieuCanhBaoRepository reppcb;
	@Autowired
	VungRepository replv;

	@GetMapping("/gianhang")
	public ResponseEntity<List<GianHang>> XemDanhSachGianHang() {
		try {
			List<GianHang> dsgianhang = new ArrayList<GianHang>();
			repo.findAll().forEach(dsgianhang::add);
			if (dsgianhang.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(dsgianhang, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/gianhang/{id}")
	public ResponseEntity<Optional<GianHang>> XemGianHang(@PathVariable("id") String id) {
		try {
			Optional<GianHang> GianHangData = repo.findById(id);
			if (GianHangData.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(GianHangData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/gianhang/loaivung/{magianhang}")
	public ResponseEntity<Vung> XemLoaiVung(@PathVariable("magianhang") String magianhang) {
		try {
			Vung LoaiVung = replv.FindLoaiVung(magianhang);

			if (LoaiVung == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(LoaiVung, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/gianhang/phieucanhbao/{id}")
	public ResponseEntity<Integer> XemLichSuMuaHang(@PathVariable("id") String id) {
		try {
			GianHang gianHang = repo.getById(id);
			if (gianHang == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<Integer>(
					reppcb.countPhieuCanhCao(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/gianhang/signup")
	public ResponseEntity<GianHang> DangKiBanHang(@RequestBody GianHang gianhang) {
		try {
			if (gianhang.getMsdn_nguoiban().isEmpty() || gianhang.getSonha_gh().isEmpty()
					|| gianhang.getTengianhang().isEmpty() || gianhang.getPhuongxa_gh().isEmpty()
					|| gianhang.getQuanhuyen_gh().isEmpty() || gianhang.getThanhpho_gh().isEmpty()
					|| gianhang.getSdt_gh().isEmpty() || gianhang.getGiaytocovid().isEmpty()
					|| gianhang.getMotagianhang().isEmpty() || gianhang.getEmail_gh().isEmpty()
					|| gianhang.getGiaytosanpham().isEmpty()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			GianHang _GianHang = repo.save(new GianHang(UUID.randomUUID().toString().substring(0, 7),
					gianhang.getTengianhang(), gianhang.getMsdn_nguoiban(),
					gianhang.getSonha_gh(), gianhang.getPhuongxa_gh(), gianhang.getQuanhuyen_gh(),
					gianhang.getThanhpho_gh(),
					gianhang.getMotagianhang(), "Chưa duyệt", 0, 0,
					gianhang.getLoaigianhang(), "a", "a", gianhang.getEmail_gh().toString().substring(0, 10),
					gianhang.getSdt_gh(),
					gianhang.getGiaytocovid().toString().substring(0, 10),
					gianhang.getGiaytosanpham().toString().substring(0, 10)));
			return new ResponseEntity<>(_GianHang, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/gianhang/{id}")
	public ResponseEntity<GianHang> UpdateGianHang(@PathVariable("id") String id, @RequestBody GianHang gianhang) {
		Optional<GianHang> GianHangData = repo.findById(id);
		if (GianHangData.isPresent()) {
			GianHang _GianHang = GianHangData.get();
			_GianHang.setTengianhang(gianhang.getTengianhang());
			_GianHang.setSonha_gh(gianhang.getSonha_gh());
			_GianHang.setPhuongxa_gh(gianhang.getPhuongxa_gh());
			_GianHang.setQuanhuyen_gh(gianhang.getQuanhuyen_gh());
			_GianHang.setThanhpho_gh(gianhang.getThanhpho_gh());
			_GianHang.setMotagianhang(gianhang.getMotagianhang());
			return new ResponseEntity<>(repo.save(_GianHang), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/gianhang/{id}")
	public ResponseEntity<HttpStatus> DeleteOneGianHang(@PathVariable("id") String id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
