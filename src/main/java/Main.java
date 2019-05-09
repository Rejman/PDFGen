import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {

        PositonOfInvoice[] list ={
                new PositonOfInvoice("test",10),
                new PositonOfInvoice("Robota", 300)
        };

        Facture newFacture = new Facture("Fakturał 01", list);
        newFacture.createDocument("sampl1.pdf");
    }
}
