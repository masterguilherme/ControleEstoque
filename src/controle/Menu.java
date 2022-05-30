package controle;

public class Menu {
    public static void MenuOperacoes(){        
        Dados_Empresa();
        System.out.println("____________________________________________________");
        System.out.print("MENU PRINCIPAL\n1 - CADASTRO DE PRODUTOS\n2 - MOVIMENTAÇÃO\n3 - REAJUSTE DE PREÇOS\n4 - RELATÓRIOS\n0 - FINALIZAR\nOPÇÃO: ");
        
    }
    public static void menuCadastroProduto(){
        Dados_Empresa();
        System.out.println("____________________________________________________");
        System.out.print("CADASTRO DE PRODUTOS\n1 - INCLUSÃO\n2 - ALTERAÇÃO\n3 - CONSULTA\n4 - EXCLUSÃO\n0 - RETORNAR\nOPÇÃO: ");
       
    }
    public static void menuMovimentacaoProduto(){
        Dados_Empresa();
        System.out.println("____________________________________________________");
        System.out.print("MOVIMENTAÇÃO\n1 - ENTRADA\n2 - SAIDA\n0 - RETORNAR\nOPÇÃO: ");
        
    }
    public static void Dados_Empresa(){
        System.out.println("____________________________________________________");
        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
        System.out.println("SISTEMA DE CONTROLE DE ESTOQUE");
        System.out.println("____________________________________________________");
    }
    public static void menuReajusteProduto(){
        Dados_Empresa();
        System.out.println("____________________________________________________");
        System.out.print("MOVIMENTAÇÃO\n1 - REAJUSTE MAIOR POR PRODUTO\n2 - REAJUSTE MENOR POR PRODUTO\n3 - REAJUSTE MAIOR TODOS PRODUTO\n4 - REAJUSTE MENOR TODOS PRODUTO\n0 - RETORNAR\nOPÇÃO: ");
        
    }
}
