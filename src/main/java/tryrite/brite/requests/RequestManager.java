package tryrite.brite.requests;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import net.hypixel.api.reply.skyblock.BazaarReply;
import tryrite.brite.main.Brite;
import tryrite.brite.menus.Menu;

public class RequestManager implements Runnable{

	public Brite brite;
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	public ScheduledFuture<?> beeperHandle;
	public BazaarReply rep;
	boolean alreadyRequesting = false;
	long lastRequestTime;

	public RequestManager(Brite brite) {
		this.brite = brite;
	}

	@Override
	public void run() {
		System.out.println("Calling the run " + (System.currentTimeMillis()/1000));
		if((System.currentTimeMillis()/1000)-lastRequestTime<4) {
			return;
		}
		else
			lastRequestTime = System.currentTimeMillis()/1000;
		try {
			rep = brite.hypixel.getBazaar().get();
			Thread.sleep(2000);
			for(Menu menu: brite.menuManager.menus) {
				menu.setproducts(rep);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 			
	}
	
	public void scheduleRequests() {
		if(!alreadyRequesting) {
			beeperHandle = scheduler.scheduleAtFixedRate(this, 0, 5, SECONDS);
			alreadyRequesting = true;
		}
	}
	
	public void cancelSchedule() {
		if(alreadyRequesting) {
			beeperHandle.cancel(true);
			alreadyRequesting = false;
		}
	}
}