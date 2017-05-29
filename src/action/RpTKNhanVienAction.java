package action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.RpThongKeForm;
import form.ThongKeForm;

public class RpTKNhanVienAction  extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ThongKeForm thongKeForm = (ThongKeForm) form;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String s = "Thống kê";
		s = thongKeForm.getSubmit();
		if(s!= null)
		{
			String ngayBatDau = thongKeForm.getNgayBatDau();
			thongKeForm.setNgayBatDau(ngayBatDau);
			System.out.println(ngayBatDau);
			String ngayKetThuc = thongKeForm.getNgayKetThuc();
			thongKeForm.setNgayKetThuc(ngayKetThuc);
			System.out.println(ngayKetThuc);
			return mapping.findForward("reportTKNV");
		}
		return mapping.findForward("thongke");
}
}
