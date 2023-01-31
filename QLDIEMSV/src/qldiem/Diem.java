
package qldiem;

import java.util.Scanner;

public class Diem {
    private String mssv, mahp; 
    private float diem;
    
    public String getMssv() {
        return mssv;
    }

    public String getMaHP() {
        return mahp;
    }

    public float getDiem() {
        return diem;
    }
    
    public Diem() {
        mssv = new String();
        mahp = new String();
        diem = 0;
    }
    
    public Diem(String mssv, String mahp, int diem) {
        this.mssv = mssv;
        this.mahp = mahp;
        this.diem = diem;
    }
    
    public void nhapdiem(){
        Scanner sc=new Scanner(System.in);
        System.out.print("MSSV: ");
        mssv=sc.nextLine();
        System.out.print("Mã học phần: ");
        mahp=sc.nextLine();
        System.out.print("Nhập điểm: ");
        diem=sc.nextFloat();
    }
}
