package model.bo;

import model.dao.NguoiDungDAO;


public class NguoiDungBO {
	NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();

	public String checkLogin(String tenDangNhap, String matKhau) {
		return nguoiDungDAO.checkLogin(tenDangNhap, matKhau);
	}
	
}

