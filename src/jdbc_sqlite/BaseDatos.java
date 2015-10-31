/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_sqlite;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuel
 */
public class BaseDatos {
    
    private Connection con;
    private String bd_name="base.db";
    
    
    
    public void conectar(){
        try {
            
            
            //obtener el directorio actual
            String path="";
            java.io.File f=new java.io.File(".");
            path=f.getCanonicalPath()+"/";
            
            
            java.io.File archivo_base=new java.io.File(path+bd_name);
           // System.out.println(archivo_base.exists());
            if (archivo_base.exists()){
                //instaciamos la conexion
                Class.forName("org.sqlite.JDBC");  
                con=DriverManager.getConnection("jdbc:sqlite:"+path+bd_name);
                System.out.println("se abrio una base existente");
            }else{
                //instaciamos la conexion
                Class.forName("org.sqlite.JDBC");  
                con=DriverManager.getConnection("jdbc:sqlite:"+path+bd_name);
                this.crearBase();
                llenar();
                System.out.println("se creo una base de datos nueva");
            }
                   
        
            
           
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex){
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    private void crearBase(){
        try {
            String sqls[]={"CREATE TABLE periodo(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,inicio TEXT NOT NULL, fin TEXT NOT NULL );"
                    , "CREATE TABLE cuenta(id VARCHAR(10) NOT NULL PRIMARY KEY,nombre VARCHAR(50) NOT NULL,tipo INTEGER,saldo FLOAT NOT NULL);"
                    , "CREATE UNIQUE INDEX unicidad_nombre_cuenta on cuenta(nombre);"
                    , "CREATE TABLE transaccion(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,fecha TEXT NOT NULL,periodo INTEGER NOT NULL,descripcion TEXT,FOREIGN KEY(periodo) REFERENCES periodo(id));"
                    , "CREATE TABLE movimiento_cuenta(cuenta VARCHAR(10) NOT NULL,transaccion INTEGER NOT NULL,monto REAL NOT NULL,cargado BOOLEAN NOT NULL,FOREIGN KEY(cuenta) REFERENCES cuenta(id),FOREIGN KEY(transaccion) REFERENCES transaccion(id),PRIMARY KEY(cuenta,transaccion));"
            };
            
            PreparedStatement st=null;
            for(int i=0;i<sqls.length;i++){
                st=con.prepareStatement(sqls[i]);
                st.execute();
            }
    
            
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void llenar(){
        try {
            String sql="INSERT INTO periodo (inicio,fin) values (date('now'),date('now'))";
            PreparedStatement st=con.prepareStatement(sql);
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
