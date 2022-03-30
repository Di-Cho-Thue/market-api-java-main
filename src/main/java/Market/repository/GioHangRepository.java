package Market.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import Market.model.GioHang;

public interface GioHangRepository extends JpaRepository <GioHang, String> {

	@Query(value = "select count(*) from GIOHANG where MaKhachHang = :makhachhang",
			nativeQuery = true)
	Integer countSanPhamByKhachHang(@Param("makhachhang") String id);
	
	@Query(value = "select sum(DonGia) from GIOHANG where MaKhachHang = :makhachhang group by MaKhachHang",
			nativeQuery = true)
	Double sumDonGiaGioHang(@Param("makhachhang") String id);
	
	@Query(value = "select GIH.MaGianHang, GH.MaKhachHang, GIH.TenGianHang, SP.MaSanPham, SP.TenSanPham, SP.MoTaSanPham, SP.HinhAnh, SP.GiaSanPham, "
			+ "GH.DonGia, GH.SoLuong, TongTienThanhToan.TongTien "
			+ "from GIANHANG GIH, SANPHAM SP, GIOHANG GH, (select GH.MaKhachHang, SP.GianHang, sum(DonGia) as TongTien "
			+ "											from GIOHANG GH, SANPHAM SP "
			+ "											where GH.MaSanPham = SP.MaSanPham "
			+ "											group by GH.MaKhachHang, SP.GianHang) as TongTienThanhToan "
			+ "where GIH.MaGianHang = SP.GianHang and SP.MaSanPham = GH. MaSanPham and TongTienThanhToan.MaKhachHang = GH.MaKhachHang "
			+ "and TongTienThanhToan.GianHang = GIH.MaGianHang and GH.MaKhachHang = :makhachhang "
			+ "GROUP BY GIH.MaGianHang, GH.MaKhachHang, GIH.TenGianHang, SP.MaSanPham, SP.TenSanPham, SP.MoTaSanPham, SP.HinhAnh, SP.GiaSanPham, "
			+ "GH.DonGia, GH.SoLuong, TongTienThanhToan.TongTien",
			nativeQuery = true)
	ArrayList<GioHang> listGioHang(@Param("makhachhang") String id);
	
	@Modifying
	@Query(value = "insert into GIOHANG values(:makhachhang, :masanpham, 0 , :soluong)",
			nativeQuery = true)
    @Transactional
	void addGioHang(@Param("makhachhang") String makh, @Param("masanpham") String masp,
			@Param("soluong") int soluong);
	
	@Query(value = "select GIH.MaGianHang, GH.MaKhachHang, GIH.TenGianHang, SP.MaSanPham, SP.TenSanPham, SP.MoTaSanPham, SP.HinhAnh, SP.GiaSanPham, "
			+ "GH.DonGia, GH.SoLuong, TongTienThanhToan.TongTien "
			+ "from GIANHANG GIH, SANPHAM SP, GIOHANG GH, (select GH.MaKhachHang, SP.GianHang, sum(DonGia) as TongTien "
			+ "											from GIOHANG GH, SANPHAM SP "
			+ "											where GH.MaSanPham = SP.MaSanPham "
			+ "											group by GH.MaKhachHang, SP.GianHang) as TongTienThanhToan "
			+ "where GIH.MaGianHang = SP.GianHang and SP.MaSanPham = GH. MaSanPham and TongTienThanhToan.MaKhachHang = GH.MaKhachHang "
			+ "and TongTienThanhToan.GianHang = GIH.MaGianHang and GH.MaKhachHang = :makhachhang and SP.MaSanPham = :masanpham "
			+ "GROUP BY GIH.MaGianHang, GH.MaKhachHang, GIH.TenGianHang, SP.MaSanPham, SP.TenSanPham, SP.MoTaSanPham, SP.HinhAnh, SP.GiaSanPham, "
			+ "GH.DonGia, GH.SoLuong, TongTienThanhToan.TongTien",
			nativeQuery = true)
	ArrayList<GioHang> GioHangByMaSanPham(@Param("makhachhang") String makh, @Param("masanpham") String masp);
	
	@Modifying
	@Query(value = "update GIOHANG set SoLuong = SoLuong + :soluong where MaKhachHang = :makhachhang and MaSanPham = :masanpham",
			nativeQuery = true)
	@Transactional
	void createSoLuongCuaGioHang(@Param("makhachhang") String makh, @Param("masanpham") String masp,
			@Param("soluong") int soluong);
	
	@Modifying
	@Query(value = "update GIOHANG set SoLuong = :soluong where MaKhachHang = :makhachhang and MaSanPham = :masanpham",
			nativeQuery = true)
	@Transactional
	void updateSoLuongCuaGioHang(@Param("makhachhang") String makh, @Param("masanpham") String masp,
			@Param("soluong") int soluong);
	
	@Modifying
	@Query(value = "delete from GIOHANG where MaKhachHang = :makhachhang and MaSanPham = :masanpham",
			nativeQuery = true)
	@Transactional
	void deleteSanPhamTrongGioHang(@Param("makhachhang") String makh, @Param("masanpham") String masp);
}
