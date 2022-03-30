package Market.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import Market.model.GianHang;

public interface GianHangRepository extends JpaRepository<GianHang, String> {

	@Query(value = "select * from GIANHANG where PhuongXa_GH = :phuongxa_gh and QuanHuyen_GH = :quanhuyen_gh "
			+ "and ThanhPho_GH = :thanhpho_gh", nativeQuery = true)
	ArrayList<GianHang> searchByWard(@Param("phuongxa_gh") String phuongxa, @Param("quanhuyen_gh") String quanhuyen,
			@Param("thanhpho_gh") String thanhpho);

	@Query(value = "select * from GIANHANG where PhuongXa_GH != :phuongxa_gh and QuanHuyen_GH = :quanhuyen_gh "
			+ "and ThanhPho_GH = :thanhpho_gh", nativeQuery = true)
	ArrayList<GianHang> searchByDistrict(@Param("phuongxa_gh") String phuongxa, @Param("quanhuyen_gh") String quanhuyen,
			@Param("thanhpho_gh") String thanhpho);

	@Query(value = "select * from GIANHANG where ThanhPho_GH = :thanhpho_gh", nativeQuery = true)
	ArrayList<GianHang> searchByCity(@Param("thanhpho_gh") String thanhpho);

	@Transactional
	@Modifying
	@Query(value = "delete from GIANHANG  where MaGianHang = :id", nativeQuery = true)
	void xoaGianHang(@Param("id") String id);
}
