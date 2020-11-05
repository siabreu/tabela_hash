package encadeamentoseparado;

/**
 *
 * @author Siabreu
 */
public class HashTable { 
    private Hash tabela[];
    private int tam;
    
    public HashTable(){}
    public HashTable(int tam){
        this.tam = tam;
        tabela = new Hash[tam];        
    }
    
    public void inserir(int pos, int n){
        Hash novo = new Hash();
        novo.chave = n;
        novo.prox = tabela[pos];
        tabela[pos] = novo;        
    }
    
    public void remover(int n){
        int pos = funcaoHashing(n);
        Hash aux;
        
        if(tabela[pos] != null){
            if(tabela[pos].chave == n)
                tabela[pos] = tabela[pos].prox;
            else{
                aux = tabela[pos].prox;
                Hash ant = tabela[pos];
                while(aux != null && aux.chave != n){
                    ant = aux;
                    aux = aux.prox;
                }
                if(aux != null)
                    ant.prox = aux.prox;
                else
                    System.out.println("Número não encontrado!");
            }
        }else
            System.out.println("Número não encontrado!");
    }
           
    public int funcaoHashing(int num){
        return num % tam;
    }
    
    public void mostrarHash(){
        Hash aux;
        
        for(int i = 0; i < tam; i++){
            StringBuilder saida = new StringBuilder();
            aux = tabela[i];
            saida.append("lista ").append(i).append(": ");
            while(aux != null){               
                saida.append(aux.chave);
                if(aux.prox != null)
                    saida.append(", ");
                aux = aux.prox;
            }  
            System.out.println(saida);
        }
    }    
}
