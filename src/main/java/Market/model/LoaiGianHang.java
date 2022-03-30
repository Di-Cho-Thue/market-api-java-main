package Market.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "LOAIGIANHANG")
public class LoaiGianHang {
	@Id
	@JsonProperty("MaLoaiGianHang")
	private String maloaigianhang;

	public String getMaloaigianhang() {
		return maloaigianhang;
	}

	public void setMaloaigianhang(String maloaigianhang) {
		this.maloaigianhang = maloaigianhang;
	}

	public String getTenloaigianhang() {
		return tenloaigianhang;
	}

	public void setTenloaigianhang(String tenloaigianhang) {
		this.tenloaigianhang = tenloaigianhang;
	}

	@JsonProperty("TenLoaiGianHang")
	private String tenloaigianhang;
	

	public LoaiGianHang(String maloaigianhang, String tenloaigianhang) {
		super();
		this.maloaigianhang = maloaigianhang;
		this.tenloaigianhang = tenloaigianhang;
		}
	
	public LoaiGianHang() {
		super();
	}
}
