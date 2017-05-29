package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NhaCungCap;
import model.bean.NhanVien;
import model.bo.NCCBO;
import model.bo.NhanVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachNCCForm;

public class DanhSachNCCAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DanhSachNCCForm danhSachNCCForm=(DanhSachNCCForm) form;
		
		// lay thong tin nhan vien dang dăng nhạp hethong
		NhanVienBO nhanVienBO = new NhanVienBO();
		HttpSession session =request.getSession();
		String tenDangNhap=	(String) session.getAttribute("tenDangNhap");
		System.out.println(tenDangNhap);
		
		NhanVien nhanVien = nhanVienBO.getThongTinNhanVien(tenDangNhap);
		danhSachNCCForm.setTenDangNhap(nhanVien.getTenNhanVien());
		
		ArrayList<NhaCungCap> listNCC;
		
		NCCBO nCCBO=new NCCBO();
		
		listNCC = nCCBO.getListNCC();
		
		danhSachNCCForm.setListNCC(listNCC);
		
		return mapping.findForward("dsNCC");
	}
}
