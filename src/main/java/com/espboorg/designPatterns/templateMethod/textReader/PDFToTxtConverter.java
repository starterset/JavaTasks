package com.espboorg.designPatterns.templateMethod.textReader;

import java.io.*;

public class PDFToTxtConverter {
    public static void convert(String filePath) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        BufferedWriter outputFile = new BufferedWriter(new FileWriter("new.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            outputFile.write(line);
        }
        reader.close();
        outputFile.close();
    }
}
