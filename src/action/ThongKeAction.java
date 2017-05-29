package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.RpThongKeForm;
import form.ThongKeForm;
import model.bean.LoaiHang;
import model.bean.NhanVien;
import model.bo.LoaiHangBO;
import model.bo.NhanVienBO;

public class ThongKeAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ThongKeForm thongKeForm = (ThongKeForm) form;
		
		
		// lay thong tin nhan vien dang dăng nhạp hethong
		NhanVienBO nhanVienBO = new NhanVienBO();
		HttpSession session =request.getSession();
		String tenDangNhap=	(String) session.getAttribute("tenDangNhap");
		System.out.println(tenDangNhap);
		
		NhanVien nhanVien = nhanVienBO.getThongTinNhanVien(tenDangNhap);
		thongKeForm.setTenDangNhap(nhanVien.getTenNhanVien());
		
		//lay danh sach loai hang
		LoaiHangBO loaiHangBO = new LoaiHangBO();
		ArrayList<LoaiHang> listLoaiHang = loaiHangBO.getListloaiHang();
		thongKeForm.setListLoaiHang(listLoaiHang);
		
		String s = "Thống kê";
		s = thongKeForm.getSubmit();
		if(s!= null)
		{
			String maLoaiHang = thongKeForm.getMaLoaiHang();
			thongKeForm.setMaLoaiHang(maLoaiHang);
			System.out.println(maLoaiHang);
			return mapping.findForward("reportTK");
		}
		return mapping.findForward("thongke");
	}
}
