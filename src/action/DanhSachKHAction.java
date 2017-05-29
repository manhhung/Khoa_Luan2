package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.KhachHang;
import model.bean.NhanVien;
import model.bo.KhachHangBO;
import model.bo.NhanVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachKHForm;


public class DanhSachKHAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DanhSachKHForm danhSachKHForm = (DanhSachKHForm) form;
		
		// lay thong tin nhan vien dang dăng nhạp hethong
		NhanVienBO nhanVienBO = new NhanVienBO();
		HttpSession session =request.getSession();
		String tenDangNhap=	(String) session.getAttribute("tenDangNhap");
		System.out.println(tenDangNhap);
		
		NhanVien nhanVien = nhanVienBO.getThongTinNhanVien(tenDangNhap);
		danhSachKHForm.setTenDangNhap(nhanVien.getTenNhanVien());
		
		System.out.println("toi DS kh action");
		
		ArrayList<KhachHang> listKH;
		System.out.println("toi array KH");
		
		KhachHangBO khachHangBO = new KhachHangBO();
		
		listKH = khachHangBO.getListKhachHang();
		
		danhSachKHForm.setListKH(listKH);
		
		return mapping.findForward("dsKH");
	}
}
