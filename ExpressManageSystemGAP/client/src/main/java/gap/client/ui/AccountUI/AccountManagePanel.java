package gap.client.ui.AccountUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import gap.client.bl.account.AccountBlController;
import gap.client.bl.account.AccountSearchResult;
import gap.client.bl.account.AccountSearcher;
import gap.client.ui.AccountUI.Listener.AccountConfirmListener;
import gap.client.ui.BaseComponents.CancelLabel;
import gap.client.ui.BaseComponents.ConfirmLabel;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.BaseComponents.MainPanelWithGird;
import gap.client.ui.BaseComponents.MessagePanel;
import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.bussinessui.carmanage.QueryPanel;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.util.MessageType;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.vo.AccountVO;
import gap.common.util.ResultMessage;

public class AccountManagePanel extends MainPanelWithGird{

	AccountBlController accountBlController;
	ArrayList<AccountVO> accounts;
	AccountConfirmListener confirmListener;
	GAPButton confirmButton;
	AccountQueryPanel queryPanel;
	
	ButtonArea area;
	AccountDisplayPanel accountDisplayPanel;
	JScrollPane jScrollPane;
	
	private int column = 4;
	
	public AccountManagePanel(MainFrame frame) {
		super(frame);
		initial();
	}
	
	public void initial(){
		accountBlController = AccountBlController.getInstance();
		
		Iterator<AccountVO> itr = accountBlController.getAccountManageList();
		itrToList(itr);
		
		
		confirmListener = new AccountConfirmListener(this);
		confirmButton = new GAPButton("确认修改");
		
		confirmButton.addActionListener(confirmListener);
		
		
		jScrollPane = getJsPanel();
		JViewport viewport = jScrollPane.getViewport();
		
		
		//主面板
		accountDisplayPanel = new AccountDisplayPanel(this, accounts,viewport);
		gcons.fill = GridBagConstraints.VERTICAL;
		SwingConsole.addComponent(gb, gcons, this, accountDisplayPanel, 0, 1, 1, 1, 1, 1);
		//搜索面板
		queryPanel = new AccountQueryPanel(this, accountDisplayPanel);
		queryPanel.setPreferredSize(new Dimension(Default.PANEL_WIDTH,50));
		SwingConsole.addComponent(gb, gcons, this, queryPanel, 0, 0, 1, 1, 1, 0);
		
		area = new ButtonArea();
		area.removeAll();
		area.add(confirmButton);
		gcons.anchor = GridBagConstraints.EAST;
		SwingConsole.addComponent(gb, gcons, this, area, 0, 2, 1, 1, 1, 0);
		
		//加载一下两个需要图片的类
		CancelLabel cancelLabel = new CancelLabel();
		ConfirmLabel confirmLabel = new ConfirmLabel();
		
		
	}
	
	public void addAccount(AccountVO vo,AddBox box){
		ResultMessage message = accountBlController.addAccount(vo);
		
		if(message.equals(ResultMessage.SUCCEED)){
			//让展示面板添加账户框
			accountDisplayPanel.addOneAccount(vo);
			
			MainFrame.setMessage("添加成功", MessageType.succeed, 2000);
		}else if(message.equals(ResultMessage.EXISTED)){
			MainFrame.setMessage("账户名已存在", MessageType.alram, 2000);
			box.nameRepeat();
		}else{
			MainFrame.setMessage("网络异常", MessageType.alram, 2000);
		}
	
	}
	
	public void balanceFormatError(){
		MainFrame.setMessage("金额格式错误", MessageType.alram, 2000);
	}
	
	public void deleteAccount(AccountVO vo){
		ResultMessage message = accountBlController.deleteAccount(vo);
		if(message.equals(ResultMessage.SUCCEED)){
			MainFrame.setMessage("删除成功", MessageType.succeed, 2000);
		}else{
			MainFrame.setMessage("网络异常", MessageType.alram, 2000);
		}
		
	}
	
	public void confirmAllChange(){
		ResultMessage message = accountBlController.confirm();
		if(message.equals(ResultMessage.SUCCEED)){
			MainFrame.setMessage("已保存所有修改", MessageType.succeed, 2000);
		}else{
			MainFrame.setMessage("网络异常", MessageType.alram, 2000);
		}
	}
	
	public void searchAccount(String key){
		ArrayList<AccountSearchResult> results
			=accountBlController.searchAccount(key);
		accountDisplayPanel.showSearchAccount(results);
	}
	
	//迭代器内容存入accounts
	private void itrToList(Iterator<AccountVO> itr){
		if(accounts==null){
			accounts = new ArrayList<>(30);
		}
		accounts.clear();
		while(itr.hasNext()){
			accounts.add(itr.next());
		}
		
	}

}