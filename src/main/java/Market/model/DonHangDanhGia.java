package Market.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "DONHANG_DANHGIA")
public class DonHangDanhGia {
	@Id
	@JsonProperty("MaDanhGia")
	private String madanhgia;

	@JsonProperty("BinhLuan_NGH")
	private String binhluan_ngh;

	@JsonProperty("BinhLuan_SanPham")
	private String binhluan_sanpham;

	@JsonProperty("NgayDanhGia")
	private LocalDateTime ngaydanhgia;

	@JsonProperty("SoSao_NGH")
	private int sosao_ngh;

	@JsonProperty("SoSao_SanPham")
	private int sosao_sanpham;

	@JsonProperty("MaDonHang")
	private String madonhang;

	public DonHangDanhGia(String madanhgia, String binhluan_ngh, String binhluan_sanpham, LocalDateTime ngaydanhgia,
			int sosao_ngh, int sosao_sanpham, String madonhang) {
		super();
		this.madanhgia = madanhgia;
		this.binhluan_ngh = binhluan_ngh;
		this.binhluan_sanpham = binhluan_sanpham;
		this.ngaydanhgia = ngaydanhgia;
		this.sosao_ngh = sosao_ngh;
		this.sosao_sanpham = sosao_sanpham;
		this.madonhang = madonhang;
	}

	public String getMadanhgia() {
		return madanhgia;
	}

	public void setMadanhgia(String madanhgia) {
		this.madanhgia = madanhgia;
	}

	public String getBinhluan_ngh() {
		return binhluan_ngh;
	}

	public void setBinhluan_ngh(String binhluan_ngh) {
		this.binhluan_ngh = binhluan_ngh;
	}

	public String getBinhluan_sanpham() {
		return binhluan_sanpham;
	}

	public void setBinhluan_sanpham(String binhluan_sanpham) {
		this.binhluan_sanpham = binhluan_sanpham;
	}

	public LocalDateTime getNgaydanhgia() {
		return ngaydanhgia;
	}

	public void setNgaydanhgia(LocalDateTime localDateTime) {
		this.ngaydanhgia = localDateTime;
	}

	public int getSosao_ngh() {
		return sosao_ngh;
	}

	public void setSosao_ngh(int sosao_ngh) {
		this.sosao_ngh = sosao_ngh;
	}

	public int getSosao_sanpham() {
		return sosao_sanpham;
	}

	public void setSosao_sanpham(int sosao_sanpham) {
		this.sosao_sanpham = sosao_sanpham;
	}

	public String getMadonhang() {
		return madonhang;
	}

	public void setMadonhang(String madonhang) {
		this.madonhang = madonhang;
	}

	public DonHangDanhGia() {
		super();
	}
}
