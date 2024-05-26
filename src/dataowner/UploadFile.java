package dataowner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Filebean;
import Implementations.Implementation;
import Interfaces.UserInterface;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

import encryption.Publickey;
import encryption.security;

@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {
	static String d;
	private static final long serialVersionUID = 1L;
	private String key;

	public UploadFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// .TODO Auto-generated method stub
		
		
		MultipartParser mp = new MultipartParser(request,99999999);
		Part part;
		FilePart filePart = null;
		ParamPart paramPart = null;
		String filename = null;
		String type = null;
		String path = null;
		String key=null;
		String username = null;
		double fileSize = 0;
		
		String searchkey=request.getParameter("searchkey");
	
		HttpSession session1=request.getSession();
		username=(String) session1.getAttribute("username");
	
		
		ArrayList<String> paramValues = new ArrayList<String>();
		String fileToupload = getServletContext().getRealPath("/");
		String fileTouploads = getServletContext().getRealPath("/");
		System.out.println(fileTouploads+"file to uploads ");
		Filebean upload = new Filebean();

		System.out.println(fileToupload+" line 98");
		fileToupload = fileToupload.substring(0, fileToupload.indexOf("."))
				+ "VTJCC22_2021\\WebContent\\CloudServer\\";
		//String metadatafile=fileTouploads.substring(0, fileTouploads.indexOf("."))+"Cloud\\WebContent\\CloudDataBase\\metadata\\";
		//System.out.println(metadatafile);
		while ((part = mp.readNextPart()) != null) {
			if (part.isFile()) {
				filePart = (FilePart) part;
				fileToupload = fileToupload + filePart.getFileName();
				
				filename = filePart.getFileName();
				/*metadatafile=metadatafile+filename;*/
			
				File uploadedFile = new File(fileToupload);
				/*File  metaupload=new File(metadatafile);	*/
				
				System.out.println("filename= line 114"+filename);
				type = filePart.getContentType();
				fileSize = filePart.writeTo(uploadedFile);
				
				FileInputStream fis=new FileInputStream(uploadedFile);
				//upload.setUploadcontent(fis);
//		filePart.writeTo(metaupload);
			
				path = fileToupload;
				System.out.println(" fileSize = " + fileSize);
			} else if (part.isParam()) {
				paramPart = (ParamPart) part;
				String tagName = paramPart.getName();
				System.out.println("tagName = " + tagName);
				String tagValue = paramPart.getStringValue();
				System.out.println("tagValue = " + tagValue);
				
				paramValues.add(tagValue);
			key=tagValue;
			
			System.out.println("key= line 137"+key);
			searchkey=key;
			}
		}
		System.out.println(paramValues);
		
		
		int status = 0;
		
		
		upload.setFilename(filename);
		upload.setType(type);
		upload.setSize(fileSize + "");
		upload.setPath(path);
		FileInputStream fis= new FileInputStream(path);	
		
		StringBuilder builder = new StringBuilder();
		System.out.println(path+ "line 153 uploadfile");
		System.out.println("path in upload file lilne 170 ="+path );
		Iterator it=paramValues.iterator();
		String arr[] = new String[2];
		boolean result;
		int num = 0;
		while(it.hasNext())
		{
			arr[num]=(String) it.next();
		//	System.out.println(it.next());
			num++;	
		}
		
		upload.setKey(arr[0]);
		upload.setUsername(arr[1]);
		System.out.println(upload.getKey()+"=key");
		UserInterface I=new Implementation();
		status = I.fileupload(upload);
		System.out.println(status);
		System.out.println("status  " + status);
		
	   String fullpath=getServletContext().getRealPath("/");
	   int a=fullpath.indexOf('.');
	   String cutpath=fullpath.substring(0, a);
	   String filePath=cutpath+"VTJCC22_2021\\WebContent\\CloudDataBase\\metadata\\";
		if (status >0)
		{
			 String path1=filePath+key+".txt";
				
			 File file=new File(path1);
				try{

			  FileOutputStream out = new FileOutputStream(cutpath+"VTJCC22_2021\\WebContent\\CloudDataBase\\metadata\\"+filename+".txt");
		         ObjectOutputStream oout = new ObjectOutputStream(out);

				UserInterface u=new Implementation();
				ArrayList list=u.upload(upload);
				Iterator iterator=list.iterator();
				while (iterator.hasNext()) {
					username=iterator.next().toString();
			         oout.writeObject("User Name is "+security.encrypt(username)+"\n");
			         filename=iterator.next().toString();
			         oout.writeObject("File Name is "+security.encrypt(filename)+"\n");
			        type=iterator.next().toString();
			         oout.writeObject("File Type is "+security.encrypt(type)+"\n");
			         oout.writeObject("File Size is "+security.encrypt( iterator.next().toString()+"")+"\n");
			         path=iterator.next().toString();
			         oout.writeObject("File Path is "+security.encrypt(path+"")+"\n");
			         key=iterator.next().toString();
			         oout.writeObject("Token Name is "+security.encrypt(key)+"\n");
			         InputStream i=(InputStream) iterator.next();
			         oout.writeObject("File Content is "+security.encrypt(i.toString())+"\n");
				}
		         oout.close();
		        
		         security.main(null);
				}
				
				catch (Exception ex) {
			         ex.printStackTrace();
			      }
				session1.getAttribute("searchkey");
				session1.getAttribute("filename");
			response.sendRedirect("success.jsp?searchkey="+searchkey);
		}
		else{
			response.sendRedirect("UploadFlie.jsp");
			}
		
	}

}
