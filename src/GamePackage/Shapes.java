package GamePackage;
import java.awt.Color;
import java.util.Random;

public class Shapes 
{	
	private int[][] shape;
	private Color color;
	private int axisX, axisY;
	private int[][][] shapes;
	private int currentRotation;
	private Color[] colorScheme = { Color.BLUE, Color.CYAN, Color.MAGENTA, Color.DARK_GRAY, Color.ORANGE, Color.DARK_GRAY};
	
	
	public int getAxisX() {
		return axisX;
	}

	public int getAxisY() {
		return axisY;
	}

	public void setAxisX( int axisX) {
		this.axisX = axisX;
	}
	
	public void setAxisY( int axisY) {
		this.axisY = axisY;
	}

	public Shapes(int[][] shape) {
		this.shape = shape;
//		
//		axisX = 3;
//		axisY = 2;
		initShape();

	}

	public int[][] getShape() {
		return shape;
	}


	public Color getColor() {
		return color;
	}

	
	public int getHeight() {
		return shape.length;
	}
	
	public int getWidth() {
		return shape[0].length;
	}
	
	public void moveDown() {
		axisY++;
	}
	
	public void moveRight() {
		axisX++;
	}
	
	public void moveLeft() {
		axisX--;
	}
	
	public void fall(int gridWidth) 
	{
		Random random = new Random();
		
		currentRotation = random.nextInt( shapes.length);
		shape = shapes[currentRotation];
		
		axisY = -getHeight();
		axisX = random.nextInt(gridWidth - getWidth());
		
		color = colorScheme[ random.nextInt(colorScheme.length) ];
	}
	
	public int getEnd() 
	{
		return axisY + getHeight();
	}
	
	public void rotate() 
	{
		currentRotation++;
	
		if(currentRotation > 3) 		
		{
			currentRotation =0;
			}
		
		shape = shapes[currentRotation];
	}
	
	void initShape() {
		shapes = new int[4][][];
		
		for(int i = 0; i < 4; i++) {
			
			int row = shape[0].length;
			int col = shape.length;
			
			shapes[i] = new int[row][col];
			
			for(int j = 0; j < row; j++) {
				for(int k = 0; k < col; k++) {
					shapes[i][j][k] = shape[col-k-1][j];
				}
			}
			shape = shapes[i];
		}
	}
	
	public int getLeftEdge() {
		return axisX;
	}
	
	public int getRightEdge() {
		return axisX + getWidth();
	}
}


