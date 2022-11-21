package edu.school21.renderer;

import edu.school21.preProcessor.PreProcessor;

public class RendererStandardImpl implements Renderer{

    private PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    public void Render(String str) {
        System.out.println(this.preProcessor.process(str));
    }
}
