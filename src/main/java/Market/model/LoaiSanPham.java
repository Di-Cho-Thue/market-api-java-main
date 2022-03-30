package Market.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "LOAISANPHAM")
public class LoaiSanPham {
	@Id
	@JsonProperty("MaLoaiSanPham")
	private String maloaisanpham;

	@JsonProperty("TenLoaiSanPham")
	private String tenloaisanpham;

	@JsonProperty("HinhAnhLoaiSanPham")
	private String hinhanhloaisanpham;
	
	
	public String getHinhanhloaisanpham() {
		return hinhanhloaisanpham;
	}

	public void setHinhanhloaisanpham(String hinhanhloaisanpham) {
		this.hinhanhloaisanpham = hinhanhloaisanpham;
	}

	public void setTenloaisanpham(String tenloaisanpham) {
		this.tenloaisanpham = tenloaisanpham;
	}

	public String getMaloaisanpham() {
		return maloaisanpham;
	}

	public void setMaloaisanpham(String maloaisanpham) {
		this.maloaisanpham = maloaisanpham;
	}

	public String getTenloaisanpham() {
		return tenloaisanpham;
	}

	public LoaiSanPham(String maloaisanpham, String tenloaisanpham, String hinhanhloaisanpham) {
		super();
		this.maloaisanpham = maloaisanpham;
		this.tenloaisanpham = tenloaisanpham;
		this.hinhanhloaisanpham = hinhanhloaisanpham;
		}
	
	public LoaiSanPham() {
		super();
	}
}
