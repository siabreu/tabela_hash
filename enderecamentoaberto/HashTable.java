package enderecamentoaberto;

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
        initHash();
    }
    
    private void initHash(){
        for(int i = 0; i < tam; i++){
            tabela[i] = new Hash();
            tabela[i].status = StatusHash.LIVRE;
        }
    }
     
    public void inserir(int pos, int n){
        int i = 0;

        while(i < tam && tabela[(pos+i)%tam].status == StatusHash.OCUPADO)
            i++;    
        if(i < tam){
            tabela[(pos+i)%tam].chave = n;
            tabela[(pos+i)%tam].status = StatusHash.OCUPADO;
        }else
            System.out.println("Tabela cheia!");        
    }
    
    public void remover(int n){
        int posicao = buscar(n);
        if(posicao < tam)
            tabela[posicao].status = StatusHash.REMOVIDO;
        else
            System.out.println("Elemento não encontrado!");
    }
    
    public int buscar(int n){
        int i = 0;
        int pos = funcaoHashing(n);
        
        while(i < tam && tabela[(pos+i)%tam].status != StatusHash.LIVRE 
                      && tabela[(pos+i)%tam].chave != n)
            i++;
       if(tabela[(pos+i)%tam].chave == n && 
          tabela[(pos+i)%tam].status != StatusHash.REMOVIDO)
           return (pos+i)%tam;
       else
           return tam; //nao encontrado
    }
    
    public int funcaoHashing(int num){
        return num % tam;
    }
    
    public void mostrarHash(){
        for(int i = 0; i < tam; i++){
            if(tabela[i].status == StatusHash.OCUPADO)
                System.out.println("Entrada: " + i + ": "
                +tabela[i].chave);
        }
    }    
}
