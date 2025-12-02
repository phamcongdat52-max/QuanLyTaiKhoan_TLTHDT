import java.time.LocalDate;
import java.util.Scanner;

public class TaiKhoanTietKiem extends TaiKhoan {
    private double laiSuat;
    private LocalDate kyHan;

    public TaiKhoanTietKiem() {
        super();
    }

    public TaiKhoanTietKiem(String soTK, String tenChuTK, double soDu,
                            LocalDate ngayMoTK, double laiSuat, LocalDate kyHan) {
        super(soTK, tenChuTK, soDu, ngayMoTK);
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    public LocalDate getKyHan() {
        return kyHan;
    }

    public void setKyHan(LocalDate kyHan) {
        this.kyHan = kyHan;
    }

    @Override
    public void NhapThongTin() {
        super.NhapThongTin();

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập lãi suất (%/năm): ");
        this.laiSuat = sc.nextDouble();

        System.out.println("Nhập kỳ hạn đáo hạn (yyyy-MM-dd): ");
        System.out.print("  Năm: ");
        int nam = sc.nextInt();
        System.out.print("  Tháng: ");
        int thang = sc.nextInt();
        System.out.print("  Ngày: ");
        int ngay = sc.nextInt();
        this.kyHan = LocalDate.of(nam, thang, ngay);
    }

    @Override
    public void XuatThongTin() {
        super.XuatThongTin();
        System.out.println("Lãi suất         : " + laiSuat + " %/năm");
        System.out.println("Kỳ hạn đáo hạn   : " + kyHan);
        System.out.println("Tiền lãi dự kiến : " + String.format("%,.0f VND", TinhLaiHoacPhi()));
        System.out.println("------------------------------" );
    }

    @Override
    public double TinhLaiHoacPhi() {
        LocalDate homNay = LocalDate.now();
        long soNam = java.time.temporal.ChronoUnit.YEARS.between(homNay, kyHan);
        if (soNam <= 0) soNam = 1;
        return getSoDu() * (laiSuat / 100) * soNam;
    }

    }
