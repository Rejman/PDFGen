package com.rejman;

import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {

        PositonOfInvoice[] list ={
                new PositonOfInvoice("test",10),
                new PositonOfInvoice("Robota", 300)
        };

        Person dealer = new Person("Jakas firma", "35-234 Rejtana 44, Rzeszow", "346346543");
        Person buyer = new Person("Jakas kupiec", "45-756 Krakowska 7, Kielce", "846384564");
        Invoice newInvoice = new Invoice("Faktura 01",dealer,buyer, list);
        newInvoice.createDocument("sample1.pdf");
    }
}
