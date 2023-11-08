/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sevice;

import java.sql.*;
import Interface_SanPham.InF_SanPham;
import Model.ChatLieu;
import Model.ChitietSP;
import Model.DanhMuc;
import Model.KichCO;
import Model.MauSac;
import Model.SanPham;
import Model.ThuongHie;
import Model.XuatSu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class SanPhamService implements InF_SanPham {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<ChitietSP> getAll() {
        sql = "select SanPham.Ma_SP, SanPham.TenSP,SanPham.SoLuong,SanPham.TrangThai,SanPham.Gia,\n"
                + "XuatXu.XuatXu,ThuongHieu.TenTH,KichCo.Size,MauSac.TenMau,ChatLieu.TenCL,DanhMuc.TenDM,ChiTietSP.Ma_SPCT,SanPham.MoTa from SanPham \n"
                + "join XuatXu on SanPham.Ma_XX=XuatXu.Ma_XX\n"
                + "join ThuongHieu on SanPham.Ma_TH=ThuongHieu.Ma_TH\n"
                + "join DanhMuc on SanPham.Ma_DM=DanhMuc.Ma_DM\n"
                + "join ChiTietSP on SanPham.Ma_SP=ChiTietSP.Ma_SP\n"
                + "join MauSac on ChiTietSP.Ma_MS=MauSac.Ma_MS\n"
                + "join ChatLieu on ChiTietSP.Ma_CL=ChatLieu.Ma_CL\n"
                + "Join KichCo on ChiTietSP.Ma_KC=KichCo.Ma_KC";
        List<ChitietSP> list = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                XuatSu xuatSu = new XuatSu(rs.getString(6));
                DanhMuc danhMuc = new DanhMuc(rs.getString(11));
                ThuongHie thuongHie = new ThuongHie(rs.getString(7));

                SanPham sanPham = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), danhMuc, thuongHie,
                        xuatSu, rs.getString(5), rs.getString(13));
                KichCO kichCO = new KichCO(rs.getString(8));
                ChatLieu chatLieu = new ChatLieu(rs.getString(10));
                MauSac mauSac = new MauSac(rs.getString(9));
                ChitietSP chitietSP = new ChitietSP(rs.getString(12), sanPham, kichCO, mauSac, chatLieu);

                list.add(chitietSP);

            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public int add(SanPham sp) {
        sql = "Insert into SanPham (ma_sp, tensp, soluong, trangthai, gia, ma_dm, ma_xx, ma_th, mota)"
                + "values(?,?,?,?,?,?,?,?,?)";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getSoluong());
            ps.setObject(4, sp.getTrangThai());
            ps.setObject(5, sp.getGia());
            ps.setObject(6,sp.getDanhMuc().getTenDM());
        } catch (Exception e) {
        }
        return 0;
    }

    @Override
    public int update(SanPham sp, String MaSP) {
        sql = "Update SanPham set TenSP=?,SoLuong=?,TrangThai=?,Gia=? where MaSP=?";
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getSoluong());
            ps.setObject(4, sp.getTrangThai());
            ps.setObject(5, sp.getGia());
            ps.setObject(6, MaSP);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

}
