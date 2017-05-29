package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachLoaiHangForm;
import model.bean.LoaiHang;
import model.bean.NhanVien;
import model.bo.LoaiHangBO;
import model.bo.NhanVienBO;

public class DanhSachLoaiHangAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		DanhSachLoaiHangForm loaiHangForm = (DanhSachLoaiHangForm) form;


		// lay thong tin nhan vien dang dăng nhạp hethong
				NhanVienBO nhanVienBO = new NhanVienBO();
				HttpSession session =request.getSession();
				String tenDangNhap=	(String) session.getAttribute("tenDangNhap");
				System.out.println(tenDangNhap);
				
				NhanVien nhanVien = nhanVienBO.getThongTinNhanVien(tenDangNhap);
				loaiHangForm.setTenDangNhap(nhanVien.getTenNhanVien());
		
		//lay danh sach loai hang
		ArrayList<LoaiHang> listLoaiHang;
		LoaiHangBO loaiHangBO = new LoaiHangBO();
		listLoaiHang = loaiHangBO.getListloaiHang();
		loaiHangForm.setListLoaiHang(listLoaiHang);
		
		return mapping.findForward("dsLoaiHang");
	}
	

}
