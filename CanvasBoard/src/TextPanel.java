import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TextPanel extends JPanel implements ActionListener{

	private JComboBox fontBox;
	private DrawingPanel drawingPanel;
	
	
	public TextPanel(){
			GraphicsEnvironment env=GraphicsEnvironment.getLocalGraphicsEnvironment();
			String[] fontNames=env.getAvailableFontFamilyNames();
			fontBox=new JComboBox(fontNames);
			setLayout(new BorderLayout());
			JPanel fontPanel =new JPanel();
			fontPanel.add(new JLabel("Font:"));
			fontPanel.add(fontBox);
			JButton drawButton =new JButton("Draw");
			drawButton.addActionListener(this);
			fontPanel.add(drawButton);
			add(fontPanel,BorderLayout.SOUTH);
			drawingPanel =new DrawingPanel();
			fontBox.setSelectedItem("Serif");
			add(drawingPanel,BorderLayout.CENTER);
			System.out.println("int java file");
				
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		drawingPanel.setFontName((String)fontBox.getSelectedItem());
		drawingPanel.repaint();
	}

	

}
