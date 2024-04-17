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
package com.iemr.admin.data.vanMaster;

import java.sql.Date;


import com.google.gson.annotations.Expose;
import com.iemr.admin.data.employeemaster.M_Country;
import com.iemr.admin.data.locationmaster.StateMaster;
import com.iemr.admin.data.parkingPlace.M_Parkingplace;
import com.iemr.admin.data.provideronboard.M_ProviderServiceMapping;
import com.iemr.admin.data.vanType.M_VanType;
import com.iemr.admin.utils.mapper.OutputMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import lombok.Data;

@Entity
@Table(name = "m_van")
@Data
public class M_Van {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "VanID")
	private Integer vanID;

	@Expose
	@Column(name = "VanName")
	private String vanName;
	@Expose
	@Column(name = "VehicalNo")
	private String vehicalNo;
	@Expose
	@Column(name = "VanTypeID")
	private Integer vanTypeID;

	@Expose
	@Column(name = "SwymedDomain")
	private String videoConsultationDomain;

	@Expose
	@Column(name = "SwymedID")
	private String videoConsultationID;

	@Expose
	@Column(name = "SwymedEmailID")
	private String videoConsultationEmail;

	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "VanTypeID")
	private M_VanType m_vanType;
	@Expose
	@Transient
	String vanType;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "ProviderServiceMapID")
	private M_ProviderServiceMapping m_providerServiceMapping;

	@Expose
	@Transient
	private Integer serviceProviderID;

	@Expose
	@Column(name = "CountryID")
	private Integer countryID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "countryID")
	private M_Country m_country;
	@Expose
	@Transient
	String countryName;

	@Expose
	@Column(name = "StateID")
	private Integer stateID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "stateID")
	private StateMaster state;
	@Expose
	@Transient
	String stateName;



	@Expose
	@Column(name = "ParkingPlaceID")
	private Integer parkingPlaceID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "parkingPlaceID")
	private M_Parkingplace m_parkingplace;
	@Expose
	@Transient
	String parkingPlaceName;

	@Expose
	@Column(name = "IsFacility")
	private Boolean isFacility;

	@Expose
	@Transient
	private Integer districtBlockID;

	@Expose
	@Column(name = "FacilityID")
	private Integer facilityID;

	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;

	@Expose
	@Column(name = "vanSpokeMapped", insertable = false, updatable = false)
	private Boolean vanSpokeMapped;

	@Expose
	@Column(name = "vanfetosenseIDmapped", insertable = false, updatable = false)
	private Boolean vanfoetalMonitorIDmapped;

	public M_Van() {
		super();
	}

	public M_Van(Integer vanID, String vanName, String vehicalNo, Integer vanTypeID, String vanType, Boolean deleted,
			Integer providerServiceMapID, Integer countryID, String countryName, Integer stateID, String stateName,
			Integer parkingPlaceID, String parkingPlaceName, Integer districtBlockID, String videoConsultationDomain,
			String videoConsultationID, String videoConsultationEmail) {
		super();
		this.vanID = vanID;
		this.vanName = vanName;
		this.vehicalNo = vehicalNo;
		this.vanTypeID = vanTypeID;
		this.vanType = vanType;
		this.providerServiceMapID = providerServiceMapID;
		this.countryID = countryID;
		this.countryName = countryName;
		this.stateID = stateID;
		this.stateName = stateName;
		this.parkingPlaceID = parkingPlaceID;
		this.parkingPlaceName = parkingPlaceName;
		this.deleted = deleted;
		this.districtBlockID = districtBlockID;
		this.videoConsultationDomain = videoConsultationDomain;
		this.videoConsultationEmail = videoConsultationEmail;
		this.videoConsultationID = videoConsultationID;
	}

	public M_Van(Integer vanID, String vanName, String vehicalNo, Integer vanTypeID, String vanType, Boolean deleted,
			Integer providerServiceMapID, Integer countryID, String countryName, Integer stateID, String stateName,
			Integer parkingPlaceID, String parkingPlaceName, Integer districtBlockID, String videoConsultationDomain,
			String videoConsultationID, String videoConsultationEmail, boolean vanSpokeMapped) {
		super();
		this.vanID = vanID;
		this.vanName = vanName;
		this.vehicalNo = vehicalNo;
		this.vanTypeID = vanTypeID;
		this.vanType = vanType;
		this.providerServiceMapID = providerServiceMapID;
		this.countryID = countryID;
		this.countryName = countryName;
		this.stateID = stateID;
		this.stateName = stateName;
		this.parkingPlaceID = parkingPlaceID;
		this.parkingPlaceName = parkingPlaceName;
		this.deleted = deleted;
		this.districtBlockID = districtBlockID;
		this.videoConsultationDomain = videoConsultationDomain;
		this.videoConsultationEmail = videoConsultationEmail;
		this.videoConsultationID = videoConsultationID;
		this.vanSpokeMapped = vanSpokeMapped;
	}

	/***
	 * @param vanID
	 * @param vehicalNo for creating the van - deviceID mapping
	 */
	public M_Van(Integer vanID, String vehicalNo, String vanName) {
		this.vanID = vanID;
		this.vehicalNo = vehicalNo;
		this.vanName = vanName;
	}

	public String getVanName() {
		return vanName;
	}

	public void setVanName(String vanName) {
		this.vanName = vanName;
	}

	public String getVehicalNo() {
		return vehicalNo;
	}

	public void setVehicalNo(String vehicalNo) {
		this.vehicalNo = vehicalNo;
	}

	public Integer getVanTypeID() {
		return vanTypeID;
	}

	public void setVanTypeID(Integer vanTypeID) {
		this.vanTypeID = vanTypeID;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public M_ProviderServiceMapping getM_providerServiceMapping() {
		return m_providerServiceMapping;
	}

	public void setM_providerServiceMapping(M_ProviderServiceMapping m_providerServiceMapping) {
		this.m_providerServiceMapping = m_providerServiceMapping;
	}

	public Integer getCountryID() {
		return countryID;
	}

	public void setCountryID(Integer countryID) {
		this.countryID = countryID;
	}

	public M_Country getM_country() {
		return m_country;
	}

	public void setM_country(M_Country m_country) {
		this.m_country = m_country;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}

	public StateMaster getState() {
		return state;
	}

	public void setState(StateMaster state) {
		this.state = state;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Integer getParkingPlaceID() {
		return parkingPlaceID;
	}

	public void setParkingPlaceID(Integer parkingPlaceID) {
		this.parkingPlaceID = parkingPlaceID;
	}

	public M_Parkingplace getM_parkingplace() {
		return m_parkingplace;
	}

	public void setM_parkingplace(M_Parkingplace m_parkingplace) {
		this.m_parkingplace = m_parkingplace;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}

	public Integer getVanID() {
		return vanID;
	}

	public M_VanType getM_vanType() {
		return m_vanType;
	}

	public void setM_vanType(M_VanType m_vanType) {
		this.m_vanType = m_vanType;
	}

	public String getVanType() {
		return vanType;
	}

	public void setVanType(String vanType) {
		this.vanType = vanType;
	}

	public Integer getServiceProviderID() {
		return serviceProviderID;
	}

	public void setServiceProviderID(Integer serviceProviderID) {
		this.serviceProviderID = serviceProviderID;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
