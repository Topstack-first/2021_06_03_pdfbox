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
import java.util.ArrayList;
import java.util.List;

@Service
public class PDFBoxService {

    public final static PDFont BOLD = PDType1Font.HELVETICA_BOLD;
    public final static PDFont PLAIN = PDType1Font.HELVETICA;
    private float Y;
    public final static int X = 0;

    public class Rider
    {
    	public String name;
    	public String type;
    	public float cost;
    	public Rider(String _name, String _type, float _cost)
    	{
    		name = _name;
    		type = _type;
    		cost = _cost;
    	}
    }
    public class Rate
    {
    	public String index;
    	public String term;
    	public String strategy;
    	public String type;
    	public float rate;
    	public Rate(String _index, String _term,String _strategy, String _type , float _rate)
    	{
    		index = _index;
    		term = _term;
    		strategy = _strategy;
    		type = _type;
    		rate = _rate;
    	}
    }
    public int riderNumPerPage = 3;
    public int rateNumPerPage = 8;
    
    public List<Rider> riders = new ArrayList<Rider>(
    		List.of(
    				new Rider(new String("Protected Income Value"), new String("GLWB"), 0.013f),
    				new Rider(new String("360 Benefit"), new String("GMWB"), 0.01f),
    				new Rider(new String("Ufetime Income Plus Flex"), new String("GLWB"), 0.0095f),
    				new Rider(new String("STAIR"), new String("GMWB"), 0.013f),
    				new Rider(new String("Protected Income Value"), new String("GLWB"), 0f),
    				new Rider(new String("Protected Income Value"), new String("GLWB"), 0.013f),
    				new Rider(new String("360 Benefit"), new String("GMWB"), 0.01f),
    				new Rider(new String("Ufetime Income Plus Flex"), new String("GLWB"), 0.0095f),
    				new Rider(new String("STAIR"), new String("GMWB"), 0.013f),
    				new Rider(new String("Protected Income Value"), new String("GLWB"), 0f),
    				new Rider(new String("Protected Income Value"), new String("GLWB"), 0.013f),
    				new Rider(new String("360 Benefit"), new String("GMWB"), 0.01f),
    				new Rider(new String("Ufetime Income Plus Flex"), new String("GLWB"), 0.0095f),
    				new Rider(new String("STAIR"), new String("GMWB"), 0.013f),
    				new Rider(new String("Protected Income Value"), new String("GLWB"), 0f),
    				new Rider(new String("Protected Income Value"), new String("GLWB"), 0.013f),
    				new Rider(new String("360 Benefit"), new String("GMWB"), 0.01f),
    				new Rider(new String("Ufetime Income Plus Flex"), new String("GLWB"), 0.0095f),
    				new Rider(new String("STAIR"), new String("GMWB"), 0.013f),
    				new Rider(new String("Protected Income Value"), new String("GLWB"), 0f)
    		));
    public List<Rate> ratesSmall = new ArrayList<Rate>(
    		List.of(
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return1"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return2"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return3"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return4"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return5"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return6"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return7"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return8"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return9"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return10"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return11"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return12"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return13"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return14"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return15"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return16"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return17"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return18"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return19"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return20"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return21"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return22"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return23"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return24"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return25"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f)
    		));
    public List<Rate> ratesHigh = new ArrayList<Rate>(
    		List.of(
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return1"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return2"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return3"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return4"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return5"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return6"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return7"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return8"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return9"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return10"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return11"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return12"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return13"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return14"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return15"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return16"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return17"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return18"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f),
    				new Rate(new String("Citi Flexible Allocation 6 Excess Return19"),new String("2 year"), new String("Point-to-Point"),new String("Buffer"), 0.013f)
    		));
    public int riderPageNum = - Math.floorDiv(- this.riders.size(),this.riderNumPerPage) ;
    public int rateSmallPageNum = - Math.floorDiv(- this.ratesSmall.size(),this.rateNumPerPage) ;
    public int rateHighPageNum = - Math.floorDiv(- this.ratesHigh.size(),this.rateNumPerPage) ;
    
    public PDDocument getPersonalDocument() {
        try {
            
            PDDocument document = new PDDocument();
            
            int totalPageNum = rateSmallPageNum > rateHighPageNum ? rateSmallPageNum:rateHighPageNum;
            totalPageNum = totalPageNum > riderPageNum ? totalPageNum : riderPageNum;
            
            for(int currentPage = 0;currentPage < totalPageNum;currentPage++)
            {
            	PDPage page = new PDPage();
                document.addPage(page);
                
                int startRider = currentPage * riderNumPerPage < riders.size() ? currentPage * riderNumPerPage:riders.size();
                int endRider = startRider+riderNumPerPage > riders.size()?riders.size(): startRider+riderNumPerPage;
                
                List<Rider> curRiders = riders.subList(startRider, endRider);
                
                int startRateSmall = currentPage * rateNumPerPage < ratesSmall.size() ? currentPage * rateNumPerPage:ratesSmall.size();
                int endRateSmall = startRateSmall+rateNumPerPage > ratesSmall.size()?ratesSmall.size(): startRateSmall+rateNumPerPage;
                
                List<Rate> curRatesSmall = ratesSmall.subList(startRateSmall, endRateSmall);
                
                int startRateHigh = currentPage * rateNumPerPage < ratesHigh.size() ? currentPage * rateNumPerPage:ratesHigh.size();
                int endRateHigh = startRateHigh+rateNumPerPage > ratesHigh.size()?ratesHigh.size(): startRateHigh+rateNumPerPage;
                
                List<Rate> curRatesHigh = ratesHigh.subList(startRateHigh, endRateHigh);
                
                
                Y = 725;
                
                PDPageContentStream contentStream = new PDPageContentStream(document, page);

                drawImage("src/images/logo.png", 25, 230, 70, document, contentStream);
                addPageSignature("Page "+String.valueOf(currentPage+1),contentStream);
                
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
                posSecondParagh -= 10;
                posSecondParagh -= 10;
                for(int i=0;i<curRiders.size();i++)
                {
                	addMyText(curRiders.get(i).name,3, posSecondParagh, 8, contentStream, PLAIN);
    				addMyText(curRiders.get(i).type,285, posSecondParagh, 8, contentStream, PLAIN);
                    addMyText(String.valueOf( curRiders.get(i).cost),445, posSecondParagh, 8, contentStream, PLAIN);
                    posSecondParagh -= 10;
                }
                
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
                
                posForthPara -= 10;
                posForthPara -= 10;
                for(int i=0;i<curRatesSmall.size();i++)
                {
                	addMyText(curRatesSmall.get(i).index,3, posForthPara, 8, contentStream, PLAIN);
                    addMyText(curRatesSmall.get(i).term,200, posForthPara, 8, contentStream, PLAIN);
                    addMyText(curRatesSmall.get(i).strategy,300, posForthPara, 8, contentStream, PLAIN);
                    addMyText(curRatesSmall.get(i).type,400, posForthPara, 8, contentStream, PLAIN);
                    addMyText(String.valueOf(curRatesSmall.get(i).rate)+"%",500, posForthPara, 8, contentStream, PLAIN);
                    posForthPara -= 10;
                }
                
                int posLastPara = -400;
                addMyText("Premium Band (ex. $100,000+)",3, posLastPara, 8, contentStream, PLAIN);
                addMyText("Index",3, posLastPara - 10, 8, contentStream, BOLD);
                addMyText("Term / Guarantee Term",200, posLastPara - 10, 8, contentStream, BOLD);
                addMyText("Crediting Strategy",300, posLastPara - 10, 8, contentStream, BOLD);
                addMyText("Rate Type",400, posLastPara - 10, 8, contentStream, BOLD);//Cap Rate, Par Rate, Spread, Performance Trigger Credit, Fixed Rate
                addMyText("Rate",500, posLastPara - 10, 8, contentStream, BOLD);
                
                posLastPara -= 10;
                posLastPara -= 10;
                for(int i=0;i<curRatesHigh.size();i++)
                {
                	addMyText(curRatesHigh.get(i).index,3, posLastPara, 8, contentStream, PLAIN);
                    addMyText(curRatesHigh.get(i).term,200, posLastPara, 8, contentStream, PLAIN);
                    addMyText(curRatesHigh.get(i).strategy,300, posLastPara, 8, contentStream, PLAIN);
                    addMyText(curRatesHigh.get(i).type,400, posLastPara, 8, contentStream, PLAIN);
                    addMyText(String.valueOf(curRatesHigh.get(i).rate)+"%",500, posLastPara, 8, contentStream, PLAIN);
                    posLastPara -= 10;
                }
                
                addMyText("Disclosure",290, -650, 9, contentStream, PLAIN);
                
                contentStream.close();
            }
            
            return document;
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        return new PDDocument();
    }
    public PDDocument getPersonalDocument2() {
        try {
            
PDDocument document = new PDDocument();
            
            int totalPageNum = rateSmallPageNum > rateHighPageNum ? rateSmallPageNum:rateHighPageNum;
            totalPageNum = totalPageNum > riderPageNum ? totalPageNum : riderPageNum;
            
            for(int currentPage = 0;currentPage < totalPageNum;currentPage++)
            {
            	PDPage page = new PDPage();
                document.addPage(page);
                
                int startRider = currentPage * riderNumPerPage < riders.size() ? currentPage * riderNumPerPage:riders.size();
                int endRider = startRider+riderNumPerPage > riders.size()?riders.size(): startRider+riderNumPerPage;
                
                List<Rider> curRiders = riders.subList(startRider, endRider);
                
                int startRateSmall = currentPage * rateNumPerPage < ratesSmall.size() ? currentPage * rateNumPerPage:ratesSmall.size();
                int endRateSmall = startRateSmall+rateNumPerPage > ratesSmall.size()?ratesSmall.size(): startRateSmall+rateNumPerPage;
                
                List<Rate> curRatesSmall = ratesSmall.subList(startRateSmall, endRateSmall);
                
                int startRateHigh = currentPage * rateNumPerPage < ratesHigh.size() ? currentPage * rateNumPerPage:ratesHigh.size();
                int endRateHigh = startRateHigh+rateNumPerPage > ratesHigh.size()?ratesHigh.size(): startRateHigh+rateNumPerPage;
                
                List<Rate> curRatesHigh = ratesHigh.subList(startRateHigh, endRateHigh);
	            Y = 725;
	            
	            PDPageContentStream contentStream = new PDPageContentStream(document, page);
	
	            drawImage("src/images/logo.png", 25, 230, 70, document, contentStream);
	            addPageSignature("Page "+String.valueOf(currentPage+1),contentStream);
	            
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
	            
	            posSecondParagh -= 10;
                posSecondParagh -= 10;
                for(int i=0;i<curRiders.size();i++)
                {
                	addMyText(curRiders.get(i).name,3, posSecondParagh, 8, contentStream, BOLD);
    				addMyText(curRiders.get(i).type,285, posSecondParagh, 8, contentStream, BOLD);
                    addMyText(String.valueOf( curRiders.get(i).cost),445, posSecondParagh, 8, contentStream, BOLD);
                    posSecondParagh -= 10;
                }
	            
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
	            
	            posForthPara -= 10;
                posForthPara -= 10;
                for(int i=0;i<curRatesSmall.size();i++)
                {
                	addMyText(curRatesSmall.get(i).index,3, posForthPara, 8, contentStream, PLAIN);
                    addMyText(curRatesSmall.get(i).term,200, posForthPara, 8, contentStream, PLAIN);
                    addMyText(curRatesSmall.get(i).strategy,300, posForthPara, 8, contentStream, PLAIN);
                    addMyText(curRatesSmall.get(i).type,400, posForthPara, 8, contentStream, PLAIN);
                    addMyText(String.valueOf(curRatesSmall.get(i).rate)+"%",500, posForthPara, 8, contentStream, PLAIN);
                    posForthPara -= 10;
                }
	            int posLastPara = -400;
	            addMyText("Premium Band (ex. $100,000+)",3, posLastPara, 8, contentStream, PLAIN);
	            addMyText("Index",3, posLastPara - 10, 8, contentStream, BOLD);
	            addMyText("Term / Guarantee Term",200, posLastPara - 10, 8, contentStream, BOLD);
	            addMyText("Crediting Strategy",300, posLastPara - 10, 8, contentStream, BOLD);
	            addMyText("Rate Type",400, posLastPara - 10, 8, contentStream, BOLD);//Cap Rate, Par Rate, Spread, Performance Trigger Credit, Fixed Rate
	            addMyText("Rate",450, posLastPara - 10, 8, contentStream, BOLD);
	            addMyText("Floor",500, posLastPara - 10, 8, contentStream, BOLD);
	            addMyText("Buffer",550, posLastPara - 10, 8, contentStream, BOLD);
	            
	            posLastPara -= 10;
                posLastPara -= 10;
                for(int i=0;i<curRatesHigh.size();i++)
                {
                	addMyText(curRatesHigh.get(i).index,3, posLastPara, 8, contentStream, PLAIN);
                    addMyText(curRatesHigh.get(i).term,200, posLastPara, 8, contentStream, PLAIN);
                    addMyText(curRatesHigh.get(i).strategy,300, posLastPara, 8, contentStream, PLAIN);
                    addMyText(curRatesHigh.get(i).type,400, posLastPara, 8, contentStream, PLAIN);
                    addMyText(String.valueOf(curRatesHigh.get(i).rate)+"%",500, posLastPara, 8, contentStream, PLAIN);
                    posLastPara -= 10;
                }
                
	            addMyText("Disclosure",290, -650, 9, contentStream, PLAIN);
	            
	            contentStream.close();
            }
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
