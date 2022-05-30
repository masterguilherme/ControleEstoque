package controle;


import view.Produto;
import java.util.List;

public class ProdutoControle {
    public static int verificarNomeProduto(List<Produto> p, String nome){
        int aux = 0;
        for (int i = 0; i < p.size(); i++) {
            if(p.get(i).getNome().equals(nome)){
                aux = 1;
                break;
            }
        }
        return aux;
    }
    public static int exibirPorPorduto(List<Produto> p, String nome){
        Relatorio r;
        int aux = 0;
        System.out.println("____________________________________________________");
         System.out.println("PRODUTO");
        for (int i = 0; i < p.size(); i++) {
            r = new Relatorio(p.get(i));
            if(p.get(i).getNome().equals(nome)){
                System.out.println(r.imprimir());
                aux = i;
                break;
            }
        }
        System.out.println("____________________________________________________");
        return aux;
    }
    public static void consultaPorPorduto(List<Produto> p, String nome){
        Relatorio r;
        System.out.println("____________________________________________________");
        System.out.println("PRODUTO");
        for (int i = 0; i < p.size(); i++) {
             r = new Relatorio(p.get(i));
            if(p.get(i).getNome().equals(nome)){
                System.out.println(r.imprimir());               
                break;
            }
        }
        System.out.println("____________________________________________________");
    }
    public static void relatorio(List<Produto> p){
        Relatorio r;
        System.out.println("____________________________________________________");
        System.out.println("Relatórios dos Produto");
        for (int i = 0; i < p.size(); i++) {
            r = new Relatorio(p.get(i));
            System.out.println("____________________________________________________");
            System.out.println(r.relatorio());
            
        }
        
    }
    public static List reajusteMaiorLoteProduto(List<Produto> p, Double percentual){
        Relatorio r;
        double novoPreco = 0;
        for (int i = 0; i < p.size(); i++) {
             novoPreco = ((p.get(i).getPrecoUnitario() /100 ) * percentual ) + p.get(i).getPrecoUnitario();
             p.get(i).setPrecoUnitario(novoPreco);
        }
        return p;
        
    }
    public static List reajusteMenorLoteProduto(List<Produto> p, Double percentual){
        Relatorio r;
        double novoPreco = 0;
        for (int i = 0; i < p.size(); i++) {
             novoPreco = p.get(i).getPrecoUnitario() - ((p.get(i).getPrecoUnitario() /100 ) * percentual ) ;
             p.get(i).setPrecoUnitario(novoPreco);
        }
        return p;
        
    }
    
}
