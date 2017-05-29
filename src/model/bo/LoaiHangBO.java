package model.bo;

import java.util.ArrayList;

import model.bean.LoaiHang;
import model.dao.LoaiHangDAO;

public class LoaiHangBO {
	LoaiHangDAO loaiHangDAO = new LoaiHangDAO();

	public ArrayList<LoaiHang> getListloaiHang() {
		return loaiHangDAO.getListLoaiHang();
	}

	public void capNhatLoaiHang(String maLoaiHang, String tenLoaiHang, String moTa) {
		loaiHangDAO.capNhatLoaiHang(maLoaiHang, tenLoaiHang, moTa);
		
	}

	public LoaiHang getThongTinLoaiHang(String maLoaiHang) {
		return loaiHangDAO.getThongTinLoaiHang(maLoaiHang);
	}

	public void themLoaiHang(String maLoaiHang, String tenLoaiHang, String moTa) {
		loaiHangDAO.themLoaiHang(maLoaiHang, tenLoaiHang, moTa);
		
	}

	public void xoaLoaiHang(String maLoaiHang) {
		loaiHangDAO.xoaLoaiHang(maLoaiHang);
		
	}

}
