package model.bo;
import java.util.ArrayList;

import model.bean.HoaDon;
import model.dao.HoaDonDAO;

public class HoaDonBO {
	
	HoaDonDAO hoaDonDAO = new HoaDonDAO();
	
	public ArrayList<HoaDon> getListHoaDon(){
		return hoaDonDAO.getListHoaDon();
	}
	
	public ArrayList<HoaDon> getListHoaDon(String maHoaDon){
		return hoaDonDAO.getListHoaDon(maHoaDon);
	}

	public void themHoaDon(String maHoaDon, String maNhanVien, String maKhachHang) {
		hoaDonDAO.themHoaDon(maHoaDon, maNhanVien, maKhachHang);
		
	}
	
	public HoaDon getThongTinHoaDon(String maHoaDon) {
		return hoaDonDAO.getThongTinHoaDon(maHoaDon);
	}

	public boolean checkMaHoaDon(String maHoaDon) {
		return hoaDonDAO.checkMaHoaDon(maHoaDon);
	}

	public void xoaHangHoa(String maHoaDon) {
		hoaDonDAO.xoaHoaDon(maHoaDon);
		
	}

}
