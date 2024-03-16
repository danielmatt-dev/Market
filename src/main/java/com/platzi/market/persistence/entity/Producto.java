package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

@Entity //Para denotar que esta clase es correspondiente a una entidad/tabla de la base de datos
@Table(name = "productos") //Colocamos la anotación table y el parámetro name = "Nombre de la tabla en la bd"
public class Producto {

    @Id //Anotación para la clave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Genera el valor de la llave primaria de manera automática
    @Column(name = "id_producto") //Indicamos a que columna hace referencia el atributo
    private Integer idProducto; //Siempre usar tipos de dato de referencia

    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    /*Establecemos la relación Muchos a uno con categoría
      Categorias 1:N Productos*/
    @ManyToOne
    /*
        name = "nombre del campo que los relaciona
        insertable = "false" (No se permite insertar una categoría desde aquí)
        updatable = "false" (No se permite actualizar una categoría desde aquí)
    */
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
