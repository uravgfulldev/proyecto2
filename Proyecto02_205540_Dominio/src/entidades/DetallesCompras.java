/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Hugo Rivera
 */
@Entity
@Table(name="detallescompras")
public class DetallesCompras implements Serializable {

    
    @Id
    @Column(name="id_detallecompra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="numerocopias",nullable=false)
    private int numerocopias;
    @Column(name="precio",nullable=false)
    private float precio;
    @Column(name="importe",nullable=false)
    private float importe;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_compra",nullable=false)
    private Compra compra;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_videojuego",nullable=false)
    private Videojuego videojuego;
    
    
    
    public DetallesCompras() {
    }

    public DetallesCompras(int numerocopias, float precio, float importe, Compra compra, Videojuego videojuego) {
        this.numerocopias = numerocopias;
        this.precio = precio;
        this.importe = importe;
        this.compra = compra;
        this.videojuego = videojuego;
    }

    public DetallesCompras(Long id, int numerocopias, float precio, float importe, Compra compra, Videojuego videojuego) {
        this.id = id;
        this.numerocopias = numerocopias;
        this.precio = precio;
        this.importe = importe;
        this.compra = compra;
        this.videojuego = videojuego;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumerocopias() {
        return numerocopias;
    }

    public void setNumerocopias(int numerocopias) {
        this.numerocopias = numerocopias;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
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
        if (!(object instanceof DetallesCompras)) {
            return false;
        }
        DetallesCompras other = (DetallesCompras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetallesCompras{" + "id=" + id + ", numerocopias=" + numerocopias + ", precio=" + precio + ", importe=" + importe + ", compra=" + compra + ", videojuego=" + videojuego + '}';
    }

    
    
}
