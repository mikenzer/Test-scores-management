
package qldiem;

import java.sql.Connection;
import java.util.Scanner;

public class QLDIEMSV {
    public static void main(String[] args){
        Scanner sc= new Scanner (System.in);
        ConnectionDB c = new ConnectionDB();
        Connection conn = null;
        c.Connection(conn);
        Function f = new Function();
        int menu;
        do {
            System.out.println("|--------------------------------------------|");
            System.out.println("|                    MENU                    |");
            System.out.println("|--------------------------------------------|");
            System.out.println("| 1. Hiển thị danh sách sinh viên            |");
            System.out.println("|--------------------------------------------|");
            System.out.println("| 2. Thêm sinh viên                          |");
            System.out.println("|--------------------------------------------|");
            System.out.println("| 3. Xóa thông tin sinh viên                 |");
            System.out.println("|--------------------------------------------|");
            System.out.println("| 4. Tìm kiếm thông tin sinh viên bằng mssv  |");
            System.out.println("|--------------------------------------------|");
            System.out.println("| 5. Tìm kiếm thông tin sinh viên bằng tên   |");
            System.out.println("|--------------------------------------------|");
            System.out.println("| 6. Xem điểm của sinh viên                  |");
            System.out.println("|--------------------------------------------|");
            System.out.println("| 7. Tìm sinh viên theo loại học lực         |");
            System.out.println("|--------------------------------------------|");
            System.out.println("| 8. Điểm trung bình và loại của sinh viên   |");
            System.out.println("|--------------------------------------------|");
            System.out.println("| 9. Nhập điểm cho sinh viên                 |");
            System.out.println("|--------------------------------------------|");
            System.out.println("| 10. Thoát chương trình                     |");
            System.out.println("|--------------------------------------------|");
            System.out.print("Nhập lựa chọn của bạn: ");
        	menu = sc.nextInt();
            switch(menu){
                case 1:
                    f.show();
                    break;       
                case 2:
                    f.insert();
                    f.show();
                    break;
                case 3:
                    f.delete();
                    f.show();
                    break;
                case 4:
                    f.find();   
                    break;
                case 5:
                    f.findName();   
                    break;
                case 6:
                    f.showDiem();
                    break;
                case 7:
                    f.timLoai();
                    break;
                case 8:
                    f.ketQua();
                    break;
                case 9:
                	f.insertDiem();
                    break;
                case 10:
                	break;
                default: 
                    System.out.println("Bạn đã nhập sai, vui lòng chọn lại !");
                    break;
            }
            if( menu != 10 ) {
                do {
                    System.out.println("\nBạn muốn tiếp tục không?");
                    System.out.println("1.Có\n2.Không");
                    System.out.print("Nhập lựa chọn( 1 or 2 ): ");
                    menu = sc.nextInt();
                } while( menu != 1 && menu != 2);
            }
            if(menu == 1) continue;
            else break;
        } while (menu != 10);
    }
}
