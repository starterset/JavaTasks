package com.espboorg.competitive.hackerrank;

public class Decryption {
    public static void main(String[] args) {
        String encryptedMessage = "world hel2o";
        System.out.println(decryptMessage(encryptedMessage));
        String encryptedMessage1 = "seaside the to sent be to ne2ds army ten of team a";
        System.out.println(decryptMessage(encryptedMessage1));
        String encryptedMessage2 = "a3b4q2i abcd2 abc";
        System.out.println(decryptMessage(encryptedMessage2));
        String encryptedMessage3 = "mis2is2ip2i";
        System.out.println(decryptMessage(encryptedMessage3));
    }

    static String decryptMessage(String encryptedMessage) {
        StringBuilder sb = new StringBuilder(encryptedMessage);
        int sbIndex = 0;
        for (int i = 0; i < encryptedMessage.length(); i++) {
            char c = encryptedMessage.charAt(i);
            if (Character.isDigit(c)) {
                int times = Character.getNumericValue(c) - 1;
                sb.replace(sbIndex + i, sbIndex + i + 1, String.valueOf(encryptedMessage.charAt(i - 1)).repeat(times));
                sbIndex += times - 1;
            }
        }

        String[] words = sb.toString().split(" ");
        for (int i = 0; i < words.length / 2; i++) {
            String temp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = temp;
        }
        return String.join(" ", words);
    }
}
