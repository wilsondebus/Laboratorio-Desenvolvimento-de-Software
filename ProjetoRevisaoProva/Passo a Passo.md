# 📚 Passo a Passo para a Prova — Java + MySQL

## 1. Criar o Banco de Dados
- Criar o banco (`CREATE DATABASE`).
- Criar a tabela principal com `PRIMARY KEY` e `AUTO_INCREMENT`.
- Criar a tabela secundária com `FOREIGN KEY`.
- Conferir os nomes das tabelas e colunas.

## 2. Criar o Projeto no NetBeans
- Criar os pacotes:
  - `Beans`
  - `Conexao`
  - `DAO`
  - `View`
- Adicionar o driver MySQL Connector/J nas bibliotecas.

## 3. Criar as Classes Beans
- Criar uma classe para cada tabela.
- Declarar os atributos como `private`.
- Gerar os getters e setters.
- Adicionar `toString()` na classe utilizada no JComboBox.

## 4. Criar a Classe Conexao
- Criar `Conexao.java`.
- Implementar `getConexao()`.
- Informar URL, usuário e senha do banco.
- Testar a conexão.

## 5. Criar as Classes DAO
- Criar um DAO para cada Bean.
- Implementar os métodos:
  - `inserir()` → INSERT.
  - `editar()` → UPDATE.
  - `excluir()` → DELETE.
  - `getObjeto(id)` → SELECT por ID.
  - `getObjetos()` → SELECT de todos.
  - `buscarObjetos()` → SELECT com LIKE.

## 6. Criar a Interface CadastrarCategoria
- Adicionar JTextField e JButton.
- No botão, criar o Bean.
- Preencher os atributos com `getText()`.
- Criar o DAO e chamar `inserir()`.

## 7. Criar a Interface CadastrarProduto
- Adicionar JTextFields, JComboBox e JButton.
- Criar `carregarCategorias()`.
- Chamar o método no construtor.
- No botão, criar o Bean e preencher os atributos.
- Pegar o ID da categoria selecionada.
- Chamar `inserir()` do DAO.

## 8. Criar a Interface AtualizarExcluirProduto
- Criar campos, JComboBox e botões.
- **Buscar:** consultar pelo ID e preencher os campos.
- **Atualizar:** pegar os dados dos campos e chamar `editar()`.
- **Excluir:** pegar o ID e chamar `excluir()`.
- Permitir alterar a categoria pelo JComboBox.

## 9. Criar a Interface EditarCategoria
- Criar os campos ID e Nome.
- **Buscar:** utilizar `getCategoria(id)`.
- **Atualizar:** utilizar `editar()`.
- **Excluir:** utilizar `excluir()`, se necessário.

## 10. Criar o RelatorioCategorias
- Adicionar JTable.
- Configurar as colunas.
- Criar método `listarCategorias()`.
- Utilizar `getCategorias()` do DAO.
- Preencher a JTable com `DefaultTableModel`.
- Chamar o método no construtor.

## 11. Criar o RelatorioProduto
- Adicionar JTable, JTextField, JComboBox e botões.
- Criar `listarProdutos()`.
- Utilizar `JOIN` no DAO para obter o nome da categoria.
- Preencher a JTable com `DefaultTableModel`.
- Criar busca por nome utilizando `LIKE`.
- Criar busca por categoria utilizando seu ID.

## 12. Criar o MenuPrincipal
- Criar um JFrame Form.
- Adicionar um botão para cada interface.
- Nos botões, utilizar `new NomeDaTela().setVisible(true)`.
- Configurar telas secundárias com `DISPOSE_ON_CLOSE`.
- Definir `MenuPrincipal` como classe principal.

## 13. Testar o Sistema
- Cadastrar categorias.
- Cadastrar produtos selecionando categorias.
- Buscar, editar e excluir registros.
- Verificar os relatórios.
- Testar a busca por nome e categoria.
- Conferir os registros no MySQL.

---

## ✅ Ordem para Memorizar

**Banco → Beans → Conexão → DAO → Cadastro → Edição/Exclusão → Relatórios → Busca → Menu → Testes.**
