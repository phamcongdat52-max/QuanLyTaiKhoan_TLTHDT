import java.util.Scanner;
import java.time.LocalDate;
public class Main {
    private static NganHang nganHang;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        nganHang = new NganHang();

        KhachHang kh1 = new KhachHang();
        kh1.setMaKhachHang("KH001");
        kh1.setHoTen("Pham Cong Dat");
        kh1.setDiaChi("19 Ong Ich Khiem");
        kh1.setSoDienThoai("0123456789");
        nganHang.getQuanLyKhachHang().themKhachHang(kh1);

        NhanVien nv1 = new NhanVien();
        nv1.setMaNhanVien("NV001");
        nv1.setHoTen("CongDat");
        nv1.setDiaChi("81 Cao Thang");
        nv1.setSoDienThoai("0987654321");
        nganHang.getQuanLyNhanVien().themNhanVien(nv1);

        TaiKhoanTietKiem tk1 = new TaiKhoanTietKiem();
        tk1.setSoTK("1234567890");
        tk1.setTenChuTK("Pham Cong Dat");
        tk1.setSoDu(5000000);
        tk1.ngayMoTK = LocalDate.now();
        tk1.setKyHan(LocalDate.of(2026, 12, 30));
        tk1.setLaiSuat(1);
        nganHang.getQuanLyTaiKhoan().themTaiKhoan(tk1);

