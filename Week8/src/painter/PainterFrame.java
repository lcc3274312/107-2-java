package painter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PainterFrame extends JFrame implements ActionListener {
	
	private JPanel bottomPanel;
	private JButton colorbtn;
	
	private JPanel shapePanel;
	private JButton randgen;
	private JButton rect;
	private JButton oval;
	private JButton vtri;
	
	private JPanel actionPanel;
	private JButton clear;
	private JButton undo;
	private JButton redo;
	
	final int RECT = 1;
	final int OVAL = 2;
	final int VTRI = 3;
	final int DIA = 4;
	private int numType = 4;
	
	private Icon colorIcon;
	private Color color;
	
	private DrawPanel drawpanel;
	
	public PainterFrame() {
		super();
		shapePanel = new JPanel();
		actionPanel = new JPanel();
		bottomPanel = new JPanel();
		
		drawpanel =new DrawPanel();
		
		bottomPanel.add(shapePanel);
		
		randgen = new JButton("Randgen");
		shapePanel.add(randgen);
		randgen.addActionListener(this);
		
		rect = new JButton("rect");
		shapePanel.add(rect);
		rect.addActionListener(this);
		
		oval = new JButton("oval");
		shapePanel.add(oval);
		oval.addActionListener(this);
		
		vtri = new JButton("vtri");
		shapePanel.add(vtri);
		vtri.addActionListener(this);
		
		colorIcon = new ImageIcon(getClass().getResource("color(1).png"));
		colorbtn = new JButton("C1",colorIcon);
		shapePanel.add(colorbtn);
		colorbtn.addActionListener(this);
				
		bottomPanel.add(actionPanel);
		clear = new JButton("clear");
		actionPanel.add(clear);
		clear.addActionListener(this);
		
		undo = new JButton("undo");
		actionPanel.add(undo);
		undo.addActionListener(this);
		
		redo = new JButton("redo");
		actionPanel.add(redo);
		redo.addActionListener(this);
		
		add(bottomPanel,BorderLayout.SOUTH);
		add(drawpanel,BorderLayout.CENTER);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==randgen)
		{
			drawpanel.randgen(15);
		}
		else if(e.getSource()==rect)
		{
			drawpanel.setShapeType(RECT);
		}
		else if(e.getSource()==oval)
		{
			drawpanel.setShapeType(OVAL);
		}
		else if(e.getSource()==vtri)
		{
			drawpanel.setShapeType(VTRI);
		}
		else if(e.getSource()==clear)
		{
			drawpanel.clear();
		}
		else if(e.getSource()==undo)
		{
			drawpanel.undo();
		}
		else if(e.getSource()==redo)
		{
			drawpanel.redo();
		}
		else if(e.getSource()==colorbtn)
		{
			color = JColorChooser.showDialog(PainterFrame.this,"Choose a Color",color);
			colorbtn.setBackground(color);
			drawpanel.setColor(color);
		}
	}
	
	

}
