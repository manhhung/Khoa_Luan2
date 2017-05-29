<%@page import="model.bean.LoaiHang"%>
<%@page import="common.StringProcess"%>
<%@page import="model.bean.HangHoa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.NhanVien"%>
<%@page import="model.bean.KhachHang"%>

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
<title>Thêm mới hóa đơn</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/bootstrap-table.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<link href = "css/table.css" rel="stylesheet">

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
<style>
#myInput {
  align-center: auto;
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 100%;
  height: 50%;
  font-size: 13px;
  padding: 12px 20px 12px 12px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
  margin-left: 15px;
}
</style>

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
			<li ><a href="danh-sach.do"><svg class="glyph stroked desktop computer and mobile"><use xlink:href="#stroked-desktop-computer-and-mobile"/></svg> Hàng hóa</a></li>
			<li><a href="danh-sach-loai-hang.do"><svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg> Loại hàng</a></li>
			<li class="active"><a href="danh-sach-hoa-don.do"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> Hóa đơn</a></li>
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
				<li class="active">Danh sách đơn hàng/ Thêm mới hóa đơn</li>
			</ol>
		</div>
		
		<html:form action="/themHoaDon" method="post">
		
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">Thông tin chung</div>
					
					<div class="panel-body">
							<p>Mã hóa đơn</p>
							<html:text styleId ="maHoaDon" property="maHoaDon" styleClass="form-control"></html:text>
							<html:errors property="maHoaDonError"/>
							<br>
							<p>Tên nhân viên</p>
<%-- 							<html:select property="maNhanVien" styleClass="form-control"> --%>
<%-- 							<html:optionsCollection name="hoaDonForm" property="listNhanVien" label="tenNhanVien" value="maNhanVien" /> --%>
<%-- 							</html:select> --%>
							<html:text styleId ="tenNhanVien" property="tenNhanVien" styleClass="form-control" readonly="true"></html:text>
							<br>
							<p>Tên khách hàng</p>
							<html:select property="maKH" styleClass="form-control">
							<html:optionsCollection name="hoaDonForm" property="listKhachHang" label="tenKH" value="maKH" />
							</html:select>
							<br>
					</div>
					
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">Thông tin đơn hàng</div>
					<div class="panel-body">
						<table class="table container" id="table-products">
            			<thead style="background-color:lavender">
                    		<tr>
                        		<th>Mã hàng</th>
                        		<th>Tên hàng</th>
                        		<th>Giá</th>
                        		<th>Số lượng</th>
                        		<th>Thành tiền</th>
                    		</tr>
                		</thead>
                		
                		<tbody id="table-products-body">
                		</tbody>
            		</table>
					<div>
					<br>
            			<div style="float: left; width: 100%;">
            				<button class="btn btn-warning" id="button-clear">Clear all</button>
            			</div>
        			</div>
						
					</div>
				</div>
			</div>	
		
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Danh sách hàng hóa</div>
					<div class="panel-info">
								
					</div>
					<BR>
							
					            <div class="col-lg-4">
					                <html:select property="maLoaiHang" styleClass="form-control">
										<option value="">-- Chọn loại hàng --</option>
										<html:optionsCollection name="hoaDonForm" property="listLoaiHang" 
											label="tenLoaiHang" value="maLoaiHang" />
									</html:select>
					            </div>
					            <script type="text/javascript">
					            	$("[name='maLoaiHang']").val('<bean:write name="hoaDonForm" property="maLoaiHang"/>');
					            </script>
					     
					            <html:submit styleClass="btn btn-primary">Xem</html:submit>
					            <br>
					            <br>
					            <label>
								<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Nhập mã hàng hóa..." title="Type in a name">
								</label>
										 
					     
					<div class="panel-body">
						<table  class="table table-striped" id="KhoHang" >
							<thead style="background-color:lavender">
								<tr>
									<th>Mã hàng</th>
									<th>Tên hàng</th>
									<th>Giá bán</th>
									<th>Số lượng trong kho</th>
									<th>Số lượng xuất</th>
									<th>Tùy chọn</th>
								</tr>
							</thead>
		
							<tbody>
								<logic:iterate name="hoaDonForm" property="listHangHoa" id="hh">
					            	<tr>
						                <td scope="row">
						                	<bean:write name="hh" property="maHangHoa"/>
										</td>
						                <td>
						                	<bean:write name="hh" property="tenHangHoa"/>
						                </td>
						                <td>
						                	<bean:write name="hh" property="donGia"/>
										</td>
						                <td>
						                	<bean:write name="hh" property="soLuong"/>
						                </td>
						                
						                <td>
						                	<input type="text" class="input<bean:write name="hh" property="maHangHoa"/>"/>
						                </td>
						                <td>
						                	<button type="button" class="add-to-cart btn btn-danger">Add to cart</button>
						                </td>
	            					</tr>
           				 		</logic:iterate>
							</tbody>
						</table>
						
					</div>
					  
				</div>
			</div>
		</div>
		<div class="row form-group" align="center" style="margin-left: 25%">
				<div class="col-sm-8">
					<p>
						<html:submit styleId="xuatHang" styleClass="btn btn-primary" property="submit" value="Tạo hóa đơn" ><span class="glyphicon glyphicon-shopping-cart"></span> Xuất</html:submit>
						<html:link styleClass="btn btn-primary" action="/px">Quay lại</html:link>
					</p>
				</div>
			</div>
			 </html:form>
		</div>
	
		


	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>

</body>


