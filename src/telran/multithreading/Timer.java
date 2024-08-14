package telran.multithreading;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer extends Thread {
	//displaying time in a given format and a given resolution
	//example displaying each second or each 5 second, etc.
	private static final DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_TIME;
	private static final Float DEFAULT_TIME_RESOLUTION = 1f;
	DateTimeFormatter timeFormatter; 
	Float timeResolution;
	
	public Timer(DateTimeFormatter timeFormatter, Float timeResolution) {
		this.timeFormatter = timeFormatter;
		this.timeResolution = timeResolution;
		setDaemon(true);
	}
	public Timer(Float timeResolution) {
		this(DEFAULT_TIME_FORMATTER, timeResolution);
	}
	public Timer(DateTimeFormatter timeFormatter) {
		this(timeFormatter, DEFAULT_TIME_RESOLUTION);
	}
	public Timer() {
		this(DEFAULT_TIME_FORMATTER, DEFAULT_TIME_RESOLUTION);
	}
	public void run() {
		boolean running = true;
		while(running) {
			System.out.println(LocalTime.now().format(timeFormatter));
			try {
				sleep((long) (timeResolution * 1000));
			} catch (InterruptedException e) {
				running = false;
			}
		}
	}
}
