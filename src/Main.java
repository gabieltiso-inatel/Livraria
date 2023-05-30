import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arquivo arquivo = new Arquivo("livros.txt");

        promptMenu();
        int op = sc.nextInt();
        while(op != 5) {
            sc.nextLine();
            switch(op) {
                case 1:
                    System.out.print("Nome do livro: ");
                    String nome = sc.nextLine();
                    System.out.print("Autor do livro: ");
                    String autor = sc.nextLine();
                    System.out.print("Editora do livro: ");
                    String editora = sc.nextLine();
                    System.out.print("Número de páginas do livro: ");
                    int qtdPaginas = sc.nextInt();

                    try {
                        Livro novoLivro = new Livro(nome, autor, editora, qtdPaginas);
                        arquivo.escrever(novoLivro);
                    } catch(InfoInvalidaException e) {
                        System.out.println("Houve um erro ao criar um novo livro:\n");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    ArrayList<Livro> livrosAux = arquivo.ler();
                    for(Livro l : livrosAux) {
                        l.mostraInfo();
                    }
                    break;
                case 3:
                    livrosAux = arquivo.ler();
                    Collections.sort(livrosAux);

                    System.out.println("Livros em ordem crescente:");
                    for(Livro l : livrosAux) {
                        l.mostraInfo();
                    }

                    break;
                case 4:
                    livrosAux = arquivo.ler();
                    Collections.sort(livrosAux, Comparator.reverseOrder());

                    System.out.println("Livros em ordem decrescente:");
                    for(Livro l : livrosAux) {
                        l.mostraInfo();
                    }

                    break;
                default:
                    System.out.println("Esse número não está relacionado a nehuma operação!");
                    break;
            }

            promptMenu();
            op = sc.nextInt();
        }

        sc.close();
    }

    public static void promptMenu() {
        System.out.printf("Digite um número de operação:\n");
        System.out.printf("1 - Salvar novo livro\n"); 
        System.out.printf("2 - Mostrar livros\n"); 
        System.out.printf("3 - Ordenar os livros de forma crescente\n"); 
        System.out.printf("4 - Ordenar os livros de forma decrescente\n"); 
        System.out.printf("5 - Sair\n"); 
    }
}
