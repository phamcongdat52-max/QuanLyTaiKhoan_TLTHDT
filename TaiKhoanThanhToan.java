import java.time.LocalDate;
import java.util.Scanner;

public class TaiKhoanThanhToan extends TaiKhoan {
    private double phiDuyTri;

    public TaiKhoanThanhToan() {
        super();
    }

    public TaiKhoanThanhToan(String soTK, String tenChuTK, double soDu,
                             LocalDate ngayMoTK, double phiDuyTri) {
        super(soTK, tenChuTK, soDu, ngayMoTK);
        this.phiDuyTri = phiDuyTri;
    }

    public double getPhiDuyTri() {
        return phiDuyTri;
    }

    public void setPhiDuyTri(double phiDuyTri) {
        this.phiDuyTri = phiDuyTri;
    }

    @Override
    public void NhapThongTin() {
        super.NhapThongTin();

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập phí duy trì tài khoản mỗi tháng (VD: 10000): ");
        this.phiDuyTri = sc.nextDouble();
    }

    @Override
    public void XuatThongTin() {
        super.XuatThongTin();
        System.out.println("Phí duy trì/tháng : " + String.format("%,.0f VND", phiDuyTri));
        System.out.println("Phí dự kiến năm   : " + String.format("%,.0f VND", TinhLaiHoacPhi()));
        System.out.println("------------------------------" );
    }

    @Override
    public double TinhLaiHoacPhi() {
        return phiDuyTri * 12;
    }

}