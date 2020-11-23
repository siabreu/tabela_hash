/**
 *
 * @author Siabreu
 */
public class Palavra {
    private String palavra;
    private int frequencia;

    public Palavra() {}

    public Palavra(String palavra) {
        this.palavra = palavra;
        this.frequencia = 1;        
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int getOcorrencias() {
        return frequencia;
    }

    public void setOcorrencias(int ocorrencias) {
        this.frequencia = ocorrencias;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Palavra){
            Palavra p = (Palavra)obj;
            return this.palavra.equalsIgnoreCase(p.getPalavra());            
        }else
            return false;        
    }

    @Override
    public int hashCode() {
        return Character.toLowerCase(this.palavra.charAt(0));        
    }   

    @Override
    public String toString() {
        return palavra + " f(" + frequencia + ")";
    }    
}
