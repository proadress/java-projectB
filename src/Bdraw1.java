import java.awt.*;

import javax.swing.ImageIcon;
/**
 * @author cloud
 */
public class Bdraw1
{
	Image groundp1 = new ImageIcon(getClass().getResource("ground1.png")).getImage();
	Image trap = new ImageIcon(getClass().getClassLoader().getResource("trap.png")).getImage();
	Image role = new ImageIcon(getClass().getClassLoader().getResource("superhero1.png")).getImage();
	Image roler = new ImageIcon(getClass().getClassLoader().getResource("superhero2.png")).getImage();
	Image door = new ImageIcon(getClass().getClassLoader().getResource("exit.png")).getImage();
	Image jojo2 = new ImageIcon(getClass().getClassLoader().getResource("g2.png")).getImage();
	Image effectp2 = new ImageIcon(getClass().getClassLoader().getResource("e3.png")).getImage();
	Image hint1 = new ImageIcon(getClass().getClassLoader().getResource("hint1.png")).getImage();
	Image hint3 = new ImageIcon(getClass().getClassLoader().getResource("hint3.png")).getImage();
	Image i;
	
	static int a = 0;
	boolean b = true;
	
	public void drawsite1(Graphics2D g) { 
		if(B.etouch) {
			B.etouch=false;
			B.song.stopsong();
			Bpanel.restart(0);
			return;
		}
		
		if(!B.soundplayed) B.song.playsong(2);
		//場景繪製
		g.drawImage(groundp1, 0, 0,1600,900, null);
		//door繪製
		g.drawImage(door, B.doorxy1[0], B.doorxy1[1],50,50, null);
		//如過困難要畫陷阱
		if(B.easyhard==2||B.easyhard==1) trapdraw(g);
		//人物繪製
		roledraw(g);
		//字幕
		g.setFont(new Font("Algerian",Font.LAYOUT_LEFT_TO_RIGHT,30));
		g.setPaint(Color.black);
		g.drawString("Time : " + B.time[1],0, 20);
		g.drawString("King Crimson : " + B.cool2,0, 55);
		g.drawString("The World : " + B.cool1,0, 90);
		
		//king
		if(B.ktouch) {
			if(a==0) {
				a=1;
				B.canmovex = true;
				B.canmovey = true;
			}
			else if(a==2) a=3;
			else if(a==3)king(g);
		}
		//加上提示
		if(a==0) {
			B.canmovex = false;
			B.canmovey = false;
			g.drawImage(hint1, 0, 0,1600,900, null);
		}
		if(a==2) {
			g.drawImage(hint3, 0, 0,1600,900, null);
		}
	}
	
	public void roledraw(Graphics2D g) {
		if(B.xv<0) B.way = true;
		else if	(B.xv>0) B.way = false;	
		if(B.way)	g.drawImage(role, B.x, B.y, B.size,B.size,null);
		else g.drawImage(roler, B.x, B.y, B.size,B.size,null);
	}
	
	public void trapdraw(Graphics2D g) {
		//trap繪製
		for(int i=0;i<B.trapsize1;i++) g.drawImage(trap, B.trapxy1[i*2],B.trapxy1[i*2+1], 50,50,null);
		if(B.easyhard==2) {
		//fake trap繪製
		for(int i=0;i<B.fakesize1;i++) {
			if((B.faketrapxy1[i*2]<B.x&&B.faketrapxy1[i*2+1]<B.y)&&(B.faketrapxy1[i*2]+50>B.x&&B.faketrapxy1[i*2+1]+50>B.y)) {
				B.fakechick1[i] = true;
			}
			if(B.fakechick1[i]!=true) {
				g.drawImage(trap, B.faketrapxy1[i*2],B.faketrapxy1[i*2+1], 50,50,null);
			}
		}
		//hide trap繪製
		for(int i=0;i<B.hidesize1;i++) {
			if((B.hidetrapxy1[i*2]-100<B.x&&B.hidetrapxy1[i*2+1]-100<B.y)&&(B.hidetrapxy1[i*2]+150>B.x&&B.hidetrapxy1[i*2+1]+150>B.y)) {
				B.hidechick1[i] = true;
			}
			if(B.hidechick1[i]) {
				g.drawImage(trap, B.hidetrapxy1[i*2],B.hidetrapxy1[i*2+1], 50,50,null);
			}
		}
		}
	}
	
	public void king(Graphics2D g) {
		if(B.videotemp==0) {
			B.videott = B.time[0]-1;
			B.sound.playsound(3);
			B.canmovex = false;
			B.canmovey = false;
		}
		B.videotemp = B.time[0] - B.videott;
		
		
		if(B.videotemp<164) {
			//影片播放
			if(B.videotemp>=35&&B.videotemp<75) {
				g.drawImage(jojo2, 500, 500-B.videotemp*8, 1500,1200,null);
				i = new ImageIcon(getClass().getResource("effect (" + B.videotemp +").png")).getImage();
				//濾鏡繪製
				g.drawImage(effectp2, 0, 0, 1600,900,null);
			}
			else i = new ImageIcon(getClass().getResource("effect (" + B.videotemp +").jpg")).getImage();
			g.drawImage(i, 0, 0,1600,1000, null);
			//黑邊繪製
			g.setPaint(Color.black);
			g.fillRect(0, 0, B.w, B.move2);
			g.fillRect(0, 900-B.move2, B.w, 100);
			if(B.move2<100)B.move2+=20;
			}
		else if(B.videotemp>=164&&B.videotemp<230) {
			B.x = 1470;
			B.y = 318;
			g.drawImage(jojo2, 4500-B.videotemp*25, 0, 2000,1500,null);
			//濾鏡繪製
			g.drawImage(effectp2, 0, 0, 1600,900,null);
			//黑邊退場
			g.setPaint(Color.black);
			g.fillRect(0, 0, B.w, B.move2);
			g.fillRect(0, 900-B.move2, B.w, 100);
			if(B.move2>0)B.move2-=1;
			B.canmovex = true;
			B.canmovey = true;
		}
		else {
			B.ktouch=false;
			B.videotemp=0;
			B.move1 = 0;
			B.cool2=B.cool22;
		}
	}
}
