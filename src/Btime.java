/**
 * @author cloud
 */
public abstract class Btime implements Runnable {

	public static final long DEFAULT_DELAY_TIME = 1000;
	private long delayTime;
	private volatile boolean goon;
	/**
	 * 
	 */
	public Btime() {
		this(DEFAULT_DELAY_TIME);
	}
	/**
	 * 
	 */
	public Btime(long delayTime) {
		this.delayTime = delayTime;
	}
	/**
	 * 
	 */
	public Btime startUp() {
		if (goon == true) {
			return this;
		}
		goon = true;
		new Thread(this).start();
		return this;
	}
	/**
	 * 
	 */
	public void stop() {
		if (goon == false) {
			return;
		}
		goon = false;
	}
	/**
	 * 
	 */
	@Override
	public void run() {
		
		while (goon) {
			try {
				Thread.sleep(delayTime);
				new InnerWoker();
			} catch (InterruptedException e) {
				stop();
			}
		}
	}
	/**
	 * 
	 */
	private class InnerWoker implements Runnable {

		InnerWoker() {
			new Thread(InnerWoker.this).start();
		}
		
		@Override
		public void run() {
			doing();
		}
		
	}
	/**
	 * 
	 */
	public abstract void doing();
}