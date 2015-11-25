package gap.server.data.order;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.orderdataservice.LoadOrderDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.LoadOrderPO;
import gap.server.initial.NetInitial;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

public class LoadOrderDataServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
			LoadOrderDataService loadorder = (LoadOrderDataService) Naming
					.lookup(RMIConfig.url
							+ ServiceName.LOADORDER_DATA_SERVICE);
			// List<String> orders = new ArrayList<>();
			// orders.add("0000000001");
			// LoadOrderPO po = new LoadOrderPO("00100011996030100001",
			// "2015-06-03", "0010001001", "0010001", "0010002",
			// "0010001001", "000000001", orders);
			// loadorder.add(po);
			// loadorder.setPassed("00100011996030100001", "南京栖霞营业厅发出");
			LoadOrderPO po = loadorder.find("00100011996030100001");
			System.out.println(po.getOrder_id() + "," + po.getDriver_id() + ","
					+ po.getCar_number() + "," + po.getDate());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

}
