import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class TaiKhoan {
    protected String soTK;
    protected String tenChuTK;
    protected double soDu;
    protected LocalDate ngayMoTK;
    protected List<GiaoDich> danhSachGD = new ArrayList<>();

    public TaiKhoan() {
        this.ngayMoTK = LocalDate.now();
    }

    public TaiKhoan(String soTK, String tenChuTK, double soDu, LocalDate ngayMoTK) {
        this.soTK = soTK;
        this.tenChuTK = tenChuTK;
        this.soDu = soDu;
        this.ngayMoTK = ngayMoTK;
    }

    public String getSoTK() {
        return soTK;
    }
    public void setSoTK(String soTK) {
        this.soTK = soTK;
    }

    public String getTenChuTK() {
        return tenChuTK;
    }
    public void setTenChuTK(String tenChuTK) {
        this.tenChuTK = tenChuTK;
    }

    public double getSoDu() {
        return soDu;
    }
    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    public LocalDate getNgayMoTK() {
        return ngayMoTK;
    }
    public void setNgayMoTK(LocalDate ngayMoTK) {
        this.ngayMoTK = ngayMoTK;
    }

    public List<GiaoDich> getDanhSachGD() {
        return danhSachGD;
    }

    public void NhapThongTin() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tên chủ tài khoản: ");
        tenChuTK = sc.nextLine();

        System.out.print("Nhập số dư ban đầu: ");
        soDu = sc.nextDouble();

        ngayMoTK = LocalDate.now();
    }

    public void XuatThongTin() {
        System.out.println("Số TK: " + soTK);
        System.out.println("Tên chủ TK: " + tenChuTK);
        System.out.println("Số dư: " + soDu);
        System.out.println("Ngày mở TK: " + ngayMoTK);

        System.out.println("Danh sách giao dịch:");
        for (GiaoDich gd : danhSachGD) {
            gd.hienThiThongTinGiaoDich();
            System.out.println("------------------------------" );
        }

    }

    public void themGiaoDich(GiaoDich gd) {
        danhSachGD.add(gd);
    }


    public abstract double TinhLaiHoacPhi();


    public void napTien(double soTien) {
        if (soTien <= 0) {
            System.out.println("Số tiền không hợp lệ.");
            return;
        }
        soDu += soTien;

        themGiaoDich(new GiaoDich("GD_NAP", LocalDate.now(), soTien, "Nạp tiền"));

        System.out.println("Nạp tiền thành công!");
    }

    public void rutTien(double soTien) {
        if (soTien <= 0) {
            System.out.println("Số tiền không hợp lệ.");
            return;
        }
        if (soTien > soDu) {
            System.out.println("Không đủ số dư!");
            return;
        }
        soDu -= soTien;

        themGiaoDich(new GiaoDich("GD_RUT", LocalDate.now(), soTien, "Rút tiền"));

        System.out.println("Rút tiền thành công!");
    }

    public void chuyenKhoan(TaiKhoan tkNhan, double soTien) {
        if (tkNhan == null) {
            System.out.println("Tài khoản nhận không tồn tại!");
            return;
        }
        if (soTien <= 0) {
            System.out.println("Số tiền không hợp lệ.");
            return;
        }
        if (soTien > soDu) {
            System.out.println("Không đủ số dư!");
            return;
        }

        soDu -= soTien;
        themGiaoDich(new GiaoDich("GD_CK", LocalDate.now(), soTien, "Chuyển khoản đi"));

        tkNhan.soDu += soTien;
        tkNhan.themGiaoDich(new GiaoDich("GD_CK_NHAN", LocalDate.now(), soTien, "Chuyển khoản đến"));

        System.out.println("Chuyển khoản thành công!");
    }
}
