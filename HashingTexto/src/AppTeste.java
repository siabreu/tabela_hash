
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;

/**
 *
 * @author Siabreu
 */
public class AppTeste {
    public static void main(String[] args) {
        HashTable<Palavra> hashTable = new HashTable<>(26);
        final String caminho = "src/resource/arquivinho.txt";
        String[] arquivo = lerArquivo(caminho);
        if (arquivo != null) {
            for (String palavra : arquivo) {
                System.out.println(palavra);
                
                Palavra objPalavra = new Palavra(palavra);
                
                hashTable.inserir(objPalavra);                
            }
            System.out.println("=======================================");
            System.out.println("|        PALAVRAS E FREQUENCIA        |");
            System.out.println("=======================================");
            hashTable.mostrarHash();
        }
    }

    public static String[] lerArquivo(String caminho) {
        try {                       
            FileInputStream arquivo = new FileInputStream(caminho);
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader br = new BufferedReader(input);

            String linha;
            StringBuilder linhas = new StringBuilder();

            do {
                linha = br.readLine();
                if (linha != null) {
                    linha = Normalizer.normalize(linha, Normalizer.Form.NFD);
                    linha = linha.replaceAll("[^\\p{ASCII}]", "");                    
                    linha = linha.replaceAll("[()'`~^.,!?]", "");                    
                    System.out.println(linha);
                    linhas.append(linha).append(" ");                   
                }                
            } while(linha != null);
            linha = linhas.toString();
            
            String palavras[] = linha.split(" ");                    
            return palavras;   
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
