package ua.javaPro.berezhnoy.hillelHomeWork3;

public class Main {
    public static void main(String[] args) {
                System.out.println("*****1*****");
        StringSymbol.findSymbolOccurance("asda",'s');
        System.out.println("*****2*****");
        System.out.println(StringSymbol.findWordPosition("Apollo","pollo"));
        System.out.println(StringSymbol.findWordPosition("Apple","Plant"));
        System.out.println("*****3*****");
        System.out.println(StringSymbol.stringReverse("Hello"));
        System.out.println("*****4*****");
        System.out.println(StringSymbol.isPalindrome("lalall"));
        System.out.println("*****6*****");
        StringSymbol.guessWord();
    }
}
