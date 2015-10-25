
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
    AnchorPane hoja;
    @FXML
    AnchorPane nTransaccion;
    @FXML
    AnchorPane eTransaccion;
    @FXML
    TreeView tree;
    @FXML
    AnchorPane newPane;
    @FXML
    AnchorPane eInventario;
    @FXML
    AnchorPane CentralAP;
    @FXML
    AnchorPane ReqDevMateriales;
    @FXML
    MenuItem menuInventario;
    @FXML
    MenuItem menuReqMateriales;
    
    
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearArbol();
        treeClick();
        menuInventarioEntrada();
        menuReqMateriales();
    }    
    
    public void menuInventarioEntrada(){
        menuInventario.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lanzarEscenario("Entrada de Inventario", eInventario, "vistas/EntradaInventario.fxml");             
            }
        });
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
   public void menuReqMateriales(){
    menuReqMateriales.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lanzarEscenario("Requerimiento/Devolución de Inventario", ReqDevMateriales, "vistas/ReqDevMateriales.fxml");
            }
        });
   }
    
    private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
     TreeItem<String> item = new TreeItem<>(title); 
     item.setExpanded(false);
     parent.getChildren().add(item);
     return item;
    }
     
    private void lanzarEscenario(String title, AnchorPane pane, String fxml){
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
    
    private void lanzarEscena(String str){
    try {
                     CentralAP.getChildren().clear();
                     newPane = FXMLLoader.load(getClass().getResource(str));     
                     CentralAP.getChildren().add(newPane);     
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
                  String str = item.getValue();

                    if(str.contains("Consultar Catalogo de cuentas")){
                        lanzarEscenario("Catalogo de cuentas", cuentas, "vistas/Catalogo.fxml");
                    }
                    else if(str.contains("Inventario Materia Prima")){
                          lanzarEscenario("Inventario Materia Prima", inventario, "vistas/inventario.fxml");
                    }
                    else if(str.contains("Balance General")){
                           lanzarEscenario("Balance General", balgeneral, "vistas/BalanceGeneral.fxml"); 
                    }
                    else if(str.contains("Estado de Resultado")){
                           lanzarEscenario("Estado de Resultado",eResultado, "vistas/EstadoResultado.fxml"); 
                    }
                    else if(str.contains("Estado de Capital")){
                           lanzarEscenario("Estado de Capital",eCapital, "vistas/EstadoCapital.fxml"); 
                    }
                    else if(str.contains("Balance de Comprobacion")){
                           lanzarEscenario("Balance de Comprobacion",ecomprobacion, "vistas/BalanceComprobacion.fxml"); 
                    }
                    else if(str.contains("Kardex")){
                           lanzarEscenario("Kardex",kardex,"vistas/Kardex.fxml"); 
                    }
                     else if(str.contains("  Agregar Cuenta")){
                         lanzarEscena("vistas/GestionarCuentas.fxml");
                    }
                    else if(str.contains("  Eliminar Cuenta")){
                         lanzarEscena("vistas/EliminarCuenta.fxml");
                    }
                    else if(str.contains("Hoja de trabajo")){
                           lanzarEscenario("Hoja de trabajo",hoja,"vistas/HojaDeTrabajo.fxml"); 
                    }
                    else if(str.contains("Nueva Transacción")){
                           lanzarEscenario("Nueva Transacción",nTransaccion,"vistas/NuevaTransaccion.fxml"); 
                    }
                    else if(str.contains("Eliminar Transacción")){
                           lanzarEscenario("Eliminar Transacción",eTransaccion,"vistas/EliminarTransaccion.fxml"); 
                    }
                }
            }
        });
    }
    
    private void crearArbol(){
    //Arbol
        TreeItem<String> raiz,Balances,Cuentas,Inventario,eCuentas,Transaccion;
        
        raiz = new TreeItem<>(); //Nueva raiz, contendrá las ramas balance, catalogos, etc
        raiz.setExpanded(true);
       
        Cuentas = makeBranch("Cuentas", raiz);
        eCuentas = makeBranch("Editar Cuentas", Cuentas);
        makeBranch("  Agregar Cuenta", eCuentas);
        makeBranch("  Eliminar Cuenta", eCuentas);
        makeBranch("Consultar Catalogo de cuentas", Cuentas);
               
        Inventario = makeBranch("Inventario", raiz);
        makeBranch("Inventario Materia Prima", Inventario);
        makeBranch("Compras", Inventario);
        makeBranch("Kardex", Inventario);
        
        Transaccion = makeBranch("Transacciones", raiz);
        makeBranch("Nueva Transacción", Transaccion);
        makeBranch("Eliminar Transacción", Transaccion);
      
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

