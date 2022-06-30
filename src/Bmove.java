/**
 * @author cloud
 */
public class Bmove
{
	Bground g = new Bground();
	Bsong song = new Bsong();
	Bsound sound = new Bsound();
	
	public Bmove() {
	}
	
	public void move() {
		g.newground();
		jump();
		B.newx = B.x + B.xv;
		B.newy = (int) (B.y + B.yv);
		//check是否要移動
		//x是否超出場地
		if(B.newx<0) B.newx = 0;
		if(B.newx>B.w-B.size) B.newx = B.w-B.size;
		//是否碰到門
		if(B.c[B.newx][B.newy]==3) {
			door();
			return;
		}
		//是否碰到陷阱
		else if(B.c[B.newx][B.newy]==4) {
			dead();
			return;
		}
		//是否碰到提示
		else if(B.c[B.newx][B.newy]==5) {
			Bdraw2.hint = true;
		}
		//x座標不正確
		if(B.c[B.newx][B.y]==1||B.c[B.newx][B.y]==2) {
			B.newx = B.x;
		}
		//y座標不正確
		if(B.c[B.newx][B.newy]==1||B.c[B.newx][B.newy]==2) {
			if(B.yv<0)B.newy = B.y;
			else {
				g.newgroundd();
				B.newy = B.newground-1;
			}
			B.yv = 0;
		}
		
		if(B.newy == B.newground-1) {
			B.wtouch = 0;
			B.groundtemp = B.newground;
		}
		if(B.canmovey)B.y = B.newy;
		if(B.canmovex)B.x = B.newx;
			
		
	}
	public void jump() {
		//在空中
		if(B.y<B.newground-1) {
			if(B.yv<20)B.yv += B.a;
			if(B.wtouch==2) {
				B.yv = -Math.pow(2*(B.jumphigh-B.groundtemp+B.y), 0.5);
				if(B.yv<-20)B.yv=-20;
				B.wtouch = 3;
				sound.playsound(10);
			}
		}
		//不在空中
		else {
			if(B.wtouch==1) {
				B.yv = -B.YV;
				sound.playsound(1);
			}
			else B.yv = 0;
		}
	}
	public void door() {
		song.stopsong();
		B.first=true;
		B.ktouch=false;
		B.videotemp=0;
		B.x = 100;
		B.y = 150;
		if(B.easyhard==1) {
			B.data=4;
			return;
		}
		if(B.data==1) {
			if(Bdraw1.a==1)Bdraw1.a=2;
			B.data++;
			return;
		}
		B.data=4;
	}
	
	public void dead() {
		B.videodata = B.data;
		B.ktouch=false;
		B.x = 0;
		B.y = 500;
		song.stopsong();
		B.data = 5;
		B.videotemp=0;
	}
}
