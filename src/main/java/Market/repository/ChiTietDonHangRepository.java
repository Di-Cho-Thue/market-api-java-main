package Market.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Market.model.ChiTietDonHang;

public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang, String> {
	@Query(value = "select SP.TenSanPham, ThongKeMatHangThietYeu.SoLuongDuocMua"
			+ "from SanPham SP, (select top(10) MaSanPham, sum(SoLuong) as SoLuongDuocMua"
			+ "											from CHITIETDONHANG"
			+ "											Group by MaSanPham"
			+ "											order by SoLuongDuocMua desc) as ThongKeMatHangThietYeu"
			+ "Where SP.MaSanPham=ThongKeMatHangThietYeu.MaSanPham",
			nativeQuery = true)
	ArrayList<ChiTietDonHang> findAll();
	
	@Query(value = "select * from CHITIETDONHANG WHERE MaDonHang = :madonhang",
			nativeQuery = true)
	ArrayList<ChiTietDonHang> findbyMaDH(@Param("madonhang") String id);
	
	@Query(value = "Select SP.TenSanPham, DanhSachMuaTheoKy.SoLuongDuocMua"
			+ "From SANPHAM SP, (Select top (10) CTDH.MaSanPham, sum (CTDH.SoLuong) as SoLuongDuocMua"
			+ "					from ChiTietDonHang CTDH, (Select MaDonHang from DONHANG"
			+ "											   Where NgayLapDon between :time and :time) as LayMaDonHang"
			+ "					Where CTDH.MaDonHang = LayMaDonHang.MaDonHang"
			+ "					Group by MaSanPham"
			+ "					order by SoLuongDuocMua desc) as DanhSachMuaTheoKy"
			+ "Where SP.MaSanPham = DanhSachMuaTheoKy.MaSanPham",
			nativeQuery = true)
	ArrayList<ChiTietDonHang> findByTime(@Param("time") String id);
	
	@Query(value = "select * from CHITIETDONHANG where MaDonHang = :madonhang and MaSanPham = :masanpham",
			nativeQuery = true)
	ArrayList<ChiTietDonHang> DonHangByMaSanPham(@Param("madonhang") String madonhang, @Param("masanpham") String masanpham);
}
