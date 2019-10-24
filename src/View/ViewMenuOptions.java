package View;


import Model.Menu;
import Tools.Path;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;


public class ViewMenuOptions {

    private Text titre;
    private Menu model2;
    private ImageView imgBg;
    private MediaView bgVideo;
    private Group root2;


    /**
     * Constructeur du menu principal
     *
     * @param model2 (Modèle correspondant au menu)
     * @param root2  (Groupe principal de la vue)
     */
    ViewMenuOptions(Menu model2, Group root2) {
        this.root2 = root2;
        this.model2 = model2;
        initBackground();
        initTitre();
        setVueCompleteOptions();
    }

    private void initTitre() {
        titre = new Text(30, 190, "Star CityFrag");
        Font policeTitre = Font.loadFont(getClass().getResourceAsStream(Path.fontHeadCase), 100);
        titre.setFont(policeTitre);
        titre.setLayoutX(60);
        titre.setLayoutY(-20);
        titre.setFill(Color.WHITE);
    }

    /**
     * Mise en place de l'image de fond en fonction de la taille de l'écran de l'utilisateur
     */
    private void initBackground() {
        imgBg = new ImageView("Asset/Images/menuOption.gif");
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
        imgBg.setFitHeight((int) primaryScreenBounds.getHeight());
        imgBg.setFitWidth((int) primaryScreenBounds.getWidth());
    }
    void setVueCompleteOptions() {
        root2.getChildren().add(imgBg);
        root2.getChildren().add(titre);
    }
    /**
     * Ajoute a la vue tous les éléments composant le menu
     */







}