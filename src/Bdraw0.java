import java.awt.*;

import javax.swing.ImageIcon;
/**
 * @author cloud
 */
public class Bdraw0
{
	Image menup = new ImageIcon(getClass().getResource("menu.png")).getImage();
	Image fild = new ImageIcon(getClass().getClassLoader().getResource("speedometer0.png")).getImage();
	Image easy = new ImageIcon(getClass().getClassLoader().getResource("speedometer1.png")).getImage();
	Image hard = new ImageIcon(getClass().getClassLoader().getResource("speedometer2.png")).getImage();
	
	int color1,color2,color3;
	int aa = 1;
	
	public void drawmenu(Graphics2D g) {
		if(B.videotemp==0) {
			B.song.playsong(0);
			B.videott = B.time[0]-1;
		}
		
		B.videotemp = B.time[0] - B.videott;
		
		if(B.videotemp<=303) {
			g.drawImage(new ImageIcon(getClass().getResource("startlogo (" + B.videotemp +").jpg")).getImage(), 0, 0,1600,900, null);
			if(B.etouch) {
				B.etouch=false;
				B.videott = B.time[0]-380;
			}
		}
		else if(B.videotemp>303&&B.videotemp<380) {
			g.setPaint(Color.black);
			g.fillRect(0, 0, B.w, B.h);	
		}
		else {	
			if(B.dtouch) if(aa<=2) {
				B.dtouch = false;
				aa++;
			}
			if(B.atouch) if(aa>=0) {
				B.atouch = false;
				aa--;
			}
			
			if(aa==0) {
				B.startsize0=200;
				B.startsize1=150;
				B.startsize2=150;
			}
			else if(aa==1) {
				B.startsize0=150;
				B.startsize1=200;
				B.startsize2=150;
			}
			else if(aa==2) {
				B.startsize0=150;
				B.startsize1=150;
				B.startsize2=200;
			}
			
			if(B.etouch) {
				B.etouch = false;
				B.easyhard = aa;
				B.song.stopsong();
				B.data = 1;
				B.videotemp = 0;
			}
			g.setPaint(new Color(0, color1, color2));
			g.fillRect(0, 0, B.w, B.h);	
			if(color1<178)color1+=2;
			if(color2<191)color2+=2;
			
			g.drawImage(menup, 0, 0,1600,900, null);
			g.drawImage(fild, 850-B.startsize0/2, 700-B.startsize0/2,B.startsize0,B.startsize0, null);
			g.drawImage(easy, 1160-B.startsize1/2, 700-B.startsize1/2,B.startsize1,B.startsize1, null);
			g.drawImage(hard, 1430-B.startsize2/2,700-B.startsize2/2,B.startsize2,B.startsize2, null);
		
		}
	}
}
