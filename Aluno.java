package SistemaMatricula;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno {
    private int numeroMatricula;
    private String nome;
    private LocalDate dataNascimento;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Aluno(int numeroMatricula, String nome, LocalDate dataNascimento) {
        this.numeroMatricula = numeroMatricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getDataNascimentoFormatada() {
        return dataNascimento.format(formatter);
    }
}
