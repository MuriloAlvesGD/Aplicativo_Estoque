package comercio;

import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {

    //OBJETOS GERAIS USADAS NA CLASSE METODOS
    static ArrayList<produto> produtos = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static int codigoProduto = 0;
    static int cod = 0;
    static int estoque = 0;


    public static boolean consultarLista() { //Retorna valor booleano para IFs

        if (produtos.size() == 0) {
            System.out.println("OPÁ, PARECE QUE NÃO TEMOS PRODUTOS CADASTRADOS");
            return false;
        } else {
            return true;
        }
    }


    public static void listarProdutos() {

        if (consultarLista()) { //usado o metodo de consulta para valor booleano
            int N = 0;
            for (produto i : produtos) {
                //if (produtos.indexOf(i) != 0) {
                    N++;
                    System.out.printf("%d) NOME: %s | cód.: %d | estoque: %d \n", N, i.nome, i.cod, i.estoque);
                //}
            }
        }
    }


    public static String adicionarProduto(String nome, int opcaoEstoque) {

        int cadastro = 0;
        codigoProduto += 1; //AUTO INCREMENT DO CODIGO DE PRODUTO
        if (opcaoEstoque == 1) { //usuario quer adicionar estoque

            System.out.println("\nQUAL O ESTOQUE DO PRODUTO?");
            estoque = Integer.parseInt(scan.nextLine());

            boolean confirmacao_estoque = true;
            while (confirmacao_estoque) {


                System.out.printf("\nPRODUTO: %s \nESTOQUE: %d", nome, estoque);
                System.out.println("\nESTÁ CORRETO? \n1)SIM | 2)NÃO | 3)EXIT");

                //CONFIRMACAO COM TRATAMENTO TRY
                try {
                    cadastro = Integer.parseInt(scan.nextLine());


                    if (cadastro == 1) {

                        //ADICIONANDO ESTOQUE
                        produto produto = new produto(nome, codigoProduto, estoque);
                        produtos.add(produto);
                        confirmacao_estoque = false;


                    } else if (cadastro == 2) {
                        System.out.println("POR FAVOR ADICIONE NOVAMENTE");


                    } else if (cadastro == 3) { //NAO ADICIONA PRODUTO A LISTA E VOLTA PARA O MENU PRINCIPAL
                        codigoProduto -= 1;
                        System.out.println("VOLTANDO PARA O MENU");
                        confirmacao_estoque = false;


                    } else {
                        System.out.println("NÃO EXISTE ESSA OPÇÃO");
                    }


                } catch (Exception e) {
                    System.out.println("INSIRA UM VALOR INTEIRO");
                }
            }

        } else { //USUARIO NAO QUER ADICIONAR ESTOQUE
            produto produto = new produto(nome, codigoProduto, 0);
            produtos.add(produto);
        }


        //RETORNOS
        if (cadastro != 3) {
            return ("PRODUTO ADICIONADO COM SUCESSO");
        }
        return (" "); // USUARIO DEU "EXIT"
    }


    public static void modificarEstoque(String alteracao) {
        int verificacao = 0;
        if (consultarLista()) {
            System.out.printf("QUAL O CÓDIGO DO PRODUTO QUE DESEJA %s O ESTOQUE?", alteracao);

            boolean confirmacao = true;
            while (confirmacao) {


                try {
                    cod = Integer.parseInt(scan.nextLine());


                    for (produto i : produtos) {
                        verificacao++; //CONTADOR PARA CASO NOTIFICAR CASO A LISTA NAO TENHA PRODUTO COM O CODIGO

                        if (cod == i.cod) { //ENCONTROU ENTRE OS PRODUTOS UM CODIGO COMPATIVEL
                            verificacao -= 1;

                            if (alteracao == "DIMINUIR" && i.estoque == 0) { //VERIFICA SE O PRODUTO TEM ESTOQUE
                                System.out.println("ENCONTREI O PRODUTO MAS ELE ESTÁ SEM ESTOQUE");
                                System.out.println("\n    TENTE VENDER UM OUTRO PRODUTO ;)");
                                confirmacao = false;
                                break;
                            }

                            System.out.printf("NOME: %s | CÓD.: %d | ESTOQUE: %d", i.nome, i.cod, i.estoque);
                            System.out.printf("\nQUANTAS UNIDADES DESEJA %s NO ESTOQUE?", alteracao);
                            estoque = Integer.parseInt(scan.nextLine());


                            if (alteracao == "AUMENTAR") { //AUMENTA O ESTOQUE
                                i.aumentar_estoque(estoque);
                                confirmacao = false;
                                System.out.println("PRODUTO FOI ACRESCENTADO AO ESTOQUE");
                            } else if (alteracao == "DIMINUIR") { //REDUZ O ESTOQUE

                                if (i.estoque - estoque < 0) { //USUARIO TENTA VENDAR MAIS DO QUE TEM EM ESTOQUE, RETORNA AO MENU PRINCIPAL
                                    int diferencaVenda = (i.estoque - estoque) * (-1);
                                    System.out.printf("VOCÊ ESTÁ TENTANDO VENDER %s UNIDADE(S) ACIMA DO QUE TEM EM ESTOQUE", diferencaVenda);
                                    confirmacao = false;
                                } else { //VENDA CONDIZ COM O ESTOQUE
                                    i.diminuir_estoque(estoque);
                                    confirmacao = false;
                                    System.out.println("PRODUTO FOI REDUZIDO DO ESTOQUE");
                                }
                            }


                        } else if (verificacao == produtos.size()) { //MENSAGEM DO CONTADOR
                            System.out.println("PRODUTO NÃO ENCONTRADO");
                            confirmacao = false;
                        }
                    }

                } catch (Exception e) {
                    System.out.println("INSIRA UM VALOR VÁLIDO");
                }
            }
        }
    }


    public static void removerProduto() {

        int verificacao = 0;
        if (consultarLista()) {
            System.out.println("QUAL O CÓDIGO DO PRODUTO QUE DESEJA REMOVER?");


            boolean confirmacao = true;
            while (confirmacao) {
                try {
                    cod = Integer.parseInt(scan.nextLine());
                } catch (Exception e) {
                    System.out.println("INSIRA UM VALOR VÁLIDO");
                }

                for (int i = 0; i<produtos.size(); i++) {
                    verificacao++;

                    if (cod == produtos.get(i).cod) {
                        verificacao -= 1;


                        if (produtos.get(i).estoque > 0) {
                            System.out.println("AVISO: AINDA CONSTA QUE O PRODUTO ESTÁ EM ESTOQUE");
                        }


                        System.out.printf("\nNOME: %s | CÓD.: %d | ESTOQUE: %d", produtos.get(i).nome, produtos.get(i).cod, produtos.get(i).estoque);
                        System.out.println("\nDESEJA REALMENTE DELETAR O PRODUTO?");
                        System.out.println("1) SIM | 2) NÃO | 3) EXIT");

                        while (confirmacao) {
                            int excluir = Integer.parseInt(scan.nextLine());

                            if (excluir==1) {
                                produtos.remove(i);
                                confirmacao = false;
                                System.out.println("PRODUTO FOI REMOVIDO DA LISTA");
                            }

                            else if (excluir==2) {
                                confirmacao = false;
                                System.out.println("PRODUTO NÃO FOI REMOVIDO DA LISTA");
                            }

                            else if (excluir==3) {
                                confirmacao = false;
                            }

                            else{
                                System.out.println("OPCAO INVÁLIDA");
                            }
                        }
                    }

                    else if (verificacao == produtos.size()) {
                        System.out.println("PRODUTO NÃO ENCONTRADO");
                        confirmacao = false;
                    }
                }
            }
        }
    }
}