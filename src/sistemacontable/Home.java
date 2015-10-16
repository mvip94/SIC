
package sistemacontable;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene; 
import javafx.stage.Stage;

/**
 *
 * @author mario
 */
public class Home extends Application{
   // public static final String MAIN_SCREEN = "main";
   // private Group mainScene;
 
    @Override
    public void start(Stage primaryStage) throws Exception {
       
       // FXMLLoader loader = new FXMLLoader(getClass().getResource("HOME.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("vistas/HOME.fxml"));
        Scene escena = new Scene(root, 800, 600);
        primaryStage.setTitle("Sistema Contable");  
        
        primaryStage.setScene(escena);
        primaryStage.show();        
      }

}
