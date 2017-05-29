package action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import form.DanhSachHangHoaForm;
import model.bean.HangHoa;
import model.bean.LoaiHang;
import model.bean.NCC;
import model.bean.NhaCungCap;
import model.bean.NhanVien;
import model.bo.HangHoaBO;
import model.bo.LoaiHangBO;
import model.bo.NCCBO;
import model.bo.NhanVienBO;
import form.HangHoaForm;
import form.NguoiDungForm;
import common.StringProcess;

public class DanhSachHangHoaAction extends Action{
	FormFile file;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		DanhSachHangHoaForm hangHoaForm = (DanhSachHangHoaForm) form;
		
				// lay thong tin nhan vien dang dăng nhạp hethong
		NhanVienBO nhanVienBO = new NhanVienBO();
		HttpSession session =request.getSession();
		String tenDangNhap=	(String) session.getAttribute("tenDangNhap");
		System.out.println(tenDangNhap);
		
		NhanVien nhanVien = nhanVienBO.getThongTinNhanVien(tenDangNhap);
		hangHoaForm.setTenDangNhap(nhanVien.getTenNhanVien());
		
		//lay danh sach loai hang
		LoaiHangBO loaiHangBO = new LoaiHangBO();
		ArrayList<LoaiHang> listLoaiHang = loaiHangBO.getListloaiHang();
		hangHoaForm.setListLoaiHang(listLoaiHang);
		
		//lay danh sach nha cung cap
		NCCBO nCCBO = new NCCBO();
		ArrayList<NhaCungCap> listNCC = nCCBO.getListNCC();
		hangHoaForm.setListNCC(listNCC);

		//lay danh sach hang hoa
		ArrayList<HangHoa> listHangHoa;
		HangHoaBO hangHoaBO = new HangHoaBO();
		String maHangHoa = hangHoaForm.getMaHangHoa();
		String maLoaiHang = hangHoaForm.getMaLoaiHang();
		if(maLoaiHang == null || maLoaiHang.length() == 0){
			listHangHoa = hangHoaBO.getListHangHoa();
		} else{
			listHangHoa = hangHoaBO.getListHangHoa(maLoaiHang);
		}
		//them hang hoa moi tu modal
		String s = "Thêm mới";
		s = hangHoaForm.getSubmit();
		if(s != null){
			ActionErrors actionErrors = new ActionErrors();
			
			if(StringProcess.notVaildS(hangHoaForm.getTenHangHoa())){
				actionErrors.add("tenHangHoaError", new ActionMessage("error.tenHangHoa.so"));
			}
			if(StringProcess.notVaildN(hangHoaForm.getSoLuong())){
				actionErrors.add("soLuongError", new ActionMessage("error.soLuong.so"));
			}else if(StringProcess.notVaildNumber(hangHoaForm.getSoLuong())){
				actionErrors.add("soLuongError", new ActionMessage("error.soLuong.so"));
			}
			if(StringProcess.notVaildN(hangHoaForm.getDonGia())){
				actionErrors.add("donGiaError", new ActionMessage("error.donGia.so"));
			}else if(StringProcess.notVaildNumber(hangHoaForm.getSoLuong())){
				actionErrors.add("donGiagError", new ActionMessage("error.donGia.so"));
			}
			
			if(StringProcess.notVaildS(hangHoaForm.getDonViTinh())){
				actionErrors.add("donViTinhError", new ActionMessage("error.donViTinh.so"));
			}
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
				return mapping.findForward("themHangHoaerror");
			}
			}
		if(s != null){		//nhan nut Xac nhan
			
			String fileName = "";
			System.out.println(fileName);
			file = hangHoaForm.getFile();
			try {
				fileName = file.getFileName();

				// Get the servers upload directory real path name
				String filePath = getServlet().getServletContext()
						.getRealPath("/") + "picture";
				System.out.println(filePath);

				// create the upload folder if not exists
				File folder = new File(filePath);
				if (!folder.exists()) {
					folder.mkdir();
				}
				if (!("").equals(fileName)) {

					System.out.println("Server path:" + filePath);
					File newFile = new File(filePath, fileName);

					if (!newFile.exists()) {
						FileOutputStream fos = new FileOutputStream(
								newFile);
						fos.write(file.getFileData());
						fos.flush();
						fos.close();
					}
					request.setAttribute("uploadedFilePath",
							newFile.getAbsoluteFile());
					request.setAttribute("uploadedFileName",
							newFile.getName());
					String mypath = "E:\\FPT SOFTWARE\\Workspace Eclipse\\Khoa_Luan2\\WebContent\\picture\\"
							+ newFile.getName();
					FileUtils.copyFile(new File(filePath + "\\"
							+ newFile.getName()), new File(mypath));

				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Thêm hàng lỗi");
			}
			
			
			
			
			String maLoaiHang2 = hangHoaForm.getMaLoaiHang2();
			System.out.println(maLoaiHang2);
			String tenHangHoa = hangHoaForm.getTenHangHoa();
			int soLuong = hangHoaForm.getSoLuong();
			int donGia = hangHoaForm.getDonGia();
			String donViTinh = hangHoaForm.getDonViTinh();
			String maNCC = hangHoaForm.getMaNCC();
			String hinhAnh = hangHoaForm.getHinhAnh();
			String ghiChu = hangHoaForm.getGhiChu();
			hangHoaBO.themHangHoa(maHangHoa, maLoaiHang2, tenHangHoa, soLuong, donGia, donViTinh, maNCC, fileName, ghiChu);
			System.out.println("toi acton them trong ds");
			hangHoaForm.setThongBao("Thêm hàng hóa thành công");
			return mapping.findForward("themHangHoaxong");
			
		}
		hangHoaForm.setListHangHoa(listHangHoa);
		return mapping.findForward("dsHangHoa");
		
		
		
	}
}
