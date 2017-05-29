package model.bo;
import java.util.ArrayList;

import model.bean.HangHoaXuat;
import model.dao.HangHoaXuatDAO;

public class HangHoaXuatBO {

	HangHoaXuatDAO hangHoaXuatDAO = new HangHoaXuatDAO();
	
	public ArrayList<HangHoaXuat> getListHangHoaXuat() {
		return hangHoaXuatDAO.getListHangHoaXuat();
	}

	public ArrayList<HangHoaXuat> getListSanPhamXuat(String maHoaDon) {
		return hangHoaXuatDAO.getListHangHoaXuat(maHoaDon);
	}

	public void themHangHoaXuat(String maHoaDon, String maHangHoa, int soLuong, int donGia) {
		hangHoaXuatDAO.themHangHoaXuat(maHoaDon, maHangHoa, soLuong, donGia);
	}

	public HangHoaXuat getThongTinHangHoaXuat(String maHoaDon) {
		return hangHoaXuatDAO.getThongTinHangHoaXuat(maHoaDon);
	}
	
	public void xoaHangHoaXuat(String maHoaDon){
		hangHoaXuatDAO.xoaHangHoaXuat(maHoaDon);
	}

}
