
package sistemacontable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
    AnchorPane kardex;
    @FXML
    AnchorPane cuentas;
    @FXML
    AnchorPane balgeneral;
    @FXML
    AnchorPane ecomprobacion;
    @FXML
    AnchorPane eResultado;
    @FXML
    AnchorPane eCapital;
    @FXML
    AnchorPane inventario;
    @FXML
    TreeView tree;
  /*  @FXML
    MenuItem menuLogin;   */ 

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearArbol();
        treeClick();
    }    
  
    public void btnMenuLogin(){
      /*  menuLogin.setOnAction(new EventHandler<ActionEvent>() {
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
        });*/
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
                    else if(str.contains("Balance de Comprobacion")){
                           lanzarEscena("Balance de Comprobacion",ecomprobacion, "vistas/BalanceComprobacion.fxml"); 
                    }
                    else if(str.contains("Kardex")){
                           lanzarEscena("Kardex",kardex,"vistas/Kardex.fxml"); 
                    }
                }
            }
        });
    }
    
    private void crearArbol(){
    //Arbol
        TreeItem<String> raiz,Balances,Cuentas,Inventario,eCuentas;
        
        raiz = new TreeItem<>(); //Nueva raiz, contendrá las ramas balance, catalogos, etc
        raiz.setExpanded(true);
       
        Cuentas = makeBranch("Cuentas", raiz);
        eCuentas = makeBranch("Editar Sub-cuentas", Cuentas);
        makeBranch("  Agregar Sub-cuenta", eCuentas);
        makeBranch("  Eliminar Sub-cuenta", eCuentas);
        makeBranch("Consultar Catalogo de cuentas", Cuentas);
               
        Inventario = makeBranch("Inventario", raiz);
        makeBranch("Consultar Inventario", Inventario);
        makeBranch("Compras", Inventario);
        makeBranch("Kardex", Inventario);
        
        Balances = makeBranch("Reportes", raiz);
        makeBranch("Balance de Comprobacion", Balances);
        makeBranch("Estado de Resultado", Balances);        
        makeBranch("Estado de Capital",Balances);
        makeBranch("Balance General",Balances);
        makeBranch("Hoja de trabajo",Balances);
             
        tree.setRoot(raiz); //tree es el TreeView del fxml
        tree.setShowRoot(false); //raiz no se ve porque solo es el contenedor
    }
}

