package Interfaces;

import java.util.ArrayList;

//import Bean.DeleteBean;
import Bean.UserBean;
import Bean.Filebean;
//import Bean.DataOwnerBean;

public interface UserInterface {

	public int register(UserBean bean);
	public String login(UserBean bean);
	public ArrayList upload(Filebean bean);
	public int fileupload(Filebean upload);
	public int sendKey1(Filebean fb);
	public int TASendKey1(Filebean fb);
	public int TASendKey2(Filebean fb);
	public int TASendKey3(Filebean fb);
	
	//public int sendkey(Filebean fb);
//	public int logout(UserBean bean);
//	public int update(DeleteBean db);
//	public int delete(DeleteBean db);
//	public int dataownerregister1(DataOwnerBean bean1);
//	public String dataownerlogin1(DataOwnerBean bean1);*/
	
}
