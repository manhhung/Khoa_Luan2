package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.ChiTietHoaDon;

public class ChiTietHoaDonDAO {
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

	public ArrayList<ChiTietHoaDon> getListChiTietHoaDon(String maHoaDon) {
		connect();
		String sql = String.format(" select hdct.MaHoaDon, hh.TenHangHoa, hdct.SoLuong, hdct.DonGia, (hdct.SoLuong*hdct.DonGia) as ThanhTien" +
									" from HANGHOA hh, HOADONCHITIET hdct "+
									" where hh.MaHangHoa = hdct.MaHangHoa and hdct.MaHoaDon = '%s'", maHoaDon);
		System.out.println(sql);
		ResultSet rs = null;
		try{
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();			
		}
		
		ArrayList<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		ChiTietHoaDon chiTietHoaDon;
		try{
			while(rs.next()){
				chiTietHoaDon = new ChiTietHoaDon();
				chiTietHoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
				chiTietHoaDon.setTenHangHoa(rs.getString("TenHangHoa"));
				chiTietHoaDon.setSoLuong(rs.getInt("SoLuong"));
				chiTietHoaDon.setDonGia(rs.getInt("DonGia"));
				chiTietHoaDon.setThanhTien(rs.getInt("ThanhTien"));
				list.add(chiTietHoaDon);
				
			}
		} catch (SQLException e){
			e.printStackTrace();			
		}
		return list;
	}

}
