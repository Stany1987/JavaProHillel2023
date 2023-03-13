package org.ua.javaPro.berezhnoy.hillelHomeWork9;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileLoggerConfigurationLoader {

    public FileLoggerConfiguration load(String pathFileConf) throws IOException {
        var props = new Properties();
        props.load(new FileInputStream(pathFileConf));
        var path = (String) props.get("PATH");
        var level = LoginLevel.valueOf(props.get("LEVEL").toString());
        var maxSize =  Integer.parseInt(props.get("MAX_SIZE").toString());
        return new FileLoggerConfiguration(path, level, maxSize);
    }
}
