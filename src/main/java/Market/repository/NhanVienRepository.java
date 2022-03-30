package Market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Market.model.NhanVien;

public interface NhanVienRepository extends JpaRepository <NhanVien, String>{
	
}
