package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import model.bean.ChucVu;
import model.bean.NhanVien;
import model.bean.Quyen;


public class NhanVienForm extends ActionForm{
	private String maNhanVien;
	private String tenNhanVien;
	private String maChucVu;
	private String tenChucVu;
	private String diaChi;
	private int dienThoai;
	private String ngaySinh;
	private String gioiTinh;
	private int maQuyen;
	private String tenQuyen;
	private String matKhau;
	
	private ArrayList<ChucVu> listChucVu;
	private ArrayList<Quyen> listQuyen;
	private String submit;
	private NhanVien nhanVien;
	
	private String tenDangNhap;
	
	
	
	
	
	
	public String getTenDangNhap() {
		return tenDangNhap;
	}




	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}




	public String getMatKhau() {
		return matKhau;
	}




	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}




	public String getMaNhanVien() {
		return maNhanVien;
	}




	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}




	public String getTenNhanVien() {
		return tenNhanVien;
	}




	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}




	public String getMaChucVu() {
		return maChucVu;
	}




	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}




	public String getTenChucVu() {
		return tenChucVu;
	}




	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}




	public String getDiaChi() {
		return diaChi;
	}




	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}




	public int getDienThoai() {
		return dienThoai;
	}




	public void setDienThoai(int dienThoai) {
		this.dienThoai = dienThoai;
	}




	public String getNgaySinh() {
		return ngaySinh;
	}




	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}




	public String getGioiTinh() {
		return gioiTinh;
	}




	public void setGioiTinh(String string) {
		this.gioiTinh = string;
	}




	public int getMaQuyen() {
		return maQuyen;
	}




	public void setMaQuyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}




	public String getTenQuyen() {
		return tenQuyen;
	}




	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}




	public ArrayList<ChucVu> getListChucVu() {
		return listChucVu;
	}




	public void setListChucVu(ArrayList<ChucVu> listChucVu) {
		this.listChucVu = listChucVu;
	}




	public ArrayList<Quyen> getListQuyen() {
		return listQuyen;
	}




	public void setListQuyen(ArrayList<Quyen> listQuyen) {
		this.listQuyen = listQuyen;
	}




	public String getSubmit() {
		return submit;
	}




	public void setSubmit(String submit) {
		this.submit = submit;
	}




	public NhanVien getNhanVien() {
		return nhanVien;
	}




	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}




	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
