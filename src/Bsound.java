import java.net.URL;
import javax.sound.sampled.*;
/**
 * @author cloud
 */
public class Bsound
{
	static Clip sound;
	static URL soundurl[] = new URL[30];
	
	AudioInputStream ais;
	
	public Bsound() {
		soundurl[1] = getClass().getResource("jump.wav");
		soundurl[2] = getClass().getResource("theworld.wav");
		soundurl[3] = getClass().getResource("king.wav");
	}
	
	
	public void playsound(int i) {
		if(i<10) B.soundplayed = true;
		try {
			ais = AudioSystem.getAudioInputStream(soundurl[i]);
			sound = AudioSystem.getClip();
			sound.open(ais);
			sound.start();
		}catch (Exception e) {}	
	}
	
}
