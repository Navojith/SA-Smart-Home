package securitysystemprovider;

public abstract class SecuritySystem {
	public SecurityDevice install(String location) {
		SecurityDevice device = installDevice(location);
		device.turnOn();
		return device;
	}

	public abstract SecurityDevice installDevice(String location);
}
