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

    public float getSize() {
        return Size;
    }

    public void setSize(float Size) {
        this.Size = Size;
    }

    @Override
    public String toString() {
        return Size+"";
    }

    public KichCO(float Size) {
        this.Size = Size;
    }
    

    

    
    
}
