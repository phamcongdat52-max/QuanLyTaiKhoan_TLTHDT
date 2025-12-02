import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyNhanVien {
    private List<NhanVien> danhSachNhanVien = new ArrayList<>();

    public boolean kiemTraMaNVTonTai(String maNV) {
        return danhSachNhanVien.stream()
                .anyMatch(nv -> nv.getMaNhanVien().equalsIgnoreCase(maNV.trim()));
    }
    public boolean kiemTraSoDTTonTai(String soDT) {
        return danhSachNhanVien.stream()
                .anyMatch(nv -> nv.getSoDienThoai().equals(soDT.trim()));
    }
    public void danhSachNhanVien() {
        if (danhSachNhanVien.isEmpty()) {
            System.out.println("Danh sách nhân viên đang trống!");
            return;
        }
        System.out.println("         DANH SÁCH NHÂN VIÊN (" + danhSachNhanVien.size() + " người)");
        for (NhanVien nv : danhSachNhanVien) {
            nv.Xuat();
            System.out.println("------------------------------------------------");
        }
    }
    public void themNhanVien(NhanVien nv) {
        if (kiemTraMaNVTonTai(nv.getMaNhanVien())) {
            System.out.println("Lỗi: Mã nhân viên đã tồn tại!");
            return;
        }
        danhSachNhanVien.add(nv);
        System.out.println("Thêm nhân viên thành công!");
    }
    public void themNhanVien() {
        System.out.println("\n=== THÊM NHÂN VIÊN MỚI ===");
        NhanVien nv = new NhanVien();
        nv.Nhap();
        danhSachNhanVien.add(nv);
        System.out.println("Thêm nhân viên thành công!\n");
    }

    public void xoaNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String maNV = sc.nextLine().trim();

        NhanVien nv = timNhanVienTheoMa(maNV);
        if (nv != null) {
            danhSachNhanVien.remove(nv);
            System.out.println("Đã xóa nhân viên mã " + maNV + " thành công!\n");
        } else {
            System.out.println(" Không tìm thấy nhân viên có mã: " + maNV + "\n");
        }
    }

    public void capNhatThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên cần cập nhật: ");
        String maNV = sc.nextLine().trim();

        NhanVien nv = timNhanVienTheoMa(maNV);
        if (nv != null) {
            System.out.println("→ Tìm thấy nhân viên. Nhập thông tin mới:");
            nv.Nhap(); // Nhập lại toàn bộ thông tin
            System.out.println(" Cập nhật thông tin nhân viên " + maNV + " thành công!\n");
        } else {
            System.out.println(" Không tìm thấy nhân viên có mã: " + maNV + "\n");
        }
    }

    public void timNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên cần tìm: ");
        String maNV = sc.nextLine().trim();

        NhanVien nv = timNhanVienTheoMa(maNV);
        if (nv != null) {
            System.out.println("\n=== THÔNG TIN NHÂN VIÊN TÌM THẤY ===");
            nv.Xuat();
            System.out.println();
        } else {
            System.out.println("Không tìm thấy nhân viên có mã: " + maNV + "\n");
        }
    }

    private NhanVien timNhanVienTheoMa(String maNV) {
        for (NhanVien nv : danhSachNhanVien) {
            if (nv.getMaNhanVien().equalsIgnoreCase(maNV)) {
                return nv;
            }
        }
        return null;
    }

    public List<NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }
}