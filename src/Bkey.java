import java.awt.event.*;
/**
 * @author cloud
 */
public class Bkey extends KeyAdapter
{	
	static boolean wlonetouch;
	static boolean elonetouch;
	
	public void speed() {
		if(B.dtouch&&( B.xv==0 || B.xv==-B.XV)) {
			B.xv = B.XV;
		}
		else if(B.atouch&&( B.xv==0 || B.xv==B.XV)) {
			B.xv = -B.XV;
		}
		
		
		if(B.atouch||B.dtouch);
		else B.xv = 0;
	}
	
	public void keyTyped(KeyEvent e) {
		switch(e.getKeyChar()) {
		
		case 'd':B.dtouch = true;break;		
		case 'a':B.atouch = true;break;	
		case 'w':
			if(B.canmovey) {
				if(!wlonetouch) {
				if(B.wtouch==0||B.wtouch==1) {
					B.wtouch++;
					wlonetouch = true;
				}
			}
			}
			
			break;
		case ' ':
			if(B.canmovey) {
				if(!wlonetouch) {
				if(B.wtouch==0||B.wtouch==1) {
					B.wtouch++;
					wlonetouch = true;
				}
			}
			}
			
			break;
		case 'r':B.rtouch = true;break;	
		case 'e':
			if(B.data==1||B.data==2||B.data==3) if(B.videotemp>0)return;
			if(!elonetouch) {
					B.etouch=true;
					elonetouch = true;
				}
			break;
			
		case 'q':if(B.cool1==0)if(B.data==2)B.qtouch = true;break;	
		case 'k':if(B.cool2==0)if(B.data==1)B.ktouch = true;break;	
		}
		speed();
	}
	
	public void keyReleased(KeyEvent e) {
		
		switch(e.getKeyChar()) {
		case 'd':B.dtouch=false;break;		
		case 'a':B.atouch=false;break;	
		case 'w':wlonetouch = false;break;
		case ' ':wlonetouch = false;break;
		case 'r':B.rtouch = false;break;
		case 'e':elonetouch = false;B.etouch = false;break;
		}
		speed();
	}
}
