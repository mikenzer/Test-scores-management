package qldiem;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Function {
// HIEN THI DANH SACH SV
    public void show() {
      try {
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qldiem?" + "user=root");
           PreparedStatement pStmt = conn.prepareStatement("select * from sinhVien");
           ResultSet rs = pStmt.executeQuery();
          
              System.out.println("|------------|-------------------------|-----------|--------------|--------------|---------------------------------------------|----------|");
              System.out.println("|    MSSV    |        Họ và Tên        | Giới Tính |  Ngày Sinh   |   Nơi Sinh   |               Địa Chỉ                       | Mã Khoa  |");
              System.out.println("|------------|-------------------------|-----------|--------------|--------------|---------------------------------------------|----------|");
              while(rs.next()){
                String mssv = rs.getString("mssv");
                String hoten= rs.getString("hoten");
                String gioitinh = rs.getString("gioiTinh");
                String ngaysinh = rs.getString("ngaySinh");
                String noisinh = rs.getString("noiSinh");
                String diachi = rs.getString("diaChi");
                String makhoa = rs.getString("maKhoa");
                 
                System.out.printf("|%-12s|%-25s|%-11s|%-14s|%-14s|%-45s|%-10s|", mssv, hoten, gioitinh, ngaysinh, noisinh, diachi, makhoa);
                System.out.println();
              }
                System.out.println("|------------|-------------------------|-----------|--------------|--------------|---------------------------------------------|----------|");
      }       
      catch (SQLException ex) {
    	  System.out.println("SQLException: " +ex.getMessage());
      }
   }
    
// THEM SINH VIEN
   public  void insert() {
	   sinhVien sv = new sinhVien();
       sv.nhap();
       Connection conn = null;
       ResultSet rs = null;
       PreparedStatement pstmt = null;
       try {
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
           } catch (ClassNotFoundException ex) {
        	   System.out.println("ClassNotFoundException: " +ex.getMessage());
           }
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qldiem?" + "user=root");
          pstmt = conn.prepareStatement("insert into sinhVien values (?,?,?,?,?,?,?);");
          pstmt.setString(1, sv.getMssv());
          pstmt.setString(2, sv.getHoten());
          pstmt.setString(3, sv.getGioiTinh());    
          pstmt.setString(4, sv.getNgaySinh());
          pstmt.setString(5, sv.getNoiSinh());  
          pstmt.setString(6, sv.getDiaChi());
          pstmt.setString(7, sv.getmaKhoa());
          pstmt.executeUpdate();
          System.out.println("Thực hiện lệnh thành công !");
       }       
       catch (SQLException e) {    
            System.out.println("Thực thi lênh thất bại !");
       }
   }
   
// XÓA SINH VIEN
   public  void delete() {
       Scanner sc = new Scanner(System.in);
       Connection conn = null;
       ResultSet rs = null;
       Statement stmt = null;
       PreparedStatement pstmt = null;
       try{
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
           } catch (ClassNotFoundException ex) {
        	   System.out.println("ClassNotFoundException: " +ex.getMessage());
           }
           
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qldiem?" + "user=root");
           String mssv = new String();
           System.out.print("Nhập mã số sinh viên cần xóa: ");
           mssv = sc.nextLine();
           pstmt = conn.prepareStatement("delete from ketQua where mssv= ?");
           pstmt.setString(1, mssv);
           pstmt.executeUpdate();
           pstmt = conn.prepareStatement("delete from sinhVien where mssv= ?");
           pstmt.setString(1, mssv);
           pstmt.executeUpdate();
           System.out.println("Thực hiện lệnh thành công !");
        } catch ( SQLException e) {            
            System.out.println("Thực thi lênh thất bại !");
        }
   } 
   
