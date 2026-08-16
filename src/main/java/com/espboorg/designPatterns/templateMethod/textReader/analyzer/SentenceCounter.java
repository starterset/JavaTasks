package com.espboorg.designPatterns.templateMethod.textReader.analyzer;


import com.espboorg.designPatterns.templateMethod.textReader.customIO.TextFileWrapper;

public class SentenceCounter extends InputAnalyzer {
    @Override
    protected long analyze(String text) {
        if (text != null) {
            return text.chars().filter(ch -> ch == '.' || ch == '?' || ch == '!').count();
        } else {
            return 0;
        }
    }

    @Override
    protected void showOutput(long count) throws Exception {
        try (TextFileWrapper text = new TextFileWrapper()) {
            text.write("SentenceCount", "Sentence count in the text: " + count);
        }
    }
}
