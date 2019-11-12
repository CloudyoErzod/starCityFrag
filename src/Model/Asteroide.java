package Model;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;




public class Asteroide {


    private int Speed;
    private char Direction;
    private int type;
    private double positionX;
    private double positionY;
    private ImageView asteroSprite;


    public Asteroide(int type, int speed, char Direction, double positionX, double positionY) {
        this.Speed = speed;
        this.Direction = Direction;
        this.type = type;
        this.positionX = positionX;
        this.positionY = positionY;


        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds();


        if (type == 1) {
            asteroSprite = new javafx.scene.image.ImageView("Asset/Images/asteroid1.png");

        } else if (type == 2) {
            asteroSprite = new javafx.scene.image.ImageView("Asset/Images/asteroid2.png");

        } else if (type == 3) {
            asteroSprite = new javafx.scene.image.ImageView("Asset/Images/asteroid3.png");

        } else if (type == 4) {
            asteroSprite = new javafx.scene.image.ImageView("Asset/Images/asteroid4.png");

        } else {
            asteroSprite = new javafx.scene.image.ImageView("Asset/Images/asteroid5.png");
        }

        //on vas set les position asteroide sur ecran
        asteroSprite.setX(positionX);
        asteroSprite.setY(positionY);
        //set taille asteroide sur ecran
        double ratio = Math.random()*3+3;
        //System.out.println("ratio: "+ratio);
        asteroSprite.setFitHeight((primaryScreenBounds.getHeight()*ratio) / 100);
        asteroSprite.setFitWidth((primaryScreenBounds.getWidth() *ratio) / 100);

    }


    public double getX() {
        return asteroSprite.getX();
    }

    public double getY() {
        return asteroSprite.getY();
    }

    public void setX(double pos) {
        asteroSprite.setX(pos);
    }

    public void setY(double pos) {
        asteroSprite.setY(pos);
    }


    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public ImageView getSprite() {
        return asteroSprite;
    }

    public void setSprite(ImageView asteroSprite) {
        this.asteroSprite = asteroSprite;
    }

    public char getDirection() {
        return Direction;
    }

    public void setDirection(char direction) {
        Direction = direction;
    }

}

