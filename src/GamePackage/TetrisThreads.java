package GamePackage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TetrisThreads extends Thread{
	
	private GamePlay gamePlay;
	private TetrisFrame tetrisFrame;
	private int score;
	private int level = 1;
	private int scorePerLevel = 3;
	private int pause = 400;
	private int speed = 15;

	TetrisThreads(GamePlay gamePlay, TetrisFrame tetrisFrame)
	{
		this.gamePlay = gamePlay;
		this.tetrisFrame = tetrisFrame;
		
		tetrisFrame.maintainScore(score);
		tetrisFrame.maintainLevel(level);
	}
	
	
	@Override
	public void run() 
	{
		while(true) 
		{
			gamePlay.moveShapes();
			
			while(gamePlay.moveBlockDown()) {
			
				try 
				{
					
					Thread.sleep(pause);
				}
				catch(InterruptedException ex) 
				{
					return;
				}
			}
			
			if(gamePlay.isGameAreaFull()) {
				TetrisGame.gameOver();
				System.exit(0);
				break;
			}
			
			gamePlay.moveBlockToBg();
			score += gamePlay.removeBlocksline();
			tetrisFrame.maintainScore(score);
			
			int lvel = score / scorePerLevel + 1;
			if(lvel > level) 
			{
				level = lvel;
				tetrisFrame.maintainLevel(level);
				pause -= speed;
			}
		}
	}
}
