package Market.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "NHANVIEN")
public class NhanVien {
	@Id
	@JsonProperty("MaNhanVien")
	private String manhanvien;

	@JsonProperty("HoTen_NV")
	private String hoten_nv;

	@JsonProperty("CMND_NV")
	private String cmnd_nv;
	
	@JsonProperty("NgaySinh_NV")
	private Date ngaysinh_nv;
	
	@JsonProperty("GioiTinh_NV")
	private String gioitinh_nv;
	
	@JsonProperty("SoNha_NV")
	private String sonha_nv;

	@JsonProperty("PhuongXa_NV")
	private String phuongxa_nv;
	
	@JsonProperty("QuanHuyen_NV")
	private String quanhuyen_nv;
	
	@JsonProperty("ThanhPho_NV")
	private String thanhpho_nv;
	
	@JsonProperty("BoPhan")
	private String bophan;
	
	public String getManhanvien() {
		return manhanvien;
	}

	public void setManhanvien(String manhanvien) {
		this.manhanvien = manhanvien;
	}

	public String getHoten_nv() {
		return hoten_nv;
	}

	public void setHoten_nv(String hoten_nv) {
		this.hoten_nv = hoten_nv;
	}
	
	public String getCmnd_nv() {
		return cmnd_nv;
	}

	public void setCmnd_nv(String cmnd_nv) {
		this.cmnd_nv = cmnd_nv;
	}

	public Date getNgaysinh_nv() {
		return ngaysinh_nv;
	}

	public void setNgaysinh_nv(Date ngaysinh_nv) {
		this.ngaysinh_nv = ngaysinh_nv;
	}

	public String getGioitinh_nv() {
		return gioitinh_nv;
	}

	public void setGioitinh_nv(String gioitinh_nv) {
		this.gioitinh_nv = gioitinh_nv;
	}
	
	public String getSonha_nv() {
		return sonha_nv;
	}

	public void setSonha_nv(String sonha_nv) {
		this.sonha_nv = sonha_nv;
	}

	public String getPhuongxa_nv() {
		return phuongxa_nv;
	}

	public void setPhuongxa_nv(String phuongxa_nv) {
		this.phuongxa_nv = phuongxa_nv;
	}

	public String getQuanhuyen_nv() {
		return quanhuyen_nv;
	}

	public void setQuanhuyen_nv(String quanhuyen_nv) {
		this.quanhuyen_nv = quanhuyen_nv;
	}

	public String getThanhpho_nv() {
		return thanhpho_nv;
	}

	public void setThanhpho_nv(String thanhpho_nv) {
		this.thanhpho_nv = thanhpho_nv;
	}

	public String getBophan() {
		return bophan;
	}

	public void setBophan(String bophan) {
		this.bophan = bophan;
	}

	public NhanVien(String manhanvien, String hoten_nv, String cmnd_nv, Date ngaysinh_nv, 
			String gioitinh_nv, String sonha_nv, String phuongxa_nv, String quanhuyen_nv, 
			String thanhpho_nv,String bophan) {
		super();
		this.manhanvien = manhanvien;
		this.hoten_nv = hoten_nv;
		this.cmnd_nv = cmnd_nv;
		this.ngaysinh_nv = ngaysinh_nv;
		this.gioitinh_nv = gioitinh_nv;
		this.sonha_nv = sonha_nv;
		this.phuongxa_nv = phuongxa_nv;
		this.quanhuyen_nv = quanhuyen_nv;
		this.thanhpho_nv = thanhpho_nv;
		this.bophan = bophan;
		}
	
	public NhanVien() {
		super();
	}
}
