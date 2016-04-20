package UI;

public class mainClass {
	public static void main(String[] args) {
	 javax.swing.SwingUtilities.invokeLater(new Runnable() {//事件派发线程
         public void run() {
	mainFrame.createAndShowGUI();//创建UI界面
         }
     });
}

}
