package gap.client.datacontroller.orderdata;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.expressorderdataservice.ExpressOrderDataService;
import gap.common.dataservice.orderdataservice.BillOrderDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.BillOrderPO;
import gap.common.util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BillOrderDateController {
	ExpressOrderDataService expressorder;
	BillOrderDataService billorder;

	public BillOrderDateController() {
		try {
			expressorder = (ExpressOrderDataService) Naming
					.lookup(RMIConfig.url
							+ ServiceName.EXPRESSORDER_DATA_SERVICE);
			billorder = (BillOrderDataService) Naming.lookup(RMIConfig.url
					+ ServiceName.BILLORDER_DATA_SERVICE);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public double getDeliveryMoney(String date, String delivery_id) {
		try {
			return expressorder.getDeliveryMoney(date, delivery_id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return -1;
	}

	public ResultMessage add(BillOrderPO po) {
		try {
			return billorder.add(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}
}