<%@ page contentType = "application/pdf" %>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@ page import = "net.sf.jasperreports.engine.*" %>
<%@ page import = "java.io.File" %>
<%@ page import = "java.io.FileInputStream" %>
<%@ page import = "java.io.FileNotFoundException" %>
<%@ page import = "java.io.FileNotFoundException" %>
<%@ page import = "java.io.InputStream" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.SQLException" %>
<%@ page import = "java.util.HashMap" %>
<%@ page import = "java.util.Map" %>
<%@ page import = "model.bean.ThongKe" %>
<%@ page import = "form.ThongKeForm" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thống kê</title>
</head>
<body>


<%
	
	Connection conn = null;
	String maLoaiHang = ThongKeForm.getMaLoaiHang2();
	
	try{
		//ket noi csdl
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLBG", "sa", "admin123");
		//load jsreport
		System.out.print("toi rpThongKe");
		String jrxmlFile = session.getServletContext().getRealPath(
				"/RpThongKe.jrxml");
		InputStream input = new FileInputStream(new File(jrxmlFile));
		
		Map<String, Object> parametersMap = new HashMap<String, Object>();  
		parametersMap.put("MaLoaiHang",maLoaiHang);
		
		//begin
		JasperReport jasperReport = JasperCompileManager.compileReport(input);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametersMap, conn);
		
		//export
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
		
	}catch(Exception e){
		e.printStackTrace();
	} finally{
		if (conn != null){
			conn.close();
		}
	}
	
	
	
%>
</body>
</html>