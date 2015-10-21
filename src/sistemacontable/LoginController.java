
package sistemacontable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mario
 */
public class LoginController implements Initializable{//, ControlledScreen {

    @FXML
    BorderPane home;
    @FXML
    Button btnLogin;
    @FXML
    TextField txtUser;
    @FXML
    PasswordField txtPass;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    @FXML
    public void btnLoginAction()  {
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                     Stage stage = new Stage();
                     stage.setTitle("Sistema Contable");
                    home = FXMLLoader.load(getClass().getResource("vistas/HOME.fxml"));
                    Scene scene = new Scene (home);
                    stage.setScene(scene);
                    stage.show();
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
     
    }
    
}
