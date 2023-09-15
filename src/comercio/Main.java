/*
PROJETO DE COMERCIO FASE 1

ALUNOS:

-Murilo dos Santos Alves
-Darlan Sadraque Oliveira
-Thomás Lopes Barbosa
-Demostenes Diniz Porto
-Dayane Rodrigues Honório
-Valdemir Domingos da Silva Junior
-Diogo Fernando Silveira de Moura
 */

package comercio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String nome = new String();
        int opcaoEstoque = 0;

        //MENU DO SISTEMA DE COMÉRCIO
        int opcaoMenu = 0;
        while (opcaoMenu != 6) {
            System.out.println("");
            System.out.println("------- MENU PRINCIPAL -------");
            System.out.println("1) Listar todos os produtos");
            System.out.println("2) Cadastrar um novo produto");
            System.out.println("3) Adicionar estoque de um produto");
            System.out.println("4) Vender algum produto existente");
            System.out.println("5) Remover um produto do comércio");
            System.out.println("6) Sair do programa");
            System.out.println("\nOque deseja fazer?");

            try {
                opcaoMenu = 0;
                opcaoMenu = Integer.parseInt(scan.nextLine());
            } catch (Exception e) { //CAPTURA EXCECAO DE LETRA
                System.out.println("INSIRA UMA OPÇÃO VÁLIDA (EM  NUMERO)");
            }


                //LISTAR PRODUTO
                if (opcaoMenu == 1) {
                    Metodos.listarProdutos();
                }

                //CADASTRAR PRODUTO
                else if (opcaoMenu == 2) {
                    System.out.println("\nQual o nome do produto?");
                    nome = scan.nextLine();

                    boolean confirmacao = true;
                    while (confirmacao) {
                        System.out.println("\n DESEJA ADICIONAR ESTOQUE? \n1) SIM | 2)NÃO");


                        try {// VERIFICACAO DO opcaoEstoque para imput de letra
                            opcaoEstoque = Integer.parseInt(scan.nextLine());
                        } catch (Exception e) {
                            System.out.println("ERROR - OPCAO INVÁLIDA");
                        }


                        if (opcaoEstoque == 1 || opcaoEstoque == 2) { //Sai do while apenas quando escolhe uma opcao
                            confirmacao = false;
                        }
                    }

                    System.out.printf(Metodos.adicionarProduto(nome, opcaoEstoque)); //Funcao para adicionar novo produto a lista, pede mais entrada se opcaoEstoque = 1
                }

                //ADICIONAR ESTOQUE
                else if (opcaoMenu == 3) {
                    Metodos.modificarEstoque("AUMENTAR");
                }

                //VENDER PRODUTO
                else if (opcaoMenu == 4) {
                    Metodos.modificarEstoque("DIMINUIR");
                }

                //REMOVER PRODUTO
                else if (opcaoMenu == 5) {
                    Metodos.removerProduto();
                }

                //MENSAGEM PARA NUMERO DA OPCAO ERRADA
                else if (opcaoMenu != 6) {
                    System.out.println("OPÇÃO INVÁLIDA");
                }


        } System.out.println("OBRIGADO POR UTILIZAR O SISTEMA");
    }
}