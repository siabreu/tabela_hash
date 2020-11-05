package encadeamentoseparado;

import java.util.Scanner;

/**
 *
 * @author Siabreu
 */
public class AppHashTableEncadeamentoSeparado {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int op, pos, num;
        
        HashTable hashTable = new HashTable(10);
       
        do{
            System.out.println("\nMENU DE OPÇÕES\n");
            System.out.println("1 - Inserir elemento"
                    + "\n2 - Mostrar tabela Hashing"
                    + "\n3 - Excluir elemento"
                    + "\n4 - Sair"
                    + "\nDigite sua opção: ");
            op = in.nextInt();
            switch(op){
                case 1:
                    System.out.println("Digite um número: ");
                    num = in.nextInt();
                    pos = hashTable.funcaoHashing(num);
                    hashTable.inserir(pos, num);
                    break;
                case 2:
                    hashTable.mostrarHash();
                    break;
                case 3:
                    System.out.println("Digite um número: ");
                    num = in.nextInt();
                    hashTable.remover(num);
                    break;
                case 4:
                    System.out.println("Fim....");
                    break;
            }
        }while(op != 4);
    }
}
