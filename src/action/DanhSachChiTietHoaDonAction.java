package action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import form.DanhSachChiTietHoaDonForm;
import model.bean.ChiTietHoaDon;
import model.bo.ChiTietHoaDonBO;

public class DanhSachChiTietHoaDonAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		DanhSachChiTietHoaDonForm chiTietHoaDonForm = (DanhSachChiTietHoaDonForm) form;
		
		HttpSession session =request.getSession();
		String tenDangNhap=	(String) session.getAttribute("tenDangNhap");
		System.out.println(tenDangNhap);
		chiTietHoaDonForm.setTenDangNhap(tenDangNhap);
		
		System.out.println("toi action cthd");
		ArrayList<ChiTietHoaDon> listChiTietHoaDon;
		ChiTietHoaDonBO chiTietHoaDonBO = new ChiTietHoaDonBO(); 
		String maHoaDon = chiTietHoaDonForm.getMaHoaDon();
		listChiTietHoaDon = chiTietHoaDonBO.getListChiTietHoaDon(maHoaDon);
		chiTietHoaDonForm.setListChiTietHoaDon(listChiTietHoaDon);
		return mapping.findForward("dsChiTietHoaDon");
	}

}
