package jw;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jw.common.pool.OracleConnectionPool;

public class UserDAO {

	//field

	//constructor
	public UserDAO() {
	}
	
	//method	
	
	public void addUser(UserVO userVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
				//connection
				System.out.println("Connection ����");
				con = OracleConnectionPool.getInstance().getConnection();
				System.out.println("Connection �Ϸ�");
				
				//statement
				System.out.println("statement ����");
				pstmt = con.prepareStatement("INSERT INTO usertest (name, gender, birth, cpNum, address) VALUES(?, ?, ?, ?, ?)");
				System.out.println("prepared statement �Ϸ�");
				System.out.println("getName");
				pstmt.setString(1,userVO.getName());
				System.out.println("getName�Ϸ�");
				System.out.println("getGender");
				pstmt.setString(2,userVO.getGender());
				System.out.println("getGender�Ϸ�");
				System.out.println("getBirth");
				pstmt.setString(3, userVO.getBirth());
				System.out.println("getBirth�Ϸ�");
				System.out.println("getCpNum");
				pstmt.setString(4, userVO.getCpNum());
				System.out.println("getCpNum�Ϸ�");
				System.out.println("getAddress");
				pstmt.setString(5, userVO.getAddress());
				System.out.println("getAddress�Ϸ�");
				int r = pstmt.executeUpdate();
				System.out.println(r);
				if (r>0) {
					userVO.setActive(true);
				}else {
					userVO.setActive(false);
				}
				System.out.println("statement �Ϸ�");


				
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
	}
	
	public UserVO findUser(String name) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO userVO = null;
		
		
		
		try {
			//connection
			System.out.println("Connection ����");
			con = OracleConnectionPool.getInstance().getConnection();
			System.out.println("Connection �Ϸ�");
			
			//statement
			System.out.println("statement ����");
			pstmt = con.prepareStatement("SELECT * FROM usertest WHERE name = ?");
			System.out.println("prepared statement �Ϸ�");
			System.out.println("query �Է�");
			pstmt.setString(1,name);
			System.out.println("query �Է¿Ϸ�");
			
			System.out.println("query ����");
			rs = pstmt.executeQuery();
			System.out.println("query ����Ϸ�");
			
			while (rs.next()) {
				userVO = new UserVO();
				userVO.setName(rs.getString("name"));
				userVO.setGender(rs.getString("gender"));
				userVO.setBirth(rs.getString("birth"));
				userVO.setCpNum(rs.getString("cpNum"));
				userVO.setAddress(rs.getString("address"));
				
			}
			System.out.println("statement �Ϸ�");
			
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
