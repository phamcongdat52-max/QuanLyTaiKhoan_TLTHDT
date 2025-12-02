import java.util.Scanner;

public class ThongTinCaNhan {
    protected String hoTen;
    protected String diaChi;
    protected String soDienThoai;

    public ThongTinCaNhan() {}

    public ThongTinCaNhan(String hoTen, String diaChi, String soDienThoai) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập họ tên: ");
        hoTen = sc.nextLine();

        System.out.print("Nhập địa chỉ: ");
        diaChi = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        soDienThoai = sc.nextLine();
    }

    public void Xuat() {
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Số điện thoại: " + soDienThoai);
    }
}
