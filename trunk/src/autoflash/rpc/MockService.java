package autoflash.rpc;


import java.util.Random;

import autoflash.rpc.slice.*;

public class MockService {
	// Register a random generated station
	public StationInfo registerMockStation() {
		StationInfo info = new StationInfo();
		System.out.println(rand_.nextInt());
		info.addr = new Address();
		info.addr.x = rand_.nextInt(999);
		info.addr.y = rand_.nextInt(999);
		info.capacity = rand_.nextInt(99999) + 30000;
		info.chargePrice = 10.0;
		info.owner = "autoflash";
		info.rentPrice = rand_.nextInt(99) + 10;
		info.ID = service_.registerStation(info);
		return info;
	}

	// Register a mock depot.
	public DepotInfo registerMockDepot() {
		DepotInfo info = new DepotInfo();
		info.addr = new Address();
		info.addr.x = rand_.nextInt(999);
		info.addr.y = rand_.nextInt(999);
		info.chargeCapacity = rand_.nextInt(9999) + 3000;
		info.chargePrice = 10.0;
		info.owner = "autoflash";
		info.rentPrice = rand_.nextInt(99) + 10;
		info.storageCapacity = info.chargeCapacity * 10;
		info.ID = service_.registerDepot(info);
		return info;
	}

	// Register a mock vehicle.
	public VehicleInfo registerMockVehicle(int stationID) {
		VehicleInfo info = new VehicleInfo();
		info.model = "benz";
		info.code = "88888";
		info.ID = service_.registerVehicle(stationID, info);
		return info;
	}

	// The amount may differ from the data in the database, and need to be measured in station.
	public double rentBattery(int stationID, int vehicleID, int batteryID, double amount) { 
		return service_.rentBattery(stationID, vehicleID, batteryID, amount); 
	}
	
	// The remaining amount is measured in station.
	public double returnBattery(int stationID, int vechildID, int batteryID, double amount) {
		return service_.returnBattery(stationID, vechildID, batteryID, amount);
	}

    public int registerVehicle(int stationID, VehicleInfo info) {
    	return service_.registerVehicle(stationID, info);
    }

    public void openStation(int stationID) {
    	service_.openStation(stationID);
    }
    public void closeStation(int stationID) {
    	service_.closeStation(stationID);
    }
    
    public int registerStation(StationInfo info) {
    	return service_.registerStation(info);
    }
	
    public StationInfo[] queryStations() { 
    	StationQueryCondition c = new StationQueryCondition();
    	c.addr = new Area();
    	return service_.queryStations(c);
    }
    
	public VehicleInfo[] queryVehicles(VehicleQueryCondition c) {
		return service_.queryVehicles(c);
	}
    
    private autoflash.rpc.slice.ClientServicePrx service_;
	private Random rand_;

    public MockService() {
    	service_ = ClientProxy.service();
    	rand_ = new Random();
    }
    
}
