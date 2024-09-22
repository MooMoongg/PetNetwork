package jw.services.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jw.common.pool.OracleConnectionPool;
import jw.services.user.vo.UserVO;

public class  UserDAO{
	 
	
	public UserDAO(){
	}
		
	public void addUser(UserVO userVO){
		
		Connection con = null;
		PreparedStatement pStmt = null;
		try{		
	
			con = OracleConnectionPool.getInstance().getConnection();
	 
			pStmt = con.prepareStatement(	"insert " + "into users ( no, id, pwd) " + "values( ? , ? , ? )" );
																
			pStmt.setInt(1,userVO.getNo());
			pStmt.setString(2,userVO.getId());
			pStmt.setString(3,userVO.getPwd());

			if( 1 == pStmt.executeUpdate()){    
				userVO.setActive(true);
			}
		}catch(Exception e){		
			e.printStackTrace();
		}finally{
			if(pStmt != null){
				try{	
					pStmt.close();	
				}catch(Exception e2){  }
			}
			if(con != null){
				try{	
					con.close();	
				}catch(Exception e3){  }
			}
		}
	}
}	