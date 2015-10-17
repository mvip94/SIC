/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab06swing;

/**
 *
 * @author jorge
 */
public class Producto {
    String codigo;
    String nombre;
    Double cantidadExistencia;
    Double precioUnitario;

    public Producto() {
    }

    public Producto(String codigo, String nombre, Double cantidadExistencia, Double precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadExistencia = cantidadExistencia;
        this.precioUnitario = precioUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(Double cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", cantidadExistencia=" + cantidadExistencia + ", precioUnitario=" + precioUnitario + '}';
    }
    
            
    
}
