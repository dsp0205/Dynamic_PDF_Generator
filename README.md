# Dynamic PDF Generation

Dynamic PDF Generator is a Spring Boot Application with REST API which accepts data and generate a PDF based on the received data. This application has the ability to download the generated PDF.

## API Reference to Generate the PDF

```http
  GET http://localhost:8081/samplePdf 
```

#### Input format
```json
{
   "seller": "XYZ Pvt. Ltd.",
   "sellerGstin": "29AABBCCDD121ZD",
   "sellerAddress": "New Delhi, India",
   "buyer": "Vedant Computers",
   "buyerGstin": "29AABBCCDD131ZD",
   "buyerAddress": "New Delhi, India",
   "items": 
   [      
      {
         "name": "Product 1",
         "quantity": "12 Nos",
         "rate": 123,
         "amount": 1476
      }
   ]
}
```
