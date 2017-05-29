package model.bo;

import java.util.ArrayList;

import model.bean.Quyen;
import model.dao.QuyenDAO;
public class QuyenBO {
	QuyenDAO quyenDAO = new QuyenDAO();

	public ArrayList<Quyen> getListQuyen() {
		return quyenDAO.getListQuyen();
	}

}
