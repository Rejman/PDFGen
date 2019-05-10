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

        Person dealer = new Person("Jakas firma", "35-234 Rejtana 44, Rzeszow", "346346543");
        Person buyer = new Person("Jakas kupiec", "45-756 Krakowska 7, Kielce", "846384564");
        Facture newFacture = new Facture("Faktura 01",dealer,buyer, list);
        newFacture.createDocument("sample1.pdf");
    }
}
