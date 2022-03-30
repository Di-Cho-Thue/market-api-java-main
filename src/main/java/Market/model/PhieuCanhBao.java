package Market.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

@Entity
@Table(name = "PHIEUCANHBAO")
public class PhieuCanhBao {
    @Id
	@JsonProperty("MaGianHang")
	private String magianhang;
    @JsonProperty("MaNguoiGiaoHang")
	private String manguoigiaohang;
    @JsonProperty("ThoiGian")
	private LocalDateTime thoigian;
    @JsonProperty("NoiDung")
	private String noidung;

    public String getMagianhang() {
		return magianhang;
	}
	
	public void setMagianhang(String magianhang) {
		this.magianhang = magianhang;
	}
    public String getManguoigiaohang(){
        return manguoigiaohang;
    }
    public void setManguoigiaohang(String manguoigiaohang){
        this.manguoigiaohang=manguoigiaohang;
    }
    public LocalDateTime getThoigian(){
        return thoigian;
    }
    public void setThoigian(LocalDateTime thoigian){
        this.thoigian=thoigian;
    }
    public String getNoidung(){
        return noidung;
    }
    public void setNoidung(String noidung){
    this.noidung=noidung;
    }
    public PhieuCanhBao(String magianhang, String manguoigiaohang,LocalDateTime thoigian, String noidung) { 
		super();
		this.magianhang = magianhang;
		this.manguoigiaohang=magianhang;
        this.thoigian=thoigian;
        this.noidung=noidung;
	}

	public PhieuCanhBao() {
		super();
	}

}
