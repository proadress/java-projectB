import java.awt.FontMetrics;
/**
 * @author cloud
 */
public class B
{
	/* 座標系統
	 * c判定座標
	 */
	final static int[][] c = new int [B.w][B.h];
	static int[][] ctemp = new int [B.w][B.h];
	//----------------------------------------------------------------------------
	//場地
	final static int fild1[] = {	
			0, 500, 400, 100,
			650, 600, 800, 50,
			1550, 750, 50, 50,
			450, 350, 1150, 50,
			100, 300, 100, 100,
			300,100,100,300,
							};
	//陷阱
	final static int trapxy1[] = {
			500,750,
			800,750,
			850,550,
			};
	//假陷阱
	final static int faketrapxy1[] = {	
			650,550,
			850,550,
			1550,700,
			450,300,
			1400,300
			};	
	//藏陷阱
	final static int hidetrapxy1[] = {
			1450,750,
			700,300,
			700,150,
			0,450,
			1550,250
			};
	//門
	final static int doorxy1[] = {1550,300};
	
	final static int fildsize1 = fild1.length/4;
	final static int trapsize1 = trapxy1.length/2;						
	final static boolean[] fakechick1 = new boolean[faketrapxy1.length/2];
	final static int fakesize1 = faketrapxy1.length/2;
	final static boolean[] hidechick1 = new boolean[hidetrapxy1.length/2];
	final static int hidesize1 = hidetrapxy1.length/2;
	//----------------------------------------------------------------------------
	//場地2
	final static int fild2[] = {	
			0,50,1600,50,
			0,200,1550,100,
			0,350,50,150,
			0,550,50,150,
			0,750,450,50,
			1450,350,50,450,
			1150,350,50,100,
			1200,350,250,150,
			1050,350,100,350,
			850,750,500,1,
			1400,600,50,50,
			900,300,100,400,
			300,400,50,300,
			350,600,550,100
							};
	//陷阱2
	final static int trapxy2[] = {
			750,150,
			850,150,
			950,150,
			1050,150,
			450,750,
			500,750,
			550,750,
			600,750,
			650,750,
			700,750,
			750,750,
			0,700
			};
	//假陷阱2無(因為the world 陷阱會消失)
	final static int faketrapxy2[] = {	
			};
	//藏陷阱2
	final static int hidetrapxy2[] = {
			650,150,
			1150,150,
			850,700,
			800,550,
			};
	//門2
	final static int doorxy2[] = {850,550,};
	final static int hintxy2[] = {1150,450,};
	
	final static int fildsize2 = fild2.length/4;
	final static int trapsize2 = trapxy2.length/2;							
	final static boolean[] fakechick2 = new boolean[faketrapxy2.length/2];
	final static int fakesize2 = faketrapxy2.length/2;
	final static boolean[] hidechick2 = new boolean[hidetrapxy2.length/2];
	final static int hidesize2 = hidetrapxy2.length/2;
	//----------------------------------------------------------------------------
	/*基本參數*/
	final static int w = 1600;
	final static int h = 900;
	final static int ground = h-100;
	final static int delay = 12;
	final static int size = 30;
	
	/* 0開始畫面
	 * 1場景1
	 * 2場景2
	 * 3場景3
	 * 4死
	 * 5通關
	 * */
	static int data = 0;
	/* 場景切換
	 * 1簡單
	 * 2難
	 * */
	/*0*/static int easyhard = 0;
	static int[] time = {0,0};
	/*座標部分
	 * XVx默認速度
	 * YVy默認速度
	 * */
	/*0*/static int x = 0;
	/*600*/static int y = 600;
	static int newx;
	static int newy;
	static int xv = 0;
	static double yv = 0;
	final static int a = 1;
	static int XV = 7;
	static int YV = 15;
	final static int jumphigh = 200;
	static int groundtemp = ground;
	static int newground = ground;
	/*
	 * 角色左右
	 */
	static boolean way;
	/*
	 * 技能冷卻
	 * 黑邊
	 */
	static int cool1=0,cool2=0;
	final static int cool11=5,cool22=20;
	static int move1 = 0,move2=0;
	static boolean canmovey = true;
	static boolean canmovex = true;
	/*按鍵部分
	 * XVx默認速度
	 * YVy默認速度
	 * */
	static int wtouch = 0;
	static boolean atouch = false;
	static boolean dtouch = false;
	static boolean rtouch = false;
	static boolean etouch = false;
	static boolean qtouch = false;
	static boolean ktouch = false;
	static boolean first;
	/*
	 * 影片計數器
	 */
	static int videotemp = 0;
	static int videott = 0;
	static int startsize0 = 150;
	static int startsize1 = 150;
	static int startsize2 = 150;	
	/*
	 * sound part
	 */
	static boolean soundplayed;
	/*
	 * cannot skip
	 */
	static boolean restart;
	static int cantskip = 5;
	static int cantskipsize = 0;
	static String skip = "skip  [R]";
	static int videodata = 1;

	/*
	 * draw用
	 */
	static Bsong song = new Bsong();
	static Bsound sound = new Bsound();
	static FontMetrics stringlengh;
}
