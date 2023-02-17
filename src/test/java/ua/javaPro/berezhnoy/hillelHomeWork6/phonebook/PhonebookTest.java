package ua.javaPro.berezhnoy.hillelHomeWork6.phonebook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookTest {
    @Test
    void mustKeepNamePhoneNumber() {
        var phonebook = new Phonebook();
        phonebook.add("Alex", "93254356");
        assertEquals(phonebook.findAll("Alex").toString(), "[Recording[name=Alex, phoneNumber=93254356]]");
    }

    @Test
    void shouldFindElementByName() {
        var phonebook = new Phonebook();
        phonebook.add("Mania", "90873232");
        phonebook.add("Mania", "90811111");
        phonebook.add("Mania", "90822222");
        assertEquals(phonebook.find("Mania").toString(), "Recording[name=Mania, phoneNumber=90873232]");
    }

    @Test
    void shouldReturnNullIfEntryNotFound() {
        var phonebook = new Phonebook();
        phonebook.add("Vika", "90873232");
        phonebook.add("Vika", "90814535");
        phonebook.add("Vika", "90833424");
        assertEquals(phonebook.find("Mania"), null);
    }

    @Test
    void
    shouldReturnAllElements() {
        var phonebook = new Phonebook();
        phonebook.add("Papazodlo", "2354346");
        phonebook.add("Papazodlo", "5647635");
        phonebook.add("Papazodlo", "8779852");
        assertEquals(phonebook.findAll("Papazodlo").toString(), "[Recording[name=Papazodlo, phoneNumber=2354346]," +
                " Recording[name=Papazodlo, phoneNumber=5647635], Recording[name=Papazodlo, phoneNumber=8779852]]");
    }

    @Test
    void ShouldReturnNullIfSubscriberNotFound(){
        var phonebook = new Phonebook();
        phonebook.add("Mia", "90822354");
        phonebook.add("Lia", "85463453");
        assertEquals(phonebook.findAll("Ada"),null);
    }
}