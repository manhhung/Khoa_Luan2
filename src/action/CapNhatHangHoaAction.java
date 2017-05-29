package action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import common.StringProcess;
import form.HangHoaForm;
import model.bean.HangHoa;
import model.bean.LoaiHang;
import model.bean.NCC;
import model.bean.NhaCungCap;
import model.bo.HangHoaBO;
import model.bo.LoaiHangBO;
import model.bo.NCCBO;

public class CapNhatHangHoaAction extends Action{
	FormFile file;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		HangHoaForm hangHoaForm = (HangHoaForm) form;
		HangHoaBO hangHoaBO = new HangHoaBO();
		
				//lay danh sach loai hang
				LoaiHangBO loaiHangBO = new LoaiHangBO();
				ArrayList<LoaiHang> listLoaiHang = loaiHangBO.getListloaiHang();
				hangHoaForm.setListLoaiHang(listLoaiHang);
				
				//lay danh sach nha cung cap
				NCCBO nCCBO = new NCCBO();
				ArrayList<NhaCungCap> listNCC = nCCBO.getListNCC();
				hangHoaForm.setListNCC(listNCC);
				
				//cap nhat hang hoa
				String maHangHoa = hangHoaForm.getMaHangHoa();
				String x = "Lưu lại";
				x = hangHoaForm.getSubmit();
				if(x != null){
					ActionErrors actionErrors = new ActionErrors();
					if(StringProcess.notVaildS(hangHoaForm.getTenHangHoa())){
						actionErrors.add("tenHangHoaError", new ActionMessage("error.tenHangHoa.trong"));
					}
					if(StringProcess.notVaildN(hangHoaForm.getSoLuong())){
						actionErrors.add("soLuongError", new ActionMessage("error.soLuong.trong"));
					}else if(StringProcess.notVaildNumber(hangHoaForm.getSoLuong())){
						actionErrors.add("soLuongError", new ActionMessage("error.soLuong.so"));
					}
					if(StringProcess.notVaildN(hangHoaForm.getDonGia())){
						actionErrors.add("donGiaError", new ActionMessage("error.donGia.trong"));
					}else if(StringProcess.notVaildNumber(hangHoaForm.getSoLuong())){
						actionErrors.add("donGiagError", new ActionMessage("error.donGia.so"));
					}
					
					if(StringProcess.notVaildS(hangHoaForm.getDonViTinh())){
						actionErrors.add("donViTinhError", new ActionMessage("error.donViTinh.trong"));
					}
					saveErrors(request, actionErrors);
					if(actionErrors.size()>0){
						return mapping.findForward("suaHangHoaerror");
					}
					}
				if(x != null){
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
						System.out.println("Thêm ảnh lỗi");
					}
					String maLoaiHang = hangHoaForm.getMaLoaiHang();
					String tenHangHoa = hangHoaForm.getTenHangHoa();
					int soLuong = hangHoaForm.getSoLuong();
					int donGia = hangHoaForm.getDonGia();
					String donViTinh = hangHoaForm.getDonViTinh();
					String maNCC = hangHoaForm.getMaNCC();
					String ghiChu = hangHoaForm.getGhiChu();
					String hinhAnh = hangHoaForm.getHinhAnh();
					System.out.println(hinhAnh);
					if(fileName.equals("")){
						hangHoaBO.CapNhatHangHoaNull(maHangHoa, maLoaiHang, tenHangHoa, soLuong, donGia, donViTinh, maNCC, ghiChu);
					}else{
					hangHoaBO.CapNhatHangHoa(maHangHoa, maLoaiHang, tenHangHoa, soLuong, donGia, donViTinh, maNCC, fileName, ghiChu);
					}
					return mapping.findForward("suaHangHoaxong");
				} else {														//chuyen sang trang cap nhat
					HangHoa hangHoa = hangHoaBO.getThongTinHangHoa(maHangHoa);
					hangHoaForm.setMaLoaiHang(hangHoa.getMaLoaiHang());
					hangHoaForm.setMaNCC(hangHoa.getMaNCC());
					hangHoaForm.setTenHangHoa(hangHoa.getTenHangHoa());
					hangHoaForm.setSoLuong(hangHoa.getSoLuong());
					hangHoaForm.setDonGia(hangHoa.getDonGia());
					hangHoaForm.setDonViTinh(hangHoa.getDonViTinh());
					hangHoaForm.setGhiChu(hangHoa.getGhiChu());
					hangHoaForm.setHinhAnh(hangHoa.getHinhAnh());
					System.out.println(hangHoa.getHinhAnh());
					return mapping.findForward("suaHangHoa");
				}
	}

}
