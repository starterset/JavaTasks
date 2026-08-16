package com.espboorg.designPatterns.templateMethod.textReader.analyzer;

import com.espboorg.designPatterns.templateMethod.textReader.customIO.TextFileWrapper;

public class SymbolCounter extends InputAnalyzer {
    @Override
    protected long analyze(String text) {
        if (text != null) {
            return text.chars().filter(ch -> ch != ' ').count();
        } else {
            return 0;
        }
    }

    @Override
    protected void showOutput(long count) throws Exception {
        try (TextFileWrapper text = new TextFileWrapper()) {
            text.write("SymbolCount", "There are " + count + " symbols in text");
        }
    }
}
