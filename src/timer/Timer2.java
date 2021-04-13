package timer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Timer2 implements PropertyChangeListener {
	//instance variables are: an amount of time and a client
	int timeRemaining;
	Notifiable observerClient;
	
	/**
	 * This constructor will initialize the instance variables of the timer,
	 * and create an instance of clock, which keep track of the seconds as the
	 * tick down.
	 * @param initialTime
	 * @param newClient
	 */
	public Timer2(int initialTime, Notifiable newClient) {
		this.timeRemaining = initialTime;
		this.observerClient = newClient;
		Clock2.instance().addPropertyChangeListener(this);
	}
	
	/**
	 * Method to top off timer
	 * @param additionalTime
	 */
	public void addTimeToTimer(int additionalTime) {
		this.timeRemaining += additionalTime;
	}
	
	
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
