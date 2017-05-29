package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import model.bean.HangHoa;
import model.bean.LoaiHang;
import model.bean.NCC;
import model.bean.NhaCungCap;

public class HangHoaForm extends ActionForm {
	private String maHangHoa;
	private String tenHangHoa;
	private String maLoaiHang;
	private String tenLoaiHang;
	private int soLuong;
	private int donGia;
	private String donViTinh;
	private String maNCC;
	private String tenNCC;
	private String submit;
	private ArrayList<LoaiHang> listLoaiHang;
	private ArrayList<HangHoa> listHangHoa;
	private ArrayList<NhaCungCap> listNCC;
	private String GhiChu;
	private String HinhAnh;
	private FormFile file;
	
	
	
	public ArrayList<NhaCungCap> getListNCC() {
		return listNCC;
	}
	public void setListNCC(ArrayList<NhaCungCap> listNCC) {
		this.listNCC = listNCC;
	}
	public FormFile getFile() {
		return file;
	}
	public void setFile(FormFile file) {
		this.file = file;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	public String getHinhAnh() {
		return HinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
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
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
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
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	
	
	
	

}
