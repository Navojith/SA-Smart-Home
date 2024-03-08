package securitysystemcontrolunit;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import securitysystemprovider.CCTVSystem;
import securitysystemprovider.MotionDetectorSystem;
import securitysystemprovider.SecuritySystem;

public class SecuritySystemControlUnitActivator implements BundleActivator {

	ServiceReference<?> cctvServiceReference;
	ServiceReference<?> motionDetectorServiceReference;
	

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Started Security System Control Unit");
		cctvServiceReference = bundleContext.getServiceReference(CCTVSystem.class.getName());
		motionDetectorServiceReference = bundleContext.getServiceReference(MotionDetectorSystem.class.getName());
		
		CCTVSystem cctvSystem = (CCTVSystem) bundleContext.getService(cctvServiceReference);
		MotionDetectorSystem motionDetectorSystem = (MotionDetectorSystem) bundleContext.getService(motionDetectorServiceReference);
		
		SecuritySystemControlUnit controlUnit = new SecuritySystemControlUnitImpl();
		controlUnit.attachSystem(cctvSystem, motionDetectorSystem);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopped Security System Control Unit");
		bundleContext.ungetService(cctvServiceReference);
	}

}