// TIM SINH VIEN BANG MSSV
   public void find() {
	   Scanner sc = new Scanner(System.in);
       PreparedStatement pstmt = null;
       String mssv = new String();
       try {
           System.out.print("Nhập mã số sinh viên cần tìm: ");
           mssv = sc.nextLine();
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qldiem?" + "user=root");
           pstmt = conn.prepareStatement("select * from sinhVien where mssv= ?");
           pstmt.setString(1, mssv);
           ResultSet rs = pstmt.executeQuery();
              System.out.println("|------------|-------------------------|-----------|--------------|--------------|---------------------------------------------|----------|");
              System.out.println("|    MSSV    |         Họ Và Tên       | Giới Tính |   Ngày Sinh  |   Nơi Sinh   |               Địa Chỉ                       | Mã Khoa  |");
              while(rs.next()){
                mssv = rs.getString("mssv");
                String hoten = rs.getString("hoten");
                String gioitinh = rs.getString("gioiTinh");
                String ngaysinh = rs.getString("ngaySinh");
                String noisinh = rs.getString("noiSinh");
                String diachi = rs.getString("diaChi");
                String makhoa = rs.getString("maKhoa");
                  
                System.out.println("|------------|-------------------------|-----------|--------------|--------------|---------------------------------------------|----------|");
                System.out.printf("|%-12s|%-25s|%-11s|%-14s|%-14s|%-45s|%-10s|\n", mssv, hoten, gioitinh, ngaysinh, noisinh, diachi, makhoa);
                System.out.println();
              }
                System.out.println("|------------|-------------------------|-----------|--------------|--------------|---------------------------------------------|----------|");
      		} catch (SQLException ex) {
      			System.out.println("SQLException: " +ex.getMessage());
               }
   }
   
// TIM SINH VIEN BANG TEN
   public void findName() {
	   Scanner sc = new Scanner(System.in);
       PreparedStatement pstmt = null;
       String tencantim = new String();
       try {
           System.out.print("Nhập tên sinh viên cần tìm: ");
           tencantim = sc.nextLine();
           Connection  conn  = DriverManager.getConnection("jdbc:mysql://localhost/qldiem?" + "user=root");
           pstmt = conn.prepareStatement("select * from sinhVien where hoten like ?");
           pstmt.setString(1,'%'+tencantim);
           ResultSet rs = pstmt.executeQuery();
              System.out.println("|------------|-------------------------|-----------|--------------|--------------|---------------------------------------------|----------|");
              System.out.println("|    MSSV    |         Họ Và Tên       | Giới Tính |   Ngày Sinh  |   Nơi Sinh   |               Địa Chỉ                       | Mã Khoa  |");
              while(rs.next()){
                String mssv = rs.getString("mssv");
                String hoten= rs.getString("hoten");
                String gioitinh = rs.getString("gioiTinh");
                String ngaysinh = rs.getString("ngaySinh");
                String noisinh = rs.getString("noiSinh");
                String diachi = rs.getString("diaChi");
                String makhoa = rs.getString("maKhoa");
                  
                System.out.println("|------------|-------------------------|-----------|--------------|--------------|---------------------------------------------|----------|");
                System.out.printf("|%-12s|%-25s|%-11s|%-14s|%-14s|%-45s|%-10s|\n", mssv, hoten, gioitinh, ngaysinh, noisinh, diachi, makhoa);
                System.out.println();
              }
                System.out.println("|------------|-------------------------|-----------|--------------|--------------|---------------------------------------------|----------|");
      		} catch (SQLException ex) {
      			System.out.println("SQLException: " +ex.getMessage());
               }
   }
   
   
 //6 BANG DIEM CUA SINH VIEN
   public void showDiem() {
	   Scanner sc = new Scanner(System.in);
	   PreparedStatement pstmt = null;
       String mssv = new String();
	   try {
		   System.out.print("Nhập mssv: ");
		   mssv = sc.nextLine();
		   Connection  conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/qldiem?" + "user=root");
		   pstmt = conn.prepareStatement("select * from diemHP where mssv= ?");
		   pstmt.setString(1, mssv);
           ResultSet rs = pstmt.executeQuery();
           System.out.println("************************************************");
           System.out.println("*                   BẢNG ĐIỂM                  *");
           System.out.println("************************************************");
           System.out.println("\n|----------------------------------------|----------|");
           System.out.println("|                Tên học phần            |   Điểm   |");
           while(rs.next()) {
//           		mssv = rs.getString("mssv");
//           		String hoten = rs.getString("hoten");
           		String tenHP = rs.getString("tenHP");
           		String diem = rs.getString("diem");     
           		System.out.println("|----------------------------------------|----------|");
           		System.out.printf("|%-40s|%-10s|\n", tenHP, diem);
           }
           System.out.println("|----------------------------------------|----------|");
	   } catch (SQLException ex) {
		   System.out.println("SQLException: " +ex.getMessage());
        }
   }
   
   //7
   public void timLoai() {
	   Scanner sc = new Scanner(System.in);
       PreparedStatement pstmt = null;
       String loaicantim = new String();
       try {
           System.out.print("Nhập loại học lực mà bạn muốn tìm: ");
           loaicantim = sc.nextLine();
           Connection  conn  = DriverManager.getConnection("jdbc:mysql://localhost/qldiem?" + "user=root");
           pstmt = conn.prepareStatement("select * from timloai where Loai= ?");
           pstmt.setString(1, loaicantim);
           ResultSet rs = pstmt.executeQuery();
           System.out.println("|------------|-------------------------|---------|--------------------|------------|");
           System.out.println("|    MSSV    |         Họ Và Tên       | Mã Khoa |   Điểm Trung Bình  |    Loại    |");
           while(rs.next()) {
                String mssv = rs.getString("mssv");
                String hoten = rs.getString("hoten");
                String maKhoa = rs.getString("maKhoa");
                String diemTB = rs.getString("diemTB");
                String loai = rs.getString("Loai");
                System.out.println("|------------|-------------------------|---------|--------------------|------------|");                
                System.out.printf("|%-12s|%-25s|%-9s|%-20s|%-12s|\n", mssv, hoten, maKhoa, diemTB, loai);
              }
                System.out.println("|------------|-------------------------|---------|--------------------|------------|");   
      		} catch (SQLException ex) {
      			System.out.println("SQLException: " +ex.getMessage());
               }
   }
   
