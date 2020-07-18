package practicejpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos_asignaturas")
public class Alumno_Asignatura implements Serializable {

    @EmbeddedId //Se usa para llaves primarias compuestas
    protected AlumnoAsignaturaPK alumnoAsignaturaPK;
    
    @Basic(optional = false)
    @Column(name = "cursada")
    private Character cursada;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_asignatura", referencedColumnName = "id_asignatura",
            insertable = false, updatable = false)
    private Asignatura asignatura;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno",
            insertable = false, updatable = false)
    private Alumno alumno;

    public Alumno_Asignatura() {
    }

    public Alumno_Asignatura(Character cursada, Asignatura asignatura, Alumno alumno) {
        this.cursada = cursada;
        this.asignatura = asignatura;
        this.alumno = alumno;
    }
    
    

    public AlumnoAsignaturaPK getAlumnoAsignaturaPK() {
        return alumnoAsignaturaPK;
    }

    public void setAlumnoAsignaturaPK(AlumnoAsignaturaPK alumnoAsignaturaPK) {
        this.alumnoAsignaturaPK = alumnoAsignaturaPK;
    }

    public Character getCursada() {
        return cursada;
    }

    public void setCursada(Character cursada) {
        this.cursada = cursada;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object object) {
        return true;
    }

    @Override
    public String toString() {
        return "practicejpa.Alumno_Asignatura[ id= ]";
    }
}
