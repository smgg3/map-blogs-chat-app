import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;

public class DrawingPanel extends JPanel {
	private Ellipse2D.Double circle=new Ellipse2D.Double(10,10,350,350);
	private GradientPaint gradient=new GradientPaint(0,0,Color.red,180,180,Color.yellow,true);
	private Color[] colors={Color.white,Color.black};
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(gradient);
		g2d.fill(circle);
		g2d.translate(185, 185);
		for(int i =0;i<16;i++){
			g2d.rotate(Math.PI/8.0);
			g2d.setPaint(colors[i%2]);
			g2d.drawString("jsp:plugin", 0, 0);
		}
		System.out.println("int java file");
	}
	public void setFontName(String fontName){
		setFont(new Font(fontName,Font.BOLD,35));
	}
	
}
