package org.ua.javaPro.berezhnoy.hillelHomeWork9;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements Logger {

    private FileLoggerConfiguration configuration;

    public FileLogger(FileLoggerConfiguration configuration) throws IOException {
        this.configuration = configuration;
        configuration.newFile();
    }

    public void debug(String messDebug) throws FileMaxSizeException, IOException {
        if (configuration.getLogLevel().getLevel() < LoginLevel.DEBUG.getLevel()) return;
        write(messDebug);

    }

    public void info(String messInfo) throws FileMaxSizeException, IOException {
        if (configuration.getLogLevel().getLevel() < LoginLevel.INFO.getLevel()) return;
        write(messInfo);

    }

    public void write(String message) throws FileMaxSizeException, IOException {
        var time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy_MM_dd_HH_mm_ss"));
        var writeMessage = String.format(time + configuration.getLogLevel() + message);
        var fileSize = Files.size(Path.of(configuration.getFilePath()));
        if (fileSize + writeMessage.getBytes(StandardCharsets.UTF_8).length > configuration.getMaxSize()) {
            configuration.newFile();
//    throw new FileMaxSizeException("Max size file ");
        }

        try (FileWriter writer = new FileWriter(configuration.getFile(), true)) {
            writer.write(writeMessage);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}