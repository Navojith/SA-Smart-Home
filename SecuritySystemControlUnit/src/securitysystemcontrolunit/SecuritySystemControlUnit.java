package securitysystemcontrolunit;

import securitysystemprovider.SecuritySystem;

public interface SecuritySystemControlUnit {
	public void attachSystem(SecuritySystem cctv, SecuritySystem motionDetector);
}
