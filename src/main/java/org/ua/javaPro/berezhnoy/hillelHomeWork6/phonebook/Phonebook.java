package org.ua.javaPro.berezhnoy.hillelHomeWork6.phonebook;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private final List<Recording> records = new ArrayList<>();

    public Recording recordAdd(String name, String phone) {
        return new Recording(name, phone);
    }

    public void add(String name, String phoneNumber) {
        records.add(recordAdd(name, phoneNumber));
    }

    public Recording find(String name) {
        for (Recording i : records) {
            if (i.name().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public List<Recording> findAll(String name) {
        List list = new ArrayList();
        for (Recording recording : records) {
            if (recording.name().equals(name)) {
                list.add(recording);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }
}


