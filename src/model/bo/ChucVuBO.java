package model.bo;

import java.util.ArrayList;

import model.bean.ChucVu;
import model.dao.ChucVuDAO;

public class ChucVuBO {
	ChucVuDAO chucVuDAO = new ChucVuDAO();
	
	public ArrayList<ChucVu> getListChucVu(){
		return chucVuDAO.getListChucVu();
	}

}
