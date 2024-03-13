

/* Name: Laurel Tay Raeanne
 * School: UoR
 * Email: ltay3@u.rochester.edu
 * Date last modified: April 4th
 * Assignment Name: URPaint
*/


/*	•	Read First: HOW TO USE PROGRAM 
	⁃	Use sliders first to choose desired color
	⁃	Click button of what you wish to change AFTER sliders 
	⁃	EG background, or a specific shape
	⁃	Draw shape/ change background by using buttons
	⁃	Whenever sliders are used to change color, reselect button that you wish to use 
	⁃	Press and hold drag - but drag SLOWLY for it to work


*/

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.util.List;


public class URPaint extends JFrame implements MouseListener, ChangeListener, MouseMotionListener {

   
	private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 400;
    private Color bgColor = Color.WHITE;
    private Color circleColor = Color.RED;
    private Color squareColor = Color.BLUE;
    private List<Shape> shapeList;
    private Shape currentShape = null;
       
    private JPanel canvas = new JPanel() {
        private static final long serialVersionUID = 1L;
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(bgColor);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };

    private JButton circleButton = new JButton("Circle");
    private JButton squareButton = new JButton("Square");
    private JButton bgColorButton = new JButton("Background Color");
    private JButton clearButton = new JButton("Clear");
    private JSlider redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 255);
    private JSlider greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
    private JSlider blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
    private boolean circleMode = false;
    private boolean squareMode = false;
    private static final int CIRCLE_SIZE = 20;
    private static final int SQUARE_SIZE = 20;

    
    public URPaint() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("PaintHW");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        shapeList  = new ArrayList<>();

        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);

        circleButton.addActionListener(e -> {
            Color newColor = chooseColor();
            if (newColor != null) {
                circleColor = newColor;
                canvas.repaint();
         
            circleMode = true;
            squareMode = false;
            

            }});

        squareButton.addActionListener(e -> {
            Color newColor = chooseColor();
            if (newColor != null) {
                squareColor = newColor;
                canvas.repaint();
            circleMode = false;
            squareMode = true;
            }});

        bgColorButton.addActionListener(e -> {
            Color newColor = chooseColor();
            if (newColor != null) {
                bgColor = newColor;
                canvas.repaint();
            }
        });

        clearButton.addActionListener(e -> {
            bgColor = Color.WHITE; // Reset background color
            canvas.removeAll(); // Remove all existing shapes from the canvas
            canvas.repaint(); // Repaint the canvas to show the cleared background
        });
        
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(circleButton);
        buttonPanel.add(squareButton);
        buttonPanel.add(bgColorButton);

        buttonPanel.add(clearButton);

        redSlider.setMajorTickSpacing(50);
        redSlider.setMinorTickSpacing(5);
        redSlider.setPaintTicks(true);
        redSlider.setPaintLabels(true);
        Hashtable<Integer, JLabel> redLabelTable = new Hashtable<Integer, JLabel>();
        redLabelTable.put(0, new JLabel("0"));
        redLabelTable.put(255, new JLabel("255"));
        redSlider.setLabelTable(redLabelTable);
        JLabel redSliderLabel = new JLabel("R");

        greenSlider.setMajorTickSpacing(50);
        greenSlider.setMinorTickSpacing(5);
        greenSlider.setPaintTicks(true);
        greenSlider.setPaintLabels(true);
        Hashtable<Integer, JLabel> greenLabelTable = new Hashtable<Integer, JLabel>();
        greenLabelTable.put(0, new JLabel("0"));
        greenLabelTable.put(255, new JLabel("255"));
        greenSlider.setLabelTable(greenLabelTable);
        JLabel greenSliderLabel = new JLabel("G");

        blueSlider.setMajorTickSpacing(50);
        blueSlider.setMinorTickSpacing(5);
        blueSlider.setPaintTicks(true);
        blueSlider.setPaintLabels(true);
        Hashtable<Integer, JLabel> blueLabelTable = new Hashtable<Integer, JLabel>();
        blueLabelTable.put(0, new JLabel("0"));
        blueLabelTable.put(255, new JLabel("255"));
        blueSlider.setLabelTable(blueLabelTable);
        JLabel blueSliderLabel = new JLabel("B");



        JPanel colorPanel = new JPanel();
        colorPanel.add(redSliderLabel);
        colorPanel.add(redSlider);
        colorPanel.add(greenSliderLabel);
        colorPanel.add(greenSlider);
        colorPanel.add(blueSliderLabel);
        colorPanel.add(blueSlider);

        JPanel sliderPanel = new JPanel();
        sliderPanel.add(colorPanel);

        JPanel mainPanel = new JPanel(new GridBagLayout()); // create a panel to hold the top panel, slider panel, and canvas

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 0.05;
        mainPanel.add(buttonPanel, gbc); // add the top panel to the north (top) of the main panel

        gbc.gridy = 1;
        gbc.weighty = 0.1;
        mainPanel.add(sliderPanel, gbc); // add the slider panel to the center of the main panel

        gbc.gridy = 2;
        gbc.weighty = 1;
        mainPanel.add(canvas, gbc); // add the canvas to the south (bottom) of the main panel

        getContentPane().add(mainPanel); // add the main panel to the content pane
        setVisible(true);

    }

    // if JSlider value is changed
    public void stateChanged(ChangeEvent e) {}

    private Color chooseColor() {
        int red = redSlider.getValue();
        int green = greenSlider.getValue();
        int blue = blueSlider.getValue();
        return new Color(red, green, blue);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    	int x = e.getX();
    	int y = e.getY();   
    
    	if (circleMode) {
    		Oval oval = new Oval(x - CIRCLE_SIZE / 2, y - CIRCLE_SIZE / 2, CIRCLE_SIZE, CIRCLE_SIZE, circleColor);
    		shapeList.add(oval);
    		canvas.add(oval);
    	} else if (squareMode) {
    		Rectangle rect = new Rectangle(x - SQUARE_SIZE / 2, y - SQUARE_SIZE / 2, SQUARE_SIZE, SQUARE_SIZE, squareColor);
    		shapeList.add(rect);
    		canvas.add(rect);
    	}
    	canvas.repaint();
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    	


    }
    
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    
    
    public static void main(String[] args) {
        new URPaint();
    }

    private abstract class Shape extends JPanel {
        protected int x;
        protected int y;
        protected int width;
        protected int height;
        protected Color color;

        public Shape(int x, int y, int width, int height, Color color) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
            setBounds(x, y, width, height);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
           
            	if(getShapeType()=="Oval"){
                    g.fillOval(x,y,getWidth(), getHeight());
                }
                if(getShapeType()=="Rect"){
                    g.fillRect(x,y,getWidth(),getHeight());
                }
            
        }
        public int getX() {
        	return x;
        }
        public int getY() {
        	return y;
        }

        public abstract String getShapeType();
    }



    private class Oval extends Shape {

        public Oval(int x, int y, int width, int height, Color color) {
            super(x, y, width, height, color);
        }

        @Override
        public String getShapeType() {
            return "Oval";
        }

        @Override
        protected void paintComponent(Graphics g) {
        	for(Shape s: shapeList) {
            g.setColor(color);
            g.fillOval(0, 0, getWidth(), getHeight());
        	}
        }
    }

    private class Rectangle extends Shape {
        private static final long serialVersionUID = 1L;
        public Rectangle(int x, int y, int width, int height, Color color) {
            super(x, y, width, height, color);
        }

        @Override
        public String getShapeType() {
            return "Rect";
        }

        @Override
        protected void paintComponent(Graphics g) {
        	super.paintComponent(g);
            g.setColor(color);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

	@Override
	public void mouseDragged(MouseEvent e) {
		int dragx = e.getX();
		int dragy = e.getY();
		
		for(Shape s: shapeList) {
			if(s.x >= dragx-10 && s.x <= dragx+10 && s.y >= dragy -10 && s.y <= dragy+10) {
				currentShape = s;
				break;
			}
		}
		
		if(currentShape != null) {
			currentShape.x = dragx;
			currentShape.y = dragy;
		}
		repaint();
		currentShape = null;
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}