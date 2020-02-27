package com.internousdev.rose.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.UserInfoDAO;
import com.internousdev.rose.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

//DAOに接続し会員情報テーブルを取得
	UserInfoDTO dto = new UserInfoDTO();
	private Map<String , Object> session;

	public String execute()throws SQLException {
		String ret = SUCCESS;
		//ログインしていない場合は、セッションエラー画面に遷移する
		boolean loginFlg = Boolean.valueOf(String.valueOf(session.get("loginFlg")));
		if (loginFlg==false) {
			ret = "loginError";
		} else {
			UserInfoDAO dao = new UserInfoDAO();
			// DBからユーザー情報を取得する。
			dto = dao.selectMyPage(String.valueOf(session.get("userId")));
		}

		return ret;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public UserInfoDTO getDto() {
		return dto;
	}
	public void setDto(UserInfoDTO dto) {
		this.dto = dto;
	}

}
