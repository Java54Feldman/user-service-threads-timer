package telran.multithreading;

import java.time.LocalTime;

public class Timer extends Thread {
	//TODO
	//displaying time in a given format and a given resolution
	//example displaying each second? or each 5 second, etc.
	public Timer() {
		setDaemon(true);
	}
	public void run() {
		while(true) {
			System.out.println(LocalTime.now());
			try {
				sleep(1000);
			} catch (InterruptedException e) {

			}
		}
	}
}
