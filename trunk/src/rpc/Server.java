/**
 * 这个类是Server类，它的功能是初始化服务器端并启动Ice服务。这这个类里并没有具体的工作，应当由ljb来提供一个CoreService类并完成真正的数据操作。
 */

package rpc;

import rpc.slice.Activity;
import rpc.slice.BatteryInfo;
import rpc.slice.BatteryQueryCondition;
import rpc.slice.DepotInfo;
import rpc.slice.DepotQueryCondition;
import rpc.slice.StationInfo;
import rpc.slice.StationQueryCondition;
import rpc.slice.VehicleInfo;
import rpc.slice.VehicleQueryCondition;

public class Server extends rpc.slice._ClientServiceDisp {
	private MockCoreService service;
	
	Server () {
		service = new MockCoreService();
	}
	
	/** For Power Station */
	// The amount may differ from the data in the database, and need to be measured in station.
	// The amount may differ from the data in the database, and need to be measured in station.
	public double rentBattery(int stationID, int vehicleID, int batteryID, double amount, Ice.Current current) { 
		return service.rentBattery(stationID, vehicleID, batteryID, amount);
	}
	// The remaining amount is measured in station.
	public double returnBattery(int stationID, int vehicleID, int batteryID, double amount, Ice.Current current) { 
		return service.returnBattery(stationID, vehicleID, batteryID, amount);
	}
	 
    // Move battery, return the battery information.
	public BatteryInfo moveBatteryToStation(int stationID, int batteryID, Ice.Current current) { 
		return service.moveBatteryFromStation(stationID, batteryID); 
	}
	public BatteryInfo moveBatteryFromStation(int stationID, int batteryID, Ice.Current current) { 
		return service.moveBatteryFromStation(stationID, batteryID); 
	}

    // Report damaged battery.
    public void reportDamagedBattery(int stationID, int batteryID, Ice.Current current) { 
    	service.reportDamagedBattery(stationID, batteryID);
    }

    // For a car first change battery, register, return vehicle ID.
    public int registerVehicle(int stationID, VehicleInfo info, Ice.Current current) {    
	    return service.registerVehicle(stationID, info);
	}

    public void openStation(int stationID, Ice.Current current) { 
    	service.openStation(stationID);
    }
    public void closeStation(int stationID, Ice.Current current) {
    	service.closeStation(stationID);
    }

    /** For Depot */
    // Move battery, return the battery information.
	public BatteryInfo moveBatteryToDepot(int depotID, int batteryID, Ice.Current current) { return null; }
	public BatteryInfo moveBatteryFromDepot(int depotID, int batteryID, Ice.Current current) { return null; }
	
    // Charge battery.
	// The currentAmount record the current electricity amount of the battery.
	// The useAmount record the electricity amount used for change since last report.
	public void charge(int stationID, int batteryID, double currentAmount, double useAmount, Ice.Current current) {
		service.charge(stationID, batteryID, currentAmount, useAmount);
	}
	
	// To discard a battery.
	public void discard(int BatteryID, Ice.Current current) {
		service.discard(BatteryID);
	}
	
    public void openDepot(int depotID, Ice.Current current) {
    	service.openDepot(depotID);
    }
    public void closeDepot(int depotID, Ice.Current current) { 
    	service.closeDepot(depotID);
    }

    /** For battery supplier */
	// For battery suppler to purchase a new battery.
	public void purchase(BatteryInfo info, Ice.Current current) {
		service.purchase(info);
	}
	
    /** For administrator */
	// Use integer value to represent time
    public Activity[] queryActivities(int start, int end, Ice.Current current) { 
    	return service.queryActivities(start, end); 
    }
	public Activity[] queryBatteryActivities(int batteryID, int start, int end, Ice.Current current) { 
		return service.queryBatteryActivities(batteryID, start, end); 
	}
	public Activity[] queryStationActivities(int staionID, int start, int end, Ice.Current current) { 
		return service.queryStationActivities(staionID, start, end); 
		}
	public Activity[] queryDepotActivities(int staionID, int start, int end, Ice.Current current) { 
		return service.queryDepotActivities(staionID, start, end); 
	}

	public StationInfo[] queryStations(StationQueryCondition c, Ice.Current current) { 
		return service.queryStations(c);
	}
	
	public DepotInfo[] queryDepots(DepotQueryCondition c, Ice.Current current) { 
		return service.queryDepots(c); 
	}
	public BatteryInfo[] queryBatteries(BatteryQueryCondition c, Ice.Current current) { 
		return service.queryBatteries(c); 
	}
	public VehicleInfo[] queryVehicles(VehicleQueryCondition c, Ice.Current current) {
		return service.queryVehicles(c);
	}

    // After registration, return the ID assigned
    public int registerStation(StationInfo info, Ice.Current current) {
    	return service.registerStation(info);
    }
    
    public int registerDepot(DepotInfo info, Ice.Current current) { 
    	return service.registerDepot(info); 
    }
    public void unregisterStation(int stationID, Ice.Current current) { 
    	service.unregisterStation(stationID);
    }
    public void setStation(int stationID, StationInfo info, Ice.Current current) {
    	service.setStation(stationID, info);
    }
    public void unregisterDepot(DepotInfo info, Ice.Current current) {
    	service.unregisterDepot(info);
    }
    public void setDepot(int stationID, DepotInfo info, Ice.Current current) { 
    	service.setDepot(stationID, info);
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		System.out.println("Server started.");
	       int status = 0;
	        Ice.Communicator ic = null;
	        try {
	            ic = Ice.Util.initialize(args);
	            Ice.ObjectAdapter adapter
	                = ic.createObjectAdapterWithEndpoints(
	                    "ClientServiceAdapter", "default -p 16000");
	            Ice.Object object = new Server();
	            adapter.add(object,ic.stringToIdentity("ClientService"));
	            adapter.activate();
	            
	            System.out.println("ClientService started.");
	            ic.waitForShutdown();

	        } catch (Exception e) {
	            e.printStackTrace();
	            status = 1;
	        }
	        if (ic != null) {
	            // Clean up
	            //
	            try {
	                ic.destroy();
	            } catch (Exception e) {
	                System.err.println(e.getMessage());
	                status = 1;
	            }
	        }
	        System.exit(status);
	}

}
