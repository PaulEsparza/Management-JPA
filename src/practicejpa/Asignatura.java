package practicejpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "asignaturas")
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_asignatura", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_asignatura;
    
    @Basic(optional = false)// El que valida es el motor de persistencia
    @Column(name = "tipo", nullable = false)// El que valida es el motor de la BD
    private String tipo;
    
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "creditos", nullable = false)
    private float creditos;
    
    //@OneToMany, @ManyToOne, @OneToOne especifica el tipo de relacion
    //mapedBy es a donde se estara ligando esta relacion (Atributo declarado en clase "Alumno_Asignatura")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private List<Alumno_Asignatura> alumnosAsignaturas = new ArrayList<>();

    public Asignatura() {
    }

    public Asignatura(Long id_asignatura, String tipo, String nombre, float creditos) {
        this.id_asignatura = id_asignatura;
        this.tipo = tipo;
        this.nombre = nombre;
        this.creditos = creditos;
    }
    
    

    public Long getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(Long id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCreditos() {
        return creditos;
    }

    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }

    public List<Alumno_Asignatura> getAlumnosAsignaturas() {
        return alumnosAsignaturas;
    }

    public void setAlumnosAsignaturas(List<Alumno_Asignatura> alumnosAsignaturas) {
        this.alumnosAsignaturas = alumnosAsignaturas;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_asignatura != null ? id_asignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.id_asignatura == null && other.id_asignatura != null) || (this.id_asignatura != null && !this.id_asignatura.equals(other.id_asignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "practicejpa.Asignatura[ id=" + id_asignatura + " ]";
    }
    
}
