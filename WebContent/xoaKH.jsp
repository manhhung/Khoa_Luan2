
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Xóa khách hàng</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3>Xóa khách hàng</h3>
    <br>
	<html:form action="/xoaKH" method="post">
        		
        <div class="row form-group">
            <label class="col-lg-2">Mã khách hàng</label>
            <div class="col-lg-3">
            	<html:text property="maKH" styleClass="form-control" readonly="true"></html:text>
            	 
            </div>
        </div>
        
            <div class="row form-group">
            <label class="col-lg-2">Tên khách hàng</label>
            <div class="col-lg-3">
            	<html:text property="tenKH" styleClass="form-control"></html:text>
        	 
            </div>
        </div>
     <div class="row form-group">
            <label class="col-lg-2">Giới tính</label>
            <div class="col-lg-3">
            	<html:radio property="gioiTinh" value="1" style="margin-right: 10px;">Nam</html:radio>
            	<html:radio property="gioiTinh" value="1" style="margin: 0px 10px 0px 30px;">Nữ</html:radio>
            </div>
        </div>
         <div class="row form-group">
            <label class="col-lg-2">Ngày sinh</label>
            <div class="col-lg-3">
            	<html:text property="ngaySinh" styleClass="form-control"></html:text>
            	
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Địa chỉ</label>
            <div class="col-lg-3">
            	<html:text property="diaChi" styleClass="form-control"></html:text>
            	
            </div>
        </div>
      	       <div class="row form-group">
            <label class="col-lg-2">Số điện thoại</label>
            <div class="col-lg-3">
            	<html:text property="sDT" styleClass="form-control"></html:text>
            	
            </div>
        </div>     
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
            	<html:submit styleClass="btn btn-success" property="submit" value="submit">Thêm mới</html:submit>
                <button class="btn btn-primary" onclick="history.go(-1);">Quay lại</button>
            </div>
        </div>
   </html:form>
    <br>
</div>
</body>
</html>