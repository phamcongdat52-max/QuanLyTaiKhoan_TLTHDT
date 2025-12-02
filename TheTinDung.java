import java.time.LocalDate;
import java.util.Scanner;

public class TheTinDung {

    private String soThe;
    private double hanMuc;
    private double soTienDangNo;
    private LocalDate ngayHetHan;

    public TheTinDung() {
    }

    public TheTinDung(String soThe, double hanMuc, double soTienDangNo, LocalDate ngayHetHan) {
        this.soThe = soThe;
        this.hanMuc = hanMuc;
        this.soTienDangNo = soTienDangNo;
        this.ngayHetHan = ngayHetHan;
    }

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public double getHanMuc() {
        return hanMuc;
    }

    public void setHanMuc(double hanMuc) {
        this.hanMuc = hanMuc;
    }

    public double getSoTienDangNo() {
        return soTienDangNo;
    }

    public void setSoTienDangNo(double soTienDangNo) {
        this.soTienDangNo = soTienDangNo;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public double kiemTraHanMucConLai() {
        return hanMuc - soTienDangNo;
    }

    public void thanhToan(double soTien) {

        if (soTien <= 0) {
            System.out.println("Số tiền thanh toán không hợp lệ!");
            return;
        }

        if (soTien > soTienDangNo) {
            System.out.println("Thanh toán vượt quá số tiền đang nợ. Hệ thống chỉ thanh toán đúng số nợ.");
            soTienDangNo = 0;
        } else {
            soTienDangNo -= soTien;
        }

        System.out.println("Thanh toán thành công!");
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số thẻ: ");
        soThe = sc.nextLine();

        System.out.print("Nhập hạn mức: ");
        hanMuc = sc.nextDouble();

        System.out.print("Nhập số tiền đang nợ: ");
        soTienDangNo = sc.nextDouble();
        sc.nextLine();

        System.out.print("Nhập ngày hết hạn (yyyy-mm-dd): ");
        ngayHetHan = LocalDate.parse(sc.nextLine());
    }

    public void Xuat() {
        System.out.println("===== Thông tin thẻ tín dụng =====");
        System.out.println("Số thẻ: " + soThe);
        System.out.println("Hạn mức: " + hanMuc);
        System.out.println("Số tiền đang nợ: " + soTienDangNo);
        System.out.println("Hạn mức còn lại: " + kiemTraHanMucConLai());
        System.out.println("Ngày hết hạn: " + ngayHetHan);
    }
}
