package mock;

import java.util.*;
import rpc.MockEnvService;
import rpc.slice.*;

class MockCar extends Thread {
	private rpc.MockEnvService service_;

	public MockCar() {
	}

	public void run() {
		try {
			service_ = new MockEnvService();
			StationInfo[] ss = service_.queryStations();
			System.out.printf("Get %d stations.\n", ss.length);
			Random rand = new Random();

			VehicleInfo vi = new VehicleInfo();
			vi.ID = rand.nextInt(100000);
			int vid = service_.registerVehicle(ss[rand.nextInt(ss.length)].ID, vi);

			while (true) {
				int sid = ss[rand.nextInt(ss.length)].ID;
				double m = service_.rentBattery(sid, vid, rand.nextInt(999999), 9.9);
				m -= service_.returnBattery(sid, vid, rand.nextInt(999999), rand.nextDouble() * 5);
				System.out.printf("%s: Car %d change battery in station %d, pay %f\n", new Date(),
						vid, sid, m);
				Thread.sleep(rand.nextInt(300000));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class MockEnv {
	void mock() {
		rpc.MockEnvService service = new MockEnvService();
		int[] sids = new int[10];
		for (int i = 0; i < 10; ++i) {
			sids[i] = service.registerStation(new StationInfo());
			service.openStation(sids[i]);
		}

		for (int i = 0; i < 50; ++i)
			new MockCar().start();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new MockEnv()).mock();
	}

}
