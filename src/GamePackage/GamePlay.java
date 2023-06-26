package GamePackage;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import ShapesPackage.*;

public class GamePlay extends JPanel{
	
	private int row, col, blockSize;
	private Shapes shapes;
	private Color[][] background;
	private Shapes[] tetrisShapes;
	
	GamePlay(JPanel panel, int col)
	{
		this.setBounds(panel.getBounds());
		this.setBackground(panel.getBackground());
		this.setBackground(panel.getBackground());
		this.col = col;

		blockSize = (int) (this.getBounds().getWidth() / col);
		row = (int) (this.getBounds().getHeight() / blockSize);
				
		tetrisShapes = new Shapes[] {new I(), new J(),new L(),new O(),new S(),new T(), new Z()};
	}
	
	
      public void moveShapes() 
	{
    	  
    	Random random = new Random();
    	shapes = tetrisShapes[random.nextInt(tetrisShapes.length)];
		shapes.fall(col);
	}

      
      public void background() 
      {
  		background = new Color[row][col];
      }
      
      public boolean isGameAreaFull() 
      {
    	  if(shapes.getAxisY() < 0) 
    	  {
    		  shapes = null;
    		  return true;
    	  }
    	  
    	  return false;
      }
      
      
	public boolean moveBlockDown() 
	{
		if(isReached() == false) 
		{
	
			return false;
		}
		
		shapes.moveDown();
		repaint();
		
		return true;
	}
	
	
	public void rightMovement() {
		
		if(shapes == null) 
		{
			return;
		}
		
		if(!isRight() || shapes.getRightEdge() > 9) {
			return;
		}
		
		shapes.moveRight();
		repaint();
	}
	
	public void leftMovement() {
		
		if(shapes == null) 
		{
			return;
		}
		
		if(!isLeft()) {
			return;
		}
		shapes.moveLeft();
		repaint();
	}
	
	public void downMovement() 
	{
		if(shapes == null) 
		{
			return;
		}
		
		while(isReached()) 
		{
			shapes.moveDown();
		}
		repaint();
	}
	
	public void doRotation() {
		
		if(shapes == null) 
		{
			return;
		}
		
		shapes.rotate();

    	
		if(shapes.getLeftEdge() < 0) {
			shapes.setAxisX(0);
		}
		
		if(shapes.getRightEdge() >= col) {
			shapes.setAxisX(col - shapes.getAxisX());
		}
		
		if(shapes.getEnd() >= row) {
			shapes.setAxisY(row - shapes.getHeight());
		}
		
		
		repaint();
	}
	
	private boolean isReached() {
		
		if(shapes.getEnd() == row) {
			return false;
		}
		
		int[][]shape = shapes.getShape();
		int w = shapes.getWidth();
		int h = shapes.getHeight();
		
		for(int i=0; i < w; i++) 
		{
			for(int j = h - 1; j >= 0; j--) 
			{
				if(shape[j][i] !=0 ) 
				{
					int x = i + shapes.getAxisX();
					int y = j + shapes.getAxisY() + 1;
					if(y < 0) 
					{
						break;
					}
					if(background[y][x] != null) 	return false;
					break;
				}
			}
		}
		
		return true;
	}
	
	private boolean isLeft() 
	{
		if(shapes.getLeftEdge() == 0) 
		{
			return false;
		}
		
		int[][]shape = shapes.getShape();
		int w = shapes.getWidth();
		int h = shapes.getHeight();
		
		for(int i=0; i < h; i++) 
		{
			for(int j = 0; j < w; j++) 
			{
				if(shape[i][j] !=0 ) 
				{
					int x = j + shapes.getAxisX() - 1;
					int y = i + shapes.getAxisY();
					if(y < 0) 
					{
						break;
					}
					if(background[y][x] != null) 	return false;
					break;
				}
			}
		}
		
		return true;
	}
	
	private boolean isRight() 
	{
		if(shapes.getRightEdge() == col) 
		{
			return false;
		}
		
		int[][]shape = shapes.getShape();
		int w = shapes.getWidth();
		int h = shapes.getHeight();
		
		for(int i=0; i < h; i++) 
		{
			for(int j = w - 1; j >= 0; j--) 
			{
				if(shape[i][j] !=0 ) 
				{
					int x = j + shapes.getAxisX() + 1;
					int y = i + shapes.getAxisY();
					if(y < 0) 
					{
						break;
					}
					if(background[y][x] != null) 	return false;
					break;
				}
			}
		}
		
		return true;
	}
	
	
	
	public void moveBlockToBg() 
	{
		int[][] shape = shapes.getShape();
		int h = shapes.getHeight();
		int w = shapes.getWidth();
		
		int xAxis = shapes.getAxisX();
		int yAxis = shapes.getAxisY();
		
		Color color = shapes.getColor();
		
		for(int i=0; i < h; i++) 
		{
			for(int j=0; j< w; j++) 
			{
				if(shape[i][j] == 1) 
				{
					background[i + yAxis][j + xAxis] = color;
				}
			}
		}
	}
	
	
	
	private void drawShape(Graphics graphics) 
	{
		int h = shapes.getHeight();
		int w = shapes.getWidth();
		Color c = shapes.getColor();
		int[][] shape = shapes.getShape();
		
		
		for(int i=0; i<h; i++) 
		{
			for (int j=0; j<w; j++) 
			{
				if(shape[i][j] == 1) 
				{
					int axisX = ( shapes.getAxisX() + j ) * blockSize;
					int axisY = ( shapes.getAxisY() + i ) * blockSize;
					drawSq(graphics, c, axisX, axisY);
				}
				
			}
		}
	}
	
	
	
	private void drawBg(Graphics graphics) {
		Color color;
		
		for(int i=0; i < row; i++) 
		{
			for(int j=0; j < col; j++) 
			{
				color = background[i][j];
				
				if(color != null) 
				{
					int x = j * blockSize;
					int y = i * blockSize;
					
					drawSq(graphics, color, x, y);
				}
			}
		}
	}
	
	
	
	private void drawSq(Graphics graphics, Color color, int x, int y) {
		graphics.setColor(shapes.getColor());
		graphics.fillRect(x, y, blockSize, blockSize);
		graphics.setColor(Color.black);
		graphics.drawRect(x, y, blockSize, blockSize);
	}
	
	
	@Override
	protected void paintComponent(Graphics graphics) 
	{
		super.paintComponent(graphics);
		
		
		drawShape(graphics);
		drawBg(graphics);
	}
	
	
	public int removeBlocksline() 
	{
		boolean isLineCompleted;
		int score = 0;
		
		for(int i = row -1; i >= 0; i--) 
		{
			isLineCompleted = true;
			
			for(int j = 0; j < col; j++) 
			{
				if(background[i][j] == null) 
				{
					isLineCompleted = false;
					break;
				}
			}
			
			if(isLineCompleted) 
			{
				score++;
				removeBlockLine(i);
				moveOneLineDown(i);
				removeBlockLine(0);
				i++;
				repaint();
			}
		}
		
		if(score > 0) {
			TetrisGame.playClearLineSound();
		}
		return score;
	}
	
	private void removeBlockLine(int i) 
	{
		for(int k = 0; k < col; k++) 
		{
			background[i][k] = null;
		}
	}
	
	private void moveOneLineDown(int row) 
	{
		for(int i = row; i > 0; i--) 
		{
			for(int j = 0; j < col; j++) 
			{
				background[i][j] = background[i - 1][j];
			}
		}
	}
}
