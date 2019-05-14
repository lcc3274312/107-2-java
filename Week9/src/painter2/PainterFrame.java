package painter2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PainterFrame extends JFrame implements ActionListener,ItemListener {

	private JPanel bottomPanel;
	private JPanel actionPanel;
	private JPanel shapePanel;
	
	private JButton randgen;
	private JButton rect;
	private JButton oval;
	private JButton vtri;
	private JButton square;
	private JButton circle;
	private JButton colorbtn;
	private JButton colorbtn2;
	private JCheckBox filled;
	private JCheckBox gradient;
	
	private JButton clear;
	private JButton undo;
	private JButton redo;
	
	private GridBagConstraints gbc;
	
	private int numType = 4;
	final int RECT = 1;
	final int OVAL = 2;
	final int VTRI = 3;
	final int DIA = 4;
	final int SQU = 5;
	final int CIR = 6;
	

	private Icon colorIcon;

	private Color color ;
	private Color color2;

	private DrawPanel drawpanel;

	void setGridBagConstraints(int x, int y, int h, int w, boolean filled) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = h;
		gbc.gridwidth = w;
		if (filled)
			gbc.fill = GridBagConstraints.BOTH;
	}

	public PainterFrame() {
		super();
		shapePanel  = new JPanel();
		actionPanel = new JPanel();
		bottomPanel = new JPanel();
		drawpanel   = new DrawPanel();
		
		shapePanel  = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints();

		
		randgen = new JButton("Randgen");
		setGridBagConstraints(0, 0, 1, 1, true);
		shapePanel.add(randgen, gbc);
		randgen.addActionListener(this);

		rect = new JButton("rect");
		setGridBagConstraints(1, 0, 1, 1, true);
		shapePanel.add(rect, gbc);
		rect.addActionListener(this);

		oval = new JButton("oval");
		setGridBagConstraints(0, 1, 1, 1, true);
		shapePanel.add(oval, gbc);
		oval.addActionListener(this);

		vtri = new JButton("vtri");
		setGridBagConstraints(1, 1, 1, 1, true);
		shapePanel.add(vtri, gbc);
		vtri.addActionListener(this);
		
		square = new JButton("square");
		setGridBagConstraints(2, 0, 1, 1, true);
		shapePanel.add(square, gbc);
		square.addActionListener(this);
		
		circle = new JButton("circle");
		setGridBagConstraints(2, 1, 1, 1, true);
		shapePanel.add(circle, gbc);
		circle.addActionListener(this);

		colorIcon = new ImageIcon(getClass().getResource("color(1).png"));
		colorbtn = new JButton("C1", colorIcon);
		setGridBagConstraints(3, 0, 1, 1, true);
		shapePanel.add(colorbtn, gbc);
		colorbtn.addActionListener(this);

		
		colorbtn2 = new JButton("C2", colorIcon);
		setGridBagConstraints(3, 1, 1, 1, true);
		shapePanel.add(colorbtn2, gbc);
		colorbtn2.addActionListener(this);
		
		filled = new JCheckBox("Filled",false);
		setGridBagConstraints(4, 0, 1, 1, true);
		shapePanel.add(filled, gbc);
		filled.addItemListener(this);
		
		gradient = new JCheckBox("Gradient",false);
		setGridBagConstraints(4, 1, 1, 1, true);
		shapePanel.add(gradient, gbc);
		gradient.addItemListener(this);
		
		clear = new JButton("clear");
		actionPanel.add(clear);
		clear.addActionListener(this);

		undo = new JButton("undo");
		actionPanel.add(undo);
		undo.addActionListener(this);

		redo = new JButton("redo");
		actionPanel.add(redo);
		redo.addActionListener(this);
		
		
		bottomPanel.add(shapePanel);
		add(actionPanel,BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);
		add(drawpanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == randgen) {
			drawpanel.randgen(15);
		}
		else if (e.getSource() == rect) {
			drawpanel.setShapeType(RECT);
		}
		else if (e.getSource() == oval) {
			drawpanel.setShapeType(OVAL);
		}
		else if (e.getSource() == vtri) {
			drawpanel.setShapeType(VTRI);
		}
		else if (e.getSource() == square) {
			drawpanel.setShapeType(SQU);
		} 
		else if (e.getSource() == circle) {
			drawpanel.setShapeType(CIR);
		}
		else if (e.getSource() == clear) {
			drawpanel.clear();
		}
		else if (e.getSource() == undo) {
			drawpanel.undo();
		}
		else if (e.getSource() == redo) {
			drawpanel.redo();
		} 
		else if (e.getSource() == colorbtn) {
			color = JColorChooser.showDialog(PainterFrame.this, "Choose a Color", color);
			colorbtn.setBackground(color);
			drawpanel.setColor(color);
		}
		else if (e.getSource() == colorbtn2) {
			color2 = JColorChooser.showDialog(PainterFrame.this, "Choose a Color", color2);
			colorbtn2.setBackground(color2);
			drawpanel.setColor2(color2);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO 自動產生的方法 Stub
		if(e.getStateChange()==ItemEvent.SELECTED){
			drawpanel.setFilled(true);
		}
		else
		{
			drawpanel.setFilled(false);
		}
		if(e.getStateChange()==ItemEvent.SELECTED)
		{
			drawpanel.setFilled(true);
		}
	}

}
