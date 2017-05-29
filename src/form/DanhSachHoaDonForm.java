package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import model.bean.HangHoa;
import model.bean.HoaDon;


public class DanhSachHoaDonForm extends ActionForm {
	private String maHoaDon;
	private String maNhanVien;
	private String maKhachHang;
	private String ngayLap;
	private String tenNhanVien;
	private String tenKhachHang;
	
	private ArrayList<HoaDon> listHoaDon;
	
	
	private String tenDangNhap;

	
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	
	
	
	
	public ArrayList<HoaDon> getListHoaDon() {
		return listHoaDon;
	}
	public void setListHoaDon(ArrayList<HoaDon> listHoaDon) {
		this.listHoaDon = listHoaDon;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaDonHang(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}
	
	

}
