package ua.javaPro.berezhnoy.hillelHomeWork7;

import java.util.*;
import java.util.List;

public class FileNavigator {
    private Map<String, List<FileData>> files = new HashMap<>();

    public void add(String path, FileData newFile) throws MyException {

        if (!path.equals(newFile.getPath())) {
            throw new MyException("Wrong way");
        } else if (files.containsKey(path)) {
            files.get(path).add(newFile);
        } else {
            List<FileData> file = new ArrayList<>();
            file.add(newFile);
            files.put(path, file);
        }
    }

    public List<FileData> find(String path) {
        return files.get(path);
    }

    public List<FileData> filterBySize(int byteSize) {
        List<FileData> result = new ArrayList<>();
        for (List<FileData> list : files.values()) {
            for (FileData file : list) {
                if (file.getSize() <= byteSize) {
                    result.add(file);
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public void remove(String path) {
        files.remove(path);
    }

    public List<FileData> sortBySize() {

        List<FileData> result = new ArrayList<>();
        for (List<FileData> filesAll : files.values()) {
            for (FileData file : filesAll) {
                result.add(file);
            }
        }
        Collections.sort(result);
        System.out.println(result);
        return result;
    }
}