package form;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.struts.action.ActionForm;
import java.text.SimpleDateFormat;

import model.bean.LoaiHang;

public class ThongKeForm extends ActionForm{
	


	private String maLoaiHang;
	private static String maLoaiHang2;
	private String tenLoaiHang;
	private ArrayList<LoaiHang> listLoaiHang;
	private String ngayBatDau;
	private String ngayKetThuc;
	
	private static String ngayBatDau2;
	private static String ngayKetThuc2;
	
	private String submit;
	
	private String tenDangNhap;
	
	
	
	
	
	
	
	
	
	
	public String getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
		ngayBatDau2 = ngayBatDau;
	}
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
		ngayKetThuc2 = ngayKetThuc;
	}
	public static String getNgayBatDau2() {
		return ngayBatDau2;
	}
	public static void setNgayBatDau2(String ngayBatDau2) {
		ThongKeForm.ngayBatDau2 = ngayBatDau2;
	}
	public static String getNgayKetThuc2() {
		return ngayKetThuc2;
	}
	public static void setNgayKetThuc2(String ngayKetThuc2) {
		ThongKeForm.ngayKetThuc2 = ngayKetThuc2;
	}
	public static String getMaLoaiHang2() {
		return maLoaiHang2;
	}
	public static void setMaLoaiHang2(String maLoaiHang2) {
		ThongKeForm.maLoaiHang2 = maLoaiHang2;
	}
	public String getMaLoaiHang() {
		return maLoaiHang;
	}
	public void setMaLoaiHang(String maLoaiHang) {
		this.maLoaiHang = maLoaiHang;
		maLoaiHang2 = maLoaiHang;
	}
	public String getTenLoaiHang() {
		return tenLoaiHang;
	}
	public void setTenLoaiHang(String tenLoaiHang) {
		this.tenLoaiHang = tenLoaiHang;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public ArrayList<LoaiHang> getListLoaiHang() {
		return listLoaiHang;
	}
	public void setListLoaiHang(ArrayList<LoaiHang> listLoaiHang) {
		this.listLoaiHang = listLoaiHang;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	

}
