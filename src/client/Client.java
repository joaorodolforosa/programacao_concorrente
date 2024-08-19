package client;

import java.io.*;
import java.net.*;
import java.util.*;

class Client {

    public static void main(String[] args) {
        // estabelece a conexão estabelecendo o endereço
        // do host e o número da porta
        try (Socket socket = new Socket("localhost", 1234)) {

            // para leitura de dados e envio para o servidor 
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            // recebe uma mensagem do servidor e a imprime no teclado
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(
                            socket.getInputStream()));

            Scanner sc = new Scanner(System.in);
            String line = null;

            while (!"exit".equalsIgnoreCase(line)) {

                // lê uma mensagem de texto escrita pelo usuário 
                line = sc.nextLine();

                // envia a mensagem de texto para o servidor 
                out.println(line);
                out.flush();

                // imprime a mensagem de texto do servidor
                System.out.println("Servidor respondeu "
                        + in.readLine());
            }

            // encerra o objeto scanner 
            sc.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
