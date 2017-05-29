package form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class RpThongKeForm extends ActionForm {

	private static String maLoaiHang;



	public static String getMaLoaiHang() {
		return maLoaiHang;
	}



	public void setMaLoaiHang(String maLoaiHang) {
		RpThongKeForm.maLoaiHang = maLoaiHang;
	}



	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
