package Market.model;

//import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "GIOHANG")
public class GioHang {
	
	@JsonProperty("MaKhachHang")
	private String makhachhang;
	
	@Id
	@JsonProperty("MaSanPham")
	private String masanpham;
	
	@JsonProperty("DonGia")
	private double dongia;
	
	@JsonProperty("SoLuong")
	private int soluong;

	@JsonProperty("MaGianHang")
	private String magianhang;
	
	@JsonProperty("TenGianHang")
	private String tengianhang;
	
	@JsonProperty("TenSanPham")
	private String tensanpham;
	
	@JsonProperty("MoTaSanPham")
	private String motasanpham;
	
	@JsonProperty("HinhAnh")
	private String hinhanh;
	
	@JsonProperty("GiaSanPham")
	private double giasanpham;
	
	@JsonProperty("TongTien")
	private double tongtien;
	
	
	public double getTongtien() {
		return tongtien;
	}

	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}

	public double getGiasanpham() {
		return giasanpham;
	}

	public void setGiasanpham(double giasanpham) {
		this.giasanpham = giasanpham;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public String getMakhachhang() {
		return makhachhang;
	}

	public void setMakhachhang(String makhachhang) {
		this.makhachhang = makhachhang;
	}

	public String getMasanpham() {
		return masanpham;
	}

	public void setMasanpham(String masanpham) {
		this.masanpham = masanpham;
	}

	public double getDongia() {
		return dongia;
	}

	public void setDongia(double dongia) {
		this.dongia = dongia;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getMagianhang() {
		return magianhang;
	}

	public void setMagianhang(String magianhang) {
		this.magianhang = magianhang;
	}

	public String getTengianhang() {
		return tengianhang;
	}

	public void setTengianhang(String tengianhang) {
		this.tengianhang = tengianhang;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public String getMotasanpham() {
		return motasanpham;
	}

	public void setMotasanpham(String motasanpham) {
		this.motasanpham = motasanpham;
	}
	
	public GioHang(String makhachhang,String masanpham, double dongia, int soluong,
			double giasanpham,String magianhang,String tengianhang,String tensanpham,
			String motasanpham, String hinhanh, double tongtien) {
		super();
		this.makhachhang = makhachhang;
		this.masanpham = masanpham;
		this.dongia = dongia;
		this.soluong = soluong;
		this.giasanpham = giasanpham;
		this.magianhang = magianhang;
		this.tengianhang = tengianhang;
		this.tensanpham = tensanpham;
		this.motasanpham = motasanpham;
		this.hinhanh = hinhanh;
		this.tongtien = tongtien;
		}
	
	public GioHang() {
		super();
	}
}