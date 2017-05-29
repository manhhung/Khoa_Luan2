package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.LoaiHang;

public class DanhSachLoaiHangForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maLoaiHang;
	private String tenLoaiHang;
	private String moTa;
	private ArrayList<LoaiHang> listLoaiHang;
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
	public ArrayList<LoaiHang> getListLoaiHang() {
		return listLoaiHang;
	}
	public void setListLoaiHang(ArrayList<LoaiHang> listLoaiHang) {
		this.listLoaiHang = listLoaiHang;
	}
	public String getMaLoaiHang() {
		return maLoaiHang;
	}
	public void setMaLoaiHang(String maLoaiHang) {
		this.maLoaiHang = maLoaiHang;
	}
	public String getTenLoaiHang() {
		return tenLoaiHang;
	}
	public void setTenLoaiHang(String tenLoaiHang) {
		this.tenLoaiHang = tenLoaiHang;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	

}
