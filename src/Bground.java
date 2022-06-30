/**
 * @author cloud
 */
public class Bground
{
	
	public void set() {
		//歸零
		setspace(0,31,B.w,B.ground-B.size-31,0,0);
		//設地板和天花板
		setspace(0,B.ground-B.size,B.w,B.h-B.ground,1,2);
		setspace(0,0,B.w,30,1,1);
		//設場地
		if(B.data==1) {
			setfild(B.fild1, B.fildsize1);
			setdoor(B.doorxy1,3);
			if(B.easyhard==2||B.easyhard==1) settrap(B.trapxy1, B.trapsize1);
			if(B.easyhard==2)settrap(B.hidetrapxy1, B.hidesize1);
		}
		else if(B.data==2) {
			setfild(B.fild2, B.fildsize2);
			setdoor(B.doorxy2,3);
			setdoor(B.hintxy2,5);
			if(B.easyhard==2) {
				settrap(B.trapxy2, B.trapsize2);
				settrap(B.hidetrapxy2, B.hidesize2);
			}
		}
	}
	
	public void setspace(int x,int y,int xw,int yh,int contain,int top) {
			for(int i=x;i<x+xw;i++) {
			B.c[i][y] = top;
			for(int j=y+1;j<y+yh;j++) {
				B.c[i][j] = contain;
			}
		}		
	}
	
	public void setfild(int[] f,int fs) {
		for(int i=0;i<fs;i++) {
			if(f[i*4]-B.size<=0) {
				setspace(0 ,f[i*4+1]-B.size, f[i*4+2],f[i*4+3]+B.size,1,2);
			}
			else {
				setspace(f[i*4]-B.size ,f[i*4+1]-B.size, f[i*4+2]+B.size,f[i*4+3]+B.size,1,2);
			}
		}
	}
	
	public void setdoor(int[] d,int a) {
		if(d[0]-B.size<=0) setspace(0,d[1],50+B.size,50-B.size,a,a);
		else setspace(d[0]-B.size,d[1],50+B.size,50-B.size,a,a);	
	}
	
	public void settrap(int[] t,int ts) {
		for(int i=0;i<ts;i++) {
			if(t[i*2]-B.size<=0) setspace(0,t[i*2+1],50+B.size,50-B.size,4,4);
			else setspace(t[i*2]-B.size,t[i*2+1],50+B.size,50-B.size,4,4);
			}
	}
	
	
	public void newground() {	
		//在空中
		if(B.c[B.x][B.y+1]==0) {
			B.newground = B.y+1;
			while(B.c[B.x][B.newground]!=2){
				B.newground++;
			}
		}
	}
	
	public void newgroundd() {	
		//在地底
		if(B.c[B.x][B.y+1]==1) {
			B.newground = B.y+1;
			while(B.c[B.x][B.newground]!=2){
				B.newground--;
			}
		}
	}
}
