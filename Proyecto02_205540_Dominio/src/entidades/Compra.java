/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Hugo Rivera
 */
@Entity
@Table(name="compras")
public class Compra implements Serializable {
    @Id
    @Column(name="id_compra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="fecha",nullable=false)
    private Date fecha;
    @Column(name="total",nullable=false)
    private float total;
    @ManyToOne
    @JoinColumn(name="id_usuario",nullable=false)
    private Usuario usuario;
    @OneToMany(cascade=CascadeType.ALL, mappedBy="compra")
    private List<DetallesCompras> videojuegos;
    public Compra() {
    }

    public Compra(Date fecha, float total) {
        this.fecha = fecha;
        this.total = total;
    }

    public Compra(Date fecha, float total, Usuario usuario) {
        this.fecha = fecha;
        this.total = total;
        this.usuario = usuario;
    }

    public Compra(Long id, Date fecha, float total) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
    }

    public Compra(Long id, Date fecha, float total, Usuario usuario) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.usuario = usuario;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Compra[ id=" + id + " ]";
    }
    
}
