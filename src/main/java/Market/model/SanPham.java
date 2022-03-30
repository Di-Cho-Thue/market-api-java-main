package Market.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "SANPHAM")
public class SanPham {
	@Id
	@JsonProperty("MaSanPham")
	private String masanpham;

	@JsonProperty("TenSanPham")
	private String tensanpham;

	@JsonProperty("GiaSanPham")
	private double giasanpham;
	
	@JsonProperty("DanhGiaSanPham")
	private float danhgiasanpham;
	
	@JsonProperty("MoTaSanPham")
	private String motasanpham;
	
	@JsonProperty("SoLuongTon")
	private int soluongton;

	@JsonProperty("TinhTrangDuyet")
	private String tinhtrangduyet;
	
	@JsonProperty("TinhTrangSanPham")
	private String tinhtrangsanpham;
	
	@JsonProperty("MaNhanVienDuyet")
	private String manhanvienduyet;
	
	@JsonProperty("LoaiSanPham")
	private String loaisanpham;
	
	@JsonProperty("GianHang")
	private String gianhang;
	
	@JsonProperty("HinhAnh")
	private String hinhanh;
	
	public String getMasanpham() {
		return masanpham;
	}

	public void setMasanpham(String masanpham) {
		this.masanpham = masanpham;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}
	
	public double getGiasanpham() {
		return giasanpham;
	}

	public void setGiasanpham(double giasanpham) {
		this.giasanpham = giasanpham;
	}

	public float getDanhgiasanpham() {
		return danhgiasanpham;
	}

	public void setDanhgiasanpham(float danhgiasanpham) {
		this.danhgiasanpham = danhgiasanpham;
	}

	public String getMotasanpham() {
		return motasanpham;
	}

	public void setMotasanpham(String motasanpham) {
		this.motasanpham = motasanpham;
	}
	
	public int getSoluongton() {
		return soluongton;
	}

	public void setSoluongton(int soluongton) {
		this.soluongton = soluongton;
	}

	public String getTinhtrangduyet() {
		return tinhtrangduyet;
	}

	public void setTinhtrangduyet(String tinhtrangduyet) {
		this.tinhtrangduyet = tinhtrangduyet;
	}

	public String getTinhtrangsanpham() {
		return tinhtrangsanpham;
	}

	public void setTinhtrangsanpham(String tinhtrangsanpham) {
		this.tinhtrangsanpham = tinhtrangsanpham;
	}

	public String getManhanvienduyet() {
		return manhanvienduyet;
	}

	public void setManhanvienduyet(String manhanvienduyet) {
		this.manhanvienduyet = manhanvienduyet;
	}

	public String getLoaisanpham() {
		return loaisanpham;
	}

	public void setLoaisanpham(String loaisanpham) {
		this.loaisanpham = loaisanpham;
	}
	
	public String getGianhang() {
		return gianhang;
	}

	public void setGianhang(String gianhang) {
		this.gianhang = gianhang;
	}
	
	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public SanPham(String masanpham, String tensanpham, double giasanpham, float danhgiasanpham, 
			String motasanpham, int soluongton, String tinhtrangduyet, String tinhtrangsanpham, 
			String manhanvienduyet,String loaisanpham, String gianhang,String hinhanh) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.giasanpham = giasanpham;
		this.danhgiasanpham = danhgiasanpham;
		this.motasanpham = motasanpham;
		this.soluongton = soluongton;
		this.tinhtrangduyet = tinhtrangduyet;
		this.tinhtrangsanpham = tinhtrangsanpham;
		this.manhanvienduyet = manhanvienduyet;
		this.loaisanpham = loaisanpham;
		this.gianhang = gianhang;
		this.hinhanh = hinhanh;
		}
	
	public SanPham() {
		super();
	}
}
