import java.time.LocalDate;

public class GiaoDich {
    private String maGD;
    private LocalDate ngayGD;
    private double soTien;
    private String loaiGD;

    public GiaoDich() {
    }

    public GiaoDich(String maGD, LocalDate ngayGD, double soTien, String loaiGD) {
        this.maGD = maGD;
        this.ngayGD = ngayGD;
        this.soTien = soTien;
        this.loaiGD = loaiGD;
    }

    public String getMaGD() {
        return maGD;
    }

    public void setMaGD(String maGD) {
        this.maGD = maGD;
    }

    public LocalDate getNgayGD() {
        return ngayGD;
    }

    public void setNgayGD(LocalDate ngayGD) {
        this.ngayGD = ngayGD;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public String getLoaiGD() {
        return loaiGD;
    }

    public void setLoaiGD(String loaiGD) {
        this.loaiGD = loaiGD;
    }

    public void nhap() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhập mã giao dịch: ");
        this.maGD = sc.nextLine();

        System.out.print("Nhập số tiền: ");
        this.soTien = sc.nextDouble();
        sc.nextLine();

        System.out.print("Nhập loại giao dịch: ");
        this.loaiGD = sc.nextLine();

        this.ngayGD = LocalDate.now();
    }
    public void hienThiThongTinGiaoDich() {
        System.out.println("Mã giao dịch     : " + maGD);
        System.out.println("Ngày giao dịch   : " + ngayGD);
        System.out.println("Số tiền          : " + String.format("%,.0f VND", soTien));
        System.out.println("Loại giao dịch   : " + loaiGD);
    }


    }
