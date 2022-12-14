package Fenetre;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class fenetreGameOver {
    private fenetreGameOver FPP;
    private AnchorPane popAnchor;
    private Stage popStage;
    private Scene popScene;
    private Stage menuStage;
    private VBox vboxButtons;
    private grilleBouton grille;
    private Button boutonQuitter;
    private Button boutonRejouer;
    private static final int G_WIDTH = 600;
    private static final int G_HEIGHT = 400;

    public fenetreGameOver() {
        popAnchor = new AnchorPane();
        popScene = new Scene(popAnchor, G_WIDTH, G_HEIGHT);
        popStage = new Stage();
        setBackground();
        boutonQuitter = new Button("Quitter");
        boutonQuitter.setOnAction(event -> {
            popStage.close();
        });
        boutonRejouer = new Button("Rejouer");
        boutonRejouer.setOnAction(event -> {
            try {
                Stage primaryStage = new Stage();
                FenetrePrincipale FP = new FenetrePrincipale();
                primaryStage = FP.getStage();
                primaryStage.show();
                popStage.close();
            } catch(Exception e) {e.printStackTrace();}
        });

        grille = new grilleBouton(boutonQuitter, boutonRejouer);
        AnchorPane.setBottomAnchor(grille,25.);
        AnchorPane.setLeftAnchor(grille,240.);

        popAnchor.getChildren().add(grille);
        popStage.setScene(popScene);
    }

    private void setBackground() {
        Image imageBackground = new Image(getClass().getResourceAsStream("/images/GameOver.jpg"));
        BackgroundImage background = new BackgroundImage(imageBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        popAnchor.setBackground(new Background(background));
    }

    public void creationFenetreGameOver(Stage menuStage, fenetreGameOver Popup) {
        this.menuStage = menuStage;
        this.FPP = Popup;
        //createBackgroud();
        //gameLoop();

        popStage.show();
        this.menuStage.close();

    }
}
