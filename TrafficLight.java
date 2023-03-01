
public class TrafficLight {

	private boolean red;
	private boolean yellow;
	private boolean green;
	
	public TrafficLight() {
		this.red = true;
		this.yellow = false;
		this.green = false;
		
	}

	public void redOn() {
		this.yellow = false;
		this.green = false;
		this.red = true;
	}
	
	public void yellowOn() {
		this.red = false;
		this.green = false;
		this.yellow = true;
	}
	
	public void greenOn() {
		this.red = false;
		this.yellow = false;
		this.green = true;
	}
	
	public boolean isRed() {
		return red;
	}
	
	public boolean isYellow() {
		return yellow;
	}

	public boolean isGreen() {
		return green;
	}
	
}
