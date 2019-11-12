package View;

import Controller.ControllerMenu;
import Model.Menu;
import Tools.Path;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

import static Tools.Music.Piou;

public class ViewMenuChoixVaisseaux {

    private Button btnMenuP;
    private Button V1;
    private Button V2;
    private Button V3;
    private Text titre;
    private ImageView imgBGChoixV;
    private Group root;
    private Menu model;


    public ViewMenuChoixVaisseaux(Menu model, Group root) {
        this.root = root;
        this.model = model;
        initTitre();
        initBackground();

        btnMenuP = initButton(110,200);
        V1 = VbuttonV1(110, 300);
        V2 = VbuttonV2(110, 500);
        V3 = VbuttonV3(110, 700);
        V1.setOnMouseEntered(mouseEvent -> Piou());
        V2.setOnMouseEntered(mouseEvent -> Piou());
        V3.setOnMouseEntered(mouseEvent -> Piou());
    }


    private void initTitre() {
        titre = new Text(15, 180, "Star CityFrag");
        Font policeTitre = Font.loadFont(getClass().getResourceAsStream(Path.fontHeadCase), 80);
        titre.setFont(policeTitre);
        titre.setLayoutX(60);
        titre.setLayoutY(-20);
        titre.setFill(Color.WHITE);
    }

    public Button initButton(int longeur, int largeur) {
        ImageView icon = new ImageView("Asset/Images/menuPrincipaleBtn.png");
        // Création d'un bouton
        Button b = new Button();
        b.setGraphic(icon);
        b.setLayoutX(longeur);
        b.setLayoutY(largeur);
        //b.setText(texteB);

        return b;
    }

    /**
     * Mise en place de l'image de fond en fonction de la taille de l'écran de l'utilisateur
     */
    private void initBackground() {
        imgBGChoixV = new ImageView("Asset/Images/ScreenShot0086.jpg");
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
        imgBGChoixV.setFitHeight((int) primaryScreenBounds.getHeight());
        imgBGChoixV.setFitWidth((int) primaryScreenBounds.getWidth());
    }

    public Button VbuttonV1(int longeur, int largeur ) {
        ImageView iconV1 = new ImageView("Asset/Images/aegisGladius.png");
        // Création d'un bouton
        Button b = new Button();
        b.setGraphic(iconV1);
        b.setLayoutX(longeur);
        b.setLayoutY(largeur);
        //b.setText(texteB);
        /* b.setFont(buttonFont);*/

        return b;
    }

    public Button VbuttonV2(int longeur, int largeur ) {
        ImageView iconV2 = new ImageView("Asset/Images/FC7Hornet.png");
        // Création d'un bouton
        Button b = new Button();
        b.setGraphic(iconV2);
        b.setLayoutX(longeur);
        b.setLayoutY(largeur);
        //b.setText(texteB);
        /* b.setFont(buttonFont);*/

        return b;
    }

    public Button VbuttonV3(int longeur, int largeur ) {
        ImageView iconV3 = new ImageView("Asset/Images/AnvillArrow.png");
        // Création d'un bouton
        Button b = new Button();
        b.setGraphic(iconV3);
        b.setLayoutX(longeur);
        b.setLayoutY(largeur);
        //b.setText(texteB);
        /* b.setFont(buttonFont);*/

        return b;
    }

    void setImgBGChoixV() {
        root.getChildren().clear();
        root.getChildren().add(imgBGChoixV);
        root.getChildren().add(titre);
        root.getChildren().add(btnMenuP);
        root.getChildren().add(V1);
        root.getChildren().add(V2);
        root.getChildren().add(V3);
    }

    void setEvents(ControllerMenu mc) {
        btnMenuP.setOnMouseClicked(mc);
        V1.setOnMouseClicked(mc);
        V2.setOnMouseClicked(mc);
        V3.setOnMouseClicked(mc);
    }

    public Object getRetourMenuPrincipale(){
        return btnMenuP;
    }

    public Object getLancerLeJeuV1() {
        return V1;
    }
    public Object getLancerLeJeuV2() {
        return V2;
    }
    public Object getLancerLeJeuV3() {
        return V3;
    }
}
