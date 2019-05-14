package painter1;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PainterFrame extends JFrame{
	
	
	private DrawPanel drawpanel;
	

	public PainterFrame() {
		super();
		
		drawpanel =new DrawPanel();
		add(drawpanel , BorderLayout.CENTER);
		
	}
	
	

}
