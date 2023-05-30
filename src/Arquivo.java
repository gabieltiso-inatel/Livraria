import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {
    private String nomeArquivo;
    private FileWriter fileWriter;
    private BufferedWriter writer;
    private FileReader fileReader;
    private BufferedReader reader;
    private static final String headerLivro = ">>> Livro <<<";

    public Arquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void escrever(Livro livro) {
        try {
            fileWriter = new FileWriter(nomeArquivo, true);
            writer = new BufferedWriter(fileWriter);
            
            writer.write(headerLivro + "\n");
            writer.write(livro.getNome() + "\n");
            writer.write(livro.getAutor() + "\n");
            writer.write(livro.getEditora() + "\n");
            writer.write(livro.getQtdPaginas() + "\n");
        } catch (IOException e) {
            System.out.println("Houve um erro durante a escrita no arquivo:\n");
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Houve um erro ao fechar o BufferedWriter:\n");
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Livro> ler() {
        ArrayList<Livro> livros = new ArrayList<>();
        try {
            fileReader = new FileReader(nomeArquivo);
            reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            while(line != null) {
                if(line.contains(headerLivro)) {
                    Livro livroAux = new Livro();
                    livroAux.setNome(reader.readLine());
                    livroAux.setAutor(reader.readLine());
                    livroAux.setEditora(reader.readLine());
                    livroAux.setQtdPaginas(Integer.parseInt(reader.readLine()));

                    livros.add(livroAux);
                }

                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Houve um erro durante a leitura do arquivo:\n");
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Houve um erro ao fechar o BufferedReader:\n");
                e.printStackTrace();
            }
        }
        return livros;
    }
}
