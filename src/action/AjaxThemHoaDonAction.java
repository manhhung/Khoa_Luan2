package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import form.AjaxThemHoaDonForm;
import model.bo.HangHoaXuatBO;


public class AjaxThemHoaDonAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AjaxThemHoaDonForm ajaxThemHoaDonForm =(AjaxThemHoaDonForm) form;
		String maHoaDon = ajaxThemHoaDonForm.getMaHoaDon();
		String maHangHoa = ajaxThemHoaDonForm.getMaHangHoa();
		int soLuong = ajaxThemHoaDonForm.getSoLuong();
		int donGia = ajaxThemHoaDonForm.getThanhTien();
		HangHoaXuatBO hangHoaXuatBO = new HangHoaXuatBO();
		hangHoaXuatBO.themHangHoaXuat(maHoaDon, maHangHoa, soLuong, donGia);
		response.setContentType("text/text;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out = response.getWriter();
		out.println("Hello"+maHoaDon);
		out.flush();
		return null;
	}

}
