package jw.services.user.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jw.common.pool.OracleConnectionPool;
import jw.services.user.vo.UserVO;

public class UserDAO {

	//field

	//constructor
	public UserDAO() {
	}
	
	//method	
	
	public void addUser(UserVO userVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
				//connection
				con = OracleConnectionPool.getInstance().getConnection();
				
				//statement
				pstmt = con.prepareStatement("INSERT INTO usertest (name, gender, birth, cpNum, address) VALUES(?, ?, ?, ?, ?)");
				pstmt.setString(1,userVO.getName());
				pstmt.setString(2,userVO.getGender());
				pstmt.setString(3, userVO.getBirth());
				pstmt.setString(4, userVO.getCpNum());
				pstmt.setString(5, userVO.getAddress());
				
				int r = pstmt.executeUpdate();
				System.out.println(r);
				if (r>0) {
					userVO.setActive(true);
				}else {
					userVO.setActive(false);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if (pstmt != null) {
					try {
						pstmt.close();
						}catch (Exception e2) {
							}
						}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e3) {
				}
					
			}
		}	
	}
	
	public UserVO findUser(String name) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO userVO = null;
				
		
		try {
			//connection
			con = OracleConnectionPool.getInstance().getConnection();
			
			//statement
			pstmt = con.prepareStatement("SELECT * FROM usertest WHERE name = ?");
			pstmt.setString(1,name);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				userVO = new UserVO();
				userVO.setName(rs.getString("name"));
				userVO.setGender(rs.getString("gender"));
				userVO.setBirth(rs.getString("birth"));
				userVO.setCpNum(rs.getString("cpNum"));
				userVO.setAddress(rs.getString("address"));
				
			}			
			return userVO;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (rs != null) {
				try {
					rs.close();
					}catch (Exception e1) {
						}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
					}catch (Exception e2) {
						}
					}
			if (con != null) {
				try {
					con.close();
					} catch (Exception e3) {
				}
			}
		}
		return null;
	}

}
