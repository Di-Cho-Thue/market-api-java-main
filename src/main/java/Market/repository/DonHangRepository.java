package Market.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Market.model.DonHang;

public interface DonHangRepository extends JpaRepository<DonHang, String> {

	@Query(value = "select *, 0 as hoahong from DONHANG", nativeQuery = true)
	ArrayList<DonHang> findAll();

	@Query(value = "select *, 0 as hoahong from DONHANG where MaKhachHang = :makhachhang", nativeQuery = true)
	ArrayList<DonHang> findByKhachHangId(@Param("makhachhang") String id);

	@Query(value = "select *, 0 as hoahong from DONHANG where MaNguoiGiaoHang = :manguoigiaohang", nativeQuery = true)
	ArrayList<DonHang> findByNguoiGiaoHangId(@Param("manguoigiaohang") String id);
	
	@Query(value = "select count(*) from DONHANG where MaKhachHang = :makhachhang",
			nativeQuery = true)
	Integer countDonHangByKhachHang(@Param("makhachhang") String id);

	@Query(value = "select *, 0 as hoahong from DONHANG where MaDonHang = :madonhang", nativeQuery = true)
	DonHang findByMaDonHang(@Param("madonhang") String madonhang);
	
	@Query(value = "select * from DONHANG where MaDonHang = :madonhang", nativeQuery = true)
	DonHang findTTDHByMaDonHang(@Param("madonhang") String madonhang);
	
	@Query(value = "select count(*) from DONHANG where MaDonHang = :madonhang", nativeQuery = true)
	int checkMaDonHang(@Param("madonhang") String madonhang);
	
	@Query(value = "select count(*) from DONHANG_DANHGIA where MaDonHang = :madonhang", nativeQuery = true)
	Integer checkDanhGia(@Param("madonhang") String madonhang);
}
