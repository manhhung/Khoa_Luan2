package model.bo;

import java.util.ArrayList;

import model.bean.HangHoa;
import model.bean.NCC;
import model.bean.NhaCungCap;
import model.dao.NCCDAO;

public class NCCBO {
	
	NCCDAO nCCDAO = new NCCDAO();
	
	
	public ArrayList<NhaCungCap> getListNCC() {
		return nCCDAO.getListNCC();
	}

	public void themNCC(String maNCC, String tenNCC, String diaChi, String sDT) {
		// TODO Auto-generated method stub
		nCCDAO.themNCC(maNCC,tenNCC,diaChi,sDT);
	}

	public void capNhatNCC(String maNCC, String tenNCC, String diaChi,
			String sDT) {
		// TODO Auto-generated method stub
		nCCDAO.capNhatNCC(maNCC,tenNCC,diaChi,sDT);
	}

	public NhaCungCap getThongTinNCC(String maNCC) {
		// TODO Auto-generated method stub
		return nCCDAO.getThongTinNCC(maNCC);
	}

	public void xoaNCC(String maNCC) {
		// TODO Auto-generated method stub
		nCCDAO.xoaNCC(maNCC);
	}
	


}
