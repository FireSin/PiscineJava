package edu.school21.preProcessor;

import edu.school21.renderer.Renderer;

public class PreProcessorToLower implements PreProcessor{
    @Override
    public String process(String str) {
        return str.toLowerCase();
    }
}
