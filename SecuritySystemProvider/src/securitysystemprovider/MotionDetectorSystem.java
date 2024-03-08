package securitysystemprovider;

public class MotionDetectorSystem extends SecuritySystem {

	@Override
	public SecurityDevice installDevice(String location) {
		return new MotionDetector(location);
	}

}
