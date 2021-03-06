package stub_drivers.dataservice.deliveryorderdata;

import dataservice.orderdataservice.DeliveryOrderDataService;
import po.DeliveryOrderPO;
import util.ResultMessage;

public class DeliveryOrderDataService_driver {
	public void driver(DeliveryOrderDataService deliveryOrder) {
		DeliveryOrderPO po = new DeliveryOrderPO(null, "19700101",
				"00100011970010100001");
		if (deliveryOrder.add(po).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed!");
		}
		if (deliveryOrder.add(po).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,order exited");
		}
		DeliveryOrderPO get = deliveryOrder.find("00100011970010100001");
		if (get != null)
			System.out.println("find:id=" + get.getId() + ",date="
					+ get.getTime());
		get = deliveryOrder.find("001100119700101000001");
		if (get == null)
			System.out.println("not found");
	}

	public static void main(String[] args) {
		DeliveryOrderDataService deliveryOrder = new DeliveryOrderDataService_stub();
		DeliveryOrderDataService_driver driver = new DeliveryOrderDataService_driver();
		driver.driver(deliveryOrder);

	}
}
