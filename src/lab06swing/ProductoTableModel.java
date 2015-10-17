/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab06swing;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jorge
 */
public class ProductoTableModel extends AbstractTableModel {

    ArrayList<Producto> Productos = new ArrayList<Producto>();

    @Override
    public int getRowCount() {
        return Productos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto producto = Productos.get(rowIndex);
        Object valor = null;
        switch (columnIndex) {
            case 0:
                valor = producto.codigo;
                break;
            case 1: 
                valor=producto.nombre;
               break;
            case 2: 
                valor=producto.cantidadExistencia;
            case 3:
                valor=producto.precioUnitario;
        }
        return valor;

    }

}
