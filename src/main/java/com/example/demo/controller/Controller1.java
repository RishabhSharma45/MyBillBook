package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Entity.Bill;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.StoredProducts;
import com.example.demo.Entity.ProductDetails;
import com.example.demo.Entity.StoredProducts;
import com.itextpdf.io.exceptions.IOException;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class Controller1 {
	
	private Bill bill;
	
	@GetMapping("/")
	public String myBillBook(Model model) {
		model.addAttribute("bill", new Bill());
		return "mybillbook";
	}
	
	@PostMapping("/bill")
	public String myBillBook2(@ModelAttribute("bill") Bill bill , Model model) {
		this.bill=bill;
		System.out.println(bill);
		model.addAttribute("product", new Product());
		
		return "addproducts";
	}
	
	@PostMapping("/submit")
	public String Submit(@ModelAttribute("product") Product product, Model model) {
		this.bill.getProducts().add(product);
		 model.addAttribute("bill", this.bill); 
		 model.addAttribute("product", new Product());
		System.out.println(bill);
		System.out.println(product);
		ProductDetails p = new StoredProducts().getProductDetails(product.getProductname());
		
		product.setProductname(p.getProductname());
		product.setPack(p.getPack());
		product.setBatch(p.getBatch());
		product.setExpiry(p.getExpiry());
		product.setHsn(p.getHsn());
		product.setMrp(p.getMrp());
		product.setCd(p.getCd());
		product.setSd(p.getSd());
		System.out.println(product.getBatch());
		
		return "addproducts";
	}
	
	 @GetMapping("/finalBill")
	    public String finalBill(Model model) {
	        model.addAttribute("bill", this.bill);
	        return "finalBill";
	    }
	 
	 @GetMapping("/remove/{index}")
		public String remove(@PathVariable int index,@ModelAttribute("product") Product product, Model model) {
		   if (index >= 0 && index < this.bill.getProducts().size()) {
		        this.bill.getProducts().remove(index);
		    }
			 model.addAttribute("bill", this.bill); 
			 model.addAttribute("product", new Product());
			System.out.println(bill);
			System.out.println(product);
			
			return "addproducts";
		}
	 
	 
	/* @GetMapping("/generatePdf")
	 public void generatePdf(HttpServletResponse response) throws IOException, java.io.IOException {
	     response.setContentType("application/pdf");
	     response.setHeader("Content-Disposition", "attachment; filename=final_bill.pdf");
	     
	     PdfWriter writer = new PdfWriter(response.getOutputStream());
	     PdfDocument pdfDoc = new PdfDocument(writer);
	     pdfDoc.setDefaultPageSize(PageSize.A4);
	     Document document = new Document(pdfDoc);
	     
	     // Title
	     Paragraph title = new Paragraph("Final Bill")
	             .setFontSize(24)
	             .setBold()
	             .setTextAlignment(TextAlignment.CENTER);
	     document.add(title);

	     // Customer Information Section
	     document.add(new Paragraph("Customer Information").setFontSize(18).setBold());
	     document.add(new Paragraph("Name: " + bill.getCustomer()));
	     document.add(new Paragraph("Address: " + bill.getAddress()));
	     document.add(new Paragraph("Date: " + bill.getDate()));

	     // Product Table Header
	     document.add(new Paragraph("\nProducts").setFontSize(18).setBold());
	     Table table = new Table(new float[] { 2, 2, 2, 2, 2, 2, 2, 2, 2 });
	     table.setWidth(100);
	     
	     // Table Headers
	     table.addHeaderCell(new Cell().add(new Paragraph("Product Name").setBold()));
	     table.addHeaderCell(new Cell().add(new Paragraph("Batch").setBold()));
	     table.addHeaderCell(new Cell().add(new Paragraph("Expiry").setBold()));
	     table.addHeaderCell(new Cell().add(new Paragraph("HSN").setBold()));
	     table.addHeaderCell(new Cell().add(new Paragraph("MRP").setBold()));
	     table.addHeaderCell(new Cell().add(new Paragraph("Rate").setBold()));
	     table.addHeaderCell(new Cell().add(new Paragraph("Quantity").setBold()));
	     table.addHeaderCell(new Cell().add(new Paragraph("CD").setBold()));
	     table.addHeaderCell(new Cell().add(new Paragraph("Amount").setBold()));
	     
	     // Adding Product Rows
	     for (Product product : bill.getProducts()) {
	         table.addCell(new Cell().add(new Paragraph(product.getProductname())));
	         table.addCell(new Cell().add(new Paragraph(product.getBatch())));
	         table.addCell(new Cell().add(new Paragraph(product.getExpiry())));
	         table.addCell(new Cell().add(new Paragraph(product.getHsn())));
	         table.addCell(new Cell().add(new Paragraph(String.valueOf(product.getMrp()))));
	         table.addCell(new Cell().add(new Paragraph(String.valueOf(product.getRate()))));
	         table.addCell(new Cell().add(new Paragraph(String.valueOf(product.getQuantity()))));
	         table.addCell(new Cell().add(new Paragraph(String.valueOf(product.getCd()))));
	         table.addCell(new Cell().add(new Paragraph(String.valueOf(product.getAmount()))));
	     }

	     document.add(table);

	     // Summary Table for Subtotal, GST, and Grand Total
	     Table summaryTable = new Table(2).setMarginTop(20);
	     summaryTable.addCell(new Cell().add(new Paragraph("Subtotal").setBold()));
	     summaryTable.addCell(new Cell().add(new Paragraph(String.valueOf(bill.subTotal()))));
	     
	     summaryTable.addCell(new Cell().add(new Paragraph("GST (18%)").setBold()));
	     summaryTable.addCell(new Cell().add(new Paragraph(String.valueOf(bill.gst()))));

	     summaryTable.addCell(new Cell().add(new Paragraph("Grand Total").setBold())
	             .setBackgroundColor(ColorConstants.LIGHT_GRAY));
	     summaryTable.addCell(new Cell().add(new Paragraph(String.valueOf(bill.grandTotal())))
	             .setBackgroundColor(ColorConstants.LIGHT_GRAY));
	     
	     document.add(summaryTable);

	     document.close();
	 }*/
	 
	 
	 @GetMapping("/generatePdf")
	 public void generatePdf1(HttpServletResponse response) throws IOException, java.io.IOException {
		 String name = bill.getCustomer() + bill.getDate()+".pdf";
				 response.setContentType("application/pdf");
	     response.setHeader("Content-Disposition", "attachment; filename=\""+name+"\"");

	     PdfWriter writer = new PdfWriter(response.getOutputStream());
	     PdfDocument pdfDoc = new PdfDocument(writer);
	     pdfDoc.setDefaultPageSize(PageSize.A4);
	     Document document = new Document(pdfDoc);

	     // Header Section with Business Name and Address
	     document.add(new Paragraph("RAM MEDICAL AGENCY").setBold().setFontSize(14).setTextAlignment(TextAlignment.CENTER));
	     document.add(new Paragraph("SHOP NO.14 , DRUG MARKET NEAR NADRA BUS STAND BHOPAL").setFontSize(10).setTextAlignment(TextAlignment.CENTER));
	     document.add(new Paragraph("PHONE: 0755-245110, MOB NO.: 7999077213").setFontSize(10).setTextAlignment(TextAlignment.CENTER));
	     document.add(new Paragraph("E-MAIL: RAMMEDICALAGENCY@gmail.com").setFontSize(10).setTextAlignment(TextAlignment.CENTER));

	     // License Details
	     Table licenseTable = new Table(new float[]{4, 4, 2, 2}).setWidth(UnitValue.createPercentValue(100));
	     licenseTable.addCell(new Cell().add(new Paragraph("D.L. NO.: 20/664/29/2020").setFontSize(10)).setBorder(null));
	     licenseTable.addCell(new Cell().add(new Paragraph("GSTIN: 23BVNPP0920J1ZZ").setFontSize(10)).setBorder(null));
	     licenseTable.addCell(new Cell().add(new Paragraph("GST INVOICE").setBold().setFontSize(10)).setBorder(null));
	     licenseTable.addCell(new Cell().add(new Paragraph("DATE " + bill.getDate()).setFontSize(10)).setBorder(null));
	     document.add(licenseTable);
	     
	    
	     document.add(new Paragraph("M/S: " + bill.getCustomer()));
	     document.add(new Paragraph("Address: " + bill.getAddress()));
	     document.add(new Paragraph("Date: " + bill.getDate()));
	     
	     // Product Table Header
	     
	     Table table = new Table(new float[] { 3,1, 1, 1, 1, 1, 1, 1, 1, 1 }).setWidth(UnitValue.createPercentValue(100));
	     
	     // Table Headers
	     table.addHeaderCell(new Cell().add(new Paragraph("Product Name").setBold().setFontSize(10)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
	     table.addHeaderCell(new Cell().add(new Paragraph("Pack").setBold().setFontSize(10)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
	     table.addHeaderCell(new Cell().add(new Paragraph("Batch").setBold().setFontSize(10)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
	     table.addHeaderCell(new Cell().add(new Paragraph("Expiry").setBold().setFontSize(10)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
	     table.addHeaderCell(new Cell().add(new Paragraph("HSN").setBold().setFontSize(10)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
	     table.addHeaderCell(new Cell().add(new Paragraph("MRP").setBold().setFontSize(10)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
	     table.addHeaderCell(new Cell().add(new Paragraph("Rate").setBold().setFontSize(10)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
	     table.addHeaderCell(new Cell().add(new Paragraph("Quantity").setBold().setFontSize(10)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
	     table.addHeaderCell(new Cell().add(new Paragraph("CD").setBold().setFontSize(10)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
	     table.addHeaderCell(new Cell().add(new Paragraph("Amount").setBold().setFontSize(10)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
	     
	     // Adding Product Rows
	     for (Product product : bill.getProducts()) {
	         table.addCell(new Cell().add(new Paragraph(product.getProductname()).setFontSize(9)));
	         table.addCell(new Cell().add(new Paragraph(product.getPack()).setFontSize(9)));
	         table.addCell(new Cell().add(new Paragraph(product.getBatch()).setFontSize(9)));
	         table.addCell(new Cell().add(new Paragraph(product.getExpiry()).setFontSize(9)));
	         table.addCell(new Cell().add(new Paragraph(product.getHsn()).setFontSize(9)));
	         table.addCell(new Cell().add(new Paragraph(String.valueOf(product.getMrp())).setFontSize(9)));
	         table.addCell(new Cell().add(new Paragraph(String.valueOf(product.getRate())).setFontSize(9)));
	         table.addCell(new Cell().add(new Paragraph(product.getScheme()).setFontSize(9)));
	         table.addCell(new Cell().add(new Paragraph(String.valueOf(product.getCd())).setFontSize(9)));
	         table.addCell(new Cell().add(new Paragraph(String.valueOf(product.getAmount())).setFontSize(9)));
	     }

	     document.add(table);
	     
	     document.add(new Paragraph("\n"));
	     
	     

	     // Subtotal, GST, and Total Section
	     Table totalTable = new Table(new float[]{10, 2}).setWidth(UnitValue.createPercentValue(100));
	     totalTable.addCell(new Cell().add(new Paragraph("SUB TOTAL").setBold().setFontSize(10)));
	     totalTable.addCell(new Cell().add(new Paragraph(String.valueOf(bill.subTotal())).setFontSize(10)));

	     totalTable.addCell(new Cell().add(new Paragraph("GST").setBold().setFontSize(10)));
	     totalTable.addCell(new Cell().add(new Paragraph(String.valueOf(bill.gst())).setFontSize(10)));

	     totalTable.addCell(new Cell().add(new Paragraph("GRAND TOTAL").setBold().setFontSize(10).setBackgroundColor(ColorConstants.LIGHT_GRAY)));
	     totalTable.addCell(new Cell().add(new Paragraph(String.valueOf(bill.grandTotal())).setFontSize(10).setBackgroundColor(ColorConstants.LIGHT_GRAY)));
	     document.add(totalTable);

	     // Amount in Words Section
	     document.add(new Paragraph("AMOUNT IN WORDS : --------")
	             .setFontSize(10).setMarginTop(10));

	     // Bank Details and Remarks
	     document.add(new Paragraph("PRICE DIFFERENCE UNDER PRICE CONTROL ORDER 1970 WILL BE REFUNDED E&O.E").setFontSize(8));
	     document.add(new Paragraph("NEFT: BANK OF INDIA A/C 94250311000005 IFC BKID009425").setFontSize(8));
	     document.add(new Paragraph("REMARK: BY HAND MR").setFontSize(8));

	     // Authorized Signature
	     document.add(new Paragraph("AUTHORIZED SIGNATURE").setBold().setFontSize(10).setTextAlignment(TextAlignment.RIGHT));

	     document.close();
	    
	 }

	 
	}
