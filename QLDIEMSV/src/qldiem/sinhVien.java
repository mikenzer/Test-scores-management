
package qldiem;

import java.util.Scanner; 

public class sinhVien {
    
    private String mssv, hoten, gioiTinh, ngaySinh, noiSinh, diaChi, maKhoa;
    
    public sinhVien() {
        mssv = new String();
        hoten = new String();
        gioiTinh= new String();
        ngaySinh = new String();
        noiSinh = new String();
        diaChi = new String();
        maKhoa=new String();
    }
    
    public sinhVien (String ms, String ht, String gt, String ngs, String ns, String dc, String mk) {
        mssv = ms;
        hoten = ht;
        gioiTinh = gt;
        ngaySinh = ngs;
        noiSinh = ns;
        diaChi = dc;
        maKhoa = mk;
    }
    
    public sinhVien(sinhVien s) {
        mssv = new String(s.mssv);
        hoten = new String(s.hoten);
        gioiTinh = new String(s.gioiTinh);
        ngaySinh = new String(s.ngaySinh);
        noiSinh = new String(s.noiSinh);
        diaChi = new String(s.diaChi);
        maKhoa = new String(s.maKhoa);
    }
    
/* ============================================================= */   
    
    public String getMssv() {
        return mssv;
    }

    public String getHoten() {
        return hoten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }
    public String getmaKhoa() {
        return maKhoa;
    }
    
/* ============================================================= */    
    
    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public void nhap(){
       Scanner  sc = new Scanner (System.in);
       
       System.out.print("MSSV: ");
       mssv = sc.nextLine();
       System.out.print("Họ và tên: ");
       hoten = sc.nextLine();
       System.out.print("Giới tính: ");
       gioiTinh = sc.nextLine();
       System.out.print("Ngày sinh: ");
       ngaySinh = sc.nextLine();
       System.out.print("Nơi sinh: ");
       noiSinh = sc.nextLine();
       System.out.print("Địa chỉ: ");
       diaChi = sc.nextLine();
       System.out.print("Mã khoa: ");
       maKhoa = sc.nextLine();
    }
    
    public void in(){
        System.out.println("MSSV: " + mssv);
        System.out.println("Họ và tên: " + hoten);
        System.out.println("Giới tính: " + gioiTinh);
        System.out.println("Ngày sinh: " + ngaySinh);
        System.out.println("Nơi sinh: " + noiSinh);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Mã khoa: " + maKhoa);
        
    }
   
}
  