<%@page import="model.bean.LoaiHang"%>
<%@page import="common.StringProcess"%>
<%@page import="model.bean.HangHoa"%>
<%@page import="java.util.ArrayList"%>
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
<title>Cập nhật khách hàng</title>

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
					
				</ul>
			</div>
							
		</div>
<!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			
		</form>
		<ul class="nav menu">
			<li><a href="danh-sach.do"><svg class="glyph stroked desktop computer and mobile"><use xlink:href="#stroked-desktop-computer-and-mobile"/></svg> Hàng hóa</a></li>
			<li><a href="danh-sach-loai-hang.do"><svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg> Loại hàng</a></li>
			<li><a href="danh-sach-hoa-don.do"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> Hóa đơn</a></li>
			<li role="presentation" class="divider"></li>
			<li><a href="danh-sach-nhan-vien.do"><svg class="glyph stroked male user "><use xlink:href="#stroked-male-user"/></svg> Nhân viên</a></li>
			<li><a href="danh-sachNCC.do"><svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg> Đối tác</a></li>
			<li  class="active"><a href="danh-sachKH.do"><svg class="glyph stroked chain"><use xlink:href="#stroked-chain"/></svg> Khách hàng</a></li>
			<li role="presentation" class="divider"></li>
			<li><a href="thongke.do"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> Thống kê</a></li>
			

			
		</ul>
		    	
		<div class="attribution">Hệ thống quản lý bán hàng <a href="http://philong.com.vn/">PHILONG Electronics & Computer</a><br/></div>
		
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Khách hàng/ Cập nhật khách hàng</li>
			</ol>
		</div>
		
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Cập nhật khách hàng</div>
					<br>
					<html:form action="/suaKH" method="post">
					<div class="panel-body">
						<div class="col-md-6">
							<form role="form">
							
								<div class="form-group">
									  <p>Mã khách hàng</p>
							          	<html:text property="maKH" styleClass="form-control" readonly="true"></html:text>
							          <html:errors property="maKHError"/>
								      <br>
								</div>
																
															
								
								<div class="form-group">
									<p>Tên khách hàng</p>
										<html:text property="tenKH" styleClass="form-control"></html:text>
									<br>
								</div>
								
								<div class="form-group">
									<p>Giới tính</p>
										<html:radio property="gioiTinh" value="Nam" style="margin-right: 10px;">Nam</html:radio>
            							<html:radio property="gioiTinh" value="Nữ" style="margin: 0px 10px 0px 30px;">Nữ</html:radio>
            							<br>
								</div>						
								
							</div>
							<div class="col-md-6">
							
							<div class="form-group">
									<p>Ngày sinh</p>
									<bean:define id="ngaySinh" name="kHForm" property="ngaySinh"></bean:define>
									<html:text property="ngaySinh" style="display:none" styleId="date"></html:text>
									<input type="date" value = "${ngaySinh}" id = "myDate" class = "form-control" onchange="myFunction(this.value)">
		            				
            						<br>
							</div>
								
							
							<div class="form-group">
									<p>Địa chỉ</p>
									<html:text property="diaChi" styleClass="form-control"></html:text>
							</div>
							
							<div class="form-group">
									<p>Số điện thoại</p>
									<html:text property="sDT" styleClass="form-control"></html:text>
            						<br>
							</div>
							
							
							<div class="row form-group">
	            				<div class="col-lg-3 col-lg-offset-9">
	               					 <html:submit styleClass="btn btn-success" property="submit" value="Lưu lại">Sửa</html:submit>
              
	         					 </div>
	       					</div>
							</div>
						</form>
					</div>
					</html:form>
				</div>
				
			</div><!-- /.col-->
		</div><!-- /.row -->
		
		
		
		
		
	</div><!--/.main-->

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script src="js/bootstrap-table.js"></script>
			<script>
			function myFunction(val) {
				document.getElementById("date").value = val;
			}
 </script>

</body>

</html>
