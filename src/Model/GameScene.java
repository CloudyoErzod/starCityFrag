package Model;

import Tools.Path;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;



public class GameScene {

    public static int score = 0;
    public static Text ScoreT;
    private ImageView imgBg;
    private SpaceShip spaceShip;




    public ImageView getImgBg() {
        return imgBg;
    }

    public void setImgBg(ImageView imgBg) {
        this.imgBg = imgBg;
    }

    public GameScene() {
        super();
    }

    public void initScore() {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // RÃ©cupÃ©ration de la taille de l'Ã©cran

        double posXScore = (primaryScreenBounds.getWidth() * 70) / 100;
        double posYscore = (primaryScreenBounds.getHeight() * 10 ) /100;

        ScoreT = new Text(posXScore, posYscore, "Score 0");
        Font policeTitre = Font.loadFont(getClass().getResourceAsStream(Path.fontHeadCase), 30);
        ScoreT.setFont(policeTitre);
        //ScoreT.setLayoutX(60);
        //ScoreT.setLayoutY(-20);
        ScoreT.setFill(Color.WHITE);
    }



    /**
     * Mise en place de l'image de fond en fonction de la taille de l'Ã©cran de l'utilisateur
     */
    public void initBackground() {
        imgBg = new ImageView("Asset/Images/imageSpace.jpg");
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // RÃ©cupÃ©ration de la taille de l'Ã©cran
        imgBg.setFitHeight((float) primaryScreenBounds.getHeight());
        imgBg.setFitWidth((float) primaryScreenBounds.getWidth());
    }




    public void initSpaceShipSkills(String typeV) {

        if ( typeV.equals("V1")){
            spaceShip = new SpaceShip(2000, 5, 80, 50);
        }
        else if ( typeV.equals("V2")){
            spaceShip = new SpaceShip(200, 20, 70, 30);
        }
        else {
            spaceShip = new SpaceShip(1000, 2, 100, 100);
        }

    }

    public SpaceShip getSpaceShip() {
        return spaceShip;
    }

    public void setSpaceShip(SpaceShip spaceShip) {
        this.spaceShip = spaceShip;
    }



}