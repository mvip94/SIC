/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacontable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author mario
 */
public class KardexController implements Initializable {

    @FXML
    TableView tabla;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }    
    
}
