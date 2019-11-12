package View;

import Controller.ControllerGameScene;
import Controller.ControllerMenu;
import Model.GameScene;
import Model.Menu;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import static Tools.Music.startMainMenuMusic;

public class ViewHandler extends Application {
    private Stage primaryStage;
    private ViewMenuPrincipal mp;
    private ViewMenuOptions mo;
    private ViewMenuChoixVaisseaux mcv;

    private Menu model;
    private GameScene modelS;
    private ControllerMenu controllerMenu;
    private ControllerGameScene controllerGs;
    private Group root;


    //private ControllerOptions controllerOptions;
    private ViewGameScene vgs;



    /**
     * Permet le lancement de l'application : méthode obligatoire pour JavaFX
     *
     * @param primaryStage ()
     * @throws Exception ()
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        // root représente le panel qui va être affiché : tout ce qui doit être affiché doit lui être ajouté

        root = new Group();
        Scene scene = new Scene(root);

        model = new Menu();
        modelS = new GameScene();

        mo = new ViewMenuOptions(model, root);
        mp = new ViewMenuPrincipal(model, root);
        mcv = new ViewMenuChoixVaisseaux(model, root);



        controllerMenu = new ControllerMenu(this, model);
        controllerGs = new ControllerGameScene(this, modelS);
        scene.setOnKeyPressed(this.controllerGs);

        //LunchMenuPrincipale();

        // Affichage du menu

        primaryStage.setTitle("Star CityFrag");
        primaryStage.setFullScreenExitHint("");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setFullScreen(true);
        primaryStage.show();
        startMainMenuMusic();
    }



    public void setEventHandlerMenu(ControllerMenu cm) {
        mp.setEvents(cm);
        mo.setEvents(cm);
        mcv.setEvents(cm);

    }

    public ViewGameScene getVgs() {
        return vgs;
    }

    public void setVgs(ViewGameScene vgs) {
        this.vgs = vgs;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ViewMenuPrincipal getMp() {
        return mp;
    }

    public ViewMenuOptions getMo(){
        return mo;
    }
    public ViewMenuChoixVaisseaux getMcv(){
        return mcv;
    }


    public void setVueCompleteOptions() {
        mo.setVueCompleteOptions();
    }

    public void setVueCompleteMenu() {
        mp.setVueCompleteMenu();
    }

    public void setVueCompleteChoixVaisseaux() {
        mcv.setImgBGChoixV();
    }





    public void setVueGameScene(String typeV){
        vgs = new ViewGameScene(modelS, root, typeV);
        vgs.setVueGameScene();
        controllerGs.GameTLStart();


    }




/*
  public void LunchMenuPrincipale(){

        model = new Menu();

        mp = new ViewMenuPrincipal(model, root);
        controllerMenu = new ControllerMenu(this, model);

    }

    public void LunchMenuOptions(){

        mo = new ViewMenuOptions(model, root);
        controllerMenu = new ControllerMenu(this, model);

    }*/
}