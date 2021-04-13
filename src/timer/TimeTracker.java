package timer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import events.TimerRanOutEvent;
import events.TimerTickedEvent;
public class TimeTracker implements PropertyChangeListener {
	//instance variables are: an amount of time and a client
	int timeRemaining;
	Notifiable client;
	
	/**
	 * This constructor will initialize the instance variables of the timer,
	 * and create an instance of clock, which keep track of the seconds as the
	 * tick down.
	 * @param initialTime
	 * @param newClient
	 */
	public TimeTracker(int initialTime, Notifiable newClient) {
		this.timeRemaining = initialTime;
		this.client = newClient;
		Timekeeper.instance().addPropertyChangeListener(this);
	}
	
	/**
	 * Method to top off timer TODO don't know if we will need this??
	 * @param additionalTime
	 */
	public void addTimeToTimer(int additionalTime) {
		this.timeRemaining += additionalTime;
	}
	
	/**
	 * Method to get the current amount of time remaining
	 * @return int - time remaining on the timer
	 */
	public int getRemainingTime() {
		return this.timeRemaining;
	}
	
	/**
	 * This method will hand the propertyChange that takes place when the 
	 * clock ticks off a second.  It will update and if there is not seconds
	 * left on timer.  client should handle a TimerRanOutEvent
	 * 
	 */
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// if the timeRemaining less 1 leaves timer less than 0 - handle a TimeRanOutEvent
		if((timeRemaining - 1) <= 0) {
			client.handleEvent(TimerRanOutEvent.instance());
			Clock.instance().removePropertyChangeListener(this);
		}else {
			//else update the timer
			client.handleEvent(new TimerTickedEvent(timeRemaining));
		}
	}
	

}
