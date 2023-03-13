package org.ua.javaPro.berezhnoy.hillelHomeWork3;

import java.util.Arrays;
import java.util.Scanner;


public class StringSymbol {
    public static int findSymbolOccurance(String str, char symbol) {
        char[] chararray = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chararray.length; i++) {
            if (chararray[i] == symbol) {
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    public static String stringReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        return str.equalsIgnoreCase(new StringBuilder(str.replaceAll("", "")).reverse().toString());
    }

    public static void guessWord() {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Угадай, какое я загадал из слов:" + Arrays.toString(words));
        int guessPC = (int) (Math.random() * words.length);
        String pcWord = words[guessPC];

        int minLength;
        int count = 0;
        while ((true)) {
            String userWord = scanner.nextLine();
            count++;
            if (pcWord.equals(userWord)) {
                break;
            }
            if (pcWord.length() < userWord.length()) {
                minLength = pcWord.length();
            } else {
                minLength = userWord.length();
            }
            for (int i = 0; i < minLength; i++) {
                if (pcWord.charAt(i) == userWord.charAt(i)) {
                    System.out.print(pcWord.charAt(i));
                } else {
                    System.out.print('#');
                }
            }
            for (int j = 0; j < 15 - minLength; j++) {
                System.out.print("#");

            }
            System.out.println();
        }
        System.out.println("Ты угадал с " + count + " попытки, это слово: " + pcWord);

    }
}
