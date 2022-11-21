package edu.school21.app;

//import edu.school21.preProcessor.PreProcessor;
//import edu.school21.preProcessor.PreProcessorToUpperImpl;
//import edu.school21.printer.PrinterWithPrefixImpl;
//import edu.school21.renderer.Renderer;
//import edu.school21.renderer.RendererErrImpl;
import edu.school21.printer.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//public class Main {
//    public static void main(String[] args) {
//        PreProcessor preProcessor = new PreProcessorToUpperImpl();
//        Renderer renderer = new RendererErrImpl(preProcessor);
//        PrinterWithPrefixImpl printer = new PrinterWithPrefixImpl(renderer);
//        printer.setPrefix ("Prefix ");
//
//        printer.print ("Hello!");
//    }
//}

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Printer printer = context.getBean("printerWithPrefixUpperStd", Printer.class);
        printer.print("Hello!");
    }
}

