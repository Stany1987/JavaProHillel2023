package org.ua.javaPro.berezhnoy.hillelHomeWork9;

public enum LoginLevel {
    INFO(0), DEBUG(1);

    private int level;

    LoginLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }


}
