package model.bean;

public class HangHoaXuat {
	
	private String MaHoaDon;
	private String MaHangHoa;
	private int soLuong;
	private int donGia;
	
	public HangHoaXuat(String maHoaDon, String maHangHoa, int soLuong, int thanhTien) {
		super();
		MaHoaDon = maHoaDon;
		MaHangHoa = maHangHoa;
		this.soLuong = soLuong;
		this.donGia = thanhTien;
	}
	public HangHoaXuat(){
		
	}
	public String getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public String getMaHangHoa() {
		return MaHangHoa;
	}
	public void setMaHangHoa(String maHangHoa) {
		MaHangHoa = maHangHoa;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	
	
	

}
