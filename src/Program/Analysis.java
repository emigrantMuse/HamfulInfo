package Program;

import java.awt.image.RescaleOp;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Global.FileInformation;
import Global.ResultInformation;
import Global.properties;
import Global.status;
import UI.SpecificDesign;

public class Analysis {
	public Analysis()
	{
		String temp;//临时文件名
		int i = 1;
		int  num_macth = 0;//匹配到的次数

		double p;

		FileInformation vector_file = FileInformation.getInstance();
		properties vector_pro = properties.getInstance();
		ResultInformation vector_result = ResultInformation.getInstance();
		
		for(int j=0; j<vector_file.size(); j++)//每个文件逐步分析
		{
			//System.out.println(vector_file.size());
			status.sum = 0;
			temp =(String) vector_file.m_element.get(j);//得到临时文件名
		
			ReadTXT eachfile =new ReadTXT();
			String file_infomation = eachfile.readFile(temp,i);//读取每个文件信息
			
			for(int l = 0;l < vector_pro.size();l++)//按配置文件遍历
			{
				String a = (String)vector_pro.m_element.get(l);//得到一行配置信息
				//System.out.println(a);    
					Pattern r = Pattern.compile(a);
				    Matcher m = r.matcher(file_infomation);
				    while(m.find())
				    {
					    num_macth ++;
					    System.out.println(m.groupCount());    
				    }
			}
			//System.out.println("存入的熵值为"+status.sum);    
			//System.out.println(num_macth);    
			vector_result.addElement(num_macth);
		}
	}
}
