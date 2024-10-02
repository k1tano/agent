package test;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import dev.langchain4j.data.document.parser.apache.poi.ApachePoiDocumentParser;
import dev.langchain4j.data.document.parser.apache.tika.ApacheTikaDocumentParser;
import org.junit.Test;


public class parserTest {

    String filePath = "src/main/resources/parserTest3.pdf";

    @Test
    public void textDocumentParserTest() {
        TextDocumentParser textDocumentParser = new TextDocumentParser();
        Document document = FileSystemDocumentLoader.loadDocument(filePath, textDocumentParser);
        System.out.println("===============TEXT=================");
        System.out.println(document.text());
        System.out.println("===============TEXT=================");

    }

    @Test
    public void apachePoiDocumentParserTest() {
        ApachePoiDocumentParser apachePoiDocumentParser = new ApachePoiDocumentParser();
        Document document = FileSystemDocumentLoader.loadDocument(filePath, apachePoiDocumentParser);
        System.out.println("===============POI=================");
        System.out.println(document.text());
        System.out.println("===============POI=================");
    }

    @Test
    public void apacheTikaDocumentParserTest() {
        ApacheTikaDocumentParser apacheTikaDocumentParser = new ApacheTikaDocumentParser();
        Document document = FileSystemDocumentLoader.loadDocument(filePath, apacheTikaDocumentParser);
        System.out.println("===============TIKA=================");
        System.out.println(document.text());
        System.out.println("===============TIKA=================");
    }

    @Test
    public void apachePdfBoxDocumentParserTest() {
        ApachePdfBoxDocumentParser apachePdfBoxDocumentParser = new ApachePdfBoxDocumentParser();
        Document document = FileSystemDocumentLoader.loadDocument(filePath, apachePdfBoxDocumentParser);
        System.out.println("===============PDF=================");
        System.out.println(document.text());
        System.out.println("===============PDF=================");

    }

}
