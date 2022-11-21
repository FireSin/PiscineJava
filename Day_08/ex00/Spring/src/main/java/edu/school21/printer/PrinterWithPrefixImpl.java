package edu.school21.printer;

import edu.school21.renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer{

    private String _prefix;
    private Renderer renderer;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setPrefix(String prefix){
        _prefix = prefix;
    }

    @Override
    public void print(String text) {
        renderer.Render(_prefix + " " + text);
    }
}
