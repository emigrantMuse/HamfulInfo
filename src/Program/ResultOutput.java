package Program;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import Global.FileInformation;
import Global.ResultInformation;

public class ResultOutput {
	public  ResultOutput(String path) {
		// TODO Auto-generated constructor stub
		try{
			  SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");//设置日期格式
			  String a = df.format(new Date());
			  String newline = System.getProperty("line.separator");
			  String str = path +"\\" + a + ".txt";
		      File file =new File(str);

		      //if file doesnt exists, then create it
		      if(!file.exists()){
		       file.createNewFile();
		      }

		      //true = append file
		      FileWriter fw = new FileWriter(file.getAbsoluteFile());
		      BufferedWriter bw = new BufferedWriter(fw);
		      FileInformation outfile = FileInformation.getInstance();
		      ResultInformation outresult = ResultInformation.getInstance();
		      for(int i = 0;i < outfile.size();i ++)
		      {
		    	  bw.write(outfile.m_element.get(i));
		    	  bw.write("-");
		    	  bw.write(outresult.m_element.get(i).toString());
		    	  bw.write(newline);
		      }
	    	  bw.close();
		      System.out.println("Done");
		      JOptionPane.showMessageDialog(null, "保存成功!!");
		     }catch(IOException e){
		      e.printStackTrace();
		     }
	}

}
