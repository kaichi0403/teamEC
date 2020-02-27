package com.internousdev.rose.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.rose.dto.PurchaseHistoryInfoDTO;
import com.internousdev.rose.util.DBConnector;

public class PurchaseHistoryInfoDAO {

	public ArrayList<PurchaseHistoryInfoDTO> select(String userId) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<PurchaseHistoryInfoDTO> purchaseHistoryList = new ArrayList<PurchaseHistoryInfoDTO>();

		String sql = "SELECT * FROM purchase_history_info"
				+ " LEFT JOIN product_info ON purchase_history_info.product_id = product_info.product_id"
				+ " LEFT JOIN destination_info ON purchase_history_info.destination_id = destination_info.id"
				+ " WHERE purchase_history_info.user_id=?"
				+ " ORDER BY purchase_history_info.regist_date DESC";
		try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userId);
		ResultSet rs=ps.executeQuery();

		while(rs.next()) {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			dto.setId(rs.getInt("id"));
			dto.setUserId(rs.getString("user_id"));
			dto.setProductId(rs.getInt("purchase_history_info.product_id"));
			dto.setProductName(rs.getString("product_name"));
			dto.setProductNameKana(rs.getString("product_name_kana"));
			dto.setImageFilePath(rs.getString("image_file_path"));
			dto.setImageFileName(rs.getString("image_file_name"));
			dto.setReleaseCompany(rs.getString("release_company"));
			dto.setReleaseDate(rs.getDate("release_date"));
			dto.setPrice(rs.getInt("price"));
			dto.setProductCount(rs.getInt("product_count"));
			dto.setFamilyName(rs.getString("family_name"));
			dto.setFirstName(rs.getString("first_name"));
			dto.setUserAddress(rs.getString("user_address"));
			purchaseHistoryList.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					con.close();
				}catch(SQLException e) {
						e.printStackTrace();
				}
		}
		return purchaseHistoryList;
	}

	public int regist(String userId, int productId, int productCount, int price, int destinationId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql 	= "insert into purchase_history_info"
				+"(user_id, product_id, product_count, price, destination_id, regist_date, update_date)"
				+"values(?, ?, ?, ?,?, now(), now())";

		int count = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, productId);
			ps.setInt(3, productCount);
			ps.setInt(4, price);
			ps.setInt(5, destinationId);
			count =ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public int deleteAll(String userId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql 	= "delete from purchase_history_info where user_id=?";
		int count = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,userId);
			count = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}
