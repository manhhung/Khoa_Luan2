package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.NhanVien;

public class NhanVienDAO {
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
	
	public ArrayList<NhanVien> getListNhanVien() {
		connect();
		String sql = " select tt.MaNhanVien, tt.TenNhanVien, cv.TenChucVu, tt.DiaChi, tt.DienThoai, CASE WHEN tt.GioiTinh = 1 THEN 'Nam' ELSE N'Nữ'END as GioiTinh, tt.NgaySinh, q.TenQuyen "+
					" from THONGTINNHANVIEN tt, CHUCVU cv, TAIKHOAN tk, QUYEN q "+
					" where tt.MaChucVu = cv.MaChucVu and tt.MaNhanVien = tk.MaNhanVien and tk.Quyen = q.MaQuyen";
		ResultSet rs = null;
		try{
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		NhanVien nhanVien;
		try{
			while(rs.next()){
				nhanVien = new NhanVien();
				nhanVien.setMaNhanVien(rs.getString("MaNhanVien"));
				nhanVien.setTenNhanVien(rs.getString("TenNhanVien"));
				nhanVien.setDiaChi(rs.getString("DiaChi"));
				nhanVien.setDienThoai(rs.getInt("DienThoai"));
				nhanVien.setTenChucVu(rs.getString("TenChucVu"));
				nhanVien.setGioiTinh(rs.getString("GioiTinh"));
				nhanVien.setNgaySinh(rs.getString("NgaySinh"));
				nhanVien.setTenQuyen(rs.getString("TenQuyen"));
				list.add(nhanVien);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList<NhanVien> getListNhanVien(String maChucVu) {
		connect();
		String sql = String.format(" select tt.MaNhanVien, tt.TenNhanVien, cv.TenChucVu, tt.DiaChi, tt.DienThoai, tt.NgaySinh, CASE WHEN tt.GioiTinh = 1 THEN 'Nam' ELSE N'Nữ'END as GioiTinh , q.TenQuyen "+
				" from THONGTINNHANVIEN tt, CHUCVU cv, TAIKHOAN tk, QUYEN q "+
				" where tt.MaChucVu = cv.MaChucVu and tt.MaNhanVien = tk.MaNhanVien and tk.Quyen = q.MaQuyen and tt.MaChucVu = '%s'", maChucVu);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		NhanVien nhanVien;
		try{
			while(rs.next()){
				nhanVien = new NhanVien();
				nhanVien.setMaNhanVien(rs.getString("MaNhanVien"));
				nhanVien.setTenNhanVien(rs.getString("TenNhanVien"));
				nhanVien.setDiaChi(rs.getString("DiaChi"));
				nhanVien.setDienThoai(rs.getInt("DienThoai"));
				nhanVien.setTenChucVu(rs.getString("TenChucVu"));
				nhanVien.setGioiTinh(rs.getString("GioiTinh"));
				nhanVien.setNgaySinh(rs.getString("NgaySinh"));
				nhanVien.setTenQuyen(rs.getString("TenQuyen"));
				list.add(nhanVien);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return list;
	}

	public void themNhanVien(String maChucVu, String maNhanVien, String tenNhanVien, String diaChi, int dienThoai,
			String ngaySinh, String gioiTinh, int maQuyen, String matKhau) {
		connect();
		
		String sql = String.format("INSERT INTO TAIKHOAN(MaNhanVien, MatKhau, Quyen) "+
									" VALUES ( '%s', '%s', '%s' )", maNhanVien, matKhau, maQuyen);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql2 = String.format("INSERT INTO THONGTINNHANVIEN(MaNhanVien, TenNhanVien, DiaChi, DienThoai, MaChucVu, GioiTinh, NgaySinh) "+
				" VALUES ( '%s', N'%s', N'%s', '%s', '%s', CASE WHEN '%s' = 'Nam' THEN 1 ELSE 0 END, '%s' )", maNhanVien, tenNhanVien, diaChi, dienThoai, maChucVu, gioiTinh, ngaySinh);
		System.out.println(sql2);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public NhanVien getThongTinNhanVien(String maNhanVien) {
		connect();
		String sql = String.format(" select tt.MaNhanVien, tt.TenNhanVien, tt.MaChucVu, tt.DiaChi, tt.DienThoai, tt.NgaySinh, CASE WHEN tt.GioiTinh = 1 THEN 'Nam' ELSE N'Nữ'END as GioiTinh, tk.Quyen, tk.MatKhau"+
				" from THONGTINNHANVIEN tt, CHUCVU cv, TAIKHOAN tk, QUYEN q "+
				" where tt.MaChucVu = cv.MaChucVu and tt.MaNhanVien = tk.MaNhanVien and tt.MaNhanVien = '%s'", maNhanVien);
		System.out.println(sql);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		NhanVien nhanVien = new NhanVien();
		try{
			while(rs.next()){
				nhanVien = new NhanVien();
				nhanVien.setMaNhanVien(maNhanVien);
				nhanVien.setTenNhanVien(rs.getString("TenNhanVien"));
				nhanVien.setDiaChi(rs.getString("DiaChi"));
				nhanVien.setDienThoai(rs.getInt("DienThoai"));
				nhanVien.setMaChucVu(rs.getString("MaChucVu"));
				nhanVien.setGioiTinh(rs.getString("GioiTinh"));
				nhanVien.setNgaySinh(rs.getString("NgaySinh"));
				nhanVien.setMaQuyen(rs.getInt("Quyen"));
				nhanVien.setMatKhau(rs.getString("MatKhau"));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return nhanVien;
	}

	public void capNhatSinhVien(String maNhanVien, String tenNhanVien, String maChucVu, String diaChi, int dienThoai,
			String ngaySinh, String gioiTinh, int maQuyen, String matKhau) {
		connect();
		String sql = String.format("UPDATE TAIKHOAN SET MatKhau = '%s', Quyen = %s WHERE MaNhanVien = '%s'", matKhau, maQuyen, maNhanVien);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql2 = String.format("UPDATE THONGTINNHANVIEN SET TenNhanVien = N'%s', MaChucVu = '%s', DiaChi = N'%s', DienThoai = %s, GioiTinh = (CASE WHEN '%s' = 'Nam' THEN 1 ELSE 0 END)  , NgaySinh = '%s'"+
						" WHERE MaNhanVien = '%s'", tenNhanVien, maChucVu, diaChi, dienThoai, gioiTinh, ngaySinh, maNhanVien);
		System.out.println(sql2);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public void xoaNhanVien(String maNhanVien) {
		connect();
		String sql2 = String.format("DELETE FROM THONGTINNHANVIEN WHERE MaNhanVien = '%s'", maNhanVien);
		System.out.println(sql2);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = String.format("DELETE FROM TAIKHOAN WHERE MaNhanVien = '%s'", maNhanVien);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
		
	}

