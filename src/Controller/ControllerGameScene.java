package Controller;

import Model.GameScene;
import Model.Menu;
import Timeline.GameTL;
import View.ViewHandler;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ControllerGameScene implements EventHandler<KeyEvent> {

    private ViewHandler launcher;
    private GameScene model;
    private GameTL gameTimeLine;
    private BooleanProperty leftKeyTyped, rightKeyTyped, spaceBarKeyTyped;

    public ControllerGameScene(ViewHandler launcher, GameScene model) {
        leftKeyTyped = new SimpleBooleanProperty(false);
        rightKeyTyped = new SimpleBooleanProperty(false);
        spaceBarKeyTyped = new SimpleBooleanProperty(false);
        this.launcher = launcher;
        this.model = model;
        gameTimeLine = new GameTL(this);


    }

    public void GameTLStart() {
        gameTimeLine.start();
    }

    public void GameTLStoppe() {
        gameTimeLine.stop();
        gameTimeLine = new GameTL(this);
    }


    @Override
    public void handle(KeyEvent event) {

        if (event.getEventType() == KeyEvent.KEY_PRESSED) {

            if (event.getCode() == KeyCode.LEFT) {
                leftKeyTyped.set(true);
            } else if (event.getCode() == KeyCode.RIGHT) {
                rightKeyTyped.set(true);
            } else if (event.getCode() == KeyCode.SPACE) {

                spaceBarKeyTyped.set(true);
            }
        }else if (event.getEventType() == KeyEvent.KEY_RELEASED) {
            if (event.getCode() == KeyCode.LEFT) {
                leftKeyTyped.set(false);
            } else if (event.getCode() == KeyCode.RIGHT) {
                rightKeyTyped.set(false);
            } else if (event.getCode() == KeyCode.SPACE) {
                spaceBarKeyTyped.set(false);
            }
        }

    }

    public synchronized void majProjectiles() {
        this.launcher.getVgs().majProjectiles();

}


    public ViewHandler getLauncher() {
        return launcher;
    }

    public void setLauncher(ViewHandler launcher) {
        this.launcher = launcher;
    }

    public GameScene getModel() {
        return model;
    }

    public void setModel(GameScene model) {
        this.model = model;
    }


    public synchronized boolean isLeftKeyTyped() {
        return leftKeyTyped.get();
    }

    public synchronized boolean isRightKeyTyped() {
        return rightKeyTyped.get();
    }

    public synchronized boolean isSpaceBarKeyTyped() {
        return spaceBarKeyTyped.get();
    }

    public synchronized void setSpaceBarKeyStatut(boolean statut) {
         spaceBarKeyTyped.set(statut);
    }

}

