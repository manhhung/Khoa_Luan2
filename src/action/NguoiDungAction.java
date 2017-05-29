package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.NguoiDungBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.NguoiDungForm;

public class NguoiDungAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		NguoiDungForm nguoiDungForm = (NguoiDungForm) form;
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		String tenDangNhap = nguoiDungForm.getTenDangNhap();
		String matKhau = nguoiDungForm.getMatKhau();
		
		HttpSession session=request.getSession();
		session.setAttribute("tenDangNhap", tenDangNhap);
		session.setAttribute("matKhau", matKhau);
		
		String ng = nguoiDungBO.checkLogin(tenDangNhap, matKhau); 
		if(nguoiDungBO.checkLogin(tenDangNhap, matKhau)  != null){
			if("1".equals(ng)){				//kiem tra neu chinh xac
				return mapping.findForward("admin");
			} else {
				return mapping.findForward("nhanvien");
			}
		} else {														//neu khong chinh xac
			nguoiDungForm.setThongBao("Đăng nhập thất bại");
			return mapping.findForward("thatBai");
		}
	}
}

