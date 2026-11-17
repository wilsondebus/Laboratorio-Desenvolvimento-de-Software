package Servidor;

import Beans.Pessoa;
import Conexao.Conexao;
import DAO.PessoaDAO;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

public class Servidor {

    public static void main(String[] args) {

        try (ServerSocket servidor = new ServerSocket(12345)) {

            System.out.println("Servidor iniciado na porta 12345...");

            while (true) {

                Socket cliente = servidor.accept();

                System.out.println("Cliente conectado!");

                // Cria uma Thread para cada cliente
                Thread thread = new Thread(() -> {

                    try (Socket socket = cliente) {

                        ObjectInputStream entrada =
                                new ObjectInputStream(socket.getInputStream());

                        ObjectOutputStream saida =
                                new ObjectOutputStream(socket.getOutputStream());

                        String mensagem;

                        try {

                            // Recebe a pessoa enviada pelo cliente
                            Pessoa pessoa = (Pessoa) entrada.readObject();

                            // Verifica se o nome foi preenchido
                            if (pessoa.getNome() == null ||
                                    pessoa.getNome().trim().isEmpty()) {

                                throw new Exception("Nome é obrigatório!");
                            }

                            // Conecta ao banco de dados
                            Conexao c = new Conexao();

                            try (Connection conn = c.getConexao()) {

                                // Insere a pessoa no banco
                                PessoaDAO dao = new PessoaDAO(conn);

                                dao.inserirPessoa(pessoa);
                            }

                            mensagem = "Pessoa cadastrada com sucesso!";

                        } catch (Exception ex) {

                            mensagem = "Erro: " + ex.getMessage();
                        }

                        // Envia a resposta para o cliente
                        saida.writeObject(mensagem);
                        saida.flush();

                    } catch (Exception ex) {

                        System.out.println(
                                "Erro na comunicação com o cliente: "
                                + ex.getMessage()
                        );
                    }

                });

                thread.start();
            }

        } catch (Exception ex) {

            System.out.println(
                    "Erro ao iniciar o servidor: " + ex.getMessage()
            );
        }
    }
}