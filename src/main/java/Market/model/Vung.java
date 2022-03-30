package Market.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "VUNG")


public class Vung {
    @Id
	@JsonProperty("PhuongXa")
	private String phuongxa;

	@JsonProperty("QuanHuyen")
	private String quanhuyen;
	
	@JsonProperty("LoaiVung")
	private String loaivung;

	
	public String getPhuongxa() {
		return phuongxa;
	}
	
	public void setPhuongxa(String phuongxa) {
		this.phuongxa = phuongxa;
	}
	public String getQuanhuyen() {
		return quanhuyen;
	}
	
	public void setQuanhuyen(String quanhuyen) {
		this.quanhuyen = quanhuyen;
	}
	public String getLoaivung() {
		return loaivung;
	}
	
	public void setLoaivung(String loaivung) {
		this.loaivung=loaivung;
	}
	public Vung(String phuongxa,String quanhuyen,String loaivung)
	{
		super();
		this.phuongxa=phuongxa;
		this.quanhuyen=quanhuyen;
		this.loaivung=loaivung;

	}
	public Vung() {
		super();
	}
    
}
