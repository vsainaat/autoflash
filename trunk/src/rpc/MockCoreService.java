/**
 * 这个类是模拟的CoreService类，用于测试工作。
 */

package rpc;

import java.util.HashMap;
import java.util.Random;

import rpc.slice.Activity;
import rpc.slice.BatteryInfo;
import rpc.slice.BatteryQueryCondition;
import rpc.slice.DepotInfo;
import rpc.slice.DepotQueryCondition;
import rpc.slice.StationInfo;
import rpc.slice.StationQueryCondition;
import rpc.slice.VehicleInfo;
import rpc.slice.VehicleQueryCondition;

public class MockCoreService {
	MockCoreService () {
		hmStations_ = new HashMap<Integer, StationInfo>();
		hmVehicles_ = new HashMap<Integer, VehicleInfo>();
    	hmOpenness_ = new HashMap<Integer, Boolean>();
	}
	
	/** For Power Station */
	// The amount may differ from the data in the database, and need to be measured in station.
	// The amount may differ from the data in the database, and need to be measured in station.
	public double rentBattery(int stationID, int vehicleID, int batteryID, double amount) { 
		System.out.printf("Car %d rent battery %d in station %d\n", vehicleID, batteryID, stationID);
		return amount * 9.9; 
	}
	// The remaining amount is measured in station.
	public double returnBattery(int stationID, int vehicleID, int batteryID, double amount) { 
		System.out.printf("Car %d return battery %d in station %d\n", vehicleID, batteryID, stationID);
		return amount * 9.9;
	}
	 
    // Move battery, return the battery information.
	public BatteryInfo moveBatteryToStation(int stationID, int batteryID) { return null; }
	public BatteryInfo moveBatteryFromStation(int stationID, int batteryID) { return null; }

    // Report damaged battery.
    public void reportDamagedBattery(int stationID, int batteryID) { }

    // For a car first change battery, register, return vehicle ID.
    public int registerVehicle(int stationID, VehicleInfo info) {    
	    System.out.println("Register vehicle.");
		Random rand = new Random();
		do {
			info.ID = rand.nextInt(999);
		} while(hmStations_.containsKey(info.ID));
		System.out.println("Get VehicleID " + info.ID);
			
		hmVehicles_.put(info.ID, info);
		hmOpenness_.put(info.ID, false);
		return info.ID;
	}

    public void openStation(int stationID) { 
    	hmOpenness_.put(stationID, true);
    	System.out.printf("Station %d opened.\n", stationID);
    }
    public void closeStation(int stationID) {
    	hmOpenness_.put(stationID, false);
    	System.out.printf("Station %d closed.\n", stationID);
    }


    /** For Depot */
    // Move battery, return the battery information.
	public BatteryInfo moveBatteryToDepot(int depotID, int batteryID) { return null; }
	public BatteryInfo moveBatteryFromDepot(int depotID, int batteryID) { return null; }
	
    // Charge battery.
	// The currentAmount record the current electricity amount of the battery.
	// The useAmount record the electricity amount used for change since last report.
	public void charge(int stationID, int batteryID, double currentAmount, double useAmount) {}
	
	// To discard a battery.
	public void discard(int BatteryID) {}
	
    public void openDepot(int depotID) {
    	;
    }
    public void closeDepot(int depotID) { 
    	;
    }

    /** For battery supplier */
	// For battery suppler to purchase a new battery.
	public void purchase(BatteryInfo info) { }
	
    /** For administrator */
	// Use integer value to represent time
    public Activity[] queryActivities(int start, int end) { return null; }
	public Activity[] queryBatteryActivities(int batteryID, int start, int end) { return null; }
	public Activity[] queryStationActivities(int staionID, int start, int end) { return null; }
	public Activity[] queryDepotActivities(int staionID, int start, int end) { return null; }

	public StationInfo[] queryStations(StationQueryCondition c) { 
		return hmStations_.values().toArray(new StationInfo[0]);
	}
	
	public DepotInfo[] queryDepots(DepotQueryCondition c) { return null; }
	public BatteryInfo[] queryBatteries(BatteryQueryCondition c) { return null; }
	public VehicleInfo[] queryVehicles(VehicleQueryCondition c) {
		return hmVehicles_.values().toArray(new VehicleInfo[0]);
	}

    // After registration, return the ID assigned
    public int registerStation(StationInfo info) {
    	System.out.println("Register station.");
    	Random rand = new Random();
    	do {
    		info.ID = rand.nextInt(99);
    	} while(hmStations_.containsKey(info.ID));
    	System.out.println("Get StationID " + info.ID);
    		
    	hmStations_.put(info.ID, info);
    	hmOpenness_.put(info.ID, false);
    	return info.ID;
    }
    
    public int registerDepot(DepotInfo info) { return 0; }
    public void unregisterStation(int stationID) { }
    public void setStation(int stationID, StationInfo info) { }
    public void unregisterDepot(DepotInfo info) { }
    public void setDepot(int stationID, DepotInfo info) { }

    
    private HashMap<Integer, StationInfo> hmStations_;   
    private HashMap<Integer, VehicleInfo> hmVehicles_;
    private HashMap<Integer, Boolean> hmOpenness_;
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		System.out.println("Test MockCoreService: Do nothing.");
	}


}
