package gap.client.datacontroller.AccountDate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.RMIClassLoader;
import java.util.ArrayList;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.accountdataservice.AccountDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.AccountPO;
import gap.common.po.Cost_profitPO;
import gap.common.util.ResultMessage;

public class AccountDateController {
	AccountDataService accountDataService;
	
	public AccountDateController(){
		
		try {
			accountDataService = (AccountDataService) Naming.lookup(RMIConfig.url+ServiceName.ACCOUNT_DATA_SERVICE);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultMessage addAccount(AccountPO accountPO) {
		try {
			accountDataService.add(accountPO);
			return ResultMessage.SUCCEED;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAILED;
		
		}
	}
	
	public ResultMessage deleteAccount(AccountPO accountPO){
		
		try {
			accountDataService.delete(accountPO);
			return ResultMessage.SUCCEED;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAILED;
		}
	}
	
	public ResultMessage modifyAccount(AccountPO accountPO){
		
		try {
			accountDataService.modify(accountPO);
			return ResultMessage.SUCCEED;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAILED;
		}
	}
	
	public ArrayList<AccountPO> getAccountList(){
		
		try {
			return accountDataService.getAccountList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Cost_profitPO> getProfitList(){
		try {
			return accountDataService.getCost_Profit();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}