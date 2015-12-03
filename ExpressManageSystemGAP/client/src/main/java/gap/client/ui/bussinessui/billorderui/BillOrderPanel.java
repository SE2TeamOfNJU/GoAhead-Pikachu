package gap.client.ui.bussinessui.billorderui;

import gap.client.blcontroller.BillOrderController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class BillOrderPanel extends MainPanel {

	TitlePanel title;
	ListItemPanel listItem;
	ButtonArea buttonArea;

	public BillOrderPanel(MainFrame frame) {
		super(frame);
		// TODO 自动生成的构造函数存根
		setBackground(Color.white);

		title = new TitlePanel();
		listItem = new ListItemPanel(frame);
		buttonArea = new ButtonArea();
		buttonArea.submit.setText("提交订单");

		buttonArea.submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				BillOrderController.saveBill(listItem.getBillOrderVO());
				listItem.clear();
			}
		});

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		JPanel jp = new JPanel();
		jp.setOpaque(false);

		SwingConsole.addComponent(gb, gcons, this, title, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, listItem, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, jp, 0, 2, 1, 1, 1, 1);
		SwingConsole
				.addComponent(gb, gcons, this, buttonArea, 0, 3, 1, 1, 1, 0);

	}

}
