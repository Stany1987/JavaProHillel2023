package ua.javaPro.berezhnoy.hillelHomeWork6.phonebook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookTest {

    @Test
    void mustKeepNamePhoneNumber() {
        var phonebook = new Phonebook();
        phonebook.add("Alex", "93254356");
        assertEquals(phonebook.findAll("Alex"), "Alex [93254356]");
    }

    @Test
    void shouldFindElementByName() {
        var phonebook = new Phonebook();
        phonebook.add("Mania", "90873232");
        phonebook.add("Mania", "90811111");
        phonebook.add("Mania", "90822222");
        assertEquals(phonebook.find("Mania", 1), "Mania 90811111");
    }

    @Test
    void shouldReturnNullIfEntryNotFound() {
        var phonebook = new Phonebook();
        phonebook.add("Vika", "90873232");
        phonebook.add("Vika", "90814535");
        phonebook.add("Vika", "90833424");
        assertEquals(phonebook.find("Mania", 7), null);
    }

    @Test
    void
    shouldReturnAllElements() {
        var phonebook = new Phonebook();
        phonebook.add("Salo", "2354346");
        phonebook.add("Salo", "5647635");
        phonebook.add("Salo", "8779852");
        assertEquals(phonebook.findAll("Salo"), "Salo [2354346, 5647635, 8779852]");
    }

    @Test
    void ShouldReturnNullIfSubscriberNotFound(){
        var phonebook = new Phonebook();
        phonebook.add("Mia", "90822354");
        phonebook.add("Lia", "85463453");
        assertEquals(phonebook.findAll("Ada"),null);
    }
}