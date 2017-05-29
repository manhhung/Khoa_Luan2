package action;
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

import form.NhanVienForm;
import model.bean.ChucVu;
import model.bean.Quyen;
import model.bo.ChucVuBO;
import model.bo.NhanVienBO;
import model.bo.QuyenBO;

public class ThemNhanVienAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		NhanVienForm nhanVienForm = (NhanVienForm) form;
		
		HttpSession session =request.getSession();
		String tenDangNhap=	(String) session.getAttribute("tenDangNhap");
		nhanVienForm.setTenDangNhap(tenDangNhap);
		
		
		//lay danh sach chuc vu
		ChucVuBO chucVuBO = new ChucVuBO();
		ArrayList<ChucVu> listChucVu = chucVuBO.getListChucVu();
		nhanVienForm.setListChucVu(listChucVu);
		
		//lay danh sach quyen
		QuyenBO quyenBO = new QuyenBO();
		ArrayList<Quyen> listQuyen = quyenBO.getListQuyen();
		nhanVienForm.setListQuyen(listQuyen);
		//xac thuc du lieu
		String s = "Thêm mới";
		s = nhanVienForm.getSubmit();
		
		if(s != null){
			System.out.println("Vào action");
			String maChucVu = nhanVienForm.getMaChucVu();
			String maNhanVien = nhanVienForm.getMaNhanVien();
			String tenNhanVien = nhanVienForm.getTenNhanVien();
			String diaChi = nhanVienForm.getDiaChi();
			int dienThoai = nhanVienForm.getDienThoai();
			String ngaySinh = nhanVienForm.getNgaySinh();
			String gioiTinh = nhanVienForm.getGioiTinh();
			int maQuyen = nhanVienForm.getMaQuyen();
			String matKhau = nhanVienForm.getMatKhau();
			NhanVienBO nhanVienBO = new NhanVienBO();
			nhanVienBO.themNhanVien(maChucVu, maNhanVien, tenNhanVien, diaChi, dienThoai, ngaySinh, gioiTinh, maQuyen, matKhau);
			return mapping.findForward("themNVxong");
		} else{
			return mapping.findForward("themNV");
		}
	}

}
