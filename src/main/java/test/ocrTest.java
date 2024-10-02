package test;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import org.junit.Test;

public class ocrTest {
    private OCRDocumentParser parser = new OCRDocumentParser();
    String filePath = "src/main/resources/parserTest.png";

    @Test
    public void OCRTest() {
        Document document = FileSystemDocumentLoader.loadDocument(filePath, parser);
        System.out.println("===============OCR=================");
        System.out.println(document.text());
        System.out.println("===============OCR=================");
    }
}
