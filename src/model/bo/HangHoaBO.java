package model.bo;

import model.dao.HangHoaDAO;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import model.bean.HangHoa;

public class HangHoaBO {

	HangHoaDAO hangHoaDAO = new HangHoaDAO();
	
	public ArrayList<HangHoa> getListHangHoa(){
		return hangHoaDAO.getListHangHoa();
	}
	
	public ArrayList<HangHoa> getListHangHoa(String maLoaiHang){
		return hangHoaDAO.getListHangHoa(maLoaiHang);
	}

	public void themHangHoa(String maHangHoa, String maLoaiHang2, String tenHangHoa, int soLuong, int donGia, String donViTinh, String maNCC, String fileName, String ghiChu){
			hangHoaDAO.themHangHoa(maHangHoa, maLoaiHang2, tenHangHoa, soLuong, donGia, donViTinh, maNCC, fileName, ghiChu);
		
	}

	public HangHoa getThongTinHangHoa(String maHangHoa) {
		return hangHoaDAO.getThongTinHangHoa(maHangHoa);
	}

	public void CapNhatHangHoa(String maHangHoa, String maLoaiHang, String tenHangHoa, int soLuong, int donGia,
			String donViTinh, String maNCC, String fileName, String ghiChu) {
		hangHoaDAO.CapNhatHangHoa(maHangHoa, maLoaiHang, tenHangHoa, soLuong, donGia, donViTinh, maNCC, fileName, ghiChu);

		
	}

	public void CapNhatHangHoaNull(String maHangHoa, String maLoaiHang, String tenHangHoa, int soLuong, int donGia,
			String donViTinh, String maNCC, String ghiChu) {
		hangHoaDAO.CapNhatHangHoaNull(maHangHoa, maLoaiHang, tenHangHoa, soLuong, donGia, donViTinh, maNCC, ghiChu);
		
	}

	public void xoaHangHoa(String maHangHoa) {
		hangHoaDAO.xoaHangHoa(maHangHoa);
		
	}

	
	/*
	 * 	public void themSinhVien(String msv, String hoTen, String gioiTinh, String maKhoa) {
		sinhVienDAO.themSinhVien(msv, hoTen, gioiTinh, maKhoa);
	}
	
	public SinhVien getThongTinSinhVien(String msv) {
		return sinhVienDAO.getThongTinSinhVien(msv);
	}
	
	public void suaSinhVien(String msv, String hoTen, String gioiTinh, String maKhoa) {
		sinhVienDAO.suaSinhVien(msv, hoTen, gioiTinh, maKhoa);
	}

	public void xoaSinhVien(String msv) {
		sinhVienDAO.xoaSinhVien(msv);
	}
	*/
	
}
