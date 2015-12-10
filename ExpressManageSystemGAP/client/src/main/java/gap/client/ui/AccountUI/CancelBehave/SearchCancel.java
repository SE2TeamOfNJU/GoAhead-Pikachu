package gap.client.ui.AccountUI.CancelBehave;

import gap.client.ui.AccountUI.AccountDisplayPanel;
import gap.client.ui.AccountUI.AccountQueryPanel;

public class SearchCancel implements CancelBehave{
	AccountQueryPanel queryPanel;
	AccountDisplayPanel displayPanel;
	public SearchCancel(AccountQueryPanel queryPanel,
			AccountDisplayPanel displayPanel) {
		// TODO Auto-generated method stub
		this.queryPanel = queryPanel;
		this.displayPanel = displayPanel;
	}

	
	public void behave() {
		queryPanel.setSearchButton();
		displayPanel.showAllAccount();
	}

}
