package securitysystemprovider;

public class MotionDetector implements SecurityDevice {

	private String location;
	private boolean isDetected;
	
	public MotionDetector(String location) {
		this.location = location;
		this.isDetected = false;
	}

	@Override
	public void turnOn() {
		System.out.println("CCTV in " + this.location + " turned on");
	}

	@Override
	public void turnOff() {
		System.out.println("CCTV in " + this.location + " turned off");
	}

	@Override
	public void setDetected(boolean state) {
		this.isDetected = state;
	}

	@Override
	public boolean getDetected() {
		return this.isDetected;
	}
	
	@Override
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String getLocation() {
		return this.location;
	}

}
