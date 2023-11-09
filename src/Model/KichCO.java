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
    private float Size;

    public KichCO() {
    }

    public KichCO(String MaKC, float Size) {
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
        return String.valueOf(Size).substring(0, 2);
    }

    public void setSize(float Size) {
        this.Size = Size;
    }

    @Override
    public String toString() {
        return String.valueOf(Size).substring(0, 2);
    }

    public KichCO(float Size) {
        this.Size = Size;
    }
 
}
