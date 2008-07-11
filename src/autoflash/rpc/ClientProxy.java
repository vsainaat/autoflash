package autoflash.rpc;

/**
 * ClientProxy
 * 	这个类是Ice对客户端的接口，所有需要rpc的客户端操作都调用这个类的接口。
 * 	这个类对外是一个singleton，所有的操作句柄通过service()获得。
 */
public class ClientProxy {
	private autoflash.rpc.slice.ClientServicePrx service_;
	private Ice.Communicator ic_;
	static private ClientProxy cp_;
	
	public static autoflash.rpc.slice.ClientServicePrx service() {
		if (cp_ == null)
			cp_ = new ClientProxy();
		return cp_.service_;
	}

	/**
	 * @param args
	 */
	private ClientProxy() {
		System.out.println("Construct ClientProxy");
		ic_ = null;
        try {
            ic_ = Ice.Util.initialize();
            Ice.ObjectPrx base = ic_.stringToProxy(
                    "ClientService:default -p 16000");

            service_ = autoflash.rpc.slice.ClientServicePrxHelper.checkedCast(base);
            //service_.registerStation(new autoflash.rpc.slice.StationInfo());

            if (service_ == null)
                throw new Error("Invalid proxy");
            else
            	System.out.println("Service inited.");
                       
        } catch (Ice.LocalException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
	}
	
	public void destroy() {
        if (ic_ != null) {
            // Clean up
            //
            try {
                ic_.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.exit(0);
	}

}

