package hashgenerics;

import java.util.List;
/**
 *
 * @author Siabreu
 */
public class AppTeste {
    public static void main(String[] args) {
        HashTable<Pessoa> hashTable = new HashTable<>(10);
        
        hashTable.inserir(new Pessoa("Ana", 1234));
        hashTable.inserir(new Pessoa("Paulo", 4567));
        hashTable.inserir(new Pessoa("Maria", 7890));
        hashTable.inserir(new Pessoa("William", 8754));
        hashTable.inserir(new Pessoa("Victoria", 3265));
        
        List<Pessoa> pessoas = hashTable.getListas();                
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
        
        Pessoa p = new Pessoa("", 1234);                
        System.out.println("Cpf: " + p.getCpf() + " " 
                + pessoas.contains(p));
                
        hashTable.mostrarHash();  
        
        System.out.println("===== após remover ====");
        hashTable.remover(p);
        hashTable.mostrarHash();  
    }
}
