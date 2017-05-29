package model.bo;
import java.util.ArrayList;

import model.bean.NhanVien;
import model.dao.NhanVienDAO;

public class NhanVienBO {
	NhanVienDAO nhanVienDAO = new NhanVienDAO();
	
	public ArrayList<NhanVien> getListNhanVien(){
		return nhanVienDAO.getListNhanVien();
	}

	public ArrayList<NhanVien> getListNhanVien(String maChucVu) {
		
		return nhanVienDAO.getListNhanVien(maChucVu);
	}

	public void themNhanVien(String maChucVu, String maNhanVien, String tenNhanVien, String diaChi, int dienThoai,
			String ngaySinh, String gioiTinh, int maQuyen, String matKhau) {
		nhanVienDAO.themNhanVien(maChucVu, maNhanVien, tenNhanVien, diaChi, dienThoai, ngaySinh, gioiTinh, maQuyen, matKhau);
		
	}

	public NhanVien getThongTinNhanVien(String maNhanVien) {
		return nhanVienDAO.getThongTinNhanVien(maNhanVien);
	}

	public void capNhatNhanVien(String maNhanVien, String tenNhanVien, String maChucVu, String diaChi, int dienThoai,
			String ngaySinh, String gioiTinh, int maQuyen, String matKhau) {
		nhanVienDAO.capNhatSinhVien(maNhanVien, tenNhanVien, maChucVu, diaChi, dienThoai, ngaySinh, gioiTinh, maQuyen, matKhau);
		
	}

	public void xoaNhanVien(String maNhanVien) {
		nhanVienDAO.xoaNhanVien(maNhanVien);
		
	}

}
