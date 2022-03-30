package Market.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "CHITIETDONHANG")
public class ChiTietDonHang {
	@Id
	@JsonProperty("MaDonHang")
	private String madonhang;
	
	@JsonProperty("MaSanPham")
	private String masanpham;
	
	@JsonProperty("DonGia")
	private String dongia;
	
	@JsonProperty("SoLuong")
	private int soluong;
	
	public String getMaDonHang() {
		return madonhang;
	}

	public void setMaDonHang(String madonhang) {
		this.madonhang = madonhang;
	}

	public String getMaSanPham() {
		return masanpham;
	}

	public void setMaSanPham(String masanpham) {
		this.masanpham = masanpham;
	}
	
	public String getDonGia() {
		return dongia;
	}

	public void setDonGia(String dongia) {
		this.dongia = dongia;
	}

	public int getSoLuong() {
		return soluong;
	}

	public void setSoLuong(int soluong) {
		this.soluong = soluong;
	}
	
	public ChiTietDonHang(String madonhang, String masanpham, String dongia, int soluong) {
		super();
		this.madonhang = madonhang;
		this.masanpham = masanpham;
		this.dongia = dongia;
		this.soluong = soluong;
	}
	
	public ChiTietDonHang() {
		super();
	}
}
