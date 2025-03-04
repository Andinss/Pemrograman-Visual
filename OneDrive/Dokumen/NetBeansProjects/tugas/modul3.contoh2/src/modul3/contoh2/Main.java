/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package modul3.contoh2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class Main extends Application {
    
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {

        primaryStage = stage;
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();

        // Memuat file FXML
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

        // Membuat scene dengan root dari FXML
        Scene scene = new Scene(root);

        // Mengatur stage (jendela utama)
        primaryStage.setScene(scene);
        primaryStage.setTitle("Masoem University");
        Image icon = new Image(getClass()
                .getResourceAsStream("/assets/img/icon.png"));
        primaryStage.getIcons().add(icon);

        primaryStage.show();
    }
    
    public void changeScene(String fxmlFile) throws Exception {

    Parent newRoot = FXMLLoader.load(getClass().getResource(fxmlFile));

    // mengambil ukuran root container pada file fxml
    double width = newRoot.prefWidth(-1);  // -1 nilai preferensi
    double height = newRoot.prefHeight(-1); // -1 nilai preferensi

    primaryStage.getScene().setRoot(newRoot);
    primaryStage.setWidth(width);
    primaryStage.setHeight(height);
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

