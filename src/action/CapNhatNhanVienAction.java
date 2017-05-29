package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.NhanVienForm;
import model.bean.ChucVu;
import model.bean.NhanVien;
import model.bean.Quyen;
import model.bo.ChucVuBO;
import model.bo.NhanVienBO;
import model.bo.QuyenBO;

public class CapNhatNhanVienAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session =request.getSession();
		String tenDangNhap2 = (String) session.getAttribute("tenDangNhap");
		String matKhau2 = (String) session.getAttribute("matKhau");
		String matKhau3 = matKhau2.trim();
		System.out.println(matKhau3);
		
		
		request.setCharacterEncoding("UTF-8");
		NhanVienForm nhanVienForm = (NhanVienForm) form;
		
		NhanVienBO nhanVienBO = new NhanVienBO();
		
		//lay danh sach chuc vu
				ChucVuBO chucVuBO = new ChucVuBO();
				ArrayList<ChucVu> listChucVu = chucVuBO.getListChucVu();
				nhanVienForm.setListChucVu(listChucVu);
				
				//lay danh sach quyen
				QuyenBO quyenBO = new QuyenBO();
				ArrayList<Quyen> listQuyen = quyenBO.getListQuyen();
				nhanVienForm.setListQuyen(listQuyen);
				//xac thuc du lieu
				
				// cap nhat nhan vien
				
				String maNhanVien = nhanVienForm.getMaNhanVien();
				
				String s = "Lưu lại";
				s = nhanVienForm.getSubmit();
				if(s != null){
					
					String tenNhanVien = nhanVienForm.getTenNhanVien();
					String maChucVu = nhanVienForm.getMaChucVu();
					String diaChi = nhanVienForm.getDiaChi();
					int dienThoai = nhanVienForm.getDienThoai();
					String ngaySinh = nhanVienForm.getNgaySinh();
					String gioiTinh = nhanVienForm.getGioiTinh();
					int maQuyen = nhanVienForm.getMaQuyen();
					String matKhau = nhanVienForm.getMatKhau().trim();
					nhanVienBO.capNhatNhanVien(maNhanVien, tenNhanVien, maChucVu, diaChi, dienThoai, ngaySinh, gioiTinh, maQuyen, matKhau);
					System.out.println("XONG CAPNHATNHANVIEN DAO");
					
					if(matKhau3 != matKhau){
						System.out.println(matKhau3);
						System.out.println(matKhau);
						System.out.println("matkhau 3 khac matkhau");
						return mapping.findForward("capNhatNVxong");
					}
					return mapping.findForward("thatBai");
	
					
//					if(matKhau3 != matKhau){
//						System.out.println("ve man hình dang nhap");
//						
//					}
					
	
					
				} else {
					NhanVien nhanVien = nhanVienBO.getThongTinNhanVien(maNhanVien);
					nhanVienForm.setTenNhanVien(nhanVien.getTenNhanVien());
					nhanVienForm.setMaChucVu(nhanVien.getMaChucVu());
					nhanVienForm.setDiaChi(nhanVien.getDiaChi());
					nhanVienForm.setDienThoai(nhanVien.getDienThoai());
					nhanVienForm.setNgaySinh(nhanVien.getNgaySinh());
					nhanVienForm.setGioiTinh(nhanVien.getGioiTinh());
					nhanVienForm.setMaQuyen(nhanVien.getMaQuyen());
					nhanVienForm.setMatKhau(nhanVien.getMatKhau());
					return mapping.findForward("capNhatNV");
					
				}
	}

}
