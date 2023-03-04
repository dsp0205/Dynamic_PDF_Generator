package com.example.dynamicpdf.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PdfFileServiceTest {

    @Autowired
    private PdfFileService pdfFileService;

    @Test
    void testCreatePdf() throws IOException {
        // Create PDF file
        pdfFileService.createPdf();

        // Check if the PDF file exists
        File file = new File("C:/Users/deepp/OneDrive/Desktop/Pdf/SamplePdf.pdf");
        assertTrue(file.exists());

        // Check if the PDF file has a non-zero size
        assertTrue(file.length() > 0);

        // Delete the PDF file
        file.delete();
    }

}
