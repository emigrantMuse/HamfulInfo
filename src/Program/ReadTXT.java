package Program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.naming.ldap.UnsolicitedNotificationListener;

import Global.properties;

public class ReadTXT {
	

	public void Readwebshell()
	{
		int i = 0;
		String a=readFile("txt//Sensitive", i);
	}
	
	public static String readFile(String fileName,int type)  
	{     
	    String fileContent = "";     
		properties pro=properties.getInstance();
		StringBuffer content = new StringBuffer();
	    try   
	    {       
	        File f = new File(fileName);      
	        if(f.isFile()&&f.exists())  
	        {
	            InputStreamReader read = new InputStreamReader(new FileInputStream(f),"gbk");       
	            BufferedReader reader=new BufferedReader(read,5*1024*1024);       
	            String line;       
	            while ((line = reader.readLine()) != null)   
	            {
	            	if(type == 0)//标志位为0时直接存储该行信息，用于配置文件读取
	            	    pro.addElement(line);
	            	else if(type == 1)//标志位为1时将该行信息串接在原字符串后，用于文件读取
	            		content.append(line);
	            }
	            fileContent = content.toString();
	            //System.out.println(fileContent);
	            read.close();      
	        }     
	    } catch (Exception e)   
	    {         
	        e.printStackTrace();     
	    }     
	    return fileContent;   
	}

}
