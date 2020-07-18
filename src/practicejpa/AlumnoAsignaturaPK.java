package practicejpa;

import javax.persistence.Embeddable;

@Embeddable // Clase que va a tomar la llave compuesta @EmbeddableId
public class AlumnoAsignaturaPK {
    private int id_alumno;
    private int id_asignatura;

    public AlumnoAsignaturaPK() {
    }

    public AlumnoAsignaturaPK(int id_alumno, int id_asignatura) {
        this.id_alumno = id_alumno;
        this.id_asignatura = id_asignatura;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }
    
    
}
