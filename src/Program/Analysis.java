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
		String temp;//��ʱ�ļ���
		int i = 1;
		int  num_macth = 0;//ƥ�䵽�Ĵ���

		double p;

		FileInformation vector_file = FileInformation.getInstance();
		properties vector_pro = properties.getInstance();
		ResultInformation vector_result = ResultInformation.getInstance();
		
		for(int j=0; j<vector_file.size(); j++)//ÿ���ļ��𲽷���
		{
			//System.out.println(vector_file.size());
			status.sum = 0;
			temp =(String) vector_file.m_element.get(j);//�õ���ʱ�ļ���
		
			ReadTXT eachfile =new ReadTXT();
			String file_infomation = eachfile.readFile(temp,i);//��ȡÿ���ļ���Ϣ
			
			for(int l = 0;l < vector_pro.size();l++)//�������ļ�����
			{
				String a = (String)vector_pro.m_element.get(l);//�õ�һ��������Ϣ
				//System.out.println(a);    
					Pattern r = Pattern.compile(a);
				    Matcher m = r.matcher(file_infomation);
				    while(m.find())
				    {
					    num_macth ++;
					    System.out.println(m.groupCount());    
				    }
			}
			//System.out.println("�������ֵΪ"+status.sum);    
			//System.out.println(num_macth);    
			vector_result.addElement(num_macth);
		}
	}
}
