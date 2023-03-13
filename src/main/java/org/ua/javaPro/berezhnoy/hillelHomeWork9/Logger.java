package org.ua.javaPro.berezhnoy.hillelHomeWork9;

import java.io.IOException;

public interface Logger {
    void debug(String message)throws FileMaxSizeException, IOException;

    void info(String message)throws FileMaxSizeException, IOException;

}
