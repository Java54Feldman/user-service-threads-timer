package telran.multithreading;

import java.time.format.DateTimeFormatter;

import telran.view.InputOutput;
import telran.view.SystemInputOutput;

public class TimerController {
	//figure out a solution allowing timer stop
	//as example in 5 seconds you stop the timer
	//following 5 seconds application is running with no timer

	public static void main(String[] args) throws InterruptedException {
		InputOutput io = new SystemInputOutput();
		System.out.println("***** Timer application *****\n");
		String timePattern = io.readString(
				"Enter the time format using pattern letters & delimeters (e.g. \"HH-mm-ss.S a\") or press \"Enter\" for the default format:");
		String timeResolution = io.readString(
				"Enter the time resolution in seconds (integer or float number) or press \"Enter\" for the default value:");
		
		try {
			Timer timer = switch ((timePattern.isEmpty() ? "0" : "*") + ":" + (timeResolution.isEmpty() ? "0" : "*")) {
				case "0:0" -> new Timer();
				case "0:*" -> new Timer(Float.parseFloat(timeResolution));
				case "*:0" -> new Timer(DateTimeFormatter.ofPattern(timePattern));
				default -> new Timer(DateTimeFormatter.ofPattern(timePattern), Float.parseFloat(timeResolution));
			};
			System.out.println("Press \"Enter\" button to stop the timer");
			timer.start();
			
			Thread stoppingThread = new Thread (() -> {
				io.readString("");
				timer.interrupt();
				System.out.println("Timer stopped");
			});
			stoppingThread.setDaemon(true);
			stoppingThread.start();
			Thread.sleep(10_000);
		} catch (RuntimeException e) {
			System.out.println("Input data is incorrect");
		}
		System.out.println("Application finished");

	}

}
