package View;

import Controller.ControllerMenu;
import Model.Menu;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.awt.*;

import static Tools.Music.startMainMenuMusic;
import static Tools.Music.Piou;

public class ViewHandler extends Application {
    private Stage primaryStage;
    private ViewMenuPrincipal mp;
    private ViewMenuOptions mo;
    private Menu model;
    private Menu model2;
    private ControllerMenu controllerMenu;
    private Button btn;
    private Button btn2;
    private Button btn3;
    private Button btn4;

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

//----------------------------------------------------------------------------------------------------------------------
//Vue Menu Principal
//----------------------------------------------------------------------------------------------------------------------
        Group root = new Group();
        Scene scene = new Scene(root);

        model = new Menu();

        mp = new ViewMenuPrincipal(model, root);

        controllerMenu = new ControllerMenu(this, model);

        // Affichage du menu

        primaryStage.setTitle("Star CityFrag");
        primaryStage.setFullScreenExitHint("");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setFullScreen(true);
        primaryStage.show();
        startMainMenuMusic();


        btn = initButton(150, 300, "Jouer");
        btn4 = initButton(150, 360, "Quitter");
        btn2 = initButton(150, 320, "Retour");

        btn2.setOnAction(event -> primaryStage.setScene(scene));
        btn4.setOnAction(event -> primaryStage.close());
        btn.setOnMouseEntered(mouseEvent -> Piou());
        btn2.setOnMouseEntered(mouseEvent -> Piou());

        btn4.setOnMouseEntered(mouseEvent -> Piou());




        root.getChildren().add(btn);

        root.getChildren().add(btn4);


//----------------------------------------------------------------------------------------------------------------------
// Vue du menu Option
//----------------------------------------------------------------------------------------------------------------------

        Group root2 = new Group();
        Scene scene2 = new Scene(root2);

        btn3 = initButton(150, 420, "Options");
        btn3.setOnMouseEntered(mouseEvent -> Piou());
        btn3.setOnAction(event -> primaryStage.setScene(scene2));
        root.getChildren().add(btn3);
        model2 = new Menu();

        mo = new ViewMenuOptions(model2, root2);
        controllerMenu = new ControllerMenu(this, model2);
        // Affichage du menu


        root2.getChildren().add(btn2);

    }


    public void setEventHandlerMenu(ControllerMenu cm) {
        mp.setEvents(cm);
    }

    // GETTERS AND SETTERS
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ViewMenuPrincipal getMp() {
        return mp;
    }
    public Button initButton(int longeur, int largeur, String texteDuBouton) {

        // Création d'un bouton
        Button b = new Button();
        b.setLayoutX(longeur);
        b.setLayoutY(largeur);
        b.setText(texteDuBouton);

        return b;
    }

}