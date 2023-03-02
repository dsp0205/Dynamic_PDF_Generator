package com.example.dynamicpdf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.dynamicpdf.service.PdfFileService;

@Controller
public class PdfController {

    private PdfFileService pdfFileService;

    @Autowired
    private PdfController(PdfFileService pdfFileService) {
        this.pdfFileService = pdfFileService;
    }

    
    @GetMapping("/samplePdf")
    public String getPdfFile(){
        return "getPdf";
    }

    @GetMapping("/createPdf")
    public String pdfFile(){
        pdfFileService.createPdf();
        return "redirect:/samplePdf";
    }
}
