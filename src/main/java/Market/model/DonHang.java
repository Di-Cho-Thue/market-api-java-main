package Market.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "DONHANG")
public class DonHang {

	@Id
	@JsonProperty("MaDonHang")
	private String madonhang;

	@JsonProperty("HinhThucThanhToan")
	private String hinhthucthanhtoan;

	@JsonProperty("NgayLapDon")
	private LocalDateTime ngaylapdon;

	@JsonProperty("TinhTrangDon")
	private String tinhtrangdon;

	@JsonProperty("TongTien")
	private BigDecimal tongtien;

	@JsonProperty("KhuyenMai")
	private String khuyenmai;

	@JsonProperty("MaKhachHang")
	private String makhachhang;

	@JsonProperty("MaNguoiGiaoHang")
	private String manguoigiaohang;

	@JsonProperty("GianHang")
	private String gianhang;

	@JsonProperty("HoaHong")
	private BigDecimal hoahong;

	public BigDecimal getHoahong() {
		return hoahong;
	}

	public void setHoahong(BigDecimal hoahong) {
		this.hoahong = hoahong;
	}

	public String getMadonhang() {
		return madonhang;
	}

	public void setMadonhang(String madonhang) {
		this.madonhang = madonhang;
	}

	public String getHinhthucthanhtoan() {
		return hinhthucthanhtoan;
	}

	public void setHinhthucthanhtoan(String hinhthucthanhtoan) {
		this.hinhthucthanhtoan = hinhthucthanhtoan;
	}

	public LocalDateTime getNgaylapdon() {
		return ngaylapdon;
	}

	public void setNgaylapdon(LocalDateTime ngaylapdon) {
		this.ngaylapdon = ngaylapdon;
	}

	public String getTinhtrangdon() {
		return tinhtrangdon;
	}

	public void setTinhtrangdon(String tinhtrangdon) {
		this.tinhtrangdon = tinhtrangdon;
	}

	public BigDecimal getTongtien() {
		return tongtien;
	}

	public void setTongtien(BigDecimal tongtien) {
		this.tongtien = tongtien;
	}

	public String getKhuyenmai() {
		return khuyenmai;
	}

	public void setKhuyenmai(String khuyenmai) {
		this.khuyenmai = khuyenmai;
	}

	public String getMakhachhang() {
		return makhachhang;
	}

	public void setMakhachhang(String makhachhang) {
		this.makhachhang = makhachhang;
	}

	public String getManguoigiaohang() {
		return manguoigiaohang;
	}

	public void setManguoigiaohang(String manguoigiaohang) {
		this.manguoigiaohang = manguoigiaohang;
	}

	public String getGianhang() {
		return gianhang;
	}

	public void setGianhang(String gianhang) {
		this.gianhang = gianhang;
	}

	public BigDecimal getHoaHongDonhang(BigDecimal tongtien, String tinhtrangdon) {
		BigDecimal hoahong = new BigDecimal(0);
		if (Objects.equals(tinhtrangdon, DonHangState.DELIVERED_STATE)) {
			hoahong = tongtien.multiply(new BigDecimal(0.05));
		}
		if (Objects.equals(tinhtrangdon, DonHangState.RETURN_STATE)) {
			hoahong = tongtien.multiply(new BigDecimal(0.1));
		}
		hoahong = hoahong.round(new MathContext(hoahong.toBigInteger().toString().length(), RoundingMode.HALF_UP));
		this.setHoahong(hoahong);
		return hoahong;
	}

	public Boolean getCoTheNhanHoaHong() {
		return Objects.equals(tinhtrangdon, DonHangState.DELIVERED_STATE)
				|| Objects.equals(tinhtrangdon, DonHangState.RETURN_STATE);
	}

	public DonHang(String madonhang, String hinhthucthanhtoan, LocalDateTime ngaylapdon, String tinhtrangdon,
			BigDecimal tongtien, String khuyenmai, String makhachhang, String manguoigiaohang, String gianhang) {
		super();
		this.madonhang = madonhang;
		this.hinhthucthanhtoan = hinhthucthanhtoan;
		this.ngaylapdon = ngaylapdon;
		this.tinhtrangdon = tinhtrangdon;
		this.tongtien = tongtien;
		this.khuyenmai = khuyenmai;
		this.makhachhang = makhachhang;
		this.manguoigiaohang = manguoigiaohang;
		this.gianhang = gianhang;
		this.hoahong = getHoaHongDonhang(tongtien, tinhtrangdon);
	}

	public DonHang() {
		super();
	}
}