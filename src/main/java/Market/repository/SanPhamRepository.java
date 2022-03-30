package Market.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Market.model.SanPham;

public interface SanPhamRepository extends JpaRepository <SanPham, String>{
	@Query(value = "select SP.* "
			+ "from DONHANG DH, CHITIETDONHANG CTDH, SANPHAM SP "
			+ "where DH.MaDonHang = CTDH.MaDonHang and CTDH.MaSanPham = SP.MaSanPham "
			+ "and MaKhachHang = :makhachhang and DH.MaDonHang = :madonhang",
			nativeQuery = true)
	ArrayList<SanPham> listSanPhamByMaDonHang(@Param("makhachhang") String id, @Param("madonhang") String madonhang);
	
	@Query(value = "select * from SANPHAM where MaSanPham = :masp",
			nativeQuery = true)
	SanPham SanPhamByMaSP(@Param("masp") String id);
}
