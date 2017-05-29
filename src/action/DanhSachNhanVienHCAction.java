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
import model.bean.ChucVu;
import model.bean.NhanVien;
import model.bean.Quyen;
import model.bo.ChucVuBO;
import model.bo.NguoiDungBO;
import model.bo.NhanVienBO;
import model.bo.QuyenBO;
import form.DanhSachNhanVienForm;
import common.StringProcess;


public class DanhSachNhanVienHCAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DanhSachNhanVienForm nhanVienForm = (DanhSachNhanVienForm) form;
		
		HttpSession session =request.getSession();
		String tenDangNhap=	(String) session.getAttribute("tenDangNhap");
		String matKhau=	(String) session.getAttribute("matKhau");
		
		// lay thong tin nhan vien dang dăng nhạp hethong
		NhanVienBO nhanVienBO = new NhanVienBO();
		
		NhanVien nhanVien = nhanVienBO.getThongTinNhanVien(tenDangNhap);
		nhanVienForm.setTenDangNhap(nhanVien.getTenNhanVien());
		
		
				//lay danh sach chuc vu
				ChucVuBO chucVuBO = new ChucVuBO();
				ArrayList<ChucVu> listChucVu = chucVuBO.getListChucVu();
				nhanVienForm.setListChucVu(listChucVu);
				
				//lay danh sach quyen
				QuyenBO quyenBO = new QuyenBO();
				ArrayList<Quyen> listQuyen = quyenBO.getListQuyen();
				nhanVienForm.setListQuyen(listQuyen);
				
				//lay danh sach nhan vien
				ArrayList<NhanVien> listNhanVien;
				
				NguoiDungBO nguoiDungBO = new NguoiDungBO();
				
				
				
				String ng = nguoiDungBO.checkLogin(tenDangNhap, matKhau); 
				if(nguoiDungBO.checkLogin(tenDangNhap, matKhau)  != null){
					if("1".equals(ng)){				//kiem tra neu chinh xac
						String maChucVu = nhanVienForm.getMaChucVu();
						if(maChucVu==null || maChucVu.length()==0){
							listNhanVien = nhanVienBO.getListNhanVien();
						} else {
							listNhanVien = nhanVienBO.getListNhanVien(maChucVu);
						}
						nhanVienForm.setListNhanVien(listNhanVien);
						return mapping.findForward("dsNhanVien");
					} else {
						String maChucVu = nhanVienForm.getMaChucVu();
						if(maChucVu==null || maChucVu.length()==0){
							listNhanVien = nhanVienBO.getListNhanVien();
						} else {
							listNhanVien = nhanVienBO.getListNhanVien(maChucVu);
						}
						nhanVienForm.setListNhanVien(listNhanVien);
						return mapping.findForward("nhanvien");
					}
				}
				
					return mapping.findForward("nhanvien");

	}

}
