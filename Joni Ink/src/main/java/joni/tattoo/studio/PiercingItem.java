package joni.tattoo.studio;

/**
 * Created by Joni on 3/16/14.
 */
public class PiercingItem {
    private Integer piercingID;
    private String PPhoto;
    private Double PPrice;
    private int PArea;
    private int PMaterial;

    public int getPiercingID() {
        return piercingID;
    }

    public String getPPhoto() {
        return PPhoto;
    }

    public Double getPPrice() {
        return PPrice;
    }

    public int getPMaterial() {
        return PMaterial;
    }

    public int getPArea() {
        return PArea;
    }

    public void setPiercingID(int piercingID) {
        this.piercingID = piercingID;
    }

    public void setPPhoto(String PPhoto) {
        this.PPhoto = PPhoto;
    }

    public void setPPrice(double PPrice) {
        this.PPrice = PPrice;
    }

    public void setPMaterial(int PMaterial) {
        this.PMaterial = PMaterial;
    }

    public void setPArea(int PArea) {
        this.PArea = PArea;
    }
}
