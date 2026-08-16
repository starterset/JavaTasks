package com.espboorg.designPatterns.templateMethod.textReader.customIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextFileWrapper implements AutoCloseable {
    private FileInputStream fileInput;
    private FileOutputStream fileOutput;

    public TextFileWrapper() {
    }

    public TextFileWrapper(FileInputStream fileInput) {
        this.fileInput = fileInput;
    }

    public TextFileWrapper(String fileName) throws FileNotFoundException {
        this.fileInput = new FileInputStream(fileName);
    }

    public String read() throws IOException {
        StringBuilder strBuild = new StringBuilder();
        int i;
        do {
            i = this.fileInput.read();
            strBuild.append((char) i);
        } while (i != -1);
        return strBuild.toString();
    }

    public void copyTo(String outputFile) throws IOException {
        this.fileOutput = new FileOutputStream(outputFile);
        int i;
        do {
            i = this.fileInput.read();
            fileOutput.write(i);
        } while (i != -1);
    }

    public void write(String outputFile, String str) throws IOException {
        this.fileOutput = new FileOutputStream(outputFile);
        for (int i = 0; i < str.length(); i++) {
            fileOutput.write(str.charAt(i));
        }
    }

    public void delete() {
    }

    @Override
    public void close() throws Exception {
        if (fileInput != null)
            fileInput.close();
        if (fileOutput != null)
            fileOutput.close();
    }
}
