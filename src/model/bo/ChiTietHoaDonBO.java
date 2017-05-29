package model.bo;

import java.util.ArrayList;

import model.bean.ChiTietHoaDon;
import model.dao.ChiTietHoaDonDAO;

public class ChiTietHoaDonBO {
	ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();

	public ArrayList<ChiTietHoaDon> getListChiTietHoaDon(String maHoaDon) {
		return chiTietHoaDonDAO.getListChiTietHoaDon(maHoaDon);
	}

}
