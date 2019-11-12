package Model;


import javafx.scene.image.ImageView;

public class projectile {

    private static final String smallShoot = "Asset/Images/small_shoot.png";
    private static final String mediumShoot = "Asset/Images/medium_shoot.png";
    private static final String bigShoot = "Asset/Images/big_shoot.png";

    private final ImageView shoot;

    public projectile(int mark, double x, double y) {
        if (mark == 1) {
            shoot = new ImageView(smallShoot);
        } else if (mark == 2) {
            shoot = new ImageView(mediumShoot);
        } else {
            shoot = new ImageView(bigShoot);
        }
        shoot.setX(x);
        shoot.setY(y);
    }

    public ImageView getShoot() {
        return shoot;
    }


    public void moveOn() {
        shoot.setY(shoot.getY()-10);
    }


    public double getX() {
        return shoot.getX();
    }

    public double getY() {
        return shoot.getY();
    }
    public void setX(double pos) {
        shoot.setX(pos);
    }

    public void setY(double pos) {
        shoot.setY(pos);
    }


    @Override
    public String toString() {
        return shoot.getX() + " " + shoot.getY();
    }
}