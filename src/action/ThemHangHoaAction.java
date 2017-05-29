package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.LoaiHang;
import model.bean.NCC;
import model.bean.NhaCungCap;
import model.bo.LoaiHangBO;
import model.bo.NCCBO;
import model.bo.HangHoaBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;
import form.HangHoaForm;


public class ThemHangHoaAction extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			request.setCharacterEncoding("UTF-8");
			HangHoaForm hangHoaForm = (HangHoaForm) form;
			//lay danh sach loai hang
			LoaiHangBO loaiHangBO = new LoaiHangBO();
			ArrayList<LoaiHang> listLoaiHang = loaiHangBO.getListloaiHang();
			hangHoaForm.setListLoaiHang(listLoaiHang);
			
			//lay danh sach nha cung cap
			NCCBO nCCBO = new NCCBO();
			ArrayList<NhaCungCap> listNCC = nCCBO.getListNCC();
			hangHoaForm.setListNCC(listNCC);
			
			if("submit".equals(hangHoaForm.getSubmit())){		//nhan nut Xac nhan 
				System.out.println("toi acton them");
				String maHangHoa = hangHoaForm.getMaHangHoa();
				String maLoaiHang = hangHoaForm.getMaLoaiHang();
				String tenHangHoa = hangHoaForm.getTenHangHoa();
				int soLuong = hangHoaForm.getSoLuong();
				int donGia = hangHoaForm.getDonGia();
				String donViTinh = hangHoaForm.getDonViTinh();
				String maNCC = hangHoaForm.getMaNCC();
				String hinhAnh = hangHoaForm.getHinhAnh();
				String ghiChu = hangHoaForm.getGhiChu();
				HangHoaBO hangHoaBO = new HangHoaBO();
				hangHoaBO.themHangHoa(maHangHoa, maLoaiHang, tenHangHoa, soLuong, donGia, donViTinh, maNCC, hinhAnh, ghiChu);
				return mapping.findForward("themHangHoaxong");
			} else {											//chuyen sang trang 
				return mapping.findForward("themHangHoa");
			}
	}
	
}
