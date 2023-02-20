package ua.javaPro.berezhnoy.hillelHomeWork7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileNavigatorTest {
    FileNavigator fileNavigator = new FileNavigator();
    FileData fileOne = new FileData("first", 111, "/path/to/files");
    FileData fileTwo = new FileData("second", 22, "/path/to/files");
    FileData fileThree = new FileData("third", 33, "/path/to/files");
    FileData fileFour = new FileData("fourth", 44, "/path/to/fileOne");
    FileData fileFive = new FileData("fifth", 5, "/path/to/file");
    FileData fileSix = new FileData("sixth", 6, "/path/to/fileOne");

    @Test
    void shouldAddFile() {
        fileNavigator.add("/path/to/files", fileOne);
        fileNavigator.add("/path/to/files", fileTwo);
        fileNavigator.add("/path/to/files", fileThree);
        fileNavigator.add("/path/to/fileOne", fileFour);
        fileNavigator.add("/path/to/fileOne", fileSix);

        assertEquals(fileNavigator.find("/path/to/files"), List.of(fileOne, fileTwo, fileThree));
        assertEquals(fileNavigator.find("/path/to/fileOne"), List.of(fileFour, fileSix));
    }

    @Test
    void find() {
        fileNavigator.add("/path/to/files", fileOne);
        assertEquals(fileNavigator.find("/path/to/files"), List.of(fileOne));
    }

    @Test
    void returnsFilesSmallerThanSpecifiedSize() {
        fileNavigator.add("/path/to/files", fileOne);
        fileNavigator.add("/path/to/files", fileTwo);
        fileNavigator.add("/path/to/files", fileThree);
        fileNavigator.add("/path/to/fileOne", fileFour);
        fileNavigator.add("/path/to/fileOne", fileSix);
        assertEquals(fileNavigator.filterBySize(90), List.of(fileFour, fileSix, fileTwo, fileThree));

    }

    @Test
    void removesFilePath() {
        fileNavigator.add("/path/to/files", fileOne);
        fileNavigator.add("/path/to/files", fileTwo);
        fileNavigator.add("/path/to/files", fileThree);
        fileNavigator.add("/path/to/fileOne", fileFour);
        fileNavigator.add("/path/to/fileOne", fileSix);

        fileNavigator.remove("/path/to/files");
        assertEquals(fileNavigator.find("/path/to/files"), null);
    }

    @Test
    void sortFilesBySize() {
        fileNavigator.add("/path/to/files", fileOne);
        fileNavigator.add("/path/to/files", fileTwo);
        fileNavigator.add("/path/to/files", fileThree);
        fileNavigator.add("/path/to/fileOne", fileFour);
        fileNavigator.add("/path/to/fileOne", fileSix);

        assertEquals(fileNavigator.sortBySize(), List.of(fileSix, fileTwo, fileThree, fileFour, fileOne));

    }

    @Test
    void shouldThrowExceptionForWrongPath() throws MyException {

        MyException myException = Assertions.assertThrows(MyException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                fileNavigator.add("/path/to/files", fileFive);
            }
        });
        Assertions.assertEquals(myException.getMessage(), "Wrong way");
    }
}

