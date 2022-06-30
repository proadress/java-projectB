import java.awt.*;
import javax.swing.ImageIcon;
/**
 * @author cloud
 */
public class Bdraw2
{
	Image door = new ImageIcon(getClass().getClassLoader().getResource("exit.png")).getImage();
	//Image trap = new ImageIcon(getClass().getClassLoader().getResource("trap.png")).getImage();
	Image jojo = new ImageIcon(getClass().getClassLoader().getResource("g1.png")).getImage();
	Image role = new ImageIcon(getClass().getClassLoader().getResource("superhero1.png")).getImage();
	Image roler = new ImageIcon(getClass().getClassLoader().getResource("superhero2.png")).getImage();
	Image effectp1 = new ImageIcon(getClass().getClassLoader().getResource("e1.png")).getImage();
	Image hint2 = new ImageIcon(getClass().getClassLoader().getResource("hint2.png")).getImage();
	Image ground2 = new ImageIcon(getClass().getClassLoader().getResource("ground2.png")).getImage();
	Image trap2 = new ImageIcon(getClass().getClassLoader().getResource("lollipop.png")).getImage();
	
	static boolean hint;
	
	public void drawsite2(Graphics2D g) {
		if(!B.soundplayed) B.song.playsong(3);
		if(B.etouch) {
			B.etouch=false;
			B.song.stopsong();
			Bpanel.restart(0);
			return;
		}
			
		g.setPaint(Color.white);
		g.fillRect(0, 0, B.w, 30);
			
		g.setPaint(new Color(166, 124, 82));
		g.fillRect(0, B.ground, B.w, B.h-B.ground);
		/*
		//fild2繪製
		for(int i=0;i<B.fildsize2;i++) g.fillRect(B.fild2[i*4], B.fild2[i*4+1], B.fild2[i*4+2], B.fild2[i*4+3]);
		*/
		//場景繪製
		g.drawImage(ground2, 0, 0,1600,900, null);
		
		//door繪製
		g.drawImage(door, B.doorxy2[0], B.doorxy2[1],50,50, null);
		if(B.easyhard==2) trapdraw(g);
		roledraw(g);
		//字幕
		g.setFont(new Font("微軟黑正體",Font.LAYOUT_LEFT_TO_RIGHT,20));
		g.setPaint(Color.white);
		g.drawString(" time：" + B.time[1],0, 20);
		g.drawString("Skill cooldown of King Crimson : " + B.cool2,0, 40);
		g.drawString("Skill cooldown of The World : " + B.cool1,0, 60);
		//技能
		if(B.qtouch){
			hint = false;
			world(g);
		};
		//提示
		if(hint)g.drawImage(hint2, 0, 0,1600,900, null);
		}

	public void roledraw(Graphics2D g) {
		if(B.xv<0) B.way = true;
		else if	(B.xv>0) B.way = false;	
		if(B.way)	g.drawImage(role, B.x, B.y, B.size,B.size,null);
		else g.drawImage(roler, B.x, B.y, B.size,B.size,null);
	}
	
	public void trapdraw(Graphics2D g) {
		//trap繪製
		for(int i=0;i<B.trapsize2;i++) g.drawImage(trap2, B.trapxy2[i*2],B.trapxy2[i*2+1], 50,50,null);
		//fake trap繪製
		for(int i=0;i<B.fakesize2;i++) {
			if((B.faketrapxy2[i*2]<B.x&&B.faketrapxy2[i*2+1]<B.y)&&(B.faketrapxy2[i*2]+50>B.x&&B.faketrapxy2[i*2+1]+50>B.y)) {
				B.fakechick2[i] = true;
			}
			if(B.fakechick2[i]!=true) {
				g.drawImage(trap2, B.faketrapxy2[i*2],B.faketrapxy2[i*2+1], 50,50,null);
			}
		}
		//hide trap繪製
		for(int i=0;i<B.hidesize2;i++) {
			if((B.hidetrapxy2[i*2]-100<B.x&&B.hidetrapxy2[i*2+1]-100<B.y)&&(B.hidetrapxy2[i*2]+150>B.x&&B.hidetrapxy2[i*2+1]+150>B.y)) {
				B.hidechick2[i] = true;
			}
			if(B.hidechick2[i]) {
				g.drawImage(trap2, B.hidetrapxy2[i*2],B.hidetrapxy2[i*2+1], 50,50,null);
			}
		}
	}
	
	public void world(Graphics2D g) {
		if(B.videotemp==0) {
			B.sound.playsound(2);
			B.canmovey = false;
			B.canmovex = false;
			B.xv = 0;
			B.XV = 1;
		}
		else if(B.videotemp<600) {
			//濾鏡繪製
			if(B.videotemp>200) {
				g.drawImage(effectp1, 0, 0, 1600,900,null);
				B.canmovex=true;
			}
			//黑邊繪製
			g.setPaint(Color.black);
			g.fillRect(0, 0, B.w, B.move2);
			g.fillRect(0, 900-B.move2, B.w, 100);
			if(B.move2<100)B.move2+=2;
			//jojo現身
			g.drawImage(jojo, 2000-B.move1, 200, 500,1000,null);
			if(B.move1<900)B.move1+=50;
		}
		else if(B.videotemp>=600&&B.videotemp<650) {
			//黑邊退場
			g.setPaint(Color.black);
			g.fillRect(0, 0, B.w, B.move2);
			g.fillRect(0, 900-B.move2, B.w, 100);
			B.move2-=2;
			//jojo退場
			g.drawImage(jojo, 2000-B.move1, 200, 500,1000,null);
			B.move1-=18;
			B.yv = 0;
			B.xv = 0;
			B.XV = 7;
			B.canmovey = true;
		}
		else {
			B.qtouch=false;
			B.videotemp=0;
			B.move1 = 0;
			B.cool1=B.cool11;
			return;
		}
		B.videotemp++;
	}
}
