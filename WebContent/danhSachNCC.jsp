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
<title>Danh sách nhà cung cấp</title>

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
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Xin chào <bean:write name = "danhSachNCCForm" property="tenDangNhap"></bean:write><span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="javascript:dx();"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Đăng xuất</a></li>
						      
						</ul>
					</li>
				</ul>
			</div>
							
		</div>
<!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			
		</form>
		<ul class="nav menu">
			<li ><a href="danh-sach.do"><svg class="glyph stroked desktop computer and mobile"><use xlink:href="#stroked-desktop-computer-and-mobile"/></svg> Hàng hóa</a></li>
			<li><a href="danh-sach-loai-hang.do"><svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg> Loại hàng</a></li>
			<li><a href="danh-sach-hoa-don.do"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> Hóa đơn</a></li>
			<li role="presentation" class="divider"></li>
			<li><a href="danh-sach-nhan-vien.do"><svg class="glyph stroked male user "><use xlink:href="#stroked-male-user"/></svg> Nhân viên</a></li>
			<li class="active"><a href="danh-sachNCC.do"><svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg> Đối tác</a></li>
			<li ><a href="danh-sachKH.do"><svg class="glyph stroked chain"><use xlink:href="#stroked-chain"/></svg> Khách hàng</a></li>
			<li role="presentation" class="divider"></li>
			<li><a href="thongke.do"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> Thống kê</a></li>
			



			
		</ul>
		    	
		<div class="attribution">Hệ thống quản lý bán hàng <a href="http://philong.com.vn/">PHILONG Electronics & Computer</a><br/></div>
		
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Danh sách nhà cung cấp</li>
			</ol>
		</div>
		
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Danh sách nhà cung cấp</div>
					<div class="panel-info">
					<html:form action="/danh-sachNCC" method="post">							
						<div class="col-lg-2 pull-right">
					            	
					            	<html:link styleClass="btn btn-success" action="/themNCC"><span class="glyphicon glyphicon-plus"></span> Thêm mới</html:link>
					            	
					            </div>
					        </html:form>
					</div>
					<BR>
							
					<div class="panel-body">
						<table data-toggle="table" data-url="listNCC"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
						    <thead>
						    <tr>
						        <th data-field="maKH" data-sortable="true">Mã nhà cung cấp</th>
						        <th data-field="tenKH" data-sortable="true">Tên nhà cung cấp</th>
						        <th data-field="diaChi" data-sortable="true">Địa chỉ</th>
						        <th data-field="sDT" data-sortable="false">Số điện thoại</th>
						        <th data-field="#" data-sortable="false">Thao tác</th>
						    </tr>
						    </thead>
							<tbody>
				            <logic:iterate name="danhSachNCCForm" property="listNCC" id="ncc">
				            	<tr>
				            	<td>           	<bean:write name="ncc" property="maNCC"/></td>
                				<td>             	<bean:write name="ncc" property="tenNCC" />         </td>
								<td>           	<bean:write name="ncc" property="diaChi"/>			</td>
								<td>               	<bean:write name="ncc" property="sDT"/>			</td>
							
				                <td>
				                <bean:define id="maNCC" name="ncc" property="maNCC"></bean:define>
				                	<html:link action="/suaNCC?maNCC=${maNCC}">
				                		<span class="glyphicon glyphicon-edit"></span>
				                	</html:link>
				                	
				                  <html:link onclick="return confirm('Xác nhận xóa?');" action="/xoaNCC?maNCC=${maNCC}" style="margin-left: 10px;">
					                        <span class="glyphicon glyphicon-trash"></span>
					                  </html:link>	
				                </td>
				            </tr>
				            </logic:iterate>
				            </tbody>
						</table>
					</div>
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
						                window.location="danh-sachNCC.do";
						            }
						        }
						       
						    </script>

</body>

</html>
