package form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;


public class NguoiDungForm extends ActionForm{

	private static final long serialVersionUID = 1L;
	private String tenDangNhap;
	private String matKhau;
	private String thongBao;
	
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getThongBao() {
		return thongBao;
	}
	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors actionErrors=new ActionErrors();
		if(StringProcess.notVaild(tenDangNhap)){
			actionErrors.add("tenDangNhapError",new ActionMessage("error.tenDangNhap"));
		}
		if(StringProcess.notVaild(matKhau)){
			actionErrors.add("matKhauError",new ActionMessage("error.matKhau"));
		}
		return actionErrors;
	}
}

