package com.dagim.rs.utility;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.Document;
import com.itextpdf.text.List;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextPdfView extends AbstractITextPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, 
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
    	List list = new List();
        PdfPTable table = new PdfPTable(3);
        table.setWidths(new int[]{25, 30, 30});
        table.addCell("PNR");
        table.addCell("No of Seats");
        table.addCell("User");
        table.addCell(String.valueOf(model.get("pnr")));
        table.addCell(String.valueOf(model.get("noOfSeats")));
        table.addCell(String.valueOf(model.get("Agent Name")));
        document.addTitle("iTravel Flight Booking Ticket");
        document.addSubject("iTravel Flight Booking Ticket"+"\nEnjoy your Flight!");
        list.add(new Date().toString());
        list.add("Payee: ");
        list.add("Flight Number: ");
        list.add("Departure: ");
        list.add("Destination: ");
        list.add("\n");
        document.add(list);
        document.add(table);

    }

}