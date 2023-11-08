/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class SanPham {
    private String MaSP;
    private String TenSP;
    private String soluong;
    private String TrangThai;
    private DanhMuc danhMuc;
    private ThuongHie thuongHie;
    private XuatSu xuatSu;
    private String Gia;
    private String Mota;


    public SanPham() {
    }

    public SanPham(String MaSP, String TenSP, String soluong, String TrangThai, DanhMuc danhMuc, ThuongHie thuongHie, XuatSu xuatSu, String Gia) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.soluong = soluong;
        this.TrangThai = TrangThai;
        this.danhMuc = danhMuc;
        this.thuongHie = thuongHie;
        this.xuatSu = xuatSu;
        this.Gia = Gia;
    }
    
    public SanPham(String MaSP, String TenSP, String soluong, String TrangThai, DanhMuc danhMuc, ThuongHie thuongHie, XuatSu xuatSu, String Gia, String Mota) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.soluong = soluong;
        this.TrangThai = TrangThai;
        this.danhMuc = danhMuc;
        this.thuongHie = thuongHie;
        this.xuatSu = xuatSu;
        this.Gia = Gia;
        this.Mota = Mota;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getTrangThai() {
        return TrangThai.equals("1")?"Còn hàng":"Hết hàng";
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public ThuongHie getThuongHie() {
        return thuongHie;
    }

    public void setThuongHie(ThuongHie thuongHie) {
        this.thuongHie = thuongHie;
    }

    public XuatSu getXuatSu() {
        return xuatSu;
    }

    public void setXuatSu(XuatSu xuatSu) {
        this.xuatSu = xuatSu;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String Gia) {
        this.Gia = Gia;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }
    
    

}
