package com.espboorg.competitive.hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecryptionTest {
    @Test
    void testDecryptMessage() {
        String encryptedMessage = "world hel2o";
        assertEquals("hello world", Decryption.decryptMessage(encryptedMessage));

        String encryptedMessage1 = "seaside the to sent be to ne2ds army ten of team a";
        String decryptedMessage1 = "a team of ten army needs to be sent to the seaside";
        assertEquals(decryptedMessage1, Decryption.decryptMessage(encryptedMessage1));

        String encryptedMessage2 = "a3b4q2i abcd2 abc";
        String decryptedMessage2 = "abc abcdd aaabbbbqqi";
        assertEquals(decryptedMessage2, Decryption.decryptMessage(encryptedMessage2));

        String encryptedMessage3 = "mis2is2ip2i";
        String decryptedMessage3 = "mississippi";
        assertEquals(decryptedMessage3, Decryption.decryptMessage(encryptedMessage3));
    }
}