/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class XuatSu {
    private String MaXX;
    private String XuatXu;

    public XuatSu() {
    }

    public XuatSu(String XuatXu) {
        this.XuatXu = XuatXu;
    }
    
    public XuatSu(String MaXX, String XuatXu) {
        this.MaXX = MaXX;
        this.XuatXu = XuatXu;
    }

    public String getMaXX() {
        return MaXX;
    }

    public void setMaXX(String MaXX) {
        this.MaXX = MaXX;
    }

    public String getXuatXu() {
        return XuatXu;
    }

    public void setXuatXu(String XuatXu) {
        this.XuatXu = XuatXu;
    }

    @Override
    public String toString() {
        return  XuatXu;
    }
    
}
