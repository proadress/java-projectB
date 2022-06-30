import java.awt.*;

import javax.swing.ImageIcon;
/**
 * @author cloud
 */
public class Bdraw5
{
	String s;
	public void drawdead(Graphics2D g) {
		//設定影片
		if(!B.soundplayed) {
			if(B.videodata==1)B.song.playsong(1);
			else B.song.playsong(4);
			B.cantskip--;
		}
		if(B.videotemp==0) {
			B.videott = B.time[0]-1;
		}
		B.videotemp = B.time[0] - B.videott;
		
		if(B.videodata==1) {
			if(B.videotemp>=452) {
				B.cantskip=3;
				B.cantskipsize = 0;
				B.skip = "skip  [R]";
				Bpanel.restart(1);
				return;
			}
		g.drawImage(new ImageIcon(getClass().getResource("video (" + B.videotemp +").jpg")).getImage(), 0, 0,1600,900, null);
		}
		else {
			if(B.videotemp>=378) {
				B.cantskip=3;
				B.cantskipsize = 0;
				B.skip = "skip  [R]";
				Bpanel.restart(1);
				return;
			}
		g.drawImage(new ImageIcon(getClass().getResource("video2 (" + B.videotemp +").jpg")).getImage(), 0, 0,1600,900, null);
		}
		
		if(B.videotemp>50) {
		//設定字幕
		g.setPaint(Color.red);
		g.setFont(new Font("Colonna MT",Font.BOLD,500));
		B.stringlengh = g.getFontMetrics(g.getFont());
		s = "dead";
		g.drawString(s,(B.w-B.stringlengh.stringWidth(s))/2, 600);
		
		if(B.rtouch) {
			if(B.cantskip>0) {
				Bpanel.restart(1);
			}
			else {
				B.cantskipsize +=5;
				B.skip = "(cannot skip)";
			}
		}
		g.setFont(new Font("Chiller",Font.BOLD,100+B.cantskipsize));
		B.stringlengh = g.getFontMetrics(g.getFont());
		g.drawString(B.skip,(B.w-B.stringlengh.stringWidth(B.skip))/2, 800);
		}
	}
}
