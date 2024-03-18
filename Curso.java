package SistemaMatricula;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Curso {
    private int codigoCurso;
    private String nomeCurso;
    private LocalDate dataInicio;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Curso(int codigoCurso, String nomeCurso, LocalDate dataInicio) {
        this.codigoCurso = codigoCurso;
        this.nomeCurso = nomeCurso;
        this.dataInicio = dataInicio;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public String getDataInicioFormatada() {
        return dataInicio.format(formatter);
    }
}
