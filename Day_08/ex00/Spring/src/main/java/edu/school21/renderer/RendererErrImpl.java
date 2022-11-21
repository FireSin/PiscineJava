package edu.school21.renderer;

import edu.school21.preProcessor.PreProcessor;

public class RendererErrImpl implements Renderer{

    private PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }


    public void Render(String str) {
        System.err.println(this.preProcessor.process(str));
    }
}
