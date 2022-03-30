package Market.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "GIANHANG")
public class GianHang {
	@Id
	@JsonProperty("MaGianHang")
	private String magianhang;
	
	@JsonProperty("TenGianHang")
	private String tengianhang;
	
	@JsonProperty("MSDN_NguoiBan")
	private String msdn_nguoiban;
	
	@JsonProperty("SoNha_GH")
	private String sonha_gh;
	
	@JsonProperty("PhuongXa_GH")
	private String phuongxa_gh;
	
	@JsonProperty("QuanHuyen_GH")
	private String quanhuyen_gh;
	
	@JsonProperty("ThanhPho_GH")
	private String thanhpho_gh;
	
	@JsonProperty("MoTaGianHang")
	private String motagianhang;
	
	@JsonProperty("TinhTrangGianHang")
	private String tinhtranggianhang;
	
	@JsonProperty("DanhGiaGianHang")
	private float danhgiagianhang;
	
	@JsonProperty("LuotTheoDoi_GH")
	private int luottheodoi_gh;
	
	@JsonProperty("LoaiGianHang")
	private String loaigianhang;
	
	@JsonProperty("TenDangNhap")
	private String tendangnhap;
	
	@JsonProperty("MatKhau")
	private String matkhau;
	
	@JsonProperty("Email_GH")
	private String email_gh;
	
	@JsonProperty("SDT_GH")
	private String sdt_gh;
	
	@JsonProperty("GiayToCovid")
	private String giaytocovid;
	
	@JsonProperty("GiayToSanPham")
	private String giaytosanpham;
	
	
	
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



	public String getMsdn_nguoiban() {
		return msdn_nguoiban;
	}



	public void setMsdn_nguoiban(String msdn_nguoiban) {
		this.msdn_nguoiban = msdn_nguoiban;
	}



	public String getSonha_gh() {
		return sonha_gh;
	}



	public void setSonha_gh(String sonha_gh) {
		this.sonha_gh = sonha_gh;
	}



	public String getPhuongxa_gh() {
		return phuongxa_gh;
	}



	public void setPhuongxa_gh(String phuongxa_gh) {
		this.phuongxa_gh = phuongxa_gh;
	}



	public String getQuanhuyen_gh() {
		return quanhuyen_gh;
	}



	public void setQuanhuyen_gh(String quanhuyen_gh) {
		this.quanhuyen_gh = quanhuyen_gh;
	}



	public String getThanhpho_gh() {
		return thanhpho_gh;
	}



	public void setThanhpho_gh(String thanhpho_gh) {
		this.thanhpho_gh = thanhpho_gh;
	}



	public String getMotagianhang() {
		return motagianhang;
	}



	public void setMotagianhang(String motagianhang) {
		this.motagianhang = motagianhang;
	}



	public String getTinhtranggianhang() {
		return tinhtranggianhang;
	}



	public void setTinhtranggianhang(String tinhtranggianhang) {
		this.tinhtranggianhang = tinhtranggianhang;
	}



	public float getDanhgiagianhang() {
		return danhgiagianhang;
	}



	public void setDanhgiagianhang(float danhgiagianhang) {
		this.danhgiagianhang = danhgiagianhang;
	}



	public int getLuottheodoi_gh() {
		return luottheodoi_gh;
	}



	public void setLuottheodoi_gh(int luottheodoi_gh) {
		this.luottheodoi_gh = luottheodoi_gh;
	}



	public String getLoaigianhang() {
		return loaigianhang;
	}



	public void setLoaigianhang(String loaigianhang) {
		this.loaigianhang = loaigianhang;
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



	public String getEmail_gh() {
		return email_gh;
	}



	public void setEmail_gh(String email_gh) {
		this.email_gh = email_gh;
	}



	public String getSdt_gh() {
		return sdt_gh;
	}



	public void setSdt_gh(String sdt_gh) {
		this.sdt_gh = sdt_gh;
	}



	public String getGiaytocovid() {
		return giaytocovid;
	}



	public void setGiaytocovid(String giaytocovid) {
		this.giaytocovid = giaytocovid;
	}



	public String getGiaytosanpham() {
		return giaytosanpham;
	}



	public void setGiaytosanpham(String giaytosanpham) {
		this.giaytosanpham = giaytosanpham;
	}



	public GianHang(String magianhang, String tengianhang, String msdn_nguoiban, String sonha_gh, String phuongxa_gh,
			String quanhuyen_gh, String thanhpho_gh, String motagianhang, String tinhtranggianhang,
			float danhgiagianhang, int luottheodoi_gh, String loaigianhang, String tendangnhap, String matkhau,
			String email_gh, String sdt_gh, String giaytocovid, String giaytosanpham) {
		super();
		this.magianhang = magianhang;
		this.tengianhang = tengianhang;
		this.msdn_nguoiban = msdn_nguoiban;
		this.sonha_gh = sonha_gh;
		this.phuongxa_gh = phuongxa_gh;
		this.quanhuyen_gh = quanhuyen_gh;
		this.thanhpho_gh = thanhpho_gh;
		this.motagianhang = motagianhang;
		this.tinhtranggianhang = tinhtranggianhang;
		this.danhgiagianhang = danhgiagianhang;
		this.luottheodoi_gh = luottheodoi_gh;
		this.loaigianhang = loaigianhang;
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
		this.email_gh = email_gh;
		this.sdt_gh = sdt_gh;
		this.giaytocovid = giaytocovid;
		this.giaytosanpham = giaytosanpham;
	}



	public GianHang() {
		super();
	}
}
