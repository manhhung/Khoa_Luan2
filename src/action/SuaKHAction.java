package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.KhachHang;

import model.bo.KhachHangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.KHForm;


public class SuaKHAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		KHForm kHForm = (KHForm) form;
		KhachHangBO khachHangBO = new KhachHangBO();
		
		
		//sua cÃƒÂ¢u hÃ¡Â»ï¿½i
		String maKH = kHForm.getMaKH();
		String s = "Lưu lại";
		s = kHForm.getSubmit();
		
		if(s != null){		//nhan nut Xac nhan
			System.out.println("da");
			String tenKH = kHForm.getTenKH();
			String gioiTinh=kHForm.getGioiTinh();
			String ngaySinh=kHForm.getNgaySinh();
			String diaChi = kHForm.getDiaChi();
			String sDT = kHForm.getsDT();
			khachHangBO.SuaKH(maKH, tenKH,gioiTinh,ngaySinh, diaChi, sDT);
			return mapping.findForward("capNhatKHxong");
			} else {														//chuyen sang trang Sua cau hoi02
			KhachHang khachHang = khachHangBO.getThongTinKH(maKH);
			kHForm.setTenKH(khachHang.getTenKH());
			kHForm.setGioiTinh(khachHang.getGioiTinh());
			kHForm.setNgaySinh(khachHang.getNgaySinh());
			kHForm.setDiaChi(khachHang.getDiaChi());
			kHForm.setsDT(khachHang.getsDT());
			return mapping.findForward("capNhatKH");
		}		
	}
}
