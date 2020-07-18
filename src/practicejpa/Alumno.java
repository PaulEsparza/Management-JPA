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
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_alumno", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_alumno;
    
    @Basic(optional = false)// El que valida es el motor de persistencia
    @Column(name = "apellidos", nullable = false)// El que valida es el motor de la BD
    private String apellidos;
    
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "curso", nullable = false)
    private int curso;
    
    @Basic(optional = false)
    @Column(name = "titulacion", nullable = false)
    private int titulacion;
    
    //@OneToMany, @ManyToOne, @OneToOne especifica el tipo de relacion
    //mapedBy es a donde se estara ligando esta relacion (Atributo declarado en clase "Alumno_Asignatura")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<Alumno_Asignatura> alumnosAsignaturas = new ArrayList<>();

    public Alumno() {
    }

    public Alumno(String apellidos, String nombre, int curso, int titulacion) {
        //this.id_alumno = id_alumno;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.curso = curso;
        this.titulacion = titulacion;
    }
    
    

    public Long getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Long id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(int titulacion) {
        this.titulacion = titulacion;
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
        hash += (id_alumno != null ? id_alumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.id_alumno == null && other.id_alumno != null) || (this.id_alumno != null && !this.id_alumno.equals(other.id_alumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "practicejpa.Alumno[ id=" + id_alumno + " ]";
    }
    
    @Transient // Define un atributo que no es parte de la tabla
    public String alumInfo;
    
    @PostLoad
    @PostPersist
    @PostUpdate
    public void info() {
        alumInfo = id_alumno + ", "
                + apellidos + ", "
                + nombre + ", "
                + titulacion + "\n";
    }
    
}
