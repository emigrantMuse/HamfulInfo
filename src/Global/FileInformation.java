package Global;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;



public class FileInformation {
	public Vector<String> m_element;
	public static Vector<String> FileCreateTime = new Vector<String>();

	private static FileInformation m_instance;//这是Vector类型的实例
	public static FileInformation getInstance()
	{
		if (m_instance==null)
			m_instance=new FileInformation();
		return m_instance; 
	}
	
	public void  Clear() {
		m_element.clear();
	}
	
	private FileInformation()
	{
		m_element=new Vector<String>();
	}
	
	public void addElement(String x)
	{
		m_element.add(x);
	}

	public int size() {
		// TODO Auto-generated method stub
		return m_element.size();
	}
}
