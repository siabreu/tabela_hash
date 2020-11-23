package hashgenerics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Siabreu
 */
public class HashTable<T> {
    private List< List<T> > tabela = new ArrayList<>();
    private int tam;

    public HashTable(int tam) {
        this.tam = tam;
        initHash();
    }

    private void initHash() {
        for (int i = 0; i < tam; i++) {
            LinkedList<T> lista = new LinkedList<>();
            tabela.add(lista);
        }
    }

    public int getTam() {
        return tam;
    }

    public int funcaoHashing(T objeto) {        
        return (Math.abs(objeto.hashCode()) % tam);
    }

    public void inserir(T objeto) {
        if (!contem(objeto)) {            
            int indice = funcaoHashing(objeto);
            List<T> lista = tabela.get(indice);
            lista.add(objeto);            
        }
    }

    public void remover(T objeto) {
        if (contem(objeto)) {
            int indice = funcaoHashing(objeto);
            List<T> lista = tabela.get(indice);
            lista.remove(objeto);
        }
    }

    public boolean contem(T objeto) {
        int indice = funcaoHashing(objeto);
        List<T> lista = this.tabela.get(indice);

        return lista.contains(objeto);
    }

    public List<T> getListas() {
        List<T> objetos = new ArrayList<>();

        for (int i = 0; i < tabela.size(); i++) {
            objetos.addAll(tabela.get(i));
        }

        return objetos;
    }

    public void mostrarHash() {        
        for (List<T> lista : tabela) {
            System.out.print("=> [ ");
            for (int i = 0; i < lista.size(); i++) {
                System.out.print(lista.get(i) + "  ");
            }
            System.out.println("]");
        }
    }  
}
