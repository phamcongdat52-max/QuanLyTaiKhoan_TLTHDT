import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyKhachHang {
    private List<KhachHang> danhSachKhachHang = new ArrayList<>();

    public boolean kiemTraMaKHTonTai(String maKH) {
        return danhSachKhachHang.stream()
                .anyMatch(kh -> kh.getMaKhachHang().equalsIgnoreCase(maKH.trim()));
    }

    public boolean kiemTraSoDTTonTai(String soDT) {
        return danhSachKhachHang.stream()
                .anyMatch(kh -> kh.getSoDienThoai().equals(soDT.trim()));
    }
    public void themKhachHang(KhachHang kh) {
        if (kiemTraMaKHTonTai(kh.getMaKhachHang())) {
            System.out.println("Lỗi: Mã khách hàng đã tồn tại!");
            return;
        }
        danhSachKhachHang.add(kh);
        System.out.println("Thêm khách hàng thành công từ Main!");
    }
    public void themKhachHang() {
        KhachHang kh = new KhachHang();
        kh.Nhap();
        danhSachKhachHang.add(kh);
        System.out.println("Thêm khách hàng thành công!");
    }

    public void xoaKhachHang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã khách hàng cần xóa: ");
        String maKH = sc.nextLine();

        KhachHang kh = timKhachHangTheoMa(maKH);
        if (kh != null) {
            danhSachKhachHang.remove(kh);
            System.out.println(" Xóa khách hàng " + maKH + " thành công!");
        } else {
            System.out.println("Không tìm thấy khách hàng có mã: " + maKH);
        }
    }

    public void capNhatThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã khách hàng cần cập nhật: ");
        String maKH = sc.nextLine();

        KhachHang kh = timKhachHangTheoMa(maKH);
        if (kh != null) {
            System.out.println("Tìm thấy khách hàng. Nhập thông tin mới:");
            kh.Nhap();
            System.out.println("Cập nhật thông tin thành công!");
        } else {
            System.out.println(" Không tìm thấy khách hàng có mã: " + maKH);
        }
    }

    public void timKhachHang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã khách hàng cần tìm: ");
        String maKH = sc.nextLine();

        KhachHang kh = timKhachHangTheoMa(maKH);
        if (kh != null) {
            System.out.println("\n=== THÔNG TIN KHÁCH HÀNG ===");
            kh.Xuat();
        } else {
            System.out.println(" Không tìm thấy khách hàng có mã: " + maKH);
        }
    }

    private KhachHang timKhachHangTheoMa(String maKH) {
        for (KhachHang kh : danhSachKhachHang) {
            if (kh.getMaKhachHang().equalsIgnoreCase(maKH)) {
                return kh;
            }
        }
        return null;
    }

    public void hienThiDanhSach() {
        if (danhSachKhachHang.isEmpty()) {
            System.out.println(" Danh sách khách hàng trống!");
            return;
        }
        System.out.println("\n=== DANH SÁCH KHÁCH HÀNG (" + danhSachKhachHang.size() + " người) ===");
        for (KhachHang kh : danhSachKhachHang) {
            kh.Xuat();
            System.out.println("-----------------------------------");
        }
    }

    public List<KhachHang> getDanhSachKhachHang() {
        return danhSachKhachHang;
    }
}