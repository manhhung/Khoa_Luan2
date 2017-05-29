package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.KhachHangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.KHForm;


public class ThemKHAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		KHForm kHForm= (KHForm) form;
		
		String s = "Thêm mới";
		s = kHForm.getSubmit();
		if(s != null){		//nhan nut Xac nhan
			String maKH = kHForm.getMaKH();
			String tenKH = kHForm.getTenKH();
			String gioiTinh=kHForm.getGioiTinh();
			String ngaySinh=kHForm.getNgaySinh();
			String diaChi = kHForm.getDiaChi();
			String sDT = kHForm.getsDT();
			
			KhachHangBO khachHangBO = new KhachHangBO();
			khachHangBO.themKH(maKH, tenKH,gioiTinh,ngaySinh, diaChi, sDT);
			return mapping.findForward("themKHxong");
		} else {											//chuyen sang trang Them cau hoi
			return mapping.findForward("themKH");
}
	}
}
