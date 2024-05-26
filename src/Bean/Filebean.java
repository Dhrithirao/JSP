package Bean;

import java.io.FileInputStream;

public class Filebean 
 {
	private String username;
	private String filename;
	private String type;
	private String size;
	private String path;
	private String key;
	private String searchkey;
	private String j=null;
	private String uname;
	private String content;
	
	public String getJ() {
		return null;
	}
	public void setJ(String j) {
		this.j = j;
	}
	public String getSearchkey() {
		return searchkey;
	}
	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}
	private FileInputStream uploadcontent;
	
   public FileInputStream getUploadcontent() {
		return uploadcontent;
	}
	public void setUploadcontent(FileInputStream uploadcontent) {
		this.uploadcontent = uploadcontent;
	}
public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

   
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	public String getUsername() 
	  {
		return username;
	  }
	public void setUsername(String username) 
	     {
		this.username = username;
	      }
	public String getType() 
	        {
		return type;
	         }
	public void setType(String type) 
	           {
		this.type = type;
	            }
	public String getSize() 
	              {
		return size;
	                }
	public void setSize(String size)
	                   {
		this.size = size;
	                   }
	public String getPath() 
	                     {
		return path;
	                     }
	public void setPath(String path) 
	                       {
		this.path = path;
	                       }
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
 }
