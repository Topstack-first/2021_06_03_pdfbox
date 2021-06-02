package com.example.simplerestapis.services;

import org.apache.commons.lang3.text.WordUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Service;

import java.awt.Color;
import java.io.IOException;

@Service
public class PDFBoxService {

    public final static PDFont BOLD = PDType1Font.HELVETICA_BOLD;
    public final static PDFont PLAIN = PDType1Font.HELVETICA;
    private float Y;
    public final static int X = 0;

    public PDDocument getPersonalDocument() {
        try {
            
            PDDocument document = new PDDocument();
            
            PDPage page = new PDPage();
            
            
            document.addPage(page);
            Y = 725;
            
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            drawImage("src/images/logo.png", 25, 230, 70, document, contentStream);
            addPageSignature("Page 1",contentStream);
            
            drawRectangle(Color.BLACK, 350, Y + 15,300,1,contentStream);
            drawRectangle(Color.BLACK, 350, Y - 5,300,1,contentStream);
            drawRectangle(Color.BLACK, 350, Y - 25,300,1,contentStream);
            
            addMyText("(carrier)",355, 20, 10, contentStream, PLAIN);
            addMyText("Effective",505, 20, 10, contentStream, PLAIN);
            
            addMyText("(product)",355, 0, 10, contentStream, PLAIN);
            addMyText("12/13/2020",505, 0, 10, contentStream, PLAIN);
            
            addMyText("(product type)",355,- 20, 10, contentStream, PLAIN);
            
            drawRectangle(new Color(254,209,9), 0, Y - 37,800,4,contentStream);
            
            drawRectangle(new Color(203,232,128), 0, Y - 58,800,15,contentStream);
            drawRectangle(new Color(203,232,128), 0, Y - 132,800,15,contentStream);
            drawRectangle(new Color(203,232,128), 0, Y - 200,800,15,contentStream);
            drawRectangle(new Color(203,232,128), 0, Y - 270,800,15,contentStream);
            
            addMyText("Product Specifications",250, - 54, 11, contentStream, PLAIN);
            addMyText("Riders",290, - 128, 11, contentStream, PLAIN);
            addMyText("State Availability",275, - 196, 11, contentStream, PLAIN);
            addMyText("Current Rates (Effective:\"effective date\")",210, - 266, 11, contentStream, PLAIN);
            
            int posFirstParagh = -65;
            addMyText("Financial Ratings",3, posFirstParagh, 8, contentStream, PLAIN);
            
            addMyText("Issue Age Min",230, posFirstParagh, 8, contentStream, PLAIN);
            addMyText("Issue Age Max",230, posFirstParagh - 10, 8, contentStream, PLAIN);
            addMyText("Account Type (Advisory / Brokerage)",230, posFirstParagh - 20, 8, contentStream, PLAIN);
            addMyText("Surrender Change:",230, posFirstParagh-30, 8, contentStream, PLAIN);
            addMyText("Minimum Premium:  ",230, posFirstParagh-40, 8, contentStream, PLAIN);
            addMyText("Maximum Premium:  ",230, posFirstParagh-50, 8, contentStream, PLAIN);
            
            addMyText("MVA",420, posFirstParagh, 8, contentStream, PLAIN);
            addMyText("ROP",420, posFirstParagh-10, 8, contentStream, PLAIN);
            addMyText("Premium Bonus",420, posFirstParagh-20, 8, contentStream, PLAIN);
            addMyText("Interest Bonus",420, posFirstParagh-30, 8, contentStream, PLAIN);
            
            addMyText("\"Yes/No\"",535, posFirstParagh, 8, contentStream, PLAIN);
            addMyText("\"Yes/No\"",535, posFirstParagh-10, 8, contentStream, PLAIN);
            addMyText("\"Yes/No\"",535, posFirstParagh-20, 8, contentStream, PLAIN);
            addMyText("\"Yes/No\"",535, posFirstParagh-30, 8, contentStream, PLAIN);
            
            int posSecondParagh = - 141;
            
            addMyText("Rider Name",3, posSecondParagh, 8, contentStream, BOLD);
            
            addMyText("Rider Type",285, posSecondParagh, 8, contentStream, BOLD);
            addMyText("(GLWB/GMWB)",285, posSecondParagh-10, 8, contentStream, PLAIN);
            
            addMyText("Rider Cost",445, posSecondParagh, 8, contentStream, BOLD);
            
            int posThirdParagh = -211;
            addMyText("AL         AK         AZ         AR         CA         CO         CT         DE         DC         FL         GA         HI         ID         IL         IN         IA         KS         KY         ME         MD",3, posThirdParagh, 8, contentStream, BOLD);
            addMyText("MA         MI         MN         MS        MP         MT         NE         NV         NH         NJ         NM         NC       ND       OH       OK        OR        PA         RI          SC        SD",3, posThirdParagh - 10, 8, contentStream, BOLD);
            addMyText("TN         UT         VT         VA         WA         WV         WI         WY         GU         PR         VI",3, posThirdParagh - 20, 8, contentStream, BOLD);
            
            int posForthPara = -291;
            addMyText("Premium Band  (ex. $0 - $99,999)",3, posForthPara, 8, contentStream, PLAIN);
            addMyText("Index",3, posForthPara - 10, 8, contentStream, BOLD);
            addMyText("Term / Guarantee Term",200, posForthPara - 10, 8, contentStream, BOLD);
            addMyText("Crediting Strategy",300, posForthPara - 10, 8, contentStream, BOLD);
            addMyText("Rate Type",400, posForthPara - 10, 8, contentStream, BOLD);
            addMyText("Rate",500, posForthPara - 10, 8, contentStream, BOLD);
            
            int posLastPara = -400;
            addMyText("Premium Band (ex. $100,000+)",3, posLastPara, 8, contentStream, PLAIN);
            addMyText("Index",3, posLastPara - 10, 8, contentStream, BOLD);
            addMyText("Term / Guarantee Term",200, posLastPara - 10, 8, contentStream, BOLD);
            addMyText("Crediting Strategy",300, posLastPara - 10, 8, contentStream, BOLD);
            addMyText("Rate Type",400, posLastPara - 10, 8, contentStream, BOLD);//Cap Rate, Par Rate, Spread, Performance Trigger Credit, Fixed Rate
            addMyText("Rate",500, posLastPara - 10, 8, contentStream, BOLD);
            
            addMyText("Disclosure",290, -650, 9, contentStream, PLAIN);
            
            contentStream.close();
            return document;
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        return new PDDocument();
    }
    public PDDocument getPersonalDocument2() {
        try {
            
            PDDocument document = new PDDocument();
            
            PDPage page = new PDPage();
            
            
            document.addPage(page);
            Y = 725;
            
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            drawImage("src/images/logo.png", 25, 230, 70, document, contentStream);
            addPageSignature("Page 1",contentStream);
            
            drawRectangle(Color.BLACK, 350, Y + 15,300,1,contentStream);
            drawRectangle(Color.BLACK, 350, Y - 5,300,1,contentStream);
            drawRectangle(Color.BLACK, 350, Y - 25,300,1,contentStream);
            
            addMyText("(carrier)",355, 20, 10, contentStream, PLAIN);
            addMyText("Effective",505, 20, 10, contentStream, PLAIN);
            
            addMyText("(product)",355, 0, 10, contentStream, PLAIN);
            addMyText("12/13/2020",505, 0, 10, contentStream, PLAIN);
            
            addMyText("(product type)",355,- 20, 10, contentStream, PLAIN);
            
            drawRectangle(new Color(254,209,9), 0, Y - 37,800,4,contentStream);
            
            drawRectangle(new Color(203,232,128), 0, Y - 58,800,15,contentStream);
            drawRectangle(new Color(203,232,128), 0, Y - 132,800,15,contentStream);
            drawRectangle(new Color(203,232,128), 0, Y - 200,800,15,contentStream);
            drawRectangle(new Color(203,232,128), 0, Y - 270,800,15,contentStream);
            
            addMyText("Product Specifications",250, - 54, 11, contentStream, PLAIN);
            addMyText("Riders",290, - 128, 11, contentStream, PLAIN);
            addMyText("State Availability",275, - 196, 11, contentStream, PLAIN);
            addMyText("Current Rates (Effective:\"effective date\")",210, - 266, 11, contentStream, PLAIN);
            
            int posFirstParagh = -65;
            addMyText("Financial Ratings",3, posFirstParagh, 8, contentStream, PLAIN);
            
            addMyText("Issue Age Min",230, posFirstParagh, 8, contentStream, PLAIN);
            addMyText("Issue Age Max",230, posFirstParagh - 10, 8, contentStream, PLAIN);
            addMyText("Account Type (Advisory / Brokerage)",230, posFirstParagh - 20, 8, contentStream, PLAIN);
            addMyText("Surrender Change:",230, posFirstParagh-30, 8, contentStream, PLAIN);
            addMyText("Minimum Premium:  ",230, posFirstParagh-40, 8, contentStream, PLAIN);
            addMyText("Maximum Premium:  ",230, posFirstParagh-50, 8, contentStream, PLAIN);
            
            addMyText("MVA",420, posFirstParagh, 8, contentStream, PLAIN);
            addMyText("ROP",420, posFirstParagh-10, 8, contentStream, PLAIN);
            addMyText("Premium Bonus",420, posFirstParagh-20, 8, contentStream, PLAIN);
            addMyText("Interest Bonus",420, posFirstParagh-30, 8, contentStream, PLAIN);
            
            addMyText("\"Yes/No\"",535, posFirstParagh, 8, contentStream, PLAIN);
            addMyText("\"Yes/No\"",535, posFirstParagh-10, 8, contentStream, PLAIN);
            addMyText("\"Yes/No\"",535, posFirstParagh-20, 8, contentStream, PLAIN);
            addMyText("\"Yes/No\"",535, posFirstParagh-30, 8, contentStream, PLAIN);
            
            int posSecondParagh = - 141;
            
            addMyText("Rider Name",3, posSecondParagh, 8, contentStream, BOLD);
            
            addMyText("Rider Type",285, posSecondParagh, 8, contentStream, BOLD);
            addMyText("(GLWB/GMWB)",285, posSecondParagh-10, 8, contentStream, PLAIN);
            
            addMyText("Rider Cost",445, posSecondParagh, 8, contentStream, BOLD);
            
            int posThirdParagh = -211;
            addMyText("AL         AK         AZ         AR         CA         CO         CT         DE         DC         FL         GA         HI         ID         IL         IN         IA         KS         KY         ME         MD",3, posThirdParagh, 8, contentStream, BOLD);
            addMyText("MA         MI         MN         MS        MP         MT         NE         NV         NH         NJ         NM         NC       ND       OH       OK        OR        PA         RI          SC        SD",3, posThirdParagh - 10, 8, contentStream, BOLD);
            addMyText("TN         UT         VT         VA         WA         WV         WI         WY         GU         PR         VI",3, posThirdParagh - 20, 8, contentStream, BOLD);
            
            int posForthPara = -291;
            addMyText("Premium Band  (ex. $0 - $99,999)",3, posForthPara, 8, contentStream, PLAIN);
            addMyText("Index",3, posForthPara - 10, 8, contentStream, BOLD);
            addMyText("Term / Guarantee Term",200, posForthPara - 10, 8, contentStream, BOLD);
            addMyText("Crediting Strategy",300, posForthPara - 10, 8, contentStream, BOLD);
            addMyText("Rate Type",400, posForthPara - 10, 8, contentStream, BOLD);
            addMyText("Rate",450, posForthPara - 10, 8, contentStream, BOLD);
            addMyText("Floor",500, posForthPara - 10, 8, contentStream, BOLD);
            addMyText("Buffer",550, posForthPara - 10, 8, contentStream, BOLD);
            
            int posLastPara = -400;
            addMyText("Premium Band (ex. $100,000+)",3, posLastPara, 8, contentStream, PLAIN);
            addMyText("Index",3, posLastPara - 10, 8, contentStream, BOLD);
            addMyText("Term / Guarantee Term",200, posLastPara - 10, 8, contentStream, BOLD);
            addMyText("Crediting Strategy",300, posLastPara - 10, 8, contentStream, BOLD);
            addMyText("Rate Type",400, posLastPara - 10, 8, contentStream, BOLD);//Cap Rate, Par Rate, Spread, Performance Trigger Credit, Fixed Rate
            addMyText("Rate",450, posLastPara - 10, 8, contentStream, BOLD);
            addMyText("Floor",500, posLastPara - 10, 8, contentStream, BOLD);
            addMyText("Buffer",550, posLastPara - 10, 8, contentStream, BOLD);
            
            addMyText("Disclosure",290, -650, 9, contentStream, PLAIN);
            
            contentStream.close();
            return document;
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        return new PDDocument();
    }

    private void drawImage(String path, float y, float width, float height, PDDocument document, PDPageContentStream contentStream) throws IOException {
        PDImageXObject image = PDImageXObject.createFromFile(path, document);

        contentStream.drawImage(image, X, Y - y, width, height);
    }
    private void addPageSignature(String text, PDPageContentStream contentStream) throws IOException {
        
    		
            contentStream.beginText();
            contentStream.setFont(BOLD, 52);
            contentStream.setNonStrokingColor(Color.LIGHT_GRAY);
            contentStream.newLineAtOffset(225, Y - 325);
            contentStream.showText(text);
            contentStream.endText();
    }


    private void drawRectangle(Color color, float x,float y,float width,float height, PDPageContentStream contentStream) throws IOException
    {
    	contentStream.setNonStrokingColor(color);
    	contentStream.addRect(x,y,width,height);  
    	contentStream.fill();
    }
    private void addMyText(String text,float x, float y,int fontSize, PDPageContentStream contentStream, PDFont font) throws IOException {
        
        contentStream.beginText();
        contentStream.setFont(font, fontSize);
        contentStream.setNonStrokingColor(Color.BLACK);
        contentStream.newLineAtOffset(x, Y + y);
        contentStream.showText(text);
        contentStream.endText();
    }
    

}
