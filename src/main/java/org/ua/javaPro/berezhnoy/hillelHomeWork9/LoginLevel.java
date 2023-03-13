package org.ua.javaPro.berezhnoy.hillelHomeWork9;

public enum LoginLevel {
    INFO(0), DEBUG(1),EROR(3);

    private int level;

    LoginLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }


}
