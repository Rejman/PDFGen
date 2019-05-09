import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        Facture newFacture = new Facture("To jest jakis tytuł");
        newFacture.createDocument("sampl1.pdf");
    }
}
