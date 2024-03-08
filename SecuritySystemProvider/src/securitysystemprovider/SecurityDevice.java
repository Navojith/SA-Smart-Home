package securitysystemprovider;

public interface SecurityDevice {
	public void turnOn();
	public void turnOff();
	public void setDetected(boolean state);
	public boolean getDetected();
	public String getLocation();
	public void setLocation(String location);
}
