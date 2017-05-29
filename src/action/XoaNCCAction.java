package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhaCungCap;
import model.bo.NCCBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.NCCForm;

public class XoaNCCAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		NCCForm nCCForm = (NCCForm) form;
		NCCBO nCCBO = new NCCBO();	
		String maNCC = nCCForm.getMaNCC();
		nCCBO.xoaNCC(maNCC);
		return mapping.findForward("xoaNCCxong");
		
		
	}
}