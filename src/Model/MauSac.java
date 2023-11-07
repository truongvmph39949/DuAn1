/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class MauSac {
    private String MaMS;
    private String TenMau;

    public MauSac() {
    }

    public MauSac(String TenMau) {
        this.TenMau = TenMau;
    }
    
    public MauSac(String MaMS, String TenMau) {
        this.MaMS = MaMS;
        this.TenMau = TenMau;
    }

    public String getMaMS() {
        return MaMS;
    }

    public void setMaMS(String MaMS) {
        this.MaMS = MaMS;
    }

    public String getTenMau() {
        return TenMau;
    }

    public void setTenMau(String TenMau) {
        this.TenMau = TenMau;
    }
    @Override
    public String toString() {
        return TenMau ;
    }
}
