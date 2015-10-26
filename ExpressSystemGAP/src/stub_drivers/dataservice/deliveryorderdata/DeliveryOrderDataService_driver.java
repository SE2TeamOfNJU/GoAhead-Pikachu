package stub_drivers.dataservice.deliveryorderdata;

import po.DeliveryOrderPO;
import util.ResultMessage;

public class DeliveryOrderDataService_driver {
	public static void main(String[] args) {
		DeliveryOrderDataService_stub stub = new DeliveryOrderDataService_stub();
		DeliveryOrderPO po = new DeliveryOrderPO(null, "19700101",
				"00100011970010100001");
		if (stub.add(po).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed!");
		}
		if (stub.add(po).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,order exited");
		}
		DeliveryOrderPO get = stub.find("00100011970010100001");
		if (get != null)
			System.out.println("find:id=" + get.getId() + ",date="
					+ get.getTime());
		get = stub.find("001100119700101000001");
		if (get == null)
			System.out.println("not found");

	}
}
