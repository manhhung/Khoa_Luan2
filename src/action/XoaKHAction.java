package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.KhachHang;

import model.bo.KhachHangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.KHForm;

public class XoaKHAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		KHForm kHForm = (KHForm) form;
		KhachHangBO khachHangBO = new KhachHangBO();
		String maKH = kHForm.getMaKH();
		
		khachHangBO.xoaKH(maKH);
		return mapping.findForward("xoaKHxong");
		
	}
}
