import java.net.URL;
import javax.sound.sampled.*;
/**
 * @author cloud
 */
public class Bsong
{
	static Clip sound;
	static URL soundurl[] = new URL[30];
	
	AudioInputStream ais;
	
	public Bsong() {
		soundurl[0] = getClass().getResource("start.wav");
		soundurl[1] = getClass().getResource("video.wav");
		soundurl[2] = getClass().getResource("song1.wav");
		soundurl[3] = getClass().getResource("song2.wav");
		soundurl[4] = getClass().getResource("video2.wav");
	}
	
	
	public void playsong(int i) {
		if(i<10) B.soundplayed = true;
		try {
			ais = AudioSystem.getAudioInputStream(soundurl[i]);
			sound = AudioSystem.getClip();
			sound.open(ais);
			sound.start();
		}catch (Exception e) {}	
	}
	
	public void stopsong() {
		if(B.soundplayed) {
			sound.stop();
			B.soundplayed = false;
		}
	
	}
}
