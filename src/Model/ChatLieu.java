/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class ChatLieu {
    private String MaCL;
    private String TenCL;

    public ChatLieu() {
    }

    public ChatLieu(String TenCL) {
        this.TenCL = TenCL;
    }
    
    public ChatLieu(String MaCL, String TenCL) {
        this.MaCL = MaCL;
        this.TenCL = TenCL;
    }

    public String getMaCL() {
        return MaCL;
    }

    public void setMaCL(String MaCL) {
        this.MaCL = MaCL;
    }

    public String getTenCL() {
        return TenCL;
    }

    public void setTenCL(String TenCL) {
        this.TenCL = TenCL;
    }

    @Override
    public String toString() {
        return TenCL ;
    }
    
    
    
    
    
}
