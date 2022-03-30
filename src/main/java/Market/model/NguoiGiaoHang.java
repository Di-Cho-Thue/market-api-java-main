package Market.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "NGUOIGIAOHANG")
public class NguoiGiaoHang {
    public NguoiGiaoHang(String manguoigiaohang, String hoten_ngh, String cmnd_ngh, Date ngaysinh_ngh,
            String gioitinh_ngh, String sonha_ngh, String phuongxa_ngh, String quanhuyen_ngh, String thanhpho_ngh,
            String sodienthoai_ngh, float danhgia_ngh, String giaypheplaixe, String giayxacnhanamtinh,
            String tinhtrangduyet, String tinhtranghoatdong) {
        super();
        this.manguoigiaohang = manguoigiaohang;
        this.hoten_ngh = hoten_ngh;
        this.cmnd_ngh = cmnd_ngh;
        this.ngaysinh_ngh = ngaysinh_ngh;
        this.gioitinh_ngh = gioitinh_ngh;
        this.sonha_ngh = sonha_ngh;
        this.phuongxa_ngh = phuongxa_ngh;
        this.quanhuyen_ngh = quanhuyen_ngh;
        this.thanhpho_ngh = thanhpho_ngh;
        this.sodienthoai_ngh = sodienthoai_ngh;
        this.danhgia_ngh = danhgia_ngh;
        this.giaypheplaixe = giaypheplaixe;
        this.giayxacnhanamtinh = giayxacnhanamtinh;
        this.tinhtrangduyet = tinhtrangduyet;
        this.tinhtranghoatdong = tinhtranghoatdong;
    }

    public NguoiGiaoHang() {
        super();
    }

    @Id
    @JsonProperty("MaNguoiGiaoHang")
    private String manguoigiaohang;

    @JsonProperty("HoTen_NGH")
    private String hoten_ngh;
    @JsonProperty("CMND_NGH")
    private String cmnd_ngh;
    @JsonProperty("NgaySinh_NGH")
    private Date ngaysinh_ngh;
    @JsonProperty("GioiTinh_NGH")
    private String gioitinh_ngh;
    @JsonProperty("SoNha_NGH")
    private String sonha_ngh;
    @JsonProperty("PhuongXa_NGH")
    private String phuongxa_ngh;
    @JsonProperty("QuanHuyen_NGH")
    private String quanhuyen_ngh;
    @JsonProperty("ThanhPho_NGH")
    private String thanhpho_ngh;
    @JsonProperty("SoDienThoai_NGH")
    private String sodienthoai_ngh;
    @JsonProperty("DanhGia_NGH")
    private float danhgia_ngh;

    @JsonProperty("GiayPhepLaiXe")
    private String giaypheplaixe;
    @JsonProperty("GiayXacNhanAmTinh")
    private String giayxacnhanamtinh;
    @JsonProperty("TinhTrangDuyet")
    private String tinhtrangduyet;
    @JsonProperty("TinhTrangHoatDong")
    private String tinhtranghoatdong;

    public String getManguoigiaohang() {
        return manguoigiaohang;
    }

    public void setManguoigiaohang(String manguoigiaohang) {
        this.manguoigiaohang = manguoigiaohang;
    }

    public String getHoten_ngh() {
        return hoten_ngh;
    }

    public void setHoten_ngh(String hoten_ngh) {
        this.hoten_ngh = hoten_ngh;
    }

    public String getCmnd_ngh() {
        return cmnd_ngh;
    }

    public void setCmnd_ngh(String cmnd_ngh) {
        this.cmnd_ngh = cmnd_ngh;
    }

    public Date getNgaysinh_ngh() {
        return ngaysinh_ngh;
    }

    public void setNgaysinh_ngh(Date ngaysinh_ngh) {
        this.ngaysinh_ngh = ngaysinh_ngh;
    }

    public String getGioitinh_ngh() {
        return gioitinh_ngh;
    }

    public void setGioitinh_ngh(String gioitinh_ngh) {
        this.gioitinh_ngh = gioitinh_ngh;
    }

    public String getSonha_ngh() {
        return sonha_ngh;
    }

    public void setSonha_ngh(String sonha_ngh) {
        this.sonha_ngh = sonha_ngh;
    }

    public String getPhuongxa_ngh() {
        return phuongxa_ngh;
    }

    public void setPhuongxa_ngh(String phuongxa_ngh) {
        this.phuongxa_ngh = phuongxa_ngh;
    }

    public String getQuanhuyen_ngh() {
        return quanhuyen_ngh;
    }

    public void setQuanhuyen_ngh(String quanhuyen_ngh) {
        this.quanhuyen_ngh = quanhuyen_ngh;
    }

    public String getThanhpho_ngh() {
        return thanhpho_ngh;
    }

    public void setThanhpho_ngh(String thanhpho_ngh) {
        this.thanhpho_ngh = thanhpho_ngh;
    }

    public String getSodienthoai_ngh() {
        return sodienthoai_ngh;
    }

    public void setSodienthoai_ngh(String sodienthoai_ngh) {
        this.sodienthoai_ngh = sodienthoai_ngh;
    }

    public float getDanhgia_ngh() {
        return danhgia_ngh;
    }

    public void setDanhgia_ngh(float danhgia_ngh) {
        this.danhgia_ngh = danhgia_ngh;
    }

    public String getGiaypheplaixe() {
        return giaypheplaixe;
    }

    public void setGiaypheplaixe(String giaypheplaixe) {
        this.giaypheplaixe = giaypheplaixe;
    }

    public String getGiayxacnhanamtinh() {
        return giayxacnhanamtinh;
    }

    public void setGiayxacnhanamtinh(String giayxacnhanamtinh) {
        this.giayxacnhanamtinh = giayxacnhanamtinh;
    }

    public String getTinhtrangduyet() {
        return tinhtrangduyet;
    }

    public void setTinhtrangduyet(String tinhtrangduyet) {
        this.tinhtrangduyet = tinhtrangduyet;
    }

    public String getTinhtranghoatdong() {
        return tinhtranghoatdong;
    }

    public void setTinhtranghoatdong(String tinhtranghoatdong) {
        this.tinhtranghoatdong = tinhtranghoatdong;
    }

}
