package gap.client.bl.expressorder;

import java.rmi.RemoteException;
import java.util.List;

import gap.client.blservice.expressorderblservice.ExpressOrderService;
import gap.client.datacontroller.controllerfactory.ControllerFactory;
import gap.client.datacontroller.expressorderdata.ExpressOrderDataController;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.StateVO;
import gap.common.po.ExpressOrderPO;
import gap.common.util.ReceiveInfo;
import gap.common.util.ResultMessage;

public class ExpressOrder implements ExpressOrderService {

	PriceCal priceCal;
	ExpressOrderDataController expressorderData;

	public ExpressOrder() {
		// TODO 自动生成的构造函数存根
		expressorderData = ControllerFactory.getExpressOrderDataController();
	}

	public ExpressOrder(PriceCal p) {
		priceCal = p;
	}

	@Override
	public List<String> getState(String order_id) {
		// TODO 自动生成的方法存根
		return expressorderData.getState(order_id);
	}

	@Override
	public ExpressOrderVO getOrder(String order_id) {
		// TODO 自动生成的方法存根
		ExpressOrderPO po = expressorderData.find(order_id);
		if (po != null)
			return new ExpressOrderVO(po);
		return null;
	}

	@Override
	public ResultMessage modify(ExpressOrderVO vo) {
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
		order_info.price = priceCal.getPrice(order_info);
		return order_info;
	}

	@Override
	public ResultMessage save(ExpressOrderVO order) {
		// TODO 自动生成的方法存根
		return expressorderData.add(order.toPO());
	}

	@Override
	public ResultMessage receiveOrder(String order_id, ReceiveInfo receiveInfo) {
		// TODO 自动生成的方法存根
		return expressorderData.setReceived(order_id, receiveInfo);
	}

}
