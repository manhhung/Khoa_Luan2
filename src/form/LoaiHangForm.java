package form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class LoaiHangForm extends ActionForm{
	private String maLoaiHang;
	private String tenLoaiHang;
	private String moTa;
	private String submit;
	
	
	
	public String getMaLoaiHang() {
		return maLoaiHang;
	}



	public void setMaLoaiHang(String maLoaiHang) {
		this.maLoaiHang = maLoaiHang;
	}



	public String getTenLoaiHang() {
		return tenLoaiHang;
	}



	public void setTenLoaiHang(String tenLoaiHang) {
		this.tenLoaiHang = tenLoaiHang;
	}



	public String getMoTa() {
		return moTa;
	}



	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}



	public String getSubmit() {
		return submit;
	}



	public void setSubmit(String submit) {
		this.submit = submit;
	}



	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	

}
