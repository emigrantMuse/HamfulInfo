package Program;

import java.io.File;

import Global.status;
import UI.SpecificDesign;

public class RuntheMain{

public RuntheMain() throws Exception 
{
	 /*****
	 * 读取目录下的所有文件列表
	 */
	GetAllFile step1= new GetAllFile();
	
	/******
	 * 
	 * 读取关键字
	 * 
	 */
	ReadTXT step2=new ReadTXT();
	step2.Readwebshell();
	
	/******
	 * 
	 * 载入所有文件并且分析其是否为webshell
	 */
	Analysis step3 = new Analysis();
	status.done = true;
}


}
