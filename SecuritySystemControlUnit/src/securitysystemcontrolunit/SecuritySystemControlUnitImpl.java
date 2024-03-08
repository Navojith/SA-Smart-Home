package securitysystemcontrolunit;

import java.util.ArrayList;
import java.util.Scanner;
import securitysystemprovider.SecurityDevice;
import securitysystemprovider.SecuritySystem;

public class SecuritySystemControlUnitImpl implements SecuritySystemControlUnit {
	SecuritySystem cctvSystem;
	SecuritySystem motionDetectorSystem;
	ArrayList<SecurityDevice> cctvDevices;
	ArrayList<SecurityDevice> motionDetectorDevices;
	Scanner sc = new Scanner(System.in);
	
	
	public static final String INSTALL = "install";
	public static final String LIST = "list";
	public static final String REMOVE = "remove";
	public static final String MOTIONDETECTOR = "motion detector";
	public static final String CCTV = "cctv";
	public static final String BACK = "back";
	public static final String QUIT = "quit";

	public SecuritySystemControlUnitImpl() {
		this.cctvDevices = new ArrayList<>();
		this.motionDetectorDevices = new ArrayList<>();
	}
	
	
	@Override
	public void attachSystem(SecuritySystem cctv, SecuritySystem motionDetector) {
		this.cctvSystem = cctv;
		this.motionDetectorSystem = motionDetector;
		
		System.out.println();
		System.out.println("==========================================================");
		System.out.println("              Security System Contol Unit                 ");
		System.out.println("==========================================================");
		System.out.println();
		
		
		while(true) {
			String input = this.showMainMenu();
			
			if(input.equalsIgnoreCase(INSTALL)) {
				String deviceType = this.showSelectDeviceTypeMenu();
				if(deviceType.equalsIgnoreCase(MOTIONDETECTOR)) {
					this.motionDetectorDevices.add(this.motionDetectorSystem.install(this.getLocation()));
				} else if(deviceType.equalsIgnoreCase(CCTV)) {
					this.cctvDevices.add(this.cctvSystem.install(this.getLocation()));
				} else if(deviceType.equalsIgnoreCase(BACK)) {
					continue;
				} else if(deviceType.equalsIgnoreCase(QUIT)) {
					break;
				}
			}else if(input.equalsIgnoreCase(LIST)) {
				this.listAllCCTVDevices();
				System.out.println("==================================================");
				this.listAllMotionDetectorDevices();
			} else if(input.equalsIgnoreCase(REMOVE)) {
				while(true) {
					String deviceType = this.showSelectDeviceTypeMenu();
					if(deviceType.equalsIgnoreCase(MOTIONDETECTOR)) {
						this.listAllMotionDetectorDevices();
						System.out.println("Select device to delete");
					} else if(deviceType.equalsIgnoreCase(CCTV)) {
						this.listAllCCTVDevices();				
						System.out.println("Select device to delete");
					} else if(deviceType.equalsIgnoreCase(BACK)) {
						break;
					} else if(deviceType.equalsIgnoreCase(QUIT)) {
						return;
					} else {
						System.out.println("Please Enter a valid input");
					}
				}
			} else if(input.equalsIgnoreCase(QUIT)) {
				break;
			} else {
				System.out.println("Please Enter a valid input");
			}
			
		}
	}
	
	public String showMainMenu() {
		System.out.println("Select the desired service from the below menu");
		System.out.println();
		System.out.println("Install new Device:     'Install'");
		System.out.println("List all devices:       'List'");
		System.out.println("Remove Device:          'Remove'");
		System.out.println("Quit the menue:         'Quit'");
		System.out.println();
		System.out.print("Type the prefered Selection: ");
		String input = sc.nextLine();
		return input;
	}
	
	public String showSelectDeviceTypeMenu() {
		System.out.println("Select the desired device type from the below menu");
		System.out.println();
		System.out.println("CCTV:                    'CCTV'");
		System.out.println("Motion Detector:         'Motion Detector'");
		System.out.println("Go back:                 'Back'");
		System.out.println("Quit the menue:          'Quit'");
		System.out.println();
		System.out.print("Type the prefered Selection: ");
		String input = sc.nextLine();
		return input;
	}

	public void listAllCCTVDevices() {
		int id = 1;
		System.out.println("==================================================");
		System.out.println("          Currently installed CCTV Devices        ");
		System.out.println();
		for(SecurityDevice device : this.cctvDevices) {
			System.out.println(id + " : " + device.getLocation());
			id++;
		}
		System.out.println();
	}
	
	public void listAllMotionDetectorDevices() {
		int id = 1;
		System.out.println("==================================================");
		System.out.println("        Currently installed Motion Detectors      ");
		System.out.println();
		for(SecurityDevice device : this.motionDetectorDevices) {
			System.out.println(id + " : " + device.getLocation());
			id++;
		}
		System.out.println();
	}
	
	public String getLocation() {
		System.out.print("Enter location : ");
		return sc.nextLine();
	}
}
