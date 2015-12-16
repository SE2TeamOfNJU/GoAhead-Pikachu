package gap.client.ui.managerui.approvalui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

import gap.client.blcontroller.ApprovalController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.ui.managerui.approvalui.OrderItemListPanel.ItemPanel;

/**
 * @author seven
 * 
 *         总经理审批单据界面
 */
public class ApprovalPanel extends MainPanel {
	TotalPanel totalPanel;
	ApprovalTitlePanel titlePanel;
	OrderItemListPanel listItemPanel;
	ButtonArea buttonArea;
	GridBagLayout gb;
	GridBagConstraints gcons;

	public ApprovalPanel(final MainFrame frame) {
		// TODO Auto-generated constructor stub
		super(frame);
		totalPanel = new TotalPanel();
		titlePanel = new ApprovalTitlePanel();
		listItemPanel = new OrderItemListPanel(frame);
		buttonArea = new ButtonArea();
		buttonArea.submit.setText("确认审批");
		
		// 给全选按钮添加监听
		titlePanel.select.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("!!!!!!!!");
				int state = arg0.getStateChange();
				if (state == ItemEvent.SELECTED) {
					System.out.println("all selected");
					for (ItemPanel item : listItemPanel.items) {
						item.setSelected(true);
					}
				} else {
					System.out.println("not select");
					for (ItemPanel item : listItemPanel.items) {
						item.setSelected(false);
					}
				}
			}
		});

		// 审批按钮添加监听
		buttonArea.submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ApprovalController.approve();
			}
		});

		// 布局
		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);
		JPanel jp = new JPanel();
		jp.setOpaque(false);
		SwingConsole.addComponent(gb, gcons, this, totalPanel, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, titlePanel, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, listItemPanel, 0, 2, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, jp, 0, 3, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, buttonArea, 0, 4, 1, 1, 1, 0);
	}
}
