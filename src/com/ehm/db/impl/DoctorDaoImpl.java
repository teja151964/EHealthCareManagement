/**
 * 
 */
package com.ehm.db.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ehm.db.config.EHMDataConnect;
import com.ehm.db.model.Doctor;

/**
 * @author MadhaviBhat
 *
 */
public class DoctorDaoImpl implements DoctorDao {

	public List<Doctor> getSearchDoctorRecords(String specialization,
			String fName, String lName) throws SQLException, ClassNotFoundException {

		List<String> paramList = new ArrayList<String>();

		StringBuffer sqlBuf = new StringBuffer("select * from doctor ");
		if (specialization != null && !specialization.isEmpty()) {

			sqlBuf.append(" where specialization_id = ? ");
			paramList.add(specialization);
		}

		if (fName != null && !fName.isEmpty()) {
			if (specialization != null && !specialization.isEmpty()) {
				sqlBuf.append(" and first_name like ? ");
			} else {
				sqlBuf.append(" where first_name like ? ");
			}
			paramList.add("%"+fName+"%");
		}

		if (lName != null && !lName.isEmpty()) {
			if ((specialization != null && !specialization.isEmpty()) || (fName != null && !fName.isEmpty())) {
				sqlBuf.append(" and last_name like ? ");
			} else {
				sqlBuf.append(" where last_name like ? ");
			}
			paramList.add("%"+lName+"%");
		}

		
		PreparedStatement ps = EHMDataConnect.getDataConn().prepareStatement(sqlBuf.toString());
		// get customer data from database
		int cnt = 1;
		for (String param : paramList) {
			ps.setString(cnt, param);
			cnt++;
		}
		ResultSet result = ps.executeQuery();

		List<Doctor> list = new ArrayList<Doctor>();

		while (result.next()) {
			Doctor doct = new Doctor();

			doct.setFirstName(result.getString("first_name"));
			doct.setLastName(result.getString("last_name"));
			doct.setSpecialization(result.getString("specialization_id"));

			list.add(doct);
		}

		return list;

	}

	public List<Doctor> getSearchDoctorRecords(String specialization) {
		// TODO Auto-generated method stub
		return null;
	}

	public Doctor getDoctorProfile(String doctoId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SelectItem> getSpecializationList() throws ClassNotFoundException, SQLException {

		StringBuffer sqlBuf = new StringBuffer("select * from specializations ");

		
		PreparedStatement ps = EHMDataConnect.getDataConn().prepareStatement(sqlBuf.toString());
		// get customer data from database
		ResultSet result = ps.executeQuery();

		List<SelectItem> list = new ArrayList<SelectItem>();
		list.add(new SelectItem("all","All"));
		while (result.next()) {
			SelectItem item = new SelectItem();
			item.setValue(result.getString("special_id"));
			item.setLabel(result.getString("special_title"));
			list.add(item);
		}

		return list;
		
	}

}
