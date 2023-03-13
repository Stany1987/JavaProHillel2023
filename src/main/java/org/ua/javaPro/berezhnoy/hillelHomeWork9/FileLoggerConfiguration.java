package org.ua.javaPro.berezhnoy.hillelHomeWork9;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FileLoggerConfiguration {
    private static final String PREFIX_FILE = "log_";
    private static final String FORMAT_FILE = ".log";
    private File file;
    private final String filePath;
    private final LoginLevel logLevel;
    private final int maxSize;

    public File getFile() {
        return file;
    }

    public String getFilePath() {
        return filePath;
    }

    public LoginLevel getLogLevel() {
        return logLevel;
    }

    public int getMaxSize() {
        return maxSize;
    }


    public FileLoggerConfiguration(String filePath, LoginLevel logLevel, int maxSize) {
        this.filePath = filePath;
        this.logLevel = logLevel;
        this.maxSize = maxSize;
    }

    public void newFile() throws IOException {
        var time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy_MM_dd_HH_mm_ss_ms"));
        file = new File(filePath + PREFIX_FILE + time + FORMAT_FILE);
        file.createNewFile();
    }
}
