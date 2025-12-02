import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QuanLyGiaoDich {


    private List<TaiKhoan> danhSachTaiKhoan;

    public QuanLyGiaoDich(List<TaiKhoan> danhSachTaiKhoan) {
        this.danhSachTaiKhoan = danhSachTaiKhoan;
    }

    public void timGDTheoTaiKhoan() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhập số tài khoản cần tra cứu giao dịch: ");
        String soTK = sc.nextLine().trim();

        TaiKhoan tk = null;
        for (TaiKhoan t : danhSachTaiKhoan) {
            if (t.getSoTK().equalsIgnoreCase(soTK)) {
                tk = t;
                break;
            }
        }

        if (tk == null) {
            System.out.println(" Không tìm thấy tài khoản: " + soTK);
            return;
        }

        List<GiaoDich> ds = tk.getDanhSachGD();
        if (ds.isEmpty()) {
            System.out.println(" Tài khoản " + soTK + " chưa có giao dịch nào.");
            return;
        }

        System.out.println("     SAO KÊ GIAO DỊCH - TÀI KHOẢN: " + soTK);
        System.out.println("     Chủ tài khoản: " + tk.getTenChuTK());
        for (GiaoDich gd : ds) {
            gd.hienThiThongTinGiaoDich();
            System.out.println("------------------------------------------------");
        }
        System.out.println("Tổng cộng: " + ds.size() + " giao dịch");
    }


}