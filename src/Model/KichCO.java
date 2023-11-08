/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class KichCO {
    private String MaKC;
    private String Size;

    public KichCO() {
    }

    public KichCO(String Size) {
        this.Size = Size;
    }
    
    public KichCO(String MaKC, String Size) {
        this.MaKC = MaKC;
        this.Size = Size;
    }

    public String getMaKC() {
        return MaKC;
    }

    public void setMaKC(String MaKC) {
        this.MaKC = MaKC;
    }

    public String getSize() {
        return Size.substring(0, 2);
    }

    public void setSize(String Size) {
        this.Size = Size;
    }
    
}
