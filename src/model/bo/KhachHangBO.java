package model.bo;

import java.util.ArrayList;

import model.bean.KhachHang;
import model.dao.KhachHangDAO;

public class KhachHangBO {
	KhachHangDAO khachHangDAO = new KhachHangDAO();
	
	public ArrayList<KhachHang> getListKhachHang(){
		return khachHangDAO.getListKH();
	}
	
	public void themKH(String maKH, String tenKH, String gioiTinh,
			String ngaySinh, String diaChi, String sDT) {
		// TODO Auto-generated method stub
		khachHangDAO.themKH(maKH, tenKH,gioiTinh,ngaySinh, diaChi, sDT);
	}

	public void SuaKH(String maKH, String tenKH, String gioiTinh,
			String ngaySinh, String diaChi, String sDT) {
		// TODO Auto-generated method stub
		khachHangDAO.SuaKH(maKH, tenKH,gioiTinh,ngaySinh, diaChi, sDT);
	}

	public KhachHang getThongTinKH(String maKH) {
		// TODO Auto-generated method stub
		return khachHangDAO.getThongTinKH(maKH);
	}

	public void xoaKH(String maKH) {
		// TODO Auto-generated method stub
		khachHangDAO.xoaKH(maKH);
	}

}
