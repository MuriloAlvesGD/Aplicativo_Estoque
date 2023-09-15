# Aplicativo_Estoque
Aplicativo que pode ser utilizado em qualquer comercio para gerenciar o seu estoque.

Está dividido em arquivo Main, Classe Produto e Metódos;

Possui as funções de:

Menu (arquivo Main):
  Chama cada função e recebe alguns imputs;

Listar produtos;
  Lista todos os produtos presentes no estoque, com nome, codigo e quantidade em estoque;
  
Adicionar Produto;
  Pede Nome e se quer adicionar estoque;
  Obs: Cód é alto incrementavel;
  
Aumentar Estoque;
  Pede o código do produto e se encontrado, pede a quantidade a ser aumentada;
  
Realizar Venda;
  Pede o código do produto e se encontrado, pede a quantidade que foi vendida;
  Obs: Se o estoque estiver zerado, o programa avisa e retorna para o menu;
        Se tentar vendar mais do que tem em estoque, o programa cancela a  operação e retorna para o menu;
  
Excluir Produto;
  Pede o código do produto e verifica a existencia dele e o estoque, caso tenha produto em estoque, notifica o usuario;
  Apresenta o produto (nome e cod) e pede para confirmar se deseja deletar, se sim, deleta;
