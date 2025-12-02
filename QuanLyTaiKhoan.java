import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyTaiKhoan  {
    private List<TaiKhoan> dsTaiKhoan = new ArrayList<>();

    public QuanLyTaiKhoan() {
    }

    public boolean kiemTraSoTKTonTai(String soTK) {
        return dsTaiKhoan.stream()
                .anyMatch(tk -> tk.getSoTK().equals(soTK.trim()));
    }

    public void themTaiKhoan(TaiKhoan tk) {
        if (kiemTraSoTKTonTai(tk.getSoTK())) {
            System.out.println("Lỗi: Số tài khoản đã tồn tại!");
            return;
        }
        dsTaiKhoan.add(tk);
        System.out.println("Mở tài khoản thành công!");
    }

    public void themTaiKhoan() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== THÊM TÀI KHOẢN MỚI ===");
        System.out.print("Chọn loại (1: Tiết kiệm | 2: Thanh toán): ");
        int loai = sc.nextInt();
        sc.nextLine();

        TaiKhoan tk = (loai == 1) ? new TaiKhoanTietKiem() : new TaiKhoanThanhToan();
        tk.NhapThongTin();
        dsTaiKhoan.add(tk);
        System.out.println("Thêm tài khoản thành công!");
    }

    public void xoaTaiKhoan() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số tài khoản cần xóa: ");
        String soTK = sc.nextLine();

        TaiKhoan tk = TimTaiKhoan(soTK);
        if (tk != null) {
            dsTaiKhoan.remove(tk);
            System.out.println("Xóa tài khoản " + soTK + " thành công!");
        } else {
            System.out.println("Không tìm thấy tài khoản: " + soTK);
        }
    }

    public TaiKhoan TimTaiKhoan(String soTK) {
        for (TaiKhoan tk : dsTaiKhoan) {
            if (tk.getSoTK().equalsIgnoreCase(soTK.trim())) {
                return tk;
            }
        }
        return null;
    }

    public void hienThiThongTin() {
        if (dsTaiKhoan.isEmpty()) {
            System.out.println(" Danh sách tài khoản trống!");
            return;
        }

        System.out.println("     DANH SÁCH TÀI KHOẢN (" + dsTaiKhoan.size() + " tài khoản)");
        for (TaiKhoan tk : dsTaiKhoan) {
            tk.XuatThongTin();
        }
    }


    public double tinhTongLaiVaPhi() {
        double tong = 0;
        for (TaiKhoan tk : dsTaiKhoan) {
            tong += tk.TinhLaiHoacPhi();
        }
        System.out.printf("TỔNG LÃI + PHÍ TOÀN NGÂN HÀNG: %,15.0f VND%n%n", tong);
        return tong;
    }


    public List<TaiKhoan> getDsTaiKhoan() {
        return dsTaiKhoan;
    }
}