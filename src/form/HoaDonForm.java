package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import model.bean.KhachHang;
import model.bean.LoaiHang;
import model.bean.NCC;
import model.bean.NhaCungCap;
import model.bean.NhanVien;
import model.bean.HangHoa;
import model.bean.HoaDon;

public class HoaDonForm extends ActionForm {
	private String maHoaDon;
	private String maNhanVien;
	private String tenNhanVien;
	private String maKH;
	private String tenKH;
	private String ngayLap;
	private ArrayList<NhanVien> listNhanVien;
	private ArrayList<KhachHang> listKhachHang;
	private String submit;
	
	
	private String maLoaiHang;
	private String maLoaiHang2;
	private ArrayList<LoaiHang> listLoaiHang;
	private ArrayList<HangHoa> listHangHoa;
	private ArrayList<NhaCungCap> listNCC;

	private String maHangHoa;
	private String tenHangHoa;
	private String tenLoaiHang;
	private int soLuong;
	private int donGia;
	private String donViTinh;
	private String maNCC;
	private String ghiChu;
	private String tenNCC;
	private String hinhAnh;
	private FormFile file;
	private String thongBao;
	private String[] listLoaiHangS;
	private String[] listNCCS;
	
	private String msp;
	private String tenDangNhap;
	
	
	
	
	
	
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public ArrayList<NhaCungCap> getListNCC() {
		return listNCC;
	}
	public void setListNCC(ArrayList<NhaCungCap> listNCC) {
		this.listNCC = listNCC;
	}
	public String getMsp() {
		return msp;
	}
	public void setMsp(String msp) {
		this.msp = msp;
	}
	public String getMaLoaiHang() {
		return maLoaiHang;
	}
	public void setMaLoaiHang(String maLoaiHang) {
		this.maLoaiHang = maLoaiHang;
	}
	public String getMaLoaiHang2() {
		return maLoaiHang2;
	}
	public void setMaLoaiHang2(String maLoaiHang2) {
		this.maLoaiHang2 = maLoaiHang2;
	}
	public ArrayList<LoaiHang> getListLoaiHang() {
		return listLoaiHang;
	}
	public void setListLoaiHang(ArrayList<LoaiHang> listLoaiHang) {
		this.listLoaiHang = listLoaiHang;
	}
	public ArrayList<HangHoa> getListHangHoa() {
		return listHangHoa;
	}
	public void setListHangHoa(ArrayList<HangHoa> listHangHoa) {
		this.listHangHoa = listHangHoa;
	}

	public String getMaHangHoa() {
		return maHangHoa;
	}
	public void setMaHangHoa(String maHangHoa) {
		this.maHangHoa = maHangHoa;
	}
	public String getTenHangHoa() {
		return tenHangHoa;
	}
	public void setTenHangHoa(String tenHangHoa) {
		this.tenHangHoa = tenHangHoa;
	}
	public String getTenLoaiHang() {
		return tenLoaiHang;
	}
	public void setTenLoaiHang(String tenLoaiHang) {
		this.tenLoaiHang = tenLoaiHang;
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
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public FormFile getFile() {
		return file;
	}
	public void setFile(FormFile file) {
		this.file = file;
	}
	public String getThongBao() {
		return thongBao;
	}
	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}
	public String[] getListLoaiHangS() {
		return listLoaiHangS;
	}
	public void setListLoaiHangS(String[] listLoaiHangS) {
		this.listLoaiHangS = listLoaiHangS;
	}
	public String[] getListNCCS() {
		return listNCCS;
	}
	public void setListNCCS(String[] listNCCS) {
		this.listNCCS = listNCCS;
	}

	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
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

	public String getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}
	public ArrayList<NhanVien> getListNhanVien() {
		return listNhanVien;
	}
	public void setListNhanVien(ArrayList<NhanVien> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}
	public ArrayList<KhachHang> getListKhachHang() {
		return listKhachHang;
	}
	public void setListKhachHang(ArrayList<KhachHang> listKhachHang) {
		this.listKhachHang = listKhachHang;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
