package com.internousdev.rose.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.PurchaseHistoryInfoDAO;
import com.internousdev.rose.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryAction extends ActionSupport implements SessionAware {
	//DAOに接続し商品情報テーブルを取得
		ArrayList<PurchaseHistoryInfoDTO> dto = new ArrayList<PurchaseHistoryInfoDTO>();

		private Map<String , Object> session;

	public String execute()throws SQLException {
		String ret = SUCCESS;
		boolean loginFlg = Boolean.valueOf(String.valueOf(session.get("loginFlg")));
		if (loginFlg==false) {
			// ログインエラーの処理
			ret = "loginError";
		} else {
			PurchaseHistoryInfoDAO dao = new PurchaseHistoryInfoDAO();
			// DBから商品情報を取得する。
			dto = dao.select(String.valueOf(session.get("userId")));
			if(!(dto.size() > 0)) {
				dto = null;
			}
		}
		return ret;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ArrayList<PurchaseHistoryInfoDTO> getDto() {
		return dto;
	}

	public void setDto(ArrayList<PurchaseHistoryInfoDTO> dto) {
		this.dto = dto;
	}

}
