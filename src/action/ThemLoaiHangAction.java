package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LoaiHangForm;
import model.bo.LoaiHangBO;

public class ThemLoaiHangAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("toi action them loai hang");
		request.setCharacterEncoding("UTF-8");
		LoaiHangForm loaiHangForm = (LoaiHangForm) form;
		
		String s = "Thêm mới";
		s = loaiHangForm.getSubmit();
		if(s != null){
			String maLoaiHang = loaiHangForm.getMaLoaiHang();
			String tenLoaiHang = loaiHangForm.getTenLoaiHang();
			String moTa = loaiHangForm.getMoTa();
			LoaiHangBO loaiHangBO = new LoaiHangBO();
			loaiHangBO.themLoaiHang(maLoaiHang, tenLoaiHang, moTa);
			return mapping.findForward("themLoaiHangxong");
		} else {
			return mapping.findForward("themLoaiHang");
		}
		
	}
}
