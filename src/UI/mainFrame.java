package UI;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class mainFrame {
	public static void createAndShowGUI() {
	//Frame是做主页面框架也可以用来做顶级窗体，要想把控件放在该界面中，必须把控件放在JPanel中
			//为最底层，同一个界面只有一个JFrame
			
	        JFrame frame = new JFrame("Webshell辅助检查工具");//构造框架
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//指定关闭按钮退出应用程序？
	 
	        //Create and set up the content pane.
	        JComponent newContentPane = new SpecificDesign();//实例化并载入具体设计
	        newContentPane.setOpaque(true); //设置控件不透明
	        frame.setContentPane(newContentPane);//JFrame是框架，不能直接添加控件，建立Jpanel的中间控件
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);//设为可见
	}
}
