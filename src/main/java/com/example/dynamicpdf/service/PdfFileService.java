package com.example.dynamicpdf.service;

import java.io.FileNotFoundException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;

import com.itextpdf.layout.element.Cell;

import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;


import org.springframework.stereotype.Service;

@Service
public class PdfFileService {

    public void createPdf() {
        String filePdf = "C:/Users/deepp/OneDrive/Desktop/Pdf/SamplePdf.pdf";
        try {

            PdfWriter writer = new PdfWriter(filePdf);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            Paragraph p1 = new Paragraph("Invoice");
            p1.setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER);
            document.add(p1);

            // Create table for seller and buyer information
            Table table = new Table(UnitValue.createPercentArray(new float[]{50, 50}));
            table.setWidth(UnitValue.createPercentValue(100));
            
                        

            // Add seller and buyer information
            table.addCell(new Cell().add(new Paragraph("Seller:")));
            table.addCell(new Cell().add(new Paragraph("Buyer:")));
            table.addCell(new Cell().add(new Paragraph("XYZ Pvt. Ltd.\nNew Delhi, India\nGSTIN: 29AABBCCDD121ZD")));
            table.addCell(new Cell().add(new Paragraph("Vedant Computers\nNew Delhi, India\nGSTIN: 29AABBCCDD131ZD")));
            
            // Add vertical line between columns
            table.addCell(new Cell().setBorder(Border.NO_BORDER));
            table.setBorder(new SolidBorder(1));

            // Add the seller and buyer information table to the document
            document.add(table);

            // Add items information
            Table itemsTable = new Table(UnitValue.createPercentArray(new float[]{25, 25, 25, 25}));
            itemsTable.setWidth(UnitValue.createPercentValue(100));
            itemsTable.setBorder(new SolidBorder(1));
            

            // Add table headers
            itemsTable.addCell(new Paragraph("Item").setTextAlignment(TextAlignment.CENTER).setWidth(180));
            itemsTable.addCell(new Paragraph("Quantity").setTextAlignment(TextAlignment.CENTER));
            itemsTable.addCell(new Paragraph("Rate").setTextAlignment(TextAlignment.CENTER));
            itemsTable.addCell(new Paragraph("Amount").setTextAlignment(TextAlignment.CENTER));

            // Add table data
            itemsTable.addCell("Product 1");
            itemsTable.setTextAlignment(TextAlignment.CENTER);
            itemsTable.addCell("12 Nos");
            itemsTable.setTextAlignment(TextAlignment.CENTER);
            itemsTable.addCell("123.00");
            itemsTable.setTextAlignment(TextAlignment.CENTER);
            itemsTable.addCell("1476.00");
            itemsTable.setTextAlignment(TextAlignment.CENTER);

            document.add(itemsTable);

            document.close();
            System.out.println("PDF file generated successfully.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
