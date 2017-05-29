<%@page import="model.bean.LoaiHang"%>
<%@page import="common.StringProcess"%>
<%@page import="model.bean.HangHoa"%>
<%@page import="model.bean.ThongKe"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Date;"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Thống kê báo cáo</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/bootstrap-table.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

<!--Icons-->
<script src="js/lumino.glyphs.js"></script>

<style>
body {
    background-image: url("picture/bg.jpg");
}
.no-background {
    background-image: url("picture/bg.jpg");
}
</style>
</head>

<!-- tab bar header -->

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<img style="width: auto; height: 50px" src="picture/logohome2.png"/>
				<img style="width: auto; height: 40px" src="picture/stt3.png"/>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Xin chào <bean:write name = "thongKeForm" property="tenDangNhap"></bean:write><span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="javascript:dx();"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Đăng xuất</a></li>
						      
						</ul>
					</li>
				</ul>
			</div>
							
		</div>
<!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-2 col-lg-2 sidebar">
		<form role="search">
			
		</form>
		<ul class="nav menu">
			<li><a href="danh-sach.do"><svg class="glyph stroked desktop computer and mobile"><use xlink:href="#stroked-desktop-computer-and-mobile"/></svg> Hàng hóa</a></li>
			<li  ><a href="danh-sach-loai-hang.do"><svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg> Loại hàng</a></li>
			<li><a href="danh-sach-hoa-don.do"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> Hóa đơn</a></li>
			<li role="presentation" class="divider"></li>
			<li><a href="danh-sach-nhan-vien.do"><svg class="glyph stroked male user "><use xlink:href="#stroked-male-user"/></svg> Nhân viên</a></li>
			<li><a href="danh-sachNCC.do"><svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg> Đối tác</a></li>
			<li ><a href="danh-sachKH.do"><svg class="glyph stroked chain"><use xlink:href="#stroked-chain"/></svg> Khách hàng</a></li>
			<li role="presentation" class="divider"></li>
			<li  class="active"><a href="thongke.do"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> Thống kê</a></li>
			
	


			
		</ul>
		    	
		<div class="attribution">Hệ thống quản lý bán hàng <a href="http://philong.com.vn/">PHILONG Electronics & Computer</a><br/></div>
		
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Thống kê báo cáo</li>
			</ol>
		</div>
		
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading"><p style="color:red">Thống kê theo loại hàng</p></div>
					<br>
					<html:form action="/thongke" method="post">
					<div class="panel-body">
						<div class="col-md-6">					
								<div class="form-group">
									<b><p>Lựa chọn loại hàng thống kê</p></b>
										<html:select property="maLoaiHang" styleClass="form-control">
										    <option value="">-- Chọn loại hàng --</option>
										    <html:optionsCollection name="thongKeForm" property="listLoaiHang" label="tenLoaiHang" value="maLoaiHang" />
										</html:select>
						
								</div>
	       					
	       					
	       					<div class="row form-group">
	            				<div class="col-lg-3 ">
	               					 <html:submit styleClass="btn btn-warning" property="submit" value="Thống kê" > <span class="glyphicon glyphicon-cd"></span></html:submit>
	         					 </div>
	       					</div>
	       					</div>
	       					</div>
	       					</html:form>
	       			<div class="panel-heading"><p style="color:red">Thống kê theo hóa đơn</p></div>
					<br>		
	       			<html:form action="/thongkeNV" method="post">
	       			<div class="panel-body">		
	       			<div class="col-md-6">					
								<div class="form-group">
									<b><p>Lựa chọn ngày bắt đầu</p></b>
									<html:text property="ngayBatDau" style="display:none" styleId="date"></html:text>
									<input type="date" id = "myDate" class = "form-control" onchange="myFunction(this.value)">
		            				
            						<br>
								</div>
								
								<div class="form-group">
									<b><p>Lựa chọn ngày kết thúc</p></b>
									
									<html:text property="ngayKetThuc" style="display:none" styleId="date2"></html:text>
									<input type="date" id = "myDate2" class = "form-control" onchange="myFunction2(this.value)">
		            				
            						<br>
								</div>
	       					
	       					
	       					<div class="row form-group">
	            				<div class="col-lg-3 ">
	               					 <html:submit styleClass="btn btn-info" property="submit" value="Thống kê" > <span class="glyphicon glyphicon-cd"></span></html:submit>
	         					 </div>
	       					</div>
	       					</div>	
	       					</div>	       					
					</html:form>
					<div class="panel-heading"><p style="color:red">Thống kê nhân viên</p></div>
					<br>
					<html:form action="/thongkeDSNV" method="post">
					<div class="panel-body">	
					<div class="col-md-6">
					<div class="row form-group">
	            				<div class="col-lg-3 ">
	               					 <html:submit styleClass="btn btn-danger" property="submit" value="Thống kê" > <span class="glyphicon glyphicon-cd"></span></html:submit>
	         					 </div>
	       					</div>
	       					</div>
	       					</div>
					</html:form>
					
				</div>
			</div>
		</div>
		
		
		
		
		
	</div><!--/.main-->

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script type="text/javascript">
						        function dx(){
						            if(confirm("Bạn có muốn đăng xuất không ?") == true){
						            	 window.location="dangNhap.jsp";
						            }else{
						                window.location="danh-sach-loai-hang.do";
						            }
						        }
						       
						    </script>
						    <script src="js/bootstrap-table.js"></script>
	<script>
			function myFunction(val) {
				document.getElementById("date").value = val;
			}
 	</script>
 	<script>
			function myFunction2(val) {
				document.getElementById("date2").value = val;
			}
 	</script>

</body>

</html>
