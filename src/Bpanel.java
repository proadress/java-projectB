import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author cloud
 */
public class Bpanel extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8558549261315259449L;
	
	Timer timer = new Timer(B.delay, this);
	Bmove m = new Bmove();
	Bground g = new Bground();
	Graphics2D gra;
	static Bsong song = new Bsong();
	
	Bdraw0 d0 = new Bdraw0();
	Bdraw1 d1 = new Bdraw1();
	Bdraw2 d2 = new Bdraw2();
	Bdraw3 d3 = new Bdraw3();
	Bdraw4 d4 = new Bdraw4();
	Bdraw5 d5 = new Bdraw5();
	int timetemp = 0;
	
	public Bpanel() {
		//設置
		this.setPreferredSize(new Dimension(B.w,B.h));
		this.setBackground(Color.white);
		//開始
		
		start();
	}
	
	public void start() {
		//設定場地
		B.first = true;
		timer.start();
		new Btime(40) {
		@Override
		public void doing() {
			B.time[0]++;
		}
		}.startUp();
	}
	
	public static void restart(int a) {
		song.stopsong();
		B.x = 0;
		B.y = 700;
		//設定場地
		B.first=true;
		B.data = a;
		B.videotemp = 0;
		for(int i=0;i<B.fakesize1;i++)B.fakechick1[i] = false;
		for(int i=0;i<B.hidesize1;i++)B.hidechick1[i] = false;
		for(int i=0;i<B.hidesize2;i++)B.hidechick2[i] = false;
	}
	
	public void paint(Graphics graphics) {
		super.paintComponent(graphics);
		
		gra = (Graphics2D)graphics;
		
		switch (B.data)
		{
			case 0: d0.drawmenu(gra);break;
			case 1: d1.drawsite1(gra);break;
			case 2: d2.drawsite2(gra);break;
			case 3: d3.drawsite3(gra);break;
			case 4: d4.drawclear(gra);break;
			case 5: d5.drawdead(gra);break;
		}
	}
	
	public void counttime() {
		B.time[1] = B.time[0]/25;
		if(B.time[1]!=timetemp) {
			timetemp =B.time[1];
			if(B.cool1>0)B.cool1--;
			if(B.cool2>0)B.cool2--;
		}
	}
	
	public void move() {
		if(B.data==1||B.data==2||B.data==3) {
			if(B.first) {
				g.set();
				B.first = false;
			}
			m.move();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		move();
		counttime();
		repaint();
	}
}
