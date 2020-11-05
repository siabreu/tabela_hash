package encadeamentoseparadoarraylist;
/**
 *
 * @author Siabreu
 */
public class Hash{
    private int chave; 

    public Hash(){}
    public Hash(int chave){
        this.chave = chave;
    }
    
    public void setChave(int chave){
        this.chave = chave;
    }
    
    public int getChave(){
        return chave;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Hash){
            Hash h = (Hash) obj;
            return this.chave == h.chave;
        }else
            return false;
    }    
}
