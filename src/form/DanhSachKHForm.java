package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.KhachHang;

public class DanhSachKHForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maKH;
	
	
	private String tenDangNhap; 
	
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private ArrayList<KhachHang> listKH;
	
	
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public ArrayList<KhachHang> getListKH() {
		return listKH;
	}
	public void setListKH(ArrayList<KhachHang> listKH) {
		this.listKH = listKH;
	}
}
