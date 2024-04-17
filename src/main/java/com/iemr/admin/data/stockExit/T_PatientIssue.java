/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.admin.data.stockExit;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.iemr.admin.utils.mapper.OutputMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name="t_patientissue")
@Data
public class T_PatientIssue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name="PatientIssueID")
	private Integer patientIssueID;
	
	@Expose
	@Column(name="BenRegID")
	private Integer benRegID;
	
	@Expose
	@Transient
	private Integer facilityID;
	
	@Expose
	@Column(name="VanID")
	private Integer vanID;
	
	@Expose
	@Column(name="ParkingPlaceID")
	private Integer parkingPlaceID;
	
	@Expose
	@Column(name="VisitID")
	private Integer visitID;
	
	@Expose
	@Column(name="PatientName")
	private String patientName;
	
	@Expose
	@Column(name="Age")
	private Integer age;
	
	@Expose
	@Column(name="Gender")
	private String gender;
		
	@Expose
	@Column(name="DoctorName")
	private String doctorName;
	
	@Expose
	@Column(name="PrescriptionID")
	private Integer prescriptionID;
	
	@Expose
	@Column(name="Reference")
	private String reference;
	
	@Expose
	@Column(name="IssueType")
	private String issueType;
	
	@Transient
	@Expose
	private List<ItemStockExit>  itemStockExit;

	
	@Expose
	@Column(name="Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	
	@Expose
	@Column(name="Processed", insertable = false, updatable = true)
	private Character processed;
	
	@Expose
	@Column(name="CreatedBy")
	private String createdBy;
	
	@Expose
	@Column(name="CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy;
	
	@Expose
	@Column(name="LastModDate", insertable = false, updatable = false)
	private Date lastModDate;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
