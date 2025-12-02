import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KhachHang extends ThongTinCaNhan {

    private String maKhachHang;
    private List<TaiKhoan> danhSachTaiKhoan;
    private TheTinDung theTinDung;

    public KhachHang() {
        super();
        danhSachTaiKhoan = new ArrayList<>();
    }

    public KhachHang(String maKhachHang, String hoTen, String diaChi, String soDienThoai) {
        super(hoTen, diaChi, soDienThoai);
        this.maKhachHang = maKhachHang;
        this.danhSachTaiKhoan = new ArrayList<>();
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public List<TaiKhoan> getDanhSachTaiKhoan() {
        return danhSachTaiKhoan;
    }

    public TheTinDung getTheTinDung() {
        return theTinDung;
    }

    public void setTheTinDung(TheTinDung theTinDung) {
        this.theTinDung = theTinDung;
    }

    public TaiKhoan layTaiKhoanTheoSo(String soTK) {
        for (TaiKhoan tk : danhSachTaiKhoan) {
            if (tk.getSoTK().equals(soTK)) {
                return tk;
            }
        }
        return null;
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã khách hàng: ");
        maKhachHang = sc.nextLine();

        System.out.println("=== Nhập thông tin cá nhân ===");
        super.Nhap();
    }


    @Override
    public void Xuat() {
        System.out.println("===== Thông tin khách hàng =====");
        System.out.println("Mã KH: " + maKhachHang);

        super.Xuat();

        System.out.println("----- Danh sách tài khoản -----");
        for (TaiKhoan tk : danhSachTaiKhoan) {
            tk.XuatThongTin();
        }

        if (theTinDung != null) {
            System.out.println("----- Thẻ tín dụng -----");
            theTinDung.Xuat();
        }
    }
}
