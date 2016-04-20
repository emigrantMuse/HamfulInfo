package Program;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Global.FileInformation;
import Global.status;

public class GetAllFile {
	
	static FileInformation vector = FileInformation.getInstance();
	public  GetAllFile() throws Exception
	{
		String temp =status.getFilePath() ;

		  File root = new File(temp);
		  showAllFiles(root);
		  
		  for(int j=0; j<vector.size(); j++){
			 System.out.println((String) vector.m_element.get(j));
		  }
		  
}
    
	 final static void showAllFiles(File dir) throws Exception{
		  File[] fs = dir.listFiles();
		  
		  for(int i=0; i<fs.length; i++){
		  
		   if(fs[i].isDirectory()){
		    try{
		     showAllFiles(fs[i]);
		    }catch(Exception e){}
		   }
		   else{
			// System.out.println(fs[i].getAbsolutePath());
			   vector.addElement(fs[i].getAbsolutePath());
		   }
		  }

		  }
	}


