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
				System.out.println("Connection 실행");
				con = OracleConnectionPool.getInstance().getConnection();
				System.out.println("Connection 완료");
				
				//statement
				System.out.println("statement 실행");
				pstmt = con.prepareStatement("INSERT INTO usertest (name, gender, birth, cpNum, address) VALUES(?, ?, ?, ?, ?)");
				System.out.println("prepared statement 완료");
				System.out.println("getName");
				pstmt.setString(1,userVO.getName());
				System.out.println("getName완료");
				System.out.println("getGender");
				pstmt.setString(2,userVO.getGender());
				System.out.println("getGender완료");
				System.out.println("getBirth");
				pstmt.setString(3, userVO.getBirth());
				System.out.println("getBirth완료");
				System.out.println("getCpNum");
				pstmt.setString(4, userVO.getCpNum());
				System.out.println("getCpNum완료");
				System.out.println("getAddress");
				pstmt.setString(5, userVO.getAddress());
				System.out.println("getAddress완료");
				int r = pstmt.executeUpdate();
				System.out.println(r);
				if (r>0) {
					userVO.setActive(true);
				}else {
					userVO.setActive(false);
				}
				System.out.println("statement 완료");


				
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
			System.out.println("Connection 실행");
			con = OracleConnectionPool.getInstance().getConnection();
			System.out.println("Connection 완료");
			
			//statement
			System.out.println("statement 실행");
			pstmt = con.prepareStatement("SELECT * FROM usertest WHERE name = ?");
			System.out.println("prepared statement 완료");
			System.out.println("query 입력");
			pstmt.setString(1,name);
			System.out.println("query 입력완료");
			
			System.out.println("query 실행");
			rs = pstmt.executeQuery();
			System.out.println("query 실행완료");
			
			while (rs.next()) {
				userVO = new UserVO();
				userVO.setName(rs.getString("name"));
				userVO.setGender(rs.getString("gender"));
				userVO.setBirth(rs.getString("birth"));
				userVO.setCpNum(rs.getString("cpNum"));
				userVO.setAddress(rs.getString("address"));
				
			}
			System.out.println("statement 완료");
			
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
