package org.ua.javaPro.berezhnoy.hillelHomeWork22ClientServer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.commons.text.WordUtils;
import org.postgresql.ds.PGSimpleDataSource;
import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.*;

import javax.sql.DataSource;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import static org.ua.javaPro.berezhnoy.utils.MyLoger.log;

public class HeroServer {
    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
HeroFactory heroFactory=new HeroFactory();
        var serverSocket = new ServerSocket(PORT);
        try (serverSocket) {
            log.info("connection successful on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                log.info("connect successful");
                var clientThread = new Thread(new ClientConnect(clientSocket,heroFactory));
                clientThread.start();
            }
        } catch (IOException ex) {
            System.out.println(ex);
            System.exit(-1);
        }
    }

    public static class ClientConnect implements Runnable {
        private final Socket clientSocket;
        private final HeroFactory heroFactory;

        public ClientConnect(Socket socket,HeroFactory heroFactory) {
            this.clientSocket = socket;
            this.heroFactory=heroFactory;
        }

        @SneakyThrows
        @Override
        public void run() {
            try (var out = new PrintWriter(clientSocket.getOutputStream(), true);
                 var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    String[] command = inputLine.split(" ", 2);

                    if (command[0].equals("-name")) {

                        String heroName = WordUtils.capitalizeFully(command[1]);

                        HeroService heroService = heroFactory.createService(dataSource());

                        List<HeroDto> heroes = heroService.findByName((heroName));

                        if (!heroes.isEmpty()) {
                            var objectMapper = new ObjectMapper();
                            String heroJson = objectMapper.writeValueAsString(heroes.get(0));
                            out.println(heroJson);
                        } else {
                            out.println("Hero is not found " + heroName);
                        }
                    } else if (command[0].equals("-exit")) {
                        log.info("Closing connection to client");
                        out.println("Closing connection");
                        break;
                    } else {
                        out.println("Unknown command");
                    }
                }
            } finally {
                clientSocket.close();
            }
        }

        private static DataSource dataSource() {
            var ds = new PGSimpleDataSource();
            ds.setDatabaseName("postgres");
            ds.setUser("postgres");
            ds.setPassword("postgres");
            ds.setCurrentSchema("hilleljdbc");
            return ds;
        }
    }
}
