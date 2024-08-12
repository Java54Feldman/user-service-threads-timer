package telran.multithreading;

public class TimerController {

	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();
		timer.start();
		Thread.sleep(10_000);
		//TODO
		//figure out a solution allowing timer stop
		//as example in 5 seconds you stop the timer
		//following 5 seconds application is running with no timer

	}

}
