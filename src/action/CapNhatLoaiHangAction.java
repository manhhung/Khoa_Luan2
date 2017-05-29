package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LoaiHangForm;
import model.bean.LoaiHang;
import model.bo.LoaiHangBO;

public class CapNhatLoaiHangAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		LoaiHangForm loaiHangForm = (LoaiHangForm) form;
		
		LoaiHangBO loaiHangBO = new LoaiHangBO();
		
		String maLoaiHang = loaiHangForm.getMaLoaiHang();
		String s = "Lưu lại";
		s = loaiHangForm.getSubmit();
		if(s != null){
			String tenLoaiHang = loaiHangForm.getTenLoaiHang();
			String moTa = loaiHangForm.getMoTa();
			loaiHangBO.capNhatLoaiHang(maLoaiHang, tenLoaiHang, moTa);
			return mapping.findForward("capNhatLoaiHangxong");
		} else {
			LoaiHang loaiHang = loaiHangBO.getThongTinLoaiHang(maLoaiHang);
			loaiHangForm.setTenLoaiHang(loaiHang.getTenLoaiHang());
			loaiHangForm.setMoTa(loaiHang.getMoTa());
			return mapping.findForward("capNhatLoaiHang");
					
		}
		
	}

}
