package org.ua.javaPro.berezhnoy.hillelHomeWork7;

public record FileData(String name, int size, String path) implements Comparable<FileData> {

    public String getPath() {
        return path;
    }


    public Integer getSize() {
        return size;
    }

    @Override
    public int compareTo(FileData o) {
        return this.getSize() - o.getSize();
    }
}
