package Market.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import Market.model.KhachHang;

public interface KhachHangRepository extends JpaRepository<KhachHang, String> {

	@Query(value = "select * from KHACHHANG where MaKhachHang = :makhachhang", nativeQuery = true)
	Optional<KhachHang> findById(@Param("makhachhang") String id);

	@Transactional
	@Modifying
	@Query(value = "delete from KHACHHANG  where MaKhachHang = :id", nativeQuery = true)
	void xoaKhachHang(@Param("id") String id);

}
