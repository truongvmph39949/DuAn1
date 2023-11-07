/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class ThuongHie {
    private String MaTH;
    private String TenTH;

    public ThuongHie() {
    }

    public ThuongHie(String TenTH) {
        this.TenTH = TenTH;
    }
    
    public ThuongHie(String MaTH, String TenTH) {
        this.MaTH = MaTH;
        this.TenTH = TenTH;
    }

    public String getMaTH() {
        return MaTH;
    }

    public void setMaTH(String MaTH) {
        this.MaTH = MaTH;
    }

    public String getTenTH() {
        return TenTH;
    }

    public void setTenTH(String TenTH) {
        this.TenTH = TenTH;
    }

    @Override
    public String toString() {
        return TenTH;
    }
    
    
}
