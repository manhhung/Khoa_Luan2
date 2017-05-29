<%@page import="model.bean.LoaiHang"%>
<%@page import="common.StringProcess"%>
<%@page import="model.bean.HangHoa"%>
<%@page import="form.NguoiDungForm"%>
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
<title>Danh sách hàng hóa</title>

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
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Xin chào <bean:write name = "danhSachHangHoaForm" property="tenDangNhap"></bean:write><span class="caret"></span></a>
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
			<li class="active"><a href="danh-sach.do"><svg class="glyph stroked desktop computer and mobile"><use xlink:href="#stroked-desktop-computer-and-mobile"/></svg> Hàng hóa</a></li>
			<li><a href="danh-sach-loai-hang.do"><svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg> Loại hàng</a></li>
			<li><a href="danh-sach-hoa-don.do"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> Hóa đơn</a></li>
			<li role="presentation" class="divider"></li>
			<li><a href="danh-sach-nhan-vien.do"><svg class="glyph stroked male user "><use xlink:href="#stroked-male-user"/></svg> Nhân viên</a></li>
			<li><a href="danh-sachNCC.do"><svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg> Đối tác</a></li>
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
				<li class="active">Danh sách hàng hóa</li>
				
			</ol>
		</div>
		
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Danh sách hàng hóa
					
					</div>
					<div class="panel-info">
								<label>
									<p style="color: red;">
									<bean:write name="danhSachHangHoaForm" property="thongBao"/>
									</p>
								</label>
					</div>
					<BR>
							<html:form action="/danh-sach" method="post" enctype="multipart/form-data">
					            <div class="col-lg-4">
					                <html:select property="maLoaiHang" styleClass="form-control">
										<option value="">-- Chọn loại hàng --</option>
										<html:optionsCollection name="danhSachHangHoaForm" property="listLoaiHang" 
											label="tenLoaiHang" value="maLoaiHang" />
									</html:select>
					            </div>
					            <script type="text/javascript">
					            	$("[name='maLoaiHang']").val('<bean:write name="danhSachHangHoaForm" property="maLoaiHang"/>');
					            </script>
					     
					            <html:submit styleClass="btn btn-primary">Xem</html:submit>
					            
					           
					            <div class="col-lg-2 pull-right">
					            	<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-plus"></span> Thêm mới</button>
					            	<br>
					            </div>
					            		<div class="modal fade" id="myModal" role="dialog">
										    <div class="modal-dialog">
										      <!-- Nội dung modal-->
												      <div class="modal-content">
														        <div class="modal-header">
														          <button type="button" class="close" data-dismiss="modal">&times;</button>
														          <h4 class="modal-title">Thêm hàng hóa mới</h4>
														        </div>
														        <div class="modal-body">
																           
																	       <p>Tên loại hàng</p>
																		       <html:select property="maLoaiHang2" styleClass="form-control">
																					   <option value="">-- Chọn loại hàng --</option>
																					   <html:optionsCollection name="danhSachHangHoaForm" property="listLoaiHang" label="tenLoaiHang" value="maLoaiHang" />
																					   <html:errors property="listLoaiHangSError"/>
																			   </html:select>
																			<br>
																			<p>Tên nhà cung cấp</p>
																				<html:select property="maNCC" styleClass="form-control">
																						<option value="">-- Chọn nhà cung cấp --</option>
            																			<html:optionsCollection name="danhSachHangHoaForm" property="listNCC" label="tenNCC" value="maNCC" />
            																			<html:errors property="listNCCError"/>
            																	</html:select>
            																<br>
            																<p>Tên hàng hóa</p>
																				        <html:text property="tenHangHoa" styleClass="form-control"></html:text>
            																			<html:errors property="tenHangHoaError"/>
            																<br>
            																<p>Số lượng</p>
																						<html:text property="soLuong" styleClass="form-control"></html:text>
		            																	<html:errors property="soLuongError"/>
            																<br>
            																<p>Đơn giá</p>
																						<html:text property="donGia" styleClass="form-control"></html:text>
            																			<html:errors property="donGiaError"/>
            																<br>
            																<p>Đơn vị tính</p>
																						<html:text property="donViTinh" styleClass="form-control"></html:text>
		            																	<html:errors property="donViTinhError"/>
            																<br>
            																<p>Hình ảnh</p>
            																	
																						<html:file property="file" styleClass="form-control" title="Chọn file"></html:file>
																				
																			<br>
            																<p>Ghi chú</p>
																						<html:text property="ghiChu" styleClass="form-control"></html:text>
		            																	<html:errors property="ghiChuError"/>
            																<br>
														        </div>
														        <div class="modal-footer">
														        	<div class="actions">
															          <html:submit styleClass="btn btn-primary" property="submit" value="Thêm mới">Thêm mới</html:submit>
															          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
														        	</div>
														        </div>
												      </div>
										    </div>
										 </div>
										 
					        </html:form>
					<div class="panel-body">
						<table data-toggle="table" data-url="listHangHoa"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
						    <thead>
						    <tr>
						        <th data-field="maHangHoa" data-sortable="true">Mã hàng hóa</th>
						        <th data-field="tenLoaiHang" data-sortable="true">Loại hàng</th>
						        <th data-field="tenHangHoa"  data-sortable="true">Tên hàng hóa</th>
						        <th data-field="soLuong" data-sortable="true">Số lượng</th>
						        <th data-field="donGia" data-sortable="true">Đơn giá</th>
						        <th data-field="donViTinh" data-sortable="true">Đơn vị tính</th>
						        <th data-field="tenNCC" data-sortable="true">Đối tác</th>
						        <th data-field="hinhAnh" data-sortable="false">Hình ảnh</th>
						        <th data-field="ghiChu" data-sortable="false">Ghi chú</th>
						        <th data-field="#" data-sortable="false">Thao tác</th>
						    </tr>
						    </thead>
							<tbody>
				            <logic:iterate name="danhSachHangHoaForm" property="listHangHoa" id="hh">
				            	<tr>
				            	<td><bean:write name="hh" property="maHangHoa"/></td>
				                <td><bean:write name="hh" property="tenLoaiHang"/></td>
				                <td><bean:write name="hh" property="tenHangHoa"/></td>
				                <td><bean:write name="hh" property="soLuong"/></td>
				                <td><bean:write name="hh" property="donGia"/></td>
				                <td><bean:write name="hh" property="donViTinh"/></td>
				                <td><bean:write name="hh" property="tenNCC"/></td>
				                <td><img style="width: auto; height: 80px" src="picture/<bean:write name="hh" property="hinhAnh"/>" alt="HinhAnhHangHoa"></td>
				                <td><bean:write name="hh" property="ghiChu"/></td>
				                <td>
				                	<bean:define id="maHangHoa" name="hh" property="maHangHoa"></bean:define>
				                	<html:link action="/capNhatHH?maHangHoa=${maHangHoa}" style="margin-left: 15px;">
                					<span class="glyphicon glyphicon-edit"></span>
                					</html:link>
                					<html:link onclick="return confirm('Xác nhận xóa?');" action="/xoaHH?maHangHoa=${maHangHoa}" style="margin-left: 10px;">
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
						                window.location="danh-sach.do";
						            }
						        }
						       
						    </script>

</body>

</html>
