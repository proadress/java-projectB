/**
 * @author cloud
 */
public class Bset
{
	Bframe f;
	Bpanel p;
	public Bset()
	{
		f = new Bframe();
		p = new Bpanel();
		f.addKeyListener(new Bkey());
		f.add(p);
		f.pack();
		f.setLocationRelativeTo(null);
	}
}
