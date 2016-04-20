package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.ShutdownChannelGroupException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Global.FileInformation;
import Global.ResultInformation;
import Global.status;
import Program.ResultOutput;
import Program.RuntheMain;
public class SpecificDesign extends JPanel{
	
	JTextField path=new JTextField(30);
	JTextArea info=new JTextArea(20,25);//�߶ȣ�����
	JTextArea result=new JTextArea(20,25);
	JButton Analysis=new JButton("��ʼɨ��");//�����ļ�
	JLabel InfoPath = new JLabel("��ɨ����ļ�Ŀ¼");
	JLabel InfoFile = new JLabel("ɨ����ļ���Ϣ");
	JLabel InfoResult = new JLabel("ɨ����");
	
	FileInformation vector_f = FileInformation.getInstance();
	ResultInformation vector_r = ResultInformation.getInstance();
	
	static javax.swing.JFileChooser MyFile=new javax.swing.JFileChooser();
	//javax.swing.

	public SpecificDesign()
	{
		super(new BorderLayout());
		JMenuBar Menubar = new JMenuBar();

	   	 JMenu StartMenu = new JMenu("��ʼ");
	   	 JMenu AboutMenu = new JMenu("����");
	   	 
	   	JMenuItem StartScanMenu= new JMenuItem("ѡ��·��");
	   	StartScanMenu.addActionListener(new GetfilepathActionListener());
	   	JMenuItem SaveMenu= new JMenuItem("������");
	   	SaveMenu.addActionListener(new SaveActionListener());
	    JMenuItem ExitMenu= new JMenuItem("�˳�");
	    ExitMenu.addActionListener(new ExitActionListener());
	  	JMenuItem InformationMenu= new JMenuItem("������Ϣ");
	   	 
	  	StartMenu.add(StartScanMenu);
	  	StartMenu.add(SaveMenu);
	  	StartMenu.add(ExitMenu);
	  	AboutMenu.add(InformationMenu);
	  	
	    Menubar.add(StartMenu);
	    Menubar.add(AboutMenu);
	    
	    Analysis.addActionListener(new AnalysisActionListener());
	      
			JPanel PathChoose = new JPanel();

			
			PathChoose.add(InfoPath);
			PathChoose.add(path);
			PathChoose.add(Analysis);
			//PathChoose.setBorder(BorderFactory.createEmptyBorder(0,20,30,20));
			
			JPanel ResultOut = new JPanel();
			info.setLineWrap(true);
			result.setLineWrap(true);
			JScrollPane jS_info;
			JScrollPane jS_result;
			
			GridBagLayout layout = new GridBagLayout();
			 ResultOut.setLayout(layout);
			ResultOut.add(InfoFile);
			ResultOut.add(InfoResult);
			ResultOut.add(jS_info = new JScrollPane(info));
			ResultOut.add(jS_result = new JScrollPane(result));
			
			
			GridBagConstraints s_layout= new GridBagConstraints();
			 //s_layout.insets = new Insets(10,5,0,0);
		        s_layout.gridwidth=1;//�÷������������ˮƽ��ռ�õĸ����������Ϊ0����˵��������Ǹ��е����һ��
		        s_layout.weightx = 0;//�÷����������ˮƽ��������ȣ����Ϊ0��˵�������죬��Ϊ0�����Ŵ�������������죬0��1֮��
		        s_layout.weighty=0;//�÷������������ֱ��������ȣ����Ϊ0��˵�������죬��Ϊ0�����Ŵ�������������죬0��1֮��
		        layout.setConstraints(InfoFile, s_layout);//�������
		        
		        s_layout.gridwidth=0;
		        layout.setConstraints(InfoResult, s_layout);
		        
		        s_layout.insets = new Insets(10,10,10,10);//top, left,  bottom, right
		        s_layout.gridwidth=1;
		        layout.setConstraints(jS_info, s_layout);
		       //s_layout.gridwidth=0;
		        layout.setConstraints(jS_result, s_layout);

			this.add(Menubar,BorderLayout.NORTH);
			this.add(PathChoose,BorderLayout.WEST);
			this.add(ResultOut,BorderLayout.SOUTH);
			
	}
	
	
	public String  getCreateTime(File cfile)
	{
		 long time = cfile.lastModified();//�����ļ�����޸�ʱ�䣬���Ը�long�ͺ�����
         String ctime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(time));
		return ctime;
	}

	
	private class GetfilepathActionListener implements ActionListener{  
        public void actionPerformed(ActionEvent e) {  
        	MyFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//ֻ��ѡ��Ŀ¼
        	 
        	 File f=null;
        	 int value = 0;
        	 try{     
        		 value = MyFile.showOpenDialog(null);  //�����ļ�ѡ��
             }    
             catch(HeadlessException head){     
                  System.out.println("Open File Dialog ERROR!");    
             }

			if(value==JFileChooser.APPROVE_OPTION){
                 f=MyFile.getSelectedFile();    
                 status.setFilePath(f.getPath());
                
                 System.out.println(status.getFilePath());    
                 path.setText(status.getFilePath());

			}
        } 
    }
	
	private class ExitActionListener implements ActionListener{  
        public void actionPerformed(ActionEvent e) {  
        	System.exit(0);
        } 
    }
	
	private class SaveActionListener implements ActionListener{  
        public void actionPerformed(ActionEvent e) {  
        	int value = 0;
        	if(status.done)
        	{
        		 MyFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//ֻ��ѡ��Ŀ¼
        	File f=null;
        	 
        	 try{     
        		 value = MyFile.showOpenDialog(null);  //�����ļ�ѡ��
        		 }    
             catch(HeadlessException head){     
                  System.out.println("Open File Dialog ERROR!");    
             } 
 			if(value==JFileChooser.APPROVE_OPTION){
 	                 f=MyFile.getSelectedFile();    
 	                 ResultOutput output = new ResultOutput(f.getPath());
 				
 			}
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(null, "û�пɱ���Ľ��!", "������Ϣ",
                        JOptionPane.ERROR_MESSAGE);
        	}
        } 
    }
	
	private class AnalysisActionListener implements ActionListener{  
        public void actionPerformed(ActionEvent e) {  
        	if(status.getFilePath() != null)
        	{
            	try {
    				 new RuntheMain();
    			} catch (Exception e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
            	/***
            	 * ��ʾ�ļ���Ϣ
            	 */
            	
            	double a = 0.0;
            	File createtime;
            	String ctime;
            	for(int j=0; j<vector_f.size(); j++){
            		//System.out.println(vector_f.size());
            		createtime = new File(vector_f.m_element.get(j));
            		info.setText(info.getText()+(String) vector_f.m_element.get(j)+"\n"+"�޸�����:"+getCreateTime(createtime)+"\n"+"------------------------------------------------------"+"\n");
            		//System.out.println(vector_r.m_element.get(j));
            		if((int)vector_r.m_element.get(j) > 0)
            		    result.setText(result.getText()+(String) vector_f.m_element.get(j)+"\n"+"------------"+"���ļ�����"+vector_r.m_element.get(j) + 
            		"��������Ϣ."+"\n"+"------------------------------------------------------"+"\n");
            	    else
            			result.setText(result.getText()+(String) vector_f.m_element.get(j)+"\n"+"------------"+"���ļ����жȽϵ�"+"\n"+"------------------------------------------------------"+"\n");
            		/****
            		 * 
            		 * ��ʾ���
            		 * 
            		 **/
            		//System.out.println("��ֵΪ"+vector_r.m_element.get(j));    
            	}
            }
        	else{
           	 JOptionPane.showMessageDialog(null, "����ѡ���ɨ��·��!", "������Ϣ",
                     JOptionPane.ERROR_MESSAGE);
        	}
        	}

    }


}