package rpc;

import rpc.slice.*;

public class MockEnvService {
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


    
    
    private rpc.slice.ClientServicePrx service_;
    public MockEnvService() {
    	service_ = ClientProxy.service();
    }
    
}
