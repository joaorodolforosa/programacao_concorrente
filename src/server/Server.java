package server;

import java.io.*;
import java.net.*;

class Server {

    public static void main(String[] args) {
        ServerSocket server = null;

        try {

            // servidor recebe conexões na porta 1234 
            server = new ServerSocket(1234);
            server.setReuseAddress(true);

            // escuta permanente 
            // requisição do cliente
            while (true) {

                // socket para receber mensagens e requisições do cliente
                Socket client = server.accept();

                // mostra que um novo cliente conectou-se
                System.out.println("Novo cliente conectado: "
                        + client.getInetAddress()
                                .getHostAddress());

                // cria um novo socket para o cliente
                ClientHandler clientSock
                        = new ClientHandler(client);

                // Thread para tratamento das requisições do cliente separadamente
                new Thread(clientSock).start();
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }

    // ClientHandler class 
    private static class ClientHandler implements Runnable {

        private final Socket clientSocket;

        // Constructor 
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            PrintWriter out = null;
            BufferedReader in = null;
            try {

                // envio de mensagens para o cliente 
                out = new PrintWriter(
                        clientSocket.getOutputStream(), true);

                // recebe a mensagem do cliente
                in = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));

                String line;
                while ((line = in.readLine()) != null) {

                    // imprime a mensagem recebida do cliente 
                    System.out.printf(
                            " Enviado do : %s\n",
                            line);
                    out.println(line);
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                        clientSocket.close();
                    }
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
