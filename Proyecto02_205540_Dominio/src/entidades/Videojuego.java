/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Hugo Rivera
 */
@Entity
@Table(name="videojuegos")
public class Videojuego implements Serializable {

    
    @Id
    @Column(name="id_videojuego")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre",nullable=false,length=50)
    private String nombre;
    @Column(name="desarrolladora",nullable=false,length=100)
    private String desarrolladora;
    @Column(name="stock",nullable=false)
    private int stock;
    @Column(name="precio",nullable=false)
    private float precio;
    @OneToMany(cascade=CascadeType.ALL, mappedBy="videojuego")
    private List<DetallesCompras> compras;
    public Videojuego() {
    }

    public Videojuego(String nombre, String desarrolladora, int stock, float precio) {
        this.nombre = nombre;
        this.desarrolladora = desarrolladora;
        this.stock = stock;
        this.precio = precio;
    }

    public Videojuego(Long id, String nombre, String desarrolladora, int stock, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.desarrolladora = desarrolladora;
        this.stock = stock;
        this.precio = precio;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videojuego)) {
            return false;
        }
        Videojuego other = (Videojuego) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Videojuego{" + "id=" + id + ", nombre=" + nombre + ", desarrolladora=" + desarrolladora + ", stock=" + stock + ", precio=" + precio + '}';
    }

   
    
}
