package org.ua.javaPro.berezhnoy.hillelHomeWork9;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, FileMaxSizeException {
        FileLoggerConfigurationLoader configLoad = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration config = configLoad.load("src/main/resources/logs_config.properties");
        Logger log = new FileLogger(config);
        for (int i = 0; i < 100; i++) {
            log.debug("  it's debug");
            log.info("   it's info");
        }

    }
}