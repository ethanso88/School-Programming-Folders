package View;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
	private Clip clip;

	public void playMusic(String filePath) {
		try {
			File musicFile = new File(filePath);
			if (musicFile.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.loop(Clip.LOOP_CONTINUOUSLY); // Loops forever
				clip.start();
			} else {
				System.out.println("Music file not found: " + filePath);
			}
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void stopMusic() {
		if (clip != null && clip.isRunning()) {
			clip.stop();
			clip.close();
		}
	}
}
