package encryption;
import encryption.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.*;
import java.util.ArrayList;
import javax.crypto.*;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.oreilly.servlet.Base64Encoder;
import java.util.Base64;


import sun.misc.*;
public class security {

	/**
	 * @param args
	 */
	 
	public static String encrypt(String Data) throws Exception
	{
	        Key key = Publickey.generateKey();
	        Cipher c = Cipher.getInstance("AES");
	        c.init(Cipher.ENCRYPT_MODE, key);
	        byte[] encVal = c.doFinal(Data.getBytes());
	       // String encryptedValue = new Base64Encoder().encode(encVal);
	        String encryptedValue = Base64.getEncoder().encodeToString(encVal);

	        return encryptedValue;
	 }
	
	public static String decrypt(String encryptedData) throws Exception 
	{
        Key key = Publickey.generateKey();
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, key);
       // byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);

        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        //System.out.println("key is :::"+ABEKey.generateKey());
        return decryptedValue;
	}
	
	
	public  static  void  main(String[] args) throws Exception
	{
		
		
		int i=0;
		ArrayList<String> listvalues=new ArrayList<String>();
		 File floder=new File("C:\\Users\\sai88\\eclipse-workspace\\VTJCC22_2021\\WebContent\\CloudServer\\");
		    File[] listoffiles=floder.listFiles();
		   
		    for (File file1 : listoffiles) 
		    {
		    	i++;
			try {
				 String filecontent="";
				FileInputStream fileInputStream=new FileInputStream(file1);
				System.out.println("filename"+file1.getName());
				String filenames=file1.getName();
				
				if(file1.getName().endsWith(".txt"))
				{
				byte[] b=new byte[fileInputStream.available()];
				fileInputStream.read(b);
				String reading=new String(b);
				filecontent=filecontent+reading;
			    System.out.println("filepath is"+file1.getPath());
				System.out.println(i+"."+filecontent);
				System.out.println(filenames);
				String encrpt=security.encrypt(filecontent);
				FileOutputStream fileOutputStream=new FileOutputStream(new File("C:\\Users\\sai88\\eclipse-workspace\\VTJCC22_2021\\WebContent\\CloudDataBase\\encrypteddata\\"+file1.getName()));
			
				fileOutputStream.write(encrpt.getBytes());
				System.out.println(encrpt);
				}
				else if(file1.getName().endsWith(".pdf"))
				{ 
					//System.out.println("padf file name"+file1.getName());
					String pdffilename=file1.getName();
					String pdffilename1=pdffilename;
					System.out.println("pdf filename is "+pdffilename);
					String text="";
					com.itextpdf.text.pdf.PdfReader pdfReader=new PdfReader("C:\\Users\\sai88\\eclipse-workspace\\VTJCC22_2021\\WebContent\\CloudServer\\"+pdffilename);
				
					int pages=pdfReader.getNumberOfPages();
					for(int i1=1;i1<pages;i1++)
					{
						 text=PdfTextExtractor.getTextFromPage(pdfReader, i1);
						System.out.println("page:"+i1+" "+text);
					}
				String encrpt=security.encrypt(text);
				  Document document=new Document(PageSize.A4);
				
				 
				PdfWriter.getInstance(document, new FileOutputStream(new File("C:\\Users\\sai88\\eclipse-workspace\\VTJCC22_2021\\WebContent\\CloudDataBase\\encrypteddata\\"+pdffilename)));
				
				Chunk chunk=new Chunk(encrpt);
				document.open();
				Font font=new Font(Font.TIMES_ROMAN);
				font.setStyle(font.BOLD);
				Paragraph p1=new Paragraph(chunk);
				p1.setAlignment(Element.ALIGN_LEFT);
				document.add(p1);
				document.close();
				System.out.println("pdf writing is completed");
				//fileOutputStream.write(encrpt.getBytes());
				System.out.println(encrpt);
				}
				else if (file1.getName().endsWith(".doc")) 
				{  
					WordExtractor extractor = null;
					String wordfilename=file1.getName();
					System.out.println("word file name is"+wordfilename);
					FileInputStream fis=new FileInputStream("C:\\Users\\sai88\\eclipse-workspace\\VTJCC22_2021\\WebContent\\CloudServer\\"+wordfilename);
					System.out.println("file is"+fis);
					HWPFDocument document=new HWPFDocument(fis);
					extractor = new WordExtractor(document);
					String [] fileData = extractor.getParagraphText();
					String mydate=extractor.getTextFromPieces();
					System.out.println("DATASSSSSSSSSSSSSSSSSss "+fileData);
					System.out.println("THE MYYYYYYYYYYY "+mydate);
					String text1=null;
					System.out.println("filedata len  "+fileData.length);
					String encrpt=security.encrypt(mydate);
					System.out.println("encrypted data is"+encrpt);
					FileOutputStream fileOutputStream=new FileOutputStream(new File("C:\\Users\\sai88\\eclipse-workspace\\VTJCC22_2021\\WebContent\\CloudDataBase\\encrypteddata\\"+file1.getName()));
					fileOutputStream.write(encrpt.getBytes());
					
				}
				
			/*	String decrypt=security.decrypt(encrpt);
				System.out.println(decrypt);*/
			}
			
			
			catch (Exception e) 
			{
		
				e.printStackTrace();
			}	
			
			}
		
	}
	
	
		
	}


