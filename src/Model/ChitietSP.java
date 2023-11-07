/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class ChitietSP {
    private String MaSPCT;
    private SanPham sanPham ;
    private KichCO kichCO;
    private MauSac mauSac;
    private ChatLieu chatLieu;
    
    public ChitietSP() {
    }

    public ChitietSP(String MaSPCT, SanPham sanPham, KichCO kichCO, MauSac mauSac, ChatLieu chatLieu) {
        this.MaSPCT = MaSPCT;
        this.sanPham = sanPham;
        this.kichCO = kichCO;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
    }

    public String getMaSPCT() {
        return MaSPCT;
    }

    public void setMaSPCT(String MaSPCT) {
        this.MaSPCT = MaSPCT;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public KichCO getKichCO() {
        return kichCO;
    }

    public void setKichCO(KichCO kichCO) {
        this.kichCO = kichCO;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public ChatLieu getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(ChatLieu chatLieu) {
        this.chatLieu = chatLieu;
    }

    public Object[]toDataRow(){
        return new Object[]{
            this.sanPham.getMaSP(),this.sanPham.getTenSP(),this.sanPham.getSoluong(),
            this.sanPham.getTrangThai(),this.sanPham.getGia(),this.sanPham.getXuatSu().getXuatXu(),
            this.sanPham.getThuongHie().getTenTH(),this.getKichCO().getSize(),this.getMauSac().getTenMau(),
            this.getChatLieu().getTenCL(),this.getSanPham().getDanhMuc().getTenDM()
        };
    }
}
