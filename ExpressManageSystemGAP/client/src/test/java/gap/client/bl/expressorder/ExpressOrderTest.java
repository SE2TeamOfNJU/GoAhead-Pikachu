package gap.client.bl.expressorder;

import static org.junit.Assert.*;
import gap.client.util.LocalInfo;
import gap.client.util.User;
import gap.client.vo.ExpressOrderVO;
import gap.common.util.Address;
import gap.common.util.CargoInfo;
import gap.common.util.ExpressType;
import gap.common.util.Gender;
import gap.common.util.PeopleInfo;
import gap.common.util.UserType;

import org.junit.Before;
import org.junit.Test;

public class ExpressOrderTest {

	@Before
	public void setUp() throws Exception {
		User user=new User(UserType.DELIVERY, "xiaoming", "000000005", Gender.MALE);
		LocalInfo.localuser=user;
	}

	@Test
	public void test() {
		ExpressOrder expressorder = new ExpressOrder();
		Address add1 = new Address("江苏省", "南京市", "玄武区");
		Address add2 = new Address("北京市", "北京市", "东城区");
		PeopleInfo sender = new PeopleInfo("杨雁飞", add1, "南京大学", "15520065137");
		PeopleInfo receiver = new PeopleInfo("张家盛", add2, "北京大学", "119");
		CargoInfo cargo = new CargoInfo(2, 2.5, 3.5, "测试");
		ExpressOrderVO vo = new ExpressOrderVO(sender, receiver,
				ExpressType.EXPRESS, 20.5, cargo, false, "0000000003",
				"0010001", null);
		expressorder.save(vo);
	}

}
