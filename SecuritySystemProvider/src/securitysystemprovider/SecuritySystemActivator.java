package securitysystemprovider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class SecuritySystemActivator implements BundleActivator {

	ServiceRegistration<?> cctvSystemRegistration;
	ServiceRegistration<?> motionDetectorSystemRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Started Security System Provider");
		CCTVSystem cctvSystem = new CCTVSystem();
		MotionDetectorSystem motionDetectorSystem = new MotionDetectorSystem();
		cctvSystemRegistration = bundleContext.registerService(CCTVSystem.class.getName(), 
				cctvSystem, null);
		motionDetectorSystemRegistration = bundleContext.registerService(
				MotionDetectorSystem.class.getName(), motionDetectorSystem, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopped Security System Provider");
		this.cctvSystemRegistration.unregister();
		this.motionDetectorSystemRegistration.unregister();
	}

}
