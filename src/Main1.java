import javax.swing.JFrame;


public class Main1 {
	public static void main(String args[]){
		Graphics1 g = new Graphics1("YouSort v0.7");
		g.setVisible(true);
		g.setSize(400,430);
		g.setResizable(false);
		g.setLocationRelativeTo(null);
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