        TaiKhoanThanhToan tk2 = new TaiKhoanThanhToan();
        tk2.setSoTK("9876543210");
        tk2.setTenChuTK("Pham Cong Dat");
        tk2.setSoDu(8000000);
        tk2.ngayMoTK = LocalDate.now();
        tk2.setPhiDuyTri(10000);
        nganHang.getQuanLyTaiKhoan().themTaiKhoan(tk2);
        while (true) {
            menuChinh();
            int choice = nhapLuaChon(0, 6, new String[]{
                    "Thoát chương trình",
                    "Quản lý khách hàng",
                    "Quản lý nhân viên",
                    "Quản lý tài khoản",
                    "Thực hiện giao dịch",
                    "Thống kê & báo cáo",
                    "Hệ thống (File)"
            });
            switch (choice) {
                case 1 -> menuQuanLyKhachHang();
                case 2 -> menuQuanLyNhanVien();
                case 3 -> menuQuanLyTaiKhoan();
                case 4 -> menuGiaoDich();
                case 5 -> menuThongKe();
                case 6 -> menuHeThong();
                case 0 -> thoatChuongTrinh();
            }
        }
    }

    private static void menuChinh() {
        System.out.println("                        MENU CHÍNH                          ");
        System.out.println(" 1  Quản lý khách hàng");
        System.out.println(" 2  Quản lý nhân viên");
        System.out.println(" 3  Quản lý tài khoản ngân hàng");
        System.out.println(" 4  Thực hiện giao dịch");
        System.out.println(" 5  Thống kê & Báo cáo");
        System.out.println(" 6  Hệ thống (Đọc/Ghi dữ liệu)");
        System.out.println(" 0  Thoát chương trình");
    }

    private static void menuQuanLyKhachHang() {
        while (true) {
            System.out.println("        QUẢN LÝ KHÁCH HÀNG        ");
            System.out.println(" 1. Thêm khách hàng mới");
            System.out.println(" 2. Xóa khách hàng");
            System.out.println(" 3. Cập nhật thông tin khách hàng");
            System.out.println(" 4. Tìm kiếm khách hàng");
            System.out.println(" 5. Hiển thị danh sách khách hàng");
            System.out.println(" 0. Quay lại menu chính");

            int c = nhapLuaChon(0, 5, new String[]{
                    "Quay lại", "Thêm khách hàng", "Xóa khách hàng",
                    "Cập nhật khách hàng", "Tìm khách hàng", "Hiển thị danh sách"
            });

            switch (c) {
                case 1 -> themKhachHangCoRangBuoc();
                case 2 -> nganHang.getQuanLyKhachHang().xoaKhachHang();
                case 3 -> nganHang.getQuanLyKhachHang().capNhatThongTin();
                case 4 -> nganHang.getQuanLyKhachHang().timKhachHang();
                case 5 -> nganHang.getQuanLyKhachHang().hienThiDanhSach();
                case 0 -> { return; }
            }
        }
    }

    private static void themKhachHangCoRangBuoc() {
        KhachHang kh = new KhachHang();

        while (true) {
            System.out.print("Nhập mã khách hàng (VD: KH001): ");
            String ma = sc.nextLine().trim();
            if (ma.isEmpty()) {
                System.out.println("Mã KH không được để trống!");
            } else if (nganHang.getQuanLyKhachHang().kiemTraMaKHTonTai(ma)) {
                System.out.println("MÃ KHÁCH HÀNG ĐÃ TỒN TẠI! Vui lòng nhập mã khác.");
            } else {
                kh.setMaKhachHang(ma);
                break;
            }
        }

        while (true) {
            System.out.print("Nhập số điện thoại (10-11 số): ");
            String sdt = sc.nextLine().trim();
            if (!sdt.matches("\\d{10,11}")) {
                System.out.println("Số điện thoại phải có 10-11 chữ số!");
            } else if (nganHang.kiemTraSoDienThoaiTonTai(sdt)) {
                System.out.println("SỐ ĐIỆN THOẠI ĐÃ ĐƯỢC SỬ DỤNG (bởi KH hoặc NV)!");
            } else {
                kh.setSoDienThoai(sdt);
                break;
            }
        }

        System.out.print("Nhập họ tên: ");
        kh.setHoTen(sc.nextLine());
        System.out.print("Nhập địa chỉ: ");
        kh.setDiaChi(sc.nextLine());

        nganHang.getQuanLyKhachHang().themKhachHang(kh);
        System.out.println("THÊM KHÁCH HÀNG THÀNH CÔNG!");
    }

    private static void menuQuanLyNhanVien() {
        while (true) {
            System.out.println("         QUẢN LÝ NHÂN VIÊN        ");
            System.out.println(" 1. Thêm nhân viên");
            System.out.println(" 2. Xóa nhân viên");
            System.out.println(" 3. Cập nhật nhân viên");
            System.out.println(" 4. Tìm kiếm nhân viên");
            System.out.println(" 5. Hiển thị danh sách nhân viên");
            System.out.println(" 0. Quay lại");

            int c = nhapLuaChon(0, 5, new String[]{
                    "Quay lại", "Thêm nhân viên", "Xóa nhân viên",
                    "Cập nhật nhân viên", "Tìm nhân viên", "Hiển thị danh sách"
            });

            switch (c) {
                case 1 -> themNhanVienCoRangBuoc();
                case 2 -> nganHang.getQuanLyNhanVien().xoaNhanVien();
                case 3 -> nganHang.getQuanLyNhanVien().capNhatThongTin();
                case 4 -> nganHang.getQuanLyNhanVien().timNhanVien();
                case 5 -> nganHang.getQuanLyNhanVien().danhSachNhanVien();
                case 0 -> { return; }
            }
        }
    }

    private static void themNhanVienCoRangBuoc() {
        NhanVien nv = new NhanVien();

        while (true) {
            System.out.print("Nhập mã nhân viên (VD: NV001): ");
            String ma = sc.nextLine().trim();
            if (ma.isEmpty()) {
                System.out.println("Mã NV không được để trống!");
            } else if (nganHang.getQuanLyNhanVien().kiemTraMaNVTonTai(ma)) {
                System.out.println("MÃ NHÂN VIÊN ĐÃ TỒN TẠI!");
            } else {
                nv.setMaNhanVien(ma);
                break;
            }
        }
        while (true) {
            System.out.print("Nhập số điện thoại (10-11 số): ");
            String sdt = sc.nextLine().trim();
            if (!sdt.matches("\\d{10,11}")) {
                System.out.println("Số điện thoại phải có 10-11 chữ số!");
            } else if (nganHang.kiemTraSoDienThoaiTonTai(sdt)) {
                System.out.println("SỐ ĐIỆN THOẠI ĐÃ ĐƯỢC SỬ DỤNG!");
            } else {
                nv.setSoDienThoai(sdt);
                break;
            }
        }

        System.out.print("Nhập họ tên: "); nv.setHoTen(sc.nextLine());
        System.out.print("Nhập địa chỉ: "); nv.setDiaChi(sc.nextLine());

        nganHang.getQuanLyNhanVien().themNhanVien(nv);
        System.out.println("→ THÊM NHÂN VIÊN THÀNH CÔNG!");
    }

    private static void menuQuanLyTaiKhoan() {
        while (true) {
            System.out.println("     QUẢN LÝ TÀI KHOẢN NGÂN HÀNG  ");
            System.out.println(" 1. Mở tài khoản mới");
            System.out.println(" 2. Xóa tài khoản");
            System.out.println(" 3. Tìm kiếm tài khoản");
            System.out.println(" 4. Hiển thị tất cả tài khoản");
            System.out.println(" 0. Quay lại");

            int c = nhapLuaChon(0, 4, new String[]{
                    "Quay lại", "Mở tài khoản mới", "Xóa tài khoản",
                    "Tìm kiếm tài khoản", "Hiển thị tất cả"
            });

            switch (c) {
                case 1 -> moTaiKhoanCoRangBuoc();
                case 2 -> nganHang.getQuanLyTaiKhoan().xoaTaiKhoan();
                case 3 -> {
                    System.out.print("Nhập số tài khoản cần tìm: ");
                    String soTK = sc.nextLine();
                    TaiKhoan tk = nganHang.getQuanLyTaiKhoan().TimTaiKhoan(soTK);
                    if (tk != null) tk.XuatThongTin();
                    else System.out.println("Không tìm thấy tài khoản!");
                }
                case 4 -> nganHang.getQuanLyTaiKhoan().hienThiThongTin();
                case 0 -> { return; }
            }
        }
    }

    private static void moTaiKhoanCoRangBuoc() {
        System.out.print("Chọn loại (1: Tiết kiệm | 2: Thanh toán): ");
        int loai = Integer.parseInt(sc.nextLine());

        TaiKhoan tk = (loai == 1) ? new TaiKhoanTietKiem() : new TaiKhoanThanhToan();

        while (true) {
            System.out.print("Nhập số tài khoản (10-12 chữ số): ");
            String soTK = sc.nextLine().trim();
            if (!soTK.matches("\\d{10,12}")) {
                System.out.println("Số tài khoản phải có 10-12 chữ số!");
            } else if (nganHang.getQuanLyTaiKhoan().kiemTraSoTKTonTai(soTK)) {
                System.out.println("SỐ TÀI KHOẢN ĐÃ TỒN TẠI TRONG HỆ THỐNG!");
            } else {
                tk.setSoTK(soTK);
                break;
            }
        }

        tk.NhapThongTin();
        nganHang.getQuanLyTaiKhoan().themTaiKhoan(tk);
        System.out.println("MỞ TÀI KHOẢN THÀNH CÔNG!");
    }

    private static void menuGiaoDich() {
        while (true) {
            System.out.println("\n THỰC HIỆN GIAO DỊCH ");
            System.out.println(" 1. Nạp tiền");
            System.out.println(" 2. Rút tiền");
            System.out.println(" 3. Chuyển khoản");
            System.out.println(" 4. Tra cứu sao kê giao dịch");
            System.out.println(" 0. Quay lại");
            int c = nhapLuaChon(0, 4, new String[]{
                    "Quay lại", "Nạp tiền", "Rút tiền", "Chuyển khoản", "Tra cứu sao kê"
            });
            if (c == 0) return;
            System.out.print("Nhập số tài khoản: ");
            String soTK = sc.nextLine();
            TaiKhoan tk = nganHang.getQuanLyTaiKhoan().TimTaiKhoan(soTK);
            if (tk == null) {
                System.out.println("Tài khoản không tồn tại!");
                continue;
            }
            switch (c) {
                case 1 -> napTien(tk);
                case 2 -> rutTien(tk);
                case 3 -> chuyenKhoan(tk);
                case 4 -> {
                    System.out.println("\nSAO KÊ GIAO DỊCH - TÀI KHOẢN: " + soTK);
                    tk.XuatThongTin();
                }
            }
        }
    }

    private static void napTien(TaiKhoan tk) {
        System.out.print("Nhập số tiền nạp: ");
        double tien = Double.parseDouble(sc.nextLine());
        tk.napTien(tien);
    }
    private static void rutTien(TaiKhoan tk) {
        System.out.print("Nhập số tiền rút: ");
        double tien = Double.parseDouble(sc.nextLine());
        tk.rutTien(tien);
    }
    private static void chuyenKhoan(TaiKhoan tkGui) {
        System.out.print("Nhập số tài khoản nhận: ");
        String soTKNhan = sc.nextLine();
        TaiKhoan tkNhan = nganHang.getQuanLyTaiKhoan().TimTaiKhoan(soTKNhan);
        if (tkNhan == null) {
            System.out.println("Tài khoản nhận không tồn tại!");
            return;
        }
        System.out.print("Nhập số tiền chuyển: ");
        double tien = Double.parseDouble(sc.nextLine());
        tkGui.chuyenKhoan(tkNhan, tien);
    }

    private static void menuThongKe() {
        while (true) {
            System.out.println("\n THỐNG KÊ & BÁO CÁO ");
            System.out.println(" 1. Thống kê tài khoản & lãi/phí");
            System.out.println(" 2. Tra cứu giao dịch theo tài khoản");
            System.out.println(" 3. Thống kê khách hàng");
            System.out.println(" 4. Thống kê nhân viên");
            System.out.println(" 0. Quay lại");
            int c = nhapLuaChon(0, 4, new String[]{
                    "Quay lại", "Thống kê tài khoản", "Tra cứu giao dịch",
                    "Thống kê khách hàng", "Thống kê nhân viên"
            });
            switch (c) {
                case 1 -> nganHang.thongKeTaiKhoan();
                case 2 -> nganHang.thongKeGiaoDich();
                case 3 -> nganHang.thongKeKhachHang();
                case 4 -> nganHang.thongKeNhanVien();
                case 0 -> { return; }
            }
        }
    }

    private static void menuHeThong() {
        System.out.println("\n HỆ THỐNG ");
        System.out.println(" 1. Đọc dữ liệu từ file");
        System.out.println(" 2. Ghi dữ liệu ra file");
        System.out.println(" 0. Quay lại");
        int c = nhapLuaChon(0, 2, new String[]{
                "Quay lại", "Đọc dữ liệu", "Ghi dữ liệu"
        });
        switch (c) {
            case 1 -> nganHang.ReadData();
            case 2 -> nganHang.WriteData();
        }
    }

    private static int nhapLuaChon(int min, int max, String[] tenChucNang) {
        while (true) {
            System.out.print(" ➤ Nhập lựa chọn (" + min + "-" + max + ", 0 để quay lại): ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(" Bạn chưa nhập gì! Vui lòng nhập lại.\n");
                continue;
            }
            try {
                int choice = Integer.parseInt(input);
                if (choice >= min && choice <= max) {
                    System.out.println(" ĐÃ CHỌN: " + choice + " → " + tenChucNang[choice]);
                    System.out.println(" " + "═".repeat(tenChucNang[choice].length() + 15) + "\n");
                    return choice;
                } else if (choice == 0) {
                    System.out.println(" Quay lại menu trước...\n");
                    return 0;
                } else {
                    System.out.println(" Sai phạm vi! Chỉ được chọn từ " + min + " đến " + max + " hoặc 0.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Sai định dạng! Vui lòng chỉ nhập số.\n");
            }
        }
    }

    private static void thoatChuongTrinh() {
        System.out.println("\nCẢM ƠN BẠN ĐÃ SỬ DỤNG HỆ THỐNG NGÂN HÀNG ABC!");
        System.exit(0);
    }
}