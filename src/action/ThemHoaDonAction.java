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

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import common.StringProcess;
import form.HoaDonForm;
import model.bean.HangHoa;
import model.bean.KhachHang;
import model.bean.LoaiHang;
import model.bean.NCC;
import model.bean.NhaCungCap;
import model.bean.NhanVien;
import model.bo.HangHoaBO;
import model.bo.HoaDonBO;
import model.bo.KhachHangBO;
import model.bo.LoaiHangBO;
import model.bo.NCCBO;
import model.bo.NhanVienBO;

public class ThemHoaDonAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			request.setCharacterEncoding("UTF-8");
			
			HoaDonForm hoaDonForm = (HoaDonForm) form;
			

			// lay thong tin nhan vien dang dăng nhạp hethong
						NhanVienBO nhanVienBO = new NhanVienBO();
						HttpSession session =request.getSession();
						String tenDangNhap=	(String) session.getAttribute("tenDangNhap");
						System.out.println(tenDangNhap);
						
						NhanVien nhanVien = nhanVienBO.getThongTinNhanVien(tenDangNhap);
						hoaDonForm.setTenNhanVien(nhanVien.getTenNhanVien());
					
					
			
			//lay danh sach khach hang
			KhachHangBO khachHangBO = new KhachHangBO();
			ArrayList<KhachHang> listKhachHang = khachHangBO.getListKhachHang();
			hoaDonForm.setListKhachHang(listKhachHang);
			
			//lay danh sach loai hang
			LoaiHangBO loaiHangBO = new LoaiHangBO();
			ArrayList<LoaiHang> listLoaiHang = loaiHangBO.getListloaiHang();
			hoaDonForm.setListLoaiHang(listLoaiHang);
			
			//lay danh sach nha cung cap
			NCCBO nCCBO = new NCCBO();
			ArrayList<NhaCungCap> listNCC = nCCBO.getListNCC();
			hoaDonForm.setListNCC(listNCC);
			
			//lay danh sach hang hoa
			HangHoaBO hangHoaBO = new HangHoaBO();
			HoaDonBO hoaDonBO = new HoaDonBO();
			ArrayList<HangHoa> listHangHoa = hangHoaBO.getListHangHoa();
			String maLoaiHang = hoaDonForm.getMaLoaiHang();
			if(maLoaiHang == null || maLoaiHang.length() == 0){
				listHangHoa = hangHoaBO.getListHangHoa();
			} else{
				listHangHoa = hangHoaBO.getListHangHoa(maLoaiHang);
			}
			hoaDonForm.setListHangHoa(listHangHoa);
			
		
			String s = "Tạo hóa đơn";
			s = hoaDonForm.getSubmit();
			if(s != null){
				ActionErrors actionErrors = new ActionErrors();
				
				if(hoaDonForm.getMaHoaDon()==""){
					actionErrors.add("errorMaHoaDon", new ActionMessage("error.input.trong"));
				}else 
					if(hoaDonBO.checkMaHoaDon(hoaDonForm.getMaHoaDon())){
						actionErrors.add("errorMaHoaDon", new ActionMessage("error.maPX.trung"));
				}
				
				saveErrors(request, actionErrors);
				if(actionErrors.size()>0){
					return mapping.findForward("themHoaDonerror");
				}
			}
			
			if(s != null){
				String maHoaDon = hoaDonForm.getMaHoaDon();
				String ngayLap = hoaDonForm.getNgayLap();
				String maKH = hoaDonForm.getMaKH();
				String maNhanVien = hoaDonForm.getMaNhanVien();		
				hoaDonBO.themHoaDon(maHoaDon, maNhanVien, maKH);
				
				return mapping.findForward("themHoaDonxong");
			}else{
				return mapping.findForward("themHoaDon");	
			}

}
	
	
}
