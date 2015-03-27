package com.ehm.web.managebeans;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.ehm.db.impl.LoginDao;
import com.ehm.db.impl.LoginDaoImpl;
import com.ehm.db.model.Patient;

public class LoginBean {

	private String userName;
	private String password;
	private boolean loginError;

	public LoginBean() {
		resetFields();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String validAndLoginUser() {
		LoginDao loginDao = new LoginDaoImpl();
		String loginResult = "failure";
		loginError = true;

		try {
			Patient logedPatient = loginDao.validate(userName, password);

			if (logedPatient != null) {
				FacesContext context = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) context
						.getExternalContext().getSession(true);
				session.setAttribute("loggedInPatient", logedPatient);
				session.setAttribute("username", logedPatient.getEmailId());
				session.setAttribute("userfName", logedPatient.getFirstName());
				loginError = false;
				loginResult = "success";
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Invalid email or password.", "Please Try Again!"));
				loginResult = "failure";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginResult;
	}

	public String userLogout() {

		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(true);
		session.removeAttribute("loggedInPatient");
		session.removeAttribute("username");
		session.removeAttribute("userfName");
		session.invalidate();

		resetFields();
		return "navigateToHomePage";
	}

	private void resetFields() {

		userName = null;
		password = null;
		loginError = false;

	}

	/**
	 * @return the loginError
	 */
	public boolean isLoginError() {
		return loginError;
	}

	/**
	 * @param loginError
	 *            the loginError to set
	 */
	public void setLoginError(boolean loginError) {
		this.loginError = loginError;
	}
}
