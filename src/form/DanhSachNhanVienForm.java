package form;
import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.ChucVu;
import model.bean.NhanVien;
import model.bean.Quyen;

public class DanhSachNhanVienForm extends ActionForm{
	private String maChucVu;
	private ArrayList<ChucVu> listChucVu;
	private ArrayList<Quyen> listQuyen;
	private ArrayList<NhanVien> listNhanVien;
	
	private String tenDangNhap;

	
	
	
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public ArrayList<Quyen> getListQuyen() {
		return listQuyen;
	}
	public void setListQuyen(ArrayList<Quyen> listQuyen) {
		this.listQuyen = listQuyen;
	}
	public String getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}
	public ArrayList<ChucVu> getListChucVu() {
		return listChucVu;
	}
	public void setListChucVu(ArrayList<ChucVu> listChucVu) {
		this.listChucVu = listChucVu;
	}
	public ArrayList<NhanVien> getListNhanVien() {
		return listNhanVien;
	}
	public void setListNhanVien(ArrayList<NhanVien> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}
	
	
	
	
	

}
