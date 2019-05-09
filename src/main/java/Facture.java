import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Facture {
    private String title;

    public Facture(String title) {
        this.title = title;
    }

    public void createDocument(String path) throws FileNotFoundException, DocumentException {
        Document document = new Document();

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();

        //dodanie tytułu
        document.add(new Paragraph(this.title));

        document.close();
        writer.close();
    }
}
