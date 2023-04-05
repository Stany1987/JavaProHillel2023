package org.ua.javaPro.berezhnoy.hillelHomeWork9;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class FileLoggerConfigurationLoaderTest {
    String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy_MM_dd_HH_mm_ss_ms"));
    FileLoggerConfigurationLoader configLoad = new FileLoggerConfigurationLoader();
    FileLoggerConfiguration config = configLoad.load("src/main/resources/logs_config.properties");
    Logger log = new FileLogger(config);


    FileLoggerConfigurationLoaderTest() throws IOException {
    }

    @Test
    void testGetFile() throws FileMaxSizeException, IOException {
        log.info("info");
        String file = String.valueOf(config.getFile());
        assertTrue(file.endsWith("log_" + time + ".log"));
    }

    @Test
    void testLoggerConfigFile() {
        String path = "src/main/resources/logs_config.properties";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        assertTrue(absolutePath.endsWith("logs_config.properties"));
    }

    @Test
    void testGetLevel() {
        LoginLevel level = config.getLogLevel();
        assertTrue(level == LoginLevel.DEBUG || level == LoginLevel.INFO);
    }

    @Test
    void checkFileLog() throws IOException, FileMaxSizeException {
        log.info("info");
        String file = String.valueOf(config.getFile());
        String searchStringTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy_MM_dd_HH_mm_ss"));
        String fileContent = Files.readString(Paths.get(file));
        assertEquals(fileContent.trim(), searchStringTime + LoginLevel.DEBUG + "info");
    }


}