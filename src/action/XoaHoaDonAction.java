package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import form.DanhSachHoaDonForm;

import model.bo.HoaDonBO;

public class XoaHoaDonAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		System.out.println("toi action xoa hoa don");
		DanhSachHoaDonForm hoaDonForm = (DanhSachHoaDonForm) form;
		
		HoaDonBO hoaDonBO = new HoaDonBO();
		
		String maHoaDon = hoaDonForm.getMaHoaDon();
		hoaDonBO.xoaHangHoa(maHoaDon);
		
		return mapping.findForward("xoaHoaDonxong");
	}

}
