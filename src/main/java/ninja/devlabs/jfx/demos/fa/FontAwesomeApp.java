package ninja.devlabs.jfx.demos.fa;

import java.io.InputStream;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FontAwesomeApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        InputStream font = FontAwesomeApp.class.getResourceAsStream("/fa/fontawesome-webfont.ttf");
        Font.loadFont(font, 10);

        FXMLLoader loader = new FXMLLoader();
        loader.setController(new AppController());
        loader.setResources(ResourceBundle.getBundle("fa.fontawesome"));
        loader.setLocation(getClass().getResource("/fxml/font_awesome.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/fxml/font_awesome.css");
        
        stage.setTitle("Font Awesome with JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
