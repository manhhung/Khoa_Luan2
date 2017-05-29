package form;

import java.util.ArrayList;

import model.bean.NhaCungCap;

import org.apache.struts.action.ActionForm;

public class DanhSachNCCForm extends ActionForm{
	private String maNCC;
	
	private String tenDangNhap;
	
	
	
	
	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	private ArrayList<NhaCungCap> listNCC;

	public ArrayList<NhaCungCap> getListNCC() {
		return listNCC;
	}

	public void setListNCC(ArrayList<NhaCungCap> listNCC) {
		this.listNCC = listNCC;
	}
}
