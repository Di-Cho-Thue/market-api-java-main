package Market.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "KHACHHANG")
public class KhachHang {
	@Id
	@JsonProperty("MaKhachHang")
	private String makhachhang;
	
	@JsonProperty("HoTen_KH")
	private String hoten_kh;
	
	@JsonProperty("CMND_KH")
	private String cmnd_kh;
	
	@JsonProperty("NgaySinh_KH")
	private Date ngaysinh_kh;
	
	@JsonProperty("GioiTinh_KH")
	private String gioitinh_kh;
	
	@JsonProperty("SoNha_KH")
	private String sonha_kh;
	
	@JsonProperty("PhuongXa_KH")
	private String phuongxa_kh;
	
	@JsonProperty("QuanHuyen_KH")
	private String quanhuyen_kh;
	
	@JsonProperty("ThanhPho_KH")
	private String thanhpho_kh;
	
	@JsonProperty("SoDienThoai_KH")
	private String sodienthoai_kh;
	
	@JsonProperty("TenDangNhap")
	private String tendangnhap;
	
	@JsonProperty("MatKhau")
	private String matkhau;
	
	public String getMakhachhang() {
		return makhachhang;
	}

	public void setMakhachhang(String makhachhang) {
		this.makhachhang = makhachhang;
	}

	public String getHoten_kh() {
		return hoten_kh;
	}

	public void setHoten_kh(String hoten_kh) {
		this.hoten_kh = hoten_kh;
	}
	
	public String getCmnd_kh() {
		return cmnd_kh;
	}

	public void setCmnd_kh(String cmnd_kh) {
		this.cmnd_kh = cmnd_kh;
	}

	public Date getNgaysinh_kh() {
		return ngaysinh_kh;
	}

	public void setNgaysinh_kh(Date ngaysinh_kh) {
		this.ngaysinh_kh = ngaysinh_kh;
	}

	public String getGioitinh_kh() {
		return gioitinh_kh;
	}

	public void setGioitinh_kh(String gioitinh_kh) {
		this.gioitinh_kh = gioitinh_kh;
	}
	
	public String getSonha_kh() {
		return sonha_kh;
	}

	public void setSonha_kh(String sonha_kh) {
		this.sonha_kh = sonha_kh;
	}

	public String getPhuongxa_kh() {
		return phuongxa_kh;
	}

	public void setPhuongxa_kh(String phuongxa_kh) {
		this.phuongxa_kh = phuongxa_kh;
	}

	public String getQuanhuyen_kh() {
		return quanhuyen_kh;
	}

	public void setQuanhuyen_kh(String quanhuyen_kh) {
		this.quanhuyen_kh = quanhuyen_kh;
	}

	public String getThanhpho_kh() {
		return thanhpho_kh;
	}

	public void setThanhpho_kh(String thanhpho_kh) {
		this.thanhpho_kh = thanhpho_kh;
	}
	
	public String getSodienthoai_kh() {
		return sodienthoai_kh;
	}

	public void setSodienthoai_kh(String sodienthoai_kh) {
		this.sodienthoai_kh = sodienthoai_kh;
	}
	
	public String getTendangnhap() {
		return tendangnhap;
	}
	
	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}
	
	public String getMatkhau() {
		return matkhau;
	}
	
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	
	public KhachHang(String makhachhang, String hoten_kh, String cmnd_kh, Date ngaysinh_kh, 
			String gioitinh_kh, String sonha_kh, String phuongxa_kh, String quanhuyen_kh, 
			String thanhpho_kh,String sodienthoai_kh, String tendangnhap, String matkhau) {
		super();
		this.makhachhang = makhachhang;
		this.hoten_kh = hoten_kh;
		this.cmnd_kh = cmnd_kh;
		this.ngaysinh_kh = ngaysinh_kh;
		this.gioitinh_kh = gioitinh_kh;
		this.sonha_kh = sonha_kh;
		this.phuongxa_kh = phuongxa_kh;
		this.quanhuyen_kh = quanhuyen_kh;
		this.thanhpho_kh = thanhpho_kh;
		this.sodienthoai_kh = sodienthoai_kh;
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
	}
	
	public KhachHang() {
		super();
	}
}
