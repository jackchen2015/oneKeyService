package oneKeyService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoDao {
    public UserInfo SearchOne(String macAddr) throws SQLException{
    	UserInfo p = null;
        Connection conn=DBUtil.getConnection();
        String sql="" + 
                "SELECT t.mac,u.userId name,u.password password FROM T_MOBILE_TERMINAL AS t LEFT JOIN "
                + "T_USER AS u on(t.userId = u.userId) where t.mac = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, macAddr);
        
        //Ö´ÐÐSQLÓï¾ä
        ResultSet rs = psmt.executeQuery();
        while(rs.next()){
            p = new UserInfo();
            p.setMacAddr(macAddr);
            p.setUserId(rs.getString("name"));
            p.setPassword(rs.getString("password"));
        }
        return p;
    }
}
