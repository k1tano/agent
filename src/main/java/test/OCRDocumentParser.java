package test;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentParser;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static dev.langchain4j.internal.Utils.getOrDefault;

public class OCRDocumentParser implements DocumentParser {
    private static final String DEFAULT_LANGUAGE = "eng";
    private String language;
    private Tesseract tesseract;

    public OCRDocumentParser() {
        this(DEFAULT_LANGUAGE);
    }

    public OCRDocumentParser(String language) {
        Tesseract tesseract = new Tesseract();
        tesseract.setLanguage(getOrDefault(language, () -> DEFAULT_LANGUAGE));
        this.tesseract = tesseract;
    }

    @Override
    public Document parse(InputStream inputStream) {
        try {
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            String text = this.tesseract.doOCR(bufferedImage);
            return Document.from(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TesseractException e) {
            throw new RuntimeException(e);
        }
    }
}
