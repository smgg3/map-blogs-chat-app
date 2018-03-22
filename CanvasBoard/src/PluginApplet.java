import javax.swing.*;

public class PluginApplet extends JApplet {
	public void init()
	{
		System.out.println("int java file");
		WindowUtilities.setNativeLookAndFeel();
		setContentPane(new TextPanel());
		
	}

}
