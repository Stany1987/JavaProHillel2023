package org.ua.javaPro.berezhnoy.hillelHomeWork22ClientServer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.HeroDto;

import java.io.*;
import java.net.Socket;

public class HeroClient {

    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 8080;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static void main(String[] args) {
        try {
            var echoSocket = new Socket(SERVER_HOST, SERVER_PORT);
            InputStream input = echoSocket.getInputStream();
            OutputStream output = echoSocket.getOutputStream();

            var reader = new BufferedReader(new InputStreamReader(input));
            var writer = new PrintWriter(output, true);
            var consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String userWriter;
            while ((userWriter = consoleReader.readLine()) != null) {
                writer.println(userWriter);
                String response = reader.readLine();

                if (response != null && response.startsWith("{")) {
                    HeroDto heroDto = objectMapper.readValue(response, HeroDto.class);
                    System.out.println(heroDto);
                } else {
                    System.out.println(response);
                }

                if (userWriter.equals("-exit")) {
                    break;
                }
            }
            echoSocket.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
