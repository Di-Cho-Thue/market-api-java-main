package Market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Market.model.LoaiSanPham;

public interface LoaiSanPhamRepository extends JpaRepository <LoaiSanPham, String>{
	
}
