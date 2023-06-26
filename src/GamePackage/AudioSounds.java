package GamePackage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioSounds {
	
	private String audioFile = "audios" + File.separator;
	private String lineClearSound = audioFile + "lineClear.wav";
	private String gameOver = audioFile + "gameOver.wav";
	
	private Clip clearLineSound, gameFinishSound;
	
	public AudioSounds()  {
		try 
		{
		clearLineSound = AudioSystem.getClip();
		gameFinishSound = AudioSystem.getClip();
		
		clearLineSound.open(AudioSystem.getAudioInputStream(new File(lineClearSound).getAbsoluteFile() ));
		
		gameFinishSound.open(AudioSystem.getAudioInputStream(new File(gameOver).getAbsoluteFile() ));
		}
		
		catch(LineUnavailableException ex){
			Logger.getLogger(AudioSounds.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void playClearLine() {
		clearLineSound.setFramePosition(0);
		clearLineSound.start();
	}

	public void playGameOver() {
		gameFinishSound.setFramePosition(0);
		gameFinishSound.start();
	}
}
