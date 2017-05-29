package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachHangHoaForm;
import model.bo.HangHoaBO;


public class XoaHangHoaAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		DanhSachHangHoaForm hangHoaForm = (DanhSachHangHoaForm) form;
		HangHoaBO hangHoaBO = new HangHoaBO();
		
		String maHangHoa = hangHoaForm.getMaHangHoa();
		hangHoaBO.xoaHangHoa(maHangHoa);
		
		return mapping.findForward("xoaHangHoaxong");

	}
}