//8 KET QUA CUA CAC SINH VIEN
   public void  ketQua() {
       Connection conn = null;
       try {
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
           } catch (ClassNotFoundException ex) {
        	   System.out.println("ClassNotFoundException: " +ex.getMessage());
           }
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qldiem?" + "user=root");
           CallableStatement cStmt = conn.prepareCall("{call KetQua()}");
           ResultSet rs=cStmt.executeQuery(); 
           System.out.println("|------------|-------------------------|---------|--------------------|------------|");
           System.out.println("|    MSSV    |         Họ Và Tên       | Mã Khoa |   Điểm Trung Bình  |    Loại    |");
           while(rs.next()) {
                String mssv = rs.getString("mssv");
                String hoten = rs.getString("hoten");
                String maKhoa = rs.getString("maKhoa");
                String diemTB = rs.getString("diemTB");
                String loai = rs.getString("Loai");
                System.out.println("|------------|-------------------------|---------|--------------------|------------|");                
                System.out.printf("|%-12s|%-25s|%-9s|%-20s|%-12s|\n", mssv, hoten, maKhoa, diemTB, loai);
              }
                System.out.println("|------------|-------------------------|---------|--------------------|------------|");                
        } catch (SQLException e) {            
            System.out.println("Thực thi lênh thất bại!");
        }
   }
   
// 9NHAP DIEM CHO SV
   public  void insertDiem() {
	   Diem d = new Diem();
       d.nhapdiem();
       Connection conn = null;
       ResultSet rs = null;
       PreparedStatement pstmt = null;
       try {
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
           } catch (ClassNotFoundException ex) {
        	   System.out.println("ClassNotFoundException: " +ex.getMessage());
           }
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qldiem?" + "user=root");
          pstmt = conn.prepareStatement("insert into ketQua values (?,?,?);");
          pstmt.setString(1, d.getMssv());
          pstmt.setString(2, d.getMaHP());
          pstmt.setFloat(3, d.getDiem());    
          pstmt.executeUpdate();
          System.out.println("Thực hiện lệnh thành công !");
       }       
       catch (SQLException e) {    
            System.out.println("Thực thi lênh thất bại !");
       }
   }
   
  }

