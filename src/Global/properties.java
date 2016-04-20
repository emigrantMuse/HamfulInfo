package Global;

import java.util.Vector;

public class properties {
	public Vector<String> m_element;

	private static properties m_instance;//这是Vector类型的实例
	public static properties getInstance()
	{
		if (m_instance==null)
			m_instance=new properties();
		return m_instance; 
	}
	
	public void  Clear() {
		m_element.clear();
	}
	
	private properties()
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
