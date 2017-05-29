package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThongKeForm;

public class RpThongKeDSNVAction extends Action{
	
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
			return mapping.findForward("thongkeDSNV");
		}
		return mapping.findForward("thongke");
	}
}
