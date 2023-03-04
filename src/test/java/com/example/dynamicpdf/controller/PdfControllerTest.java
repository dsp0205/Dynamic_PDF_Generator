package com.example.dynamicpdf.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.example.dynamicpdf.service.PdfFileService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PdfController.class)
public class PdfControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PdfFileService pdfFileService;

    @Test
    public void testGetPdfFile() throws Exception {
        mockMvc.perform(get("/samplePdf"))
                .andExpect(status().isOk())
                .andExpect(view().name("getPdf"));
    }

    @Test
    public void testPdfFile() throws Exception {
        mockMvc.perform(get("/createPdf"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/samplePdf"));
        // Verify that the PdfFileService was called
        verify(pdfFileService, times(1)).createPdf();
    }
}
