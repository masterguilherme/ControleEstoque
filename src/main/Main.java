package main;

import view.Produto;
import controle.Menu;
import controle.ProdutoControle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {   
    public static void main(String[] args) {
        int op = 0;
        
        List<Produto> Lista_Cadastro_Produto = new ArrayList<Produto>();
        Produto produto;
        ProdutoControle controle_produto;
        Menu operacoes = new Menu();
        
        Scanner EntradaTexto = new Scanner(System.in);
        Scanner Texto_entrada = new Scanner(System.in);
        Scanner EntradaValor = new Scanner(System.in);
        Scanner Entrada_Inteiro = new Scanner(System.in);
        
        do{
            operacoes.MenuOperacoes();
            op = EntradaTexto.nextInt();
            switch(op){
                case 1:                    
                    do{
                        operacoes.menuCadastroProduto();
                        op = EntradaTexto.nextInt();
                        operacoes.Dados_Empresa();
                        switch(op){                            
                            case 1:
                                int aux;
                                String resp = "";
                                controle_produto = new ProdutoControle();
                                do{
                                    produto = new Produto();
                                    
                                    
                                    System.out.println("INCLUSÃO DE PRODUTO");
                                    do{
                                        System.out.print("NOME: ");
                                        produto.setNome(Texto_entrada.nextLine());
                                        aux = controle_produto.verificarNomeProduto(Lista_Cadastro_Produto, produto.getNome());
                                        if(aux == 1){
                                            System.out.println("PRODUTO JÁ CADASTRADO");
                                        }
                                    }while(aux != 0 );

                                    do{
                                        System.out.print("PREÇO: ");
                                        produto.setPrecoUnitario(EntradaValor.nextDouble());
                                        if(produto.getPrecoUnitario() <= 0){
                                            System.out.println("VALOR INVALIDO, INFORME VALOR MAIOR QUE ZERO");
                                        }
                                    }while(produto.getPrecoUnitario() <= 0);
                                    System.out.print("UNIDADE: ");
                                    produto.setUnidade(Texto_entrada.nextLine());
                                    do{
                                        System.out.print("QUANTIDADE: ");
                                        produto.setQtdEstoque(Entrada_Inteiro.nextInt());
                                        if(produto.getQtdEstoque() < 0){
                                            System.out.println("VALOR INVALIDO, INFORME VALOR MAIOR OU IGUAL A ZERO");
                                        }
                                    }while(produto.getQtdEstoque() < 0);

                                    System.out.println("CONFIRMA INCLUSÃO (S/N)?");
                                    resp = Texto_entrada.nextLine();
                                    if(resp.equals("S") || resp.equals("s")){
                                        System.out.println("CADASTRO CONFIRMADO");
                                        Lista_Cadastro_Produto.add(produto);
                                    }else{
                                        System.out.println("CADASTRO NÃO CONFIRMADO");
                                    }
                                    System.out.println("REPETIR OPERAÇÃO (S/N)?");
                                    resp = Texto_entrada.nextLine();
                                    if(resp.equals("S") || resp.equals("s")){
                                        aux = 1;
                                    }else{
                                        aux = 0;
                                    }
                                }while(aux != 0);
                                
                                
                            break;
                            case 2:
                                System.out.println("ALTERAÇÃO DE PRODUTO");
                                aux = 0;
                                controle_produto = new ProdutoControle();
                                do{
                                    produto = new Produto();
                                    System.out.print("INFORME O NOME DO PRODUTO PARA ALTERAR: ");
                                    produto.setNome(Texto_entrada.nextLine());
                                    aux = controle_produto.verificarNomeProduto(Lista_Cadastro_Produto, produto.getNome());
                                    if(aux == 1){
                                        int codProduto = 0;
                                        System.out.println("PRODUTO CADASTRADO");
                                        codProduto = controle_produto.exibirPorPorduto(Lista_Cadastro_Produto, produto.getNome());
                                        
                                        do{
                                            System.out.print("INFORME O NOVO PREÇO: ");
                                            produto.setPrecoUnitario(EntradaValor.nextDouble());
                                            if(produto.getPrecoUnitario() <= 0){
                                                System.out.println("VALOR INVALIDO, INFORME VALOR MAIOR QUE ZERO");
                                            }
                                        }while(produto.getPrecoUnitario() <= 0);
                                        System.out.print("INFORME A NOVA UNIDADE: ");
                                        produto.setUnidade(Texto_entrada.nextLine());
                                        do{
                                            System.out.print("INFORME A NOVA QUANTIDADE: ");
                                            produto.setQtdEstoque(Entrada_Inteiro.nextInt());
                                            if(produto.getQtdEstoque() < 0){
                                                System.out.println("VALOR INVALIDO, INFORME VALOR MAIOR QUE ZERO");
                                            }
                                        }while(produto.getQtdEstoque() < 0);
                                        System.out.println("CONFIRMA INCLUSÃO (S/N)?");
                                        resp = Texto_entrada.nextLine();
                                        if(resp.equals("S") || resp.equals("s")){
                                            System.out.println("ALTERAÇÃO CONFIRMADO");
                                            Lista_Cadastro_Produto.set(codProduto ,produto);
                                        }else{
                                            System.out.println("ALTERAÇÃO NÃO CONFIRMADO");
                                        }
                                       
                                        
                                    }else{
                                        System.out.println("PRODUTO NÃO CADASTRADO");
                                    }
                                    System.out.println("REPETIR OPERAÇÃO (S/N)?");
                                    resp = Texto_entrada.nextLine();
                                    if(resp.equals("S") || resp.equals("s")){
                                        aux = 1;
                                    }else{
                                        aux = 0;
                                    }
                                    
                                }while(aux != 0);
                            break;
                            case 3:
                                controle_produto = new ProdutoControle();
                                System.out.println("CONSULTA DE PRODUTO");
                                produto = new Produto();
                                System.out.print("INFORME O NOME DO PRODUTO PARA CONSULTA: ");
                                produto.setNome(Texto_entrada.nextLine());
                                aux = controle_produto.verificarNomeProduto(Lista_Cadastro_Produto, produto.getNome());
                                if(aux == 1){
                                    controle_produto.consultaPorPorduto(Lista_Cadastro_Produto, produto.getNome());
                                }else{
                                   System.out.println("PRODUTO NÃO CADASTRADO");
                                }
                            break;
                            case 4:
                                controle_produto = new ProdutoControle();
                                System.out.println("EXCLUSÃO DE PRODUTO");
                                produto = new Produto();
                                System.out.print("INFORME O NOME DO PRODUTO PARA EXCLUSÃO: ");
                                produto.setNome(Texto_entrada.nextLine());
                                aux = controle_produto.verificarNomeProduto(Lista_Cadastro_Produto, produto.getNome());
                                if(aux == 1){
                                    int codProduto = 0;
                                    System.out.println("PRODUTO CADASTRADO");
                                    codProduto = controle_produto.exibirPorPorduto(Lista_Cadastro_Produto, produto.getNome());
                                    System.out.println("CONFIRMA EXCLUSÃO (S/N)?");
                                    resp = Texto_entrada.nextLine();
                                    if(resp.equals("S") || resp.equals("s")){
                                       System.out.println("EXCLUSÃO CONFIRMADO");
                                       Lista_Cadastro_Produto.remove(codProduto);
                                    }else{
                                       System.out.println("EXCLUSÃO NÃO CONFIRMADO");
                                    }
                                }else{
                                   System.out.println("PRODUTO NÃO CADASTRADO");
                                }
                            break;
                            case 0:
                                System.out.println("RETORNO PARA MENU PRINCIPAL");
                            break;
                            
                            default:
                                System.out.println("\nOpção Inválida");
                            break;
                            
                        }
                        
                    }while(op != 0);
                    
                    op = 1;
                break;
                case 2:
                    int aux;
                    String resp = "";
                    do{
                        produto = new Produto();
                        operacoes.menuMovimentacaoProduto();
                        op = EntradaTexto.nextInt();
                        operacoes.Dados_Empresa();
                        switch(op){
                            case 1:
                                controle_produto = new ProdutoControle();
                                System.out.println("ENTRADA DE PRODUTO");
                                produto = new Produto();
                                System.out.print("INFORME O NOME DO PRODUTO: ");
                                produto.setNome(Texto_entrada.nextLine());
                                aux = controle_produto.verificarNomeProduto(Lista_Cadastro_Produto, produto.getNome());
                                if(aux == 1){
                                    int codProduto = 0;
                                    System.out.println("Produto Existente");
                                    codProduto = controle_produto.exibirPorPorduto(Lista_Cadastro_Produto, produto.getNome());
                                    
                                    do{
                                        System.out.print("QUANTIDADE DE ENTRADA: ");
                                        produto.setQtdEstoque(Entrada_Inteiro.nextInt());
                                        if(produto.getQtdEstoque() < 0){
                                            System.out.println("VALOR INVALIDO, INFORME VALOR MAIOR OU IGUAL A ZERO");
                                        }
                                    }while(produto.getQtdEstoque() < 0);
                                    produto.setQtdEstoque(produto.getQtdEstoque() + Lista_Cadastro_Produto.get(codProduto).getQtdEstoque());
                                    produto.setPrecoUnitario(Lista_Cadastro_Produto.get(codProduto).getPrecoUnitario());
                                    produto.setUnidade(Lista_Cadastro_Produto.get(codProduto).getUnidade());
                                    
                                    System.out.println("CONFIRMA ENTRADA (S/N)?");
                                    resp = Texto_entrada.nextLine();
                                    if(resp.equals("S") || resp.equals("s")){
                                       System.out.println("ENTRADA CONFIRMADO");
                                       Lista_Cadastro_Produto.set(codProduto, produto);
                                    }else{
                                       System.out.println("ENTRADA NÃO CONFIRMADO");
                                    }
                                }else{
                                   System.out.println("PRODUTO NÃO CADASTRADO");
                                }
                                
                            break;
                            case 2:
                                controle_produto = new ProdutoControle();
                                System.out.println("SAÍDA DE PRODUTO");
                                produto = new Produto();
                                System.out.print("INFORME O NOME DO PRODUTO: ");
                                produto.setNome(Texto_entrada.nextLine());
                                aux = controle_produto.verificarNomeProduto(Lista_Cadastro_Produto, produto.getNome());
                                if(aux == 1){
                                   int codProduto = 0;
                                   System.out.println("Produto Existente");
                                   codProduto = controle_produto.exibirPorPorduto(Lista_Cadastro_Produto, produto.getNome());                                    
                                   do{
                                       System.out.print("QUANTIDADE DE SAÍDA: ");
                                       produto.setQtdEstoque(Entrada_Inteiro.nextInt());
                                       if(produto.getQtdEstoque() <= 0 || produto.getQtdEstoque() > Lista_Cadastro_Produto.get(codProduto).getQtdEstoque()){
                                         System.out.println("VALOR INVALIDO, INFORME UM VALOR MAIOR QUE ZERO OU MENOR IGUAL A QUANTIDADE EXISTENTE");
                                       }
                                   }while(produto.getQtdEstoque() <= 0 || produto.getQtdEstoque() > Lista_Cadastro_Produto.get(codProduto).getQtdEstoque());
                                   System.out.println("CONFIRMA SAÍDA (S/N)?");
                                   resp = Texto_entrada.nextLine();
                                   if(resp.equals("S") || resp.equals("s")){
                                     System.out.println("SAÍDA CONFIRMADO");
                                     produto.setQtdEstoque(Lista_Cadastro_Produto.get(codProduto).getQtdEstoque() - produto.getQtdEstoque());
                                     produto.setPrecoUnitario(Lista_Cadastro_Produto.get(codProduto).getPrecoUnitario());
                                     produto.setUnidade(Lista_Cadastro_Produto.get(codProduto).getUnidade());
                                     Lista_Cadastro_Produto.set(codProduto, produto);
                                   }else{
                                     System.out.println("SAÍDA NÃO CONFIRMADO");
                                   }
                                   
                                   
                                }else{
                                   System.out.println("PRODUTO NÃO CADASTRADO");
                                }
                                
                            break;
                            case 0:
                                System.out.println("Retorno para Menu Principal");
                            break;
                            
                            default:
                                System.out.println("\nOpção Inválida");
                            break;
                            
                        }
                    }while(op != 0);
                    op = 2;
                break;
                case 3:
                    aux = 0;
                    resp = "";
                    double percentual = 0, novoPreco = 0;
                    do{
                        produto = new Produto();
                        operacoes.menuReajusteProduto();
                        op = EntradaTexto.nextInt();
                        operacoes.Dados_Empresa();
                        switch(op){
                            case 1:
                                controle_produto = new ProdutoControle();
                                aux = 0;
                                resp = "";
                                System.out.println("REAJUSTE DE PREÇOS");
                                System.out.println("REAJUSTE MAIOR POR PRODUTO");
                                produto = new Produto();
                                System.out.print("INFORME O NOME DO PRODUTO: ");
                                produto.setNome(Texto_entrada.nextLine());
                                aux = controle_produto.verificarNomeProduto(Lista_Cadastro_Produto, produto.getNome());
                                if(aux == 1){
                                    int codProduto = 0;
                                    System.out.println("Produto Existente");
                                    codProduto = controle_produto.exibirPorPorduto(Lista_Cadastro_Produto, produto.getNome());    
                                    do{
                                        System.out.print("INFORME O NOVO PERCENTUAL REAJUSTE DE PREÇO: ");
                                        percentual = EntradaValor.nextDouble();
                                        
                                        if(percentual <= 0){
                                            System.out.println("Valor Invalido, informe valor maior que zero");
                                        }
                                    }while(percentual <= 0);  
                                    novoPreco = ((Lista_Cadastro_Produto.get(codProduto).getPrecoUnitario() /100 ) * percentual ) + Lista_Cadastro_Produto.get(codProduto).getPrecoUnitario();
                                    produto.setPrecoUnitario(novoPreco);
                                    produto.setQtdEstoque(Lista_Cadastro_Produto.get(codProduto).getQtdEstoque());
                                    produto.setUnidade(Lista_Cadastro_Produto.get(codProduto).getUnidade());

                                    System.out.println("CONFIRMA REAJUSTE (S/N)?");
                                    resp = Texto_entrada.nextLine();
                                    if(resp.equals("S") || resp.equals("s")){
                                        System.out.println("REAJUSTE CONFIRMADO");
                                        Lista_Cadastro_Produto.set(codProduto, produto);
                                    }else{
                                        System.out.println("REAJUSTE NÃO CONFIRMADO");
                                    }

                                }else{
                                    System.out.println("PRODUTO NÃO CADASTRADO");
                                }
                                
                            break;
                            case 2:
                                controle_produto = new ProdutoControle();
                                aux = 0;
                                resp = "";
                                System.out.println("REAJUSTE DE PREÇOS");
                                System.out.println("REAJUSTE MENOR POR PRODUTO");
                                produto = new Produto();
                                System.out.print("INFORME O NOME DO PRODUTO: ");
                                produto.setNome(Texto_entrada.nextLine());
                                aux = controle_produto.verificarNomeProduto(Lista_Cadastro_Produto, produto.getNome());
                                if(aux == 1){
                                    int codProduto = 0;
                                    System.out.println("Produto Existente");
                                    codProduto = controle_produto.exibirPorPorduto(Lista_Cadastro_Produto, produto.getNome());    
                                    do{
                                        System.out.print("INFORME O NOVO PERCENTUAL REAJUSTE DE PREÇO: ");
                                        percentual = EntradaValor.nextDouble();
                                        
                                        if(percentual <= 0){
                                            System.out.println("Valor Invalido, informe valor maior que zero");
                                        }
                                    }while(percentual <= 0);  
                                    novoPreco = Lista_Cadastro_Produto.get(codProduto).getPrecoUnitario() - ((Lista_Cadastro_Produto.get(codProduto).getPrecoUnitario() /100 ) * percentual );
                                    produto.setPrecoUnitario(novoPreco);
                                    produto.setQtdEstoque(Lista_Cadastro_Produto.get(codProduto).getQtdEstoque());
                                    produto.setUnidade(Lista_Cadastro_Produto.get(codProduto).getUnidade());

                                    System.out.println("CONFIRMA REAJUSTE (S/N)?");
                                    resp = Texto_entrada.nextLine();
                                    if(resp.equals("S") || resp.equals("s")){
                                        System.out.println("REAJUSTE CONFIRMADO");
                                        Lista_Cadastro_Produto.set(codProduto, produto);
                                    }else{
                                        System.out.println("REAJUSTE NÃO CONFIRMADO");
                                    }

                                }else{
                                    System.out.println("PRODUTO NÃO CADASTRADO");
                                }
                                
                            break;
                            case 3:
                                controle_produto = new ProdutoControle();
                                System.out.println("REAJUSTE DE PREÇOS");
                                System.out.println("REAJUSTE MAIOR TODOS PRODUTOS");
                                do{
                                    System.out.print("INFORME O NOVO PERCENTUAL REAJUSTE DE PREÇO: ");
                                    percentual = EntradaValor.nextDouble();
                                        
                                    if(percentual <= 0){
                                       System.out.println("Valor Invalido, informe valor maior que zero");
                                    }
                                }while(percentual <= 0);
                                System.out.println("CONFIRMA REAJUSTE (S/N)?");
                                resp = Texto_entrada.nextLine();
                                if(resp.equals("S") || resp.equals("s")){
                                    System.out.println("REAJUSTE CONFIRMADO");
                                    Lista_Cadastro_Produto = controle_produto.reajusteMaiorLoteProduto(Lista_Cadastro_Produto, percentual);
                                }else{
                                    System.out.println("REAJUSTE NÃO CONFIRMADO");
                                }
                                
                                
                            break;
                            case 4:
                                controle_produto = new ProdutoControle();
                                System.out.println("REAJUSTE DE PREÇOS");
                                System.out.println("REAJUSTE MENOR TODOS PRODUTOS");
                                do{
                                    System.out.print("INFORME O NOVO PERCENTUAL REAJUSTE DE PREÇO: ");
                                    percentual = EntradaValor.nextDouble();
                                        
                                    if(percentual <= 0){
                                       System.out.println("Valor Invalido, informe valor maior que zero");
                                    }
                                }while(percentual <= 0);
                                System.out.println("CONFIRMA REAJUSTE (S/N)?");
                                resp = Texto_entrada.nextLine();
                                if(resp.equals("S") || resp.equals("s")){
                                    System.out.println("REAJUSTE CONFIRMADO");
                                    Lista_Cadastro_Produto = controle_produto.reajusteMenorLoteProduto(Lista_Cadastro_Produto, percentual);
                                }else{
                                    System.out.println("REAJUSTE NÃO CONFIRMADO");
                                }
                                
                                
                            break;
                            case 0:
                                System.out.println("Retorno para Menu Principal");
                            break;
                            
                            default:
                                System.out.println("\nOpção Inválida");
                            break;
                            
                        }
                        
                    }while(op != 0);
                    op = 3;
                    
                break;                
                case 4:
                    controle_produto = new ProdutoControle();
                    System.out.println("RELATÓRIOS");
                    if(Lista_Cadastro_Produto.size()> 0){
                        controle_produto.relatorio(Lista_Cadastro_Produto);
                    }else{
                        System.out.println("NÃO EXISTE PRODUTOS CADASTRADO");
                    }
                break;
                case 0:
                    System.out.println("Fim");
                break;
                
                default:
                    System.out.println("\nOpção Inválida");
                break;
            }
            
        }while(op != 0);
    
    }
    
    
    
    
}
