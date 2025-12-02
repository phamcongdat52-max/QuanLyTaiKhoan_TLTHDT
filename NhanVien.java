import java.util.Scanner;

public class NhanVien extends ThongTinCaNhan {

    private String maNhanVien;

    public NhanVien() {
        super();
    }

    public NhanVien(String maNhanVien, String hoTen, String diaChi, String soDienThoai) {
        super(hoTen, diaChi, soDienThoai);
        this.maNhanVien = maNhanVien;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã nhân viên: ");
        maNhanVien = sc.nextLine();

        System.out.println("=== Nhập thông tin cá nhân ===");
        super.Nhap();
    }


    @Override
    public void Xuat() {
        System.out.println("===== Thông tin nhân viên =====");
        System.out.println("Mã NV: " + maNhanVien);
        super.Xuat();
    }
}
