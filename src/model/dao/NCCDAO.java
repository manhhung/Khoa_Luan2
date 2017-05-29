package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.HangHoa;
import model.bean.LoaiHang;
import model.bean.NCC;
import model.bean.NhaCungCap;

public class NCCDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=QLBG";
	String userName = "sa";
	String password = "admin123";
	Connection connection;
	
	void connect(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		}
	}


	
	public ArrayList<NhaCungCap> getListNCC() {
		// TODO Auto-generated method stub
		connect();
		String sql = "SELECT MaNCC,TenNCC,DiaChi,DienThoai "+
					"FROM  NhaCungCap ";
		ResultSet rs = null;
		try{
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();			
		}
		
		ArrayList<NhaCungCap> list = new ArrayList<NhaCungCap>();
		NhaCungCap nhaCungCap;
		try{
			while(rs.next()){
				nhaCungCap = new NhaCungCap();
				nhaCungCap.setMaNCC(rs.getString("MaNCC"));
				nhaCungCap.setTenNCC(rs.getString("TenNCC"));
				nhaCungCap.setDiaChi(rs.getString("DiaChi"));
				nhaCungCap.setsDT(rs.getString("DienThoai"));
				list.add(nhaCungCap);
			}
		} catch (SQLException e){
			e.printStackTrace();			
		}
		return list;
	}
	public void themNCC(String maNCC, String tenNCC, String diaChi, String sDT) {
		// TODO Auto-generated method stub
		connect();
		String sql = String.format(
				"INSERT INTO NHACUNGCAP(TenNCC,DiaChi,DienThoai) "
						+ " VALUES ( N'%s',N'%s','%s')", tenNCC,diaChi,sDT);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void capNhatNCC(String maNCC, String tenNCC, String diaChi,
			String sDT) {
		// TODO Auto-generated method stub
		connect();
		String sql = String.format("UPDATE NHACUNGCAP "+
								   " SET TenNCC = N'%s', DiaChi = N'%s', DienThoai = '%s'" +
								   " WHERE  MaNCC = '%s'", tenNCC, diaChi, sDT, maNCC);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public NhaCungCap getThongTinNCC(String maNCC) {
		// TODO Auto-generated method stub
		connect();
		String sql = String.format("SELECT MaNCC,TenNCC,DiaChi,DienThoai "+
								" FROM NHACUNGCAP WHERE MaNCC = '%s'", maNCC);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		NhaCungCap nhaCungCap = new NhaCungCap();
		try{
			while(rs.next()){
				nhaCungCap.setMaNCC(maNCC);
				nhaCungCap.setTenNCC(rs.getString("TenNCC"));
				nhaCungCap.setDiaChi(rs.getString("DiaChi"));
				nhaCungCap.setsDT(rs.getString("DienThoai"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return nhaCungCap;
	}
	public void xoaNCC(String maNCC) {
		// TODO Auto-generated method stub
		connect();
		String sql = String.format("Delete from NHACUNGCAP "+
								   " WHERE  MaNCC = '%s'", maNCC);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
	
}