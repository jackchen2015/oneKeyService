package oneKeyService;

import java.sql.SQLException;

public class OneKeyService {  
    public UserInfo getUserByMacAddr(String macAddr) throws InterruptedException{  
    	UserInfoDao dao = new UserInfoDao();
    	UserInfo ui = null;
		try {
			ui = dao.SearchOne(macAddr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	UserInfo ui = new UserInfo();
//    	ui.setMacAddr(macAddr);
//    	ui.setUserId("userid");
//    	ui.setPassword("asd,cc,asdf");
    	return ui;
    }  
}  