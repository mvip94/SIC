
package sistemacontable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author mario
 */
public class LoginController implements Initializable{//, ControlledScreen {

    /**
     * Initializes the controller class.
     */
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    @FXML
    public void btnLoginAction(ActionEvent e) throws IOException {
        ((Node)(e.getSource())).getScene().getWindow().hide();
     
    }
    
}
