package Model;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

public class SpaceShip {
    private int nbMunition;
    private int life;
    private int speedShip;
    private int speedDrawn;
    private ImageView CockpitPic;



    public SpaceShip(int nbMunition, int life, int speedShip, int speedDrawn){
        this.nbMunition = nbMunition;
        this.life = life;
        this.speedShip = speedShip;
        this.speedDrawn = speedDrawn;
    }
    public void initSpaceShip(String typeV){

        if (typeV.equals("V1")) {
         CockpitPic = new ImageView("Asset/Images/cockpit2.png");

     }else if (typeV.equals("V2")){
         CockpitPic = new ImageView("Asset/Images/Cockpit3.png");


     }else if (typeV.equals("V3")){
         CockpitPic = new ImageView("Asset/Images/Cockpit4.png");

     }

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // RÃ©cupÃ©ration de la taille de l'Ã©cran
        CockpitPic.setFitHeight((float) primaryScreenBounds.getHeight());
        CockpitPic.setFitWidth((float) primaryScreenBounds.getWidth());

    }

    public ImageView getSprite() {
        return CockpitPic;
    }



    public void setSprite(ImageView cockpitPic) {
        CockpitPic = cockpitPic;
    }

    public int getNbMunition() {
        return nbMunition;
    }

    public void setNbMunition(int nbMunition) {
        this.nbMunition = nbMunition;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getSpeedShip() {
        return speedShip;
    }

    public void setSpeedShip(int speedShip) {
        this.speedShip = speedShip;
    }

    public int getSpeedDrawn() {
        return speedDrawn;
    }

    public void setSpeedDrawn(int speedDrawn) {
        this.speedDrawn = speedDrawn;
    }
}
