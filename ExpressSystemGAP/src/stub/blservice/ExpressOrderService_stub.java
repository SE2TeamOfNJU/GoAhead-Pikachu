package stub.blservice;

import java.util.List;

import po.ResultMessage;
import client.blservice.expressorderblservice.ExpressOrderService;
import client.vo.ExpressOrderVO;
import client.vo.ReceiveInfoVO;
import client.vo.StateVO;

public class ExpressOrderService_stub implements ExpressOrderService{

	@Override
	public StateVO getState(String order_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<ExpressOrderVO> getArrivingOrders(String ins_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<ExpressOrderVO> getCurrentOrders(String ins_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage setArrivedOrders(List<ExpressOrderVO> orders,
			String ins_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage setOffOders(List<ExpressOrderVO> orders, String ins_id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ExpressOrderVO createOrder(ExpressOrderVO order_info) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage save(ExpressOrderVO order) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage receiveOrder(String order_id, ReceiveInfoVO receiveInfo) {
		// TODO 自动生成的方法存根
		return null;
	}

}
