package SistemaMatricula;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Aluno> alunos = new ArrayList<>();
            ArrayList<Curso> cursos = new ArrayList<>();
            ArrayList<Matricula> matriculas = new ArrayList<>();

            while (true) {
                System.out.println("1. Cadastrar Aluno");
                System.out.println("2. Cadastrar Curso");
                System.out.println("3. Realizar Matrícula");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        System.out.print("Número de Matrícula do Aluno: ");
                        int numeroMatricula = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome do Aluno: ");
                        String nomeAluno = scanner.nextLine();

                        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
                        String dataNascimentoStr = scanner.nextLine();
                        LocalDate dataNascimentoAluno = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                        Aluno aluno = new Aluno(numeroMatricula, nomeAluno, dataNascimentoAluno);
                        alunos.add(aluno);
                        break;

                    case 2:
                        System.out.print("Código do Curso: ");
                        int codigoCurso = scanner.nextInt();
                        scanner.nextLine(); 

                        System.out.print("Nome do Curso: ");
                        String nomeCurso = scanner.nextLine();

                        System.out.print("Data de Início do Curso (dd/MM/yyyy): ");
                        String dataInicioStr = scanner.nextLine();
                        LocalDate dataInicioCurso = LocalDate.parse(dataInicioStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                        Curso curso = new Curso(codigoCurso, nomeCurso, dataInicioCurso);
                        cursos.add(curso);
                        break;

                    case 3:
                        System.out.println("Lista de Alunos:");
                        for (Aluno a : alunos) {
                            System.out.println(a.getNumeroMatricula() + " - " + a.getNome());
                        }
                        System.out.print("Escolha o número de matrícula do aluno: ");
                        int matriculaAluno = scanner.nextInt();

                        System.out.println("Lista de Cursos:");
                        for (Curso c : cursos) {
                            System.out.println(c.getCodigoCurso() + " - " + c.getNomeCurso());
                        }
                        System.out.print("Escolha o código do curso: ");
                        int codigoCursoMatricula = scanner.nextInt();

                        Aluno alunoSelecionado = null;
                        Curso cursoSelecionado = null;

                        for (Aluno a : alunos) {
                            if (a.getNumeroMatricula() == matriculaAluno) {
                                alunoSelecionado = a;
                                break;
                            }
                        }

                        for (Curso c : cursos) {
                            if (c.getCodigoCurso() == codigoCursoMatricula) {
                                cursoSelecionado = c;
                                break;
                            }
                        }

                        if (alunoSelecionado == null || cursoSelecionado == null) {
                            System.out.println("Aluno ou Curso não encontrado.");
                            break;
                        }

                        Matricula novaMatricula = new Matricula(alunoSelecionado, cursoSelecionado, LocalDate.now());
                        if (!novaMatricula.verificarIdadeMinima()) {
                            System.out.println("O aluno deve ter 18 anos ou mais para ser matriculado.");
                            break;
                        }

                        matriculas.add(novaMatricula);
                        System.out.println("Matrícula realizada com sucesso!");
                        break;

                    case 4:
                        System.out.println("Encerrando o programa...");
                        return;

                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }
            }
        }
    }
}

