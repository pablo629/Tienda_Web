package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")

public class Producto implements Serializable { //serializacion porque se va almacenar ciertos datos en el disco{

    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la producto.

    @Id //id producto es la llave de la tabla producto. 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que estrategia usan, identico a la BD 
    @Column(name = "id_producto") //decir cual es el nombre en la base de datos. Se hace la asociación 
    private long idProducto;
    //private long idCategoria; //este categoria ya no se va a necesitar, ya se va a utilizar más abajo, en la línea 31
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;
    
    //Asociación con la tabla de categorias//
    @ManyToOne // de productos a categoria es una relacion de muchos a uno, porque tenemos menos categorias para muchos productos.
    @JoinColumn(name="id_categoria") //esta es la union con la tabla de categoria (foreing key)
    Categoria categoria; //Categoria informacion id

    public Producto() {
    }

    public Producto(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}
