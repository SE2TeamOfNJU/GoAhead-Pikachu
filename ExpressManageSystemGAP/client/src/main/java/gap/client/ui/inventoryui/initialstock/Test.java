package gap.client.ui.inventoryui.initialstock;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.UserBox.Sex;
import gap.client.ui.UITools.ConstInfo;

public class Test {
	public static void main(String[] args) {
		ConstInfo.setJob("库存管理人员");
		ConstInfo.setName("王小二");
		ConstInfo.setNumber("000000001");
		ConstInfo.setSex(Sex.man);
		MainFrame mainFrame = new MainFrame();
		InitialStockPanel panel = new InitialStockPanel(mainFrame);
		mainFrame.setMainPanel(panel);
	}
}
