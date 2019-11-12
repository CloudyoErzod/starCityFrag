package Timeline;

import Controller.ControllerGameScene;
import javafx.animation.AnimationTimer;


public class GameTL extends AnimationTimer {
    private final ControllerGameScene controlleurGS;
    private long countDownUpdate = 0;
    private long lastUpdate = 0;
    private boolean isSpaceBarKeyTyped;
    private double timeSpaceBarPressed;
    private double initTimeSpaceBarPressed;


    public GameTL(ControllerGameScene controlleurGS) {

        this.controlleurGS = controlleurGS;
        isSpaceBarKeyTyped = false;
        timeSpaceBarPressed = 0;

        initTimeSpaceBarPressed = 0;


    }

    @Override
    public void handle(long now) {

        if (now - lastUpdate >= 10_000) {

            if (controlleurGS.isLeftKeyTyped()) {
                System.out.println("leftpressed");
                //controlleurGS.moveLeft();

            } else if (controlleurGS.isRightKeyTyped()) {
                System.out.println("rightpressed");
                //controlleurGS.moveRight();
            }
            if (controlleurGS.isSpaceBarKeyTyped() && initTimeSpaceBarPressed == 0) {
                controlleurGS.getLauncher().getVgs().shoot(3);
                controlleurGS.setSpaceBarKeyStatut(false);
                initTimeSpaceBarPressed = now;

               // System.out.println("inittimespacebarpressed");

            } else if (controlleurGS.isSpaceBarKeyTyped() && now - timeSpaceBarPressed>500_000_000) {

                //System.out.println("time SpaceBar Pressed");
                controlleurGS.getLauncher().getVgs().shoot(3);
                controlleurGS.setSpaceBarKeyStatut(false);

                timeSpaceBarPressed = now;
                //System.out.println(!controlleurGS.isSpaceBarKeyTyped());
            }
                lastUpdate = now;
            }


            if (now - countDownUpdate >= 28_000_000) {
                countDownUpdate = now;
                controlleurGS.getLauncher().getVgs().setPosition(2);
            }

            //controlleurGS.moveProjectile();
            controlleurGS.getLauncher().getVgs().setPositionProjectile();
            controlleurGS.majProjectiles();

        }


    }