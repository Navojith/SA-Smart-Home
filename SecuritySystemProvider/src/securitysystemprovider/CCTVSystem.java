package securitysystemprovider;

public class CCTVSystem extends SecuritySystem {

	@Override
	public SecurityDevice installDevice(String location) {
		return new CCTV(location);
	}

}
