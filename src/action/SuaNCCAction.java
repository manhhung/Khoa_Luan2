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



public class SuaNCCAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		NCCForm nCCForm = (NCCForm) form;
		
		NCCBO nCCBO = new NCCBO();	
	
			
		
		String maNCC = nCCForm.getMaNCC();
		
		String s = "Lưu lại";
		s = nCCForm.getSubmit();
		if(s != null){		//nhan nut Xac nhan
					String tenNCC=nCCForm.getTenNCC();
					String diaChi=nCCForm.getDiaChi();
					String sDT=nCCForm.getsDT();
					nCCBO.capNhatNCC(maNCC, tenNCC, diaChi, sDT);
					return mapping.findForward("capNhatNCCxong");
				} else {														//chuyen sang trang Sua cau hoi02
					NhaCungCap nhaCungCap = nCCBO.getThongTinNCC(maNCC);
					nCCForm.setTenNCC(nhaCungCap.getTenNCC());
					nCCForm.setDiaChi(nhaCungCap.getDiaChi());
					nCCForm.setsDT(nhaCungCap.getsDT());
					return mapping.findForward("capNhatNCC");
				}		
	}
}
