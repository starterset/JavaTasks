package com.espboorg.designPatterns.templateMethod.textReader.analyzer;

import com.espboorg.designPatterns.templateMethod.textReader.customIO.TextFileWrapper;

public class WordCounter extends InputAnalyzer {
    @Override
    protected long analyze(String text) {
        if (text != null) {
            return text.split("\\W+").length;
        } else {
            return 0;
        }
    }

    @Override
    protected void showOutput(long count) throws Exception {
        try (TextFileWrapper text = new TextFileWrapper()) {
            text.write("WordCount", "Word count in the text: " + count);
        }
    }
}
