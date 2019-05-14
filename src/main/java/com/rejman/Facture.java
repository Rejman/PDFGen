package com.rejman;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Facture {

    private static BaseFont helvetica;
    static {
        try {
            helvetica = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Font helvetica16=new Font(helvetica,16);
    static Font helvetica12 = new Font(helvetica, 12);
    static Font helveticaBold12 = new Font(helvetica, 12, Font.BOLD);
    static Font helveticaBold16 = new Font(helvetica, 16, Font.BOLD);


    private String title;
    private PositonOfInvoice[] services;
    private Person buyer;
    private Person dealer;

    public Facture(String title, Person dealer, Person buyer, PositonOfInvoice[] services) {
        this.title = title;
        this.services = services;
        this.buyer = buyer;
        this.dealer = dealer;
    }

    public void createDocument(String path) throws FileNotFoundException, DocumentException {
        Document document = new Document();

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();

        //dodanie tytułu
        Paragraph title = new Paragraph(this.title, helveticaBold16);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        //dodanie sprzedawcy
        document.add(new Paragraph("From:", helveticaBold12));
        document.add(new Paragraph(dealer.getName(),helvetica12));
        document.add(new Paragraph(dealer.getAddress(),helvetica12));
        document.add(new Paragraph("nip: "+dealer.getNip(),helvetica12));
        //dodanie kupca
        document.add(new Paragraph("To:", helveticaBold12));
        document.add(new Paragraph(buyer.getName(),helvetica12));
        document.add(new Paragraph(buyer.getAddress(),helvetica12));
        document.add(new Paragraph("nip: "+buyer.getNip(),helvetica12));
        //dodanie tabelki z usuługami i produktami
        document.add(getTableOfInvoicePositons());
        //dodanie TotalPrice
        document.add(new Paragraph("Total Price: "+getTotalPrice()+" zł", helvetica16));


        document.close();
        writer.close();
    }

    private double getTotalPrice(){
        double sume = 0;
        for (PositonOfInvoice elem: services
        ) {
            sume+= elem.getPrice();
        }
        return sume;
    }

    private PdfPTable getTableOfInvoicePositons() throws DocumentException {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(105);
        table.setSpacingBefore(11f);
        table.setSpacingAfter(11f);

        float[] colWidth = {2f, 2f};
        table.setWidths(colWidth);

        Paragraph nameHeader = new Paragraph("Service/Product", helveticaBold12);
        nameHeader.setIndentationRight(20);

        Paragraph priceHeader = new Paragraph("Price", helveticaBold12);
        nameHeader.setAlignment(Element.ALIGN_CENTER);

        PdfPCell c1 = new PdfPCell(nameHeader);
        PdfPCell c2 = new PdfPCell(priceHeader);
        table.addCell(c1);
        table.addCell(c2);

        for (PositonOfInvoice elem: services
             ) {

            table.addCell(new PdfPCell(new Paragraph(elem.getName(), helvetica12)));
            table.addCell(new PdfPCell(new Paragraph(elem.getPrice()+"", helvetica12)));
        }

        return table;
    }
}