<script>
// tìm kiếm giá trị
function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("KhoHang");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('#KhoHang').DataTable();
			});
		</script>
		<script>
		
		// Định nghĩa một mảng các phần tử sẽ bỏ vào giỏ hàng
	    var shoppingCartItems = [];

	    $(document).ready(function () {
	        // Kiểm tra nếu đã có sessionStorage["shopping-cart-items"] hay chưa?
	        if (sessionStorage["shopping-cart-items"] != null) {
	            shoppingCartItems = JSON.parse(sessionStorage["shopping-cart-items"].toString());
	        }

	        // Hiển thị thông tin từ giỏ hàng
	        displayShoppingCartItems();
	    });
	    
	    // Sự kiện click các button có class=".add-to-cart"
	    $("#KhoHang .add-to-cart").click(function () {
	    	
	    	var button = $(this);
	        var tr = $(this).parent().parent();
	        var td = tr.children();
	        var td1 = td[0].innerText;
	        var td2 = td[1].innerText;
	        var td3 = td[2].innerText;
	        var td4 = td[3].innerText;
	        
	        var quantity = 0;
	        
	        
	        if ($(".input"+td1).val() !== ""){
	        	quantity = parseInt($(".input"+td1).val());
	        }
	        
	        
	        var item = {
	        		id: td1,
	                name: td2,
	                price: td3,
	                quantity: quantity
	         };
	        
	        if(parseInt(td4)<item.quantity||item.quantity<=0||isNaN(item.quantity)){
	        	 alert("Số lượng không hợp lệ.");
	        	 return false;
	        }
	        
	        else{
	        	var exists = false;
	        	if (shoppingCartItems.length > 0) {
	            	$.each(shoppingCartItems, function (index, value) {
	                // Nếu mặt hàng đã tồn tại trong giỏ hàng thì chỉ cần tăng số lượng mặt hàng đó trong giỏ hàng.
	                	if (value.id == item.id) {
	                   		value.quantity= value.quantity + item.quantity;
	                    	exists = true;
	                    	return false;
	                	}
	            	});
	        	}
	        }
	        
	     // Nếu mặt hàng chưa tồn tại trong giỏ hàng thì bổ sung vào mảng
	        if (!exists) {
	            shoppingCartItems.push(item);
	        }
	     // Lưu thông tin vào sessionStorage
	        sessionStorage["shopping-cart-items"] = JSON.stringify(shoppingCartItems); // Chuyển thông tin mảng shoppingCartItems sang JSON trước khi lưu vào sessionStorage
	        // Gọi hàm hiển thị giỏ hàng
	        displayShoppingCartItems(); 
	    });
	    
	    // Xóa hết giỏ hàng shoppingCartItems
	    $("#button-clear").click(function () {
	        var rowCount = $('#table-products >tbody tr').length;
	        if(rowCount==0){
	            return false;
	        }else{
	        	shoppingCartItems = [];
	        	sessionStorage["shopping-cart-items"] = JSON.stringify(shoppingCartItems);
	            $("#table-products > tbody").html("");
	        }   
	    });
	    
	    // Hiển thị giỏ hàng ra table
	    function displayShoppingCartItems() {
	        if (sessionStorage["shopping-cart-items"] != null) {
	            shoppingCartItems = JSON.parse(sessionStorage["shopping-cart-items"].toString()); // Chuyển thông tin từ JSON trong sessionStorage sang mảng shoppingCartItems.
	    
	            $("#table-products > tbody").html("");
	            // Duyệt qua mảng shoppingCartItems để append từng item dòng vào table
	    
	            $.each(shoppingCartItems, function (index, item) {
	            
	                
	                var htmlString = "";

	                htmlString += "<tr>";
	                	htmlString += "<td>" + item.id + "</td>";
	                	htmlString += "<td>" + item.name + "</td>";
	                	htmlString += "<td>" + item.price + "</td>";
	                	htmlString += "<td>" + item.quantity + "</td>";
	               		htmlString += "<td>" + item.price * item.quantity + "</td>";
	               	htmlString += "</tr>";
	                $("#table-products > tbody:last").append(htmlString);  
	             
	            });
	        }
	    }
	    
	        
	    $('#xuatHang').click(function () {
    		var rowCount = $('#table-products >tbody tr').length;
    		if($("#maHoaDon").val()==""){
				alert("Mã hóa đơn trống");
				return false;
        	}
			if(rowCount == 0){
				alert("Giỏ hàng trống");
       			return false;	
       		} else {
       			
       			for(i=1; i <= rowCount; i++){
       			 	var x = document.getElementById("table-products").rows[i].cells;
       				var maHoaDon = $("#maHoaDon").val();
       		  	 	var maHangHoa = x[0].innerHTML;
       		  		var tenHangHoa = x[1].innerHTML;
       				var soLuong = x[3].innerHTML;
       				var thanhTien = x[4].innerHTML;    		
	
       				doAjaxPost(maHoaDon, maHangHoa, soLuong, thanhTien);
       			}      
       		}
			shoppingCartItems = [];
            sessionStorage["shopping-cart-items"] = JSON.stringify(shoppingCartItems);
            $("#table-products > tbody").html("");
    	});
	     
		
			function doAjaxPost(maHoaDon, maHangHoa, soLuong, thanhTien) {
         	
            $.ajax({
                type: "POST",
                url: "ajaxThemHoaDon.do",
                data: {maHoaDon: maHoaDon, maHangHoa: maHangHoa, soLuong: soLuong, thanhTien: thanhTien},
                success: function(response){  
                  
                },
                error: function(e){
                    alert('Error: ' + e);
                }
            });
        } 
    	
		</script>

</html>
