package painter;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class PainterFrame extends JFrame implements ActionListener, ItemListener {

	private JPanel actionPanel;
	private JButton clear;
	private JButton undo;
	private JButton redo;

	private JPanel shapePanel;
	private GridBagConstraints gbc;
	private JButton randgen;
	private JButton rect;
	private JButton oval;
	private JButton vtri;
	private JButton square;
	private JButton circle;
	private JButton line;
	private JButton diamond;

	private JSlider slider;
	private JLabel strokeLabel;
	private JTextField strokeText;
	private float stroke;

	private JCheckBox filled;
	private JCheckBox gradient;

	private JButton colorBtn;
	private Icon colorIcon;
	private Color color;

	private JButton colorBtn2;
	private Icon colorIcon2;
	private Color color2;

	private JPanel bottomPanel;

	private DrawPanel drawPanel;

	private int numTypes = 6;
	final int RECT = 1;
	final int OVAL = 2;
	final int VTRI = 3;
	final int LINE = 4;
	final int SQUARE = 5;
	final int CIRCLE = 6;

	public PainterFrame() {
		super();

		bottomPanel = new JPanel();

		drawPanel = new DrawPanel();
		add(drawPanel, BorderLayout.CENTER);

		actionPanel = new JPanel();

		clear = new JButton("Clear");
		actionPanel.add(clear);
		clear.addActionListener(this);

		undo = new JButton("Undo");
		actionPanel.add(undo);
		undo.addActionListener(this);

		redo = new JButton("Redo");
		actionPanel.add(redo);
		redo.addActionListener(this);

		add(actionPanel, BorderLayout.NORTH);
		// bottomPanel.add(actionPanel);

		shapePanel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints();

		randgen = new JButton("Randgen");
		setGridBagConstraints(0, 0, 1, 1, true);
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		gbc.gridheight = 1;
//		gbc.gridwidth = 1;
		shapePanel.add(randgen, gbc);
		randgen.addActionListener(this);
		setGridBagConstraints(1, 0, 1, 1, true);
		rect = new JButton("Rect");

		shapePanel.add(rect, gbc);
		rect.addActionListener(this);

		oval = new JButton("Oval");
		setGridBagConstraints(2, 0, 1, 1, true);
		shapePanel.add(oval, gbc);
		oval.addActionListener(this);

		line = new JButton("Line");
		setGridBagConstraints(3, 0, 1, 1, true);
		shapePanel.add(line, gbc);
		line.addActionListener(this);

		vtri = new JButton("Vtri");
		setGridBagConstraints(0, 1, 1, 1, true);
		shapePanel.add(vtri, gbc);
		vtri.addActionListener(this);

		square = new JButton("Square");
		setGridBagConstraints(1, 1, 1, 1, true);
		shapePanel.add(square, gbc);
		square.addActionListener(this);

		circle = new JButton("Circle");
		setGridBagConstraints(2, 1, 1, 1, true);
		shapePanel.add(circle, gbc);
		circle.addActionListener(this);

		diamond = new JButton("Diamond");
		setGridBagConstraints(3, 1, 1, 1, true);
		shapePanel.add(diamond, gbc);
		diamond.addActionListener(this);

		colorIcon = new ImageIcon(getClass().getResource("color.png"));
		colorBtn = new JButton("C1", colorIcon);
		setGridBagConstraints(4, 0, 2, 1, true);
		shapePanel.add(colorBtn, gbc);
		colorBtn.addActionListener(this);

		colorBtn2 = new JButton("C2", colorIcon);
		setGridBagConstraints(5, 0, 2, 1, true);
		shapePanel.add(colorBtn2, gbc);
		colorBtn2.addActionListener(this);

		filled = new JCheckBox("Filled", false);
		setGridBagConstraints(6, 0, 1, 1, true);
		shapePanel.add(filled, gbc);
		filled.addItemListener(this);

		gradient = new JCheckBox("Gradient", false);
		setGridBagConstraints(7, 0, 1, 1, true);
		shapePanel.add(gradient, gbc);
		gradient.addItemListener(this);

		strokeLabel = new JLabel(" Stroke: ");
		setGridBagConstraints(6, 1, 1, 1, true);
		shapePanel.add(strokeLabel, gbc);

		strokeText = new JTextField();
		setGridBagConstraints(7, 1, 1, 1, true);
		shapePanel.add(strokeText, gbc);
		strokeText.addActionListener(this);

		// add(shapePanel, BorderLayout.SOUTH);
		bottomPanel.add(shapePanel);

		add(bottomPanel, BorderLayout.SOUTH);
	}

	void setGridBagConstraints(int x, int y, int h, int w, boolean fill) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = h;
		gbc.gridwidth = w;
		if (fill)
			gbc.fill = GridBagConstraints.BOTH;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == randgen) {
			drawPanel.randgen(15);
		} else if (e.getSource() == rect) {
			drawPanel.setShapeType(RECT);
		} else if (e.getSource() == oval) {
			drawPanel.setShapeType(OVAL);
		} else if (e.getSource() == vtri) {
			drawPanel.setShapeType(VTRI);
		} else if (e.getSource() == line) {
			drawPanel.setShapeType(LINE);
		} else if (e.getSource() == square) {
			drawPanel.setShapeType(SQUARE);
		} else if (e.getSource() == clear) {
			drawPanel.clear();
		} else if (e.getSource() == undo) {
			drawPanel.undo();
		} else if (e.getSource() == redo) {
			drawPanel.redo();
		} else if (e.getSource() == colorBtn) {
			color = JColorChooser.showDialog(PainterFrame.this, "Pick Color", color);
			colorBtn.setBackground(color);
			drawPanel.setColor(color);
		} else if (e.getSource() == colorBtn2) {
			color2 = JColorChooser.showDialog(PainterFrame.this, "Pick Color", color2);
			colorBtn2.setBackground(color2);
			System.out.println("jframe" + color2);
			drawPanel.setColor2(color2);
		} else if (e.getSource() == strokeText) {
			stroke = Float.parseFloat(strokeText.getText());
			System.out.println("jframe: " + stroke);
			drawPanel.setStroke(stroke);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == filled) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				drawPanel.setFilled(true);
			} else {
				drawPanel.setFilled(false);
			}
		} else if (e.getSource() == gradient) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				drawPanel.setGradient(true);
			} else {
				drawPanel.setGradient(false);
			}
		}
	}

}
