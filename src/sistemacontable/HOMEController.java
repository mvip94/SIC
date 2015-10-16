
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
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class HOMEController extends StackPane implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @FXML
    AnchorPane login;
    @FXML
    AnchorPane cuentas;
    @FXML
    AnchorPane balgeneral;
    @FXML
    AnchorPane eResultado;
    @FXML
    AnchorPane eCapital;
    @FXML
    AnchorPane inventario;
    @FXML
    TreeView tree;
    @FXML
    MenuItem menuLogin;    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearArbol();
        treeClick();
    }    
  
    public void btnMenuLogin(){
        menuLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                     Stage stage = new Stage();
                     stage.setTitle("Login");
                    login = FXMLLoader.load(getClass().getResource("vistas/login.fxml"));
                    Scene scene = new Scene (login);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(HOMEController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
   
    private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
     TreeItem<String> item = new TreeItem<>(title); 
     item.setExpanded(false);
     parent.getChildren().add(item);
     return item;
    }
     
    private void lanzarEscena(String title, AnchorPane pane, String fxml){
    try {
                     Stage stage = new Stage();
                     stage.setTitle(title);
                     pane = FXMLLoader.load(getClass().getResource(fxml));
                     Scene scene = new Scene (pane);
                     stage.setScene(scene);
                     stage.show();
                    }
                    catch (IOException ex) {
                        Logger.getLogger(HOMEController.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
    
    private void treeClick(){
        tree.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
             @Override
            public void handle(MouseEvent mouseEvent)
            {            
                if(mouseEvent.getClickCount() == 2)
                {
                  TreeItem<String> item = (TreeItem<String>)tree.getSelectionModel().getSelectedItem();
                    //  System.out.println("Selected Text : " + item.getValue());
                  String str = item.getValue();
                    // System.out.println("Selected Textasasdf : " + str);

                    if(str.contains("Consultar Catalogo de cuentas")){
                        lanzarEscena("Catalogo de cuentas", cuentas, "vistas/Catalogo.fxml");
                    }
                    else if(str.contains("Consultar Inventario")){
                          lanzarEscena("Inventario", inventario, "vistas/inventario.fxml");
                    }
                    else if(str.contains("Balance General")){
                           lanzarEscena("Balance General", balgeneral, "vistas/BalanceGeneral.fxml"); 
                    }
                    else if(str.contains("Estado de Resultado")){
                           lanzarEscena("Estado de Resultado",eResultado, "vistas/EstadoResultado.fxml"); 
                    }
                    else if(str.contains("Estado de Capital")){
                           lanzarEscena("Estado de Capital",eCapital, "vistas/EstadoCapital.fxml"); 
                    }
                }
            }
        });
    }
    
    private void crearArbol(){
    //Arbol
        TreeItem<String> raiz,Balances, Reportes, ECatalogos;
        
        raiz = new TreeItem<>(); //Nueva raiz, contendrá las ramas balance, catalogos, etc
        raiz.setExpanded(true);
       
        Reportes = makeBranch("Consultar catalogos", raiz);
        makeBranch("Consultar Catalogo de cuentas", Reportes);
        makeBranch("Consultar Inventario", Reportes);
        
        Balances = makeBranch("Reportes", raiz);
        makeBranch("Estado de Resultado", Balances);
        makeBranch("Estado de Comprobacion", Balances);
        makeBranch("Balance General",Balances);
        makeBranch("Estado de Capital",Balances);
        makeBranch("Hoja de trabajo",Balances);
        
        ECatalogos = makeBranch("Inventario", raiz);
        makeBranch("Compras", ECatalogos);
        makeBranch("Kardex", ECatalogos);
        
        
        
        
        tree.setRoot(raiz); //tree es el TreeView del fxml
        tree.setShowRoot(false); //raiz no se ve porque solo es el contenedor
    }
}

