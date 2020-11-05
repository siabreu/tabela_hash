package encadeamentoseparadoarraylist;

import java.util.ArrayList;
/**
 *
 * @author Siabreu
 */
public class HashTable { 
    private ArrayList<Hash> tabela[];
    private int tam;
    
    public HashTable(){}
    public HashTable(int tam){
        this.tam = tam;
        tabela = new ArrayList[tam];
        initHash();
    }
    
    private void initHash(){
        for (int i = 0; i < tam; i++) {
            tabela[i] = new ArrayList<>();
        }
    }
    
    public void inserir(int pos, int n){
        Hash hash = new Hash();
        hash.setChave(n);
        tabela[pos].add(hash);        
    }
    
    public void remover(int n){
        int pos = funcaoHashing(n);
        ArrayList<Hash> lista = tabela[pos];
        Hash obj = new Hash(n);
        if(lista.contains(obj))
            lista.remove(obj);
        else
            System.out.println("Número não encontrado!");
    }
           
    public int funcaoHashing(int num){
        return num % tam;
    }
            
    public void mostrarHash(){                   
        for(int i = 0; i < tam; i++){            
            StringBuilder saida = new StringBuilder();
            saida.append("lista ").append(i).append(": ");
            
            ArrayList<Hash> lista = tabela[i];
            for (Hash hash : lista){                                 
                saida.append(hash.getChave()).append(" ");                
            }
            System.out.println(saida);
        }
    }    
}
