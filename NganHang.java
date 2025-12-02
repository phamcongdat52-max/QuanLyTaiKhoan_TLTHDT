public class NganHang implements IReadWrite{
    private QuanLyKhachHang quanLyKhachHang;
    private QuanLyNhanVien quanLyNhanVien;
    private QuanLyTaiKhoan quanLyTaiKhoan;
    private QuanLyGiaoDich quanLyGiaoDich;

    public NganHang() {
        this.quanLyKhachHang = new QuanLyKhachHang();
        this.quanLyNhanVien = new QuanLyNhanVien();
        this.quanLyTaiKhoan = new QuanLyTaiKhoan();
        this.quanLyGiaoDich = new QuanLyGiaoDich(quanLyTaiKhoan.getDsTaiKhoan());
    }

    public void thongKeTaiKhoan() {
        System.out.println("           THỐNG KÊ TÀI KHOẢN NGÂN HÀNG");
        quanLyTaiKhoan.hienThiThongTin();
        quanLyTaiKhoan.tinhTongLaiVaPhi();
    }

    public void thongKeGiaoDich() {
        System.out.println("           THỐNG KÊ GIAO DỊCH");
        quanLyGiaoDich.timGDTheoTaiKhoan();
    }

    public void thongKeKhachHang() {
        System.out.println("           THỐNG KÊ KHÁCH HÀNG");
        quanLyKhachHang.hienThiDanhSach();
        System.out.println("Tổng số khách hàng: " + quanLyKhachHang.getDanhSachKhachHang().size() + " người");
    }

    public void thongKeNhanVien() {
        System.out.println("           THỐNG KÊ NHÂN VIÊN");
        quanLyNhanVien.danhSachNhanVien();
        System.out.println("Tổng số nhân viên: " + quanLyNhanVien.getDanhSachNhanVien().size() + " người");
    }

    public boolean kiemTraSoDienThoaiTonTai(String soDT) {
        return quanLyKhachHang.kiemTraSoDTTonTai(soDT) ||
                quanLyNhanVien.kiemTraSoDTTonTai(soDT);
    }

    public QuanLyKhachHang getQuanLyKhachHang() {

        return quanLyKhachHang;
    }

    public QuanLyNhanVien getQuanLyNhanVien() {
        return quanLyNhanVien;
    }

    public QuanLyTaiKhoan getQuanLyTaiKhoan() {
        return quanLyTaiKhoan;
    }

    public QuanLyGiaoDich getQuanLyGiaoDich() {
        return quanLyGiaoDich;
    }
    @Override
    public void ReadData() {
    }

    @Override
    public void WriteData() {
    }
}