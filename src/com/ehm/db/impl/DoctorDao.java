package com.ehm.db.impl;

import java.sql.SQLException;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ehm.db.model.Doctor;

public interface DoctorDao {
	
	List<Doctor> getSearchDoctorRecords(String specialization, String fName, String lName) throws SQLException, ClassNotFoundException;
	
	List<Doctor> getSearchDoctorRecords(String specialization);

	Doctor getDoctorProfile(String doctoId);

	List<SelectItem> getSpecializationList() throws ClassNotFoundException, SQLException;
}
