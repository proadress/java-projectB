import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;
/**
 * @author cloud
 */
public class Bdraw4
{
	boolean a = false;
	static ArrayList<Integer> record = new ArrayList<>();
	BufferedWriter out;
	BufferedReader br;
	File f;
	String s;
	int time = 0;
	Image end = new ImageIcon(getClass().getClassLoader().getResource("end.png")).getImage();
	
	public void drawclear(Graphics2D g) {		
		//讀檔（1次）
		if(!a) {
			a=true;
			read();
		}
		g.drawImage(end, 0, 0,1600,900, null);
		
		//顯示記錄
		g.setPaint(Color.red);
		g.setFont(new Font("清松手寫體1",Font.BOLD,60));
		s = "" + time;
		g.drawString(s,530, 330);
		
		g.setPaint(Color.black);
		for(int i=0;i<record.size();i++)g.drawString(record.get(i)+"",650, 550+i*70);
		
	}
	
	public void save() {
		try {
			if(B.easyhard==0) out = new BufferedWriter(new FileWriter("fildrecord.txt"));
			else if(B.easyhard==1) out = new BufferedWriter(new FileWriter("easyrecord.txt"));
			else out = new BufferedWriter(new FileWriter("hardrecord.txt"));
			
			for(int i=0;i<record.size();i++)
			out.write(record.get(i)+"\n");
			out.close();
		} catch (Exception e) {
			return;
		}
	}
	
	public void read() {
		try {
			if(B.easyhard==0) f = new File("fildrecord.txt");
			else if(B.easyhard==1) f = new File("easyrecord.txt");
			else f = new File("hardrecord.txt");
				
			if (!f.exists()) f.createNewFile();
			br = new BufferedReader(new InputStreamReader(new FileInputStream(f.getAbsoluteFile())));
			String info = null;
			while ((info = br.readLine()) != null) {
				record.add(Integer.parseInt(info));
			}
			br.close();
			time = B.time[1];
			record.add(time);
			Collections.sort(record);
			save();
		} catch (Exception e) {
			return;
		}
	}
	
}
