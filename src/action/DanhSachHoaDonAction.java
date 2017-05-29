package action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import form.DanhSachHoaDonForm;
import model.bean.HoaDon;
import model.bean.NhanVien;
import model.bo.HoaDonBO;
import model.bo.NhanVienBO;

public class DanhSachHoaDonAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		DanhSachHoaDonForm hoaDonForm = (DanhSachHoaDonForm) form;
		
		// lay thong tin nhan vien dang dăng nhạp hethong
		NhanVienBO nhanVienBO = new NhanVienBO();
		HttpSession session =request.getSession();
		String tenDangNhap=	(String) session.getAttribute("tenDangNhap");
		System.out.println(tenDangNhap);
		
		NhanVien nhanVien = nhanVienBO.getThongTinNhanVien(tenDangNhap);
		hoaDonForm.setTenDangNhap(nhanVien.getTenNhanVien());
		
		// lay danh sach  hoa don
		ArrayList<HoaDon> listHoaDon;
		HoaDonBO hoaDonBO = new HoaDonBO();
		listHoaDon = hoaDonBO.getListHoaDon();
		hoaDonForm.setListHoaDon(listHoaDon);
		
		return mapping.findForward("dsHoaDon");
	}

}
