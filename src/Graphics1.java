import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Graphics1 extends JFrame{
	private static final long serialVersionUID = 1L;
	int tmp,tmp2;
    String tmp3;
	JRadioButton r1, r2,r3,r4;
	JRadioButton rs1, rs2,rs3,rs4;
	JRadioButton ra1, ra2,ra3;
	JLabel l1,l2, l3, l4, l5, l6;
	JTextArea ta1;
	JButton b1, b2 ;
	ButtonGroup bg = new ButtonGroup();
	ButtonGroup bg2 = new ButtonGroup();
	ButtonGroup bg3 = new ButtonGroup();
	Sorter1 s = new Sorter1();
	eHandler handler = new eHandler();
	public Graphics1(String s){
		super(s);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (InstantiationException e) {
	        e.printStackTrace();
	    } catch (IllegalAccessException e) {
	        e.printStackTrace();
	    } catch (UnsupportedLookAndFeelException e) {
	        e.printStackTrace();
	    }		
		l1 = new JLabel("Choose array size:");
		r1 = new JRadioButton("10");
		r1.setActionCommand("10");
		r2 = new JRadioButton("100");
		r2.setActionCommand("100");
		r3 = new JRadioButton("1000");
		r3.setActionCommand("1000");
		r4 = new JRadioButton("10000");
		r4.setActionCommand("10000");
		
		l2 = new JLabel("Choose sorting type:");
		rs1 = new JRadioButton("Insertion");
		rs1.setActionCommand("1");
		rs2 = new JRadioButton("Merge");
		rs2.setActionCommand("2");
		rs3 = new JRadioButton("Heap");
		rs3.setActionCommand("3");
		rs4 = new JRadioButton("Quick");
		rs4.setActionCommand("4");
		
		l6 = new JLabel("Choose array type:");
		ra1 = new JRadioButton("Random");
		ra1.setActionCommand("Random");
		ra2 = new JRadioButton("Straight");
		ra2.setActionCommand("Straight");
		ra3 = new JRadioButton("Reversed");
		ra3.setActionCommand("Reversed");
		
		b1 = new JButton("Calculate");
		b2 = new JButton("Clear");
		
		l3 = new JLabel("");
		l4 = new JLabel("");
		l5 = new JLabel("");
		
		ta1 = new JTextArea(14,30);

		ta1.setLineWrap(true);
		ta1.setWrapStyleWord(true);
		JScrollPane scrollBar = new JScrollPane(ta1);
		scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Font font = new Font("Verdana", Font.BOLD, 12);
		ta1.setFont(font); 
		bg.add(r1);bg.add(r2);bg.add(r3);bg.add(r4);
		add(l1);
		add(r1);add(r2);add(r3);add(r4);
		add(l2);
		add(rs1);add(rs2);add(rs3);add(rs4);
		bg2.add(rs1);bg2.add(rs2);bg2.add(rs3);bg2.add(rs4);
		add(l6);
		add(ra1);add(ra2);add(ra3);
		bg3.add(ra1);bg3.add(ra2);bg3.add(ra3);
		add(b1); add(b2);
		add(l3);add(l4);add(l5);
		add(scrollBar, BorderLayout.EAST);
		b1.addActionListener(handler);
		b2.addActionListener(handler);
		
	}
	protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
	public class eHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try{
				if(e.getActionCommand().equals("Calculate")){
					tmp = Integer.parseInt(bg.getSelection().getActionCommand());
					tmp2 = Integer.parseInt(bg2.getSelection().getActionCommand());
					tmp3 = bg3.getSelection().getActionCommand();
					s.tester(tmp, tmp3, tmp2);
					l3.setText("Time: " + s.time_end);
					l4.setText("Assigns: " + s.assign_count);
					l5.setText("Compares: " + s.compare_count);
					ta1.setText(bg3.getSelection().getActionCommand() + " array: " + s.rand_output);
					ta1.append("\n\nSorted array: " + s.output);
					
					s.time_end = 0;
					s.time = 0;
					s.assign_count = 0;
					s.compare_count = 0;
					s.output = "";
					s.rand_output = "";
				}
				else if(e.getActionCommand().equals("Clear")){
					s.time_end = 0;
					s.time = 0;
					s.assign_count = 0;
					s.compare_count = 0;
					s.output = "";
					s.rand_output = "";
					l3.setText("");
					l4.setText("");
					l5.setText("");
					ta1.setText("");
				}
			}catch (Exception exc) { JOptionPane.showMessageDialog(null, "Choose all required options");}
		}
		
	}
	
}