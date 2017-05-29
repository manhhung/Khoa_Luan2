package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.bo.NCCBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.NCCForm;

public class ThemNCCAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		NCCForm nCCForm= (NCCForm) form;
		
		String s = "Thêm mới";
		s = nCCForm.getSubmit();
		if(s != null){		//nhan nut Xac nhan
			String maNCC = nCCForm.getMaNCC();
			String tenNCC = nCCForm.getTenNCC();
			String diaChi = nCCForm.getDiaChi();
			String sDT = nCCForm.getsDT();
			System.out.println("abc");
			NCCBO nCCBO = new NCCBO();
			nCCBO.themNCC(maNCC, tenNCC, diaChi, sDT);
			return mapping.findForward("themNCCxong");
		} else {											//chuyen sang trang Them cau hoi
			return mapping.findForward("themNCC");
}
	}
}

