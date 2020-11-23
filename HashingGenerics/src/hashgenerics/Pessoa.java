package hashgenerics;
/**
 *
 * @author Siabreu
 */
public class Pessoa {
    private String nome;
    private int cpf;

    public Pessoa() {}

    public Pessoa(String nome, int cfp) {
        this.nome = nome;
        this.cpf = cfp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Pessoa){
            Pessoa p = (Pessoa)obj;
            return this.cpf == p.getCpf();
        }else
            return false;        
    }

    @Override
    public int hashCode() {
        return this.cpf;
    }   

    @Override
    public String toString() {
        return nome + ", " + cpf;
    }    
}
