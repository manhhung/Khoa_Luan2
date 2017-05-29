package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LoaiHangForm;
import model.bo.LoaiHangBO;

public class XoaLoaiHangAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		LoaiHangForm loaiHangForm = (LoaiHangForm) form;
		LoaiHangBO loaiHangBO = new LoaiHangBO();
		String maLoaiHang = loaiHangForm.getMaLoaiHang();
		loaiHangBO.xoaLoaiHang(maLoaiHang);
		return mapping.findForward("xoaLoaiHangxong");
		
				
	}

}
