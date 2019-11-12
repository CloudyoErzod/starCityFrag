package View;

import Controller.ControllerGameScene;
import Controller.ControllerMenu;
import Model.Asteroide;
import Model.GameScene;
import Model.projectile;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

import javax.imageio.ImageTranscoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ViewGameScene {

    private GameScene model;
    private Group root;
    private final Rectangle2D bounds = Screen.getPrimary().getBounds();
    private List<projectile> projectiles;
    private List<Asteroide> astreList;
    private Rectangle2D primaryScreenBounds;



    public List<Asteroide> getAstre() {
        return astreList;
    }

    public void setAstre( List<Asteroide> astre) {
        this.astreList = astre;
    }

    /**
     * Constructeur du menu principal
     *
     * @param model (ModÃ¨le correspondant au menu)
     * @param root  (Groupe principal de la vue)
     */
    ViewGameScene(GameScene model, Group root, String typeV) {
        this.root = root;
        this.model = model;
        projectiles = new ArrayList<>();
        astreList = new ArrayList<>();
         primaryScreenBounds = Screen.getPrimary().getBounds();

        this.model.initBackground();
        this.model.initSpaceShipSkills(typeV);
        this.model.getSpaceShip().initSpaceShip(typeV);//recupere v et le cockpit
        this.model.initScore();




    }
    public void majProjectiles() {
        //la fonction stream nous permet de filtrer la liste de nous astre par rapport a la collision
        projectiles = projectiles.stream()
                .filter(projectile -> !collision(projectile, astreList))
                .filter(projectile -> root.getChildren().contains(projectile.getShoot()))
                .collect(Collectors.toList());
    }


    public void shoot(int mark) {

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds();
        projectile projec = new projectile(mark, primaryScreenBounds.getWidth()/2,  primaryScreenBounds.getHeight()-220);
        projectiles.add(projec);
        root.getChildren().add(projec.getShoot());

    }

    public void creatAsteroide(int type){
        double positionX = 0;
        //je devise mon ecran par raport a la totalite /1.70 pour avoir plus au moins les astre centrer
        double maxY = primaryScreenBounds.getHeight()/1.70;
        double minY = 0;
        double range = maxY - minY;
        double positionY = (Math.random()*range)+minY;
        //set aleatoirement la direction
        char direction = Math.random()*10 + 1 > 5 ?'+':'-';
        // je dit si la direction et egal a mon caractere + elle commence a -20px de l'ecran
        if (direction=='+') {
            positionX = -20;

        }else {
            //sinon j prend la largeur de mon ecran et je rajoute +20px pour qu'il soit a l'exterieur de mon ecran
            positionX = primaryScreenBounds.getWidth() + 20;
        }
        //je crée ma variable vitesse en aleatoire pour chaque astre
       int vitesse = (int)( Math.random()*10+2);
       // System.out.println(" direction "+direction);
        //j'instencie mon astre
        Asteroide astre = new Asteroide(type,vitesse, direction ,positionX, positionY);
        //je crée ma liste dastre
        astreList.add(astre);
        root.getChildren().add(astre.getSprite());

    }


    void setVueGameScene() {
        //je crée ma vue
        root.getChildren().clear();
        root.getChildren().add(this.model.getImgBg());
        creatAsteroide(1);
        creatAsteroide(2);
        creatAsteroide(3);
        creatAsteroide(4);
        creatAsteroide(5);

        root.getChildren().add(this.model.getSpaceShip().getSprite());
        root.getChildren().add(GameScene.ScoreT);
    }

    private boolean collision(projectile projec , List<Asteroide> targetList) {
        if (projec.getY() < -10) {
            root.getChildren().remove(projec.getShoot());
           if(GameScene.score> 0) {
              GameScene.score  -= 10;
              GameScene.ScoreT.setText("Score "+GameScene.score);
               System.out.println(GameScene.ScoreT);
           }
            return true;
        }
        for (Asteroide target : targetList) {
            if (projec.getShoot().getX()  < target.getSprite().getX() + 60 && projec.getShoot().getX() > target.getSprite().getX() -60
                    && projec.getShoot().getY() < target.getSprite().getY() + 60 && projec.getShoot().getY()  > target.getSprite().getY() -60) {
                targetList.remove(target);
                GameScene.score += 10;
                GameScene.ScoreT.setText("Score "+GameScene.score);
               // System.out.println("toucher");
                root.getChildren().removeAll(projec.getShoot(), target.getSprite());
                //une fois toucher en crée à nouveau l'asteroide
                creatAsteroide((int)(Math.random()*5+1));

                return true;
            }

        }
        return false;
    }


    public void setPosition(int i){
        //cette fonction nous permet de faire
        for (int counter = 0; counter < astreList.size(); counter++) {
            if (astreList.get(counter).getDirection()=='+' && astreList.get(counter).getX()>primaryScreenBounds.getWidth()) {

                astreList.get(counter).setX(-20);

            }
            else if (astreList.get(counter).getDirection()=='-' && astreList.get(counter).getX()< 0) {

                astreList.get(counter).setX(primaryScreenBounds.getWidth()+20);

            }

            else if (astreList.get(counter).getDirection()=='+') {

                astreList.get(counter).setX(astreList.get(counter).getX()+astreList.get(counter).getSpeed());
            }
            else if (astreList.get(counter).getDirection()=='-') {
                astreList.get(counter).setX(astreList.get(counter).getX()-astreList.get(counter).getSpeed());
            }



        }

//        this.model.getAstre().getPosition().x+=this.model.getAstre().getSpeed();
//        root.getChildren().get(i).setTranslateX(this.model.getAstre().getPosition().x);


    }
    public void setPositionProjectile(){

        for (int counter = 0; counter < projectiles.size(); counter++) {
            projectiles.get(counter).setY(projectiles.get(counter).getY()-10);
            //collision(projectiles.get(counter),astreList);

        }



    }


}