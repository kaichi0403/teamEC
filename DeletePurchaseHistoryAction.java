package com.internousdev.rose.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.PurchaseHistoryInfoDAO;
import com.internousdev.rose.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePurchaseHistoryAction extends ActionSupport implements SessionAware{
	private ArrayList<PurchaseHistoryInfoDTO> dto;
	private Map<String , Object> session;
	public String execute() throws SQLException{
		Boolean loginFlg = Boolean.valueOf(String.valueOf(session.get("loginFlg")));
		if(!loginFlg) {
			return "loginError";
		}

		String result = ERROR;
		PurchaseHistoryInfoDAO dao = new PurchaseHistoryInfoDAO();
		int count = dao.deleteAll(String.valueOf(session.get("userId")));
		if(count > 0) {
			dto = dao.select(String.valueOf(session.get("userId")));
			if(!(dto.size() > 0)) {
				dto = null;
			}
			result = SUCCESS;
		}
		return result;
	}
	public ArrayList<PurchaseHistoryInfoDTO> getDto(){
		return dto;
	}
	public void setDto(ArrayList<PurchaseHistoryInfoDTO> dto) {
		this.dto = dto;
	}
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
