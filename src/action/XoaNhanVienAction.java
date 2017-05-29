package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.NhanVienForm;
import model.bo.NhanVienBO;

public class XoaNhanVienAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		NhanVienForm nhanVienForm = (NhanVienForm) form;
		NhanVienBO nhanVienBO = new NhanVienBO();
		String maNhanVien = nhanVienForm.getMaNhanVien();
		nhanVienBO.xoaNhanVien(maNhanVien);
		return mapping.findForward("xoaNVxong");
	}

}
