package SistemaMatricula;
import java.time.LocalDate;
import java.time.Period;

public class Matricula {
    private Aluno aluno;
    private Curso curso;
    private LocalDate dataMatricula;

    public Matricula(Aluno aluno, Curso curso, LocalDate dataMatricula) {
        this.aluno = aluno;
        this.curso = curso;
        this.dataMatricula = dataMatricula;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public int calcularIdade() {
        LocalDate dataAtual = LocalDate.now();
        return Period.between(aluno.getDataNascimento(), dataAtual).getYears();
    }

    public boolean verificarIdadeMinima() {
        int idade = calcularIdade();
        return idade >= 18;
    }
}

