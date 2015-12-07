package gap.client.blcontroller;

import java.util.List;

import gap.client.bl.order.LoadOrder;
import gap.client.util.LocalInfo;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.LoadOrderVO;
import gap.common.util.ResultMessage;

public class LoadOrderController {
	private static LoadOrder loadOrder = new LoadOrder();

	public static ResultMessage save(LoadOrderVO loadOrderVO) {
		return loadOrder.save(loadOrderVO);
	}

	public static List<LoadOrderVO> getArrivingLoadOrder() {
		return loadOrder.getArrivingLoadOrder(LocalInfo.ins_id);
	}

}