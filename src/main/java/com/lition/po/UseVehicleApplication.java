package com.lition.po;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UseVehicleApplication entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "USE_VEHICLE_APPLICATION", schema = "CAR")
public class UseVehicleApplication implements java.io.Serializable {

	// Fields

	private Integer id;
	private String proposer;
	private String contactWay;
	private String requisitionReason;
	private BigDecimal passengerNum;
	private String startPlace;
	private String destination;
	private Date startTime;
	private Date endTime;
	private BigDecimal emergencyLevel;
	private String state;
	private String memo;

	// Constructors

	/** default constructor */
	public UseVehicleApplication() {
	}

	/** minimal constructor */
	public UseVehicleApplication(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public UseVehicleApplication(Integer id, String proposer,
			String contactWay, String requisitionReason,
			BigDecimal passengerNum, String startPlace, String destination,
			Date startTime, Date endTime, BigDecimal emergencyLevel,
			String state, String memo) {
		this.id = id;
		this.proposer = proposer;
		this.contactWay = contactWay;
		this.requisitionReason = requisitionReason;
		this.passengerNum = passengerNum;
		this.startPlace = startPlace;
		this.destination = destination;
		this.startTime = startTime;
		this.endTime = endTime;
		this.emergencyLevel = emergencyLevel;
		this.state = state;
		this.memo = memo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_application")
	@SequenceGenerator(name="seq_application",initialValue=1,allocationSize=1,sequenceName="seq_t_application",schema="car")
	@Column(name = "ID", nullable = false, precision = 5, scale = 0)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "PROPOSER", length = 10)
	public String getProposer() {
		return this.proposer;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	@Column(name = "CONTACT_WAY", length = 200)
	public String getContactWay() {
		return this.contactWay;
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}

	@Column(name = "REQUISITION_REASON", length = 200)
	public String getRequisitionReason() {
		return this.requisitionReason;
	}

	public void setRequisitionReason(String requisitionReason) {
		this.requisitionReason = requisitionReason;
	}

	@Column(name = "PASSENGER_NUM", precision = 22, scale = 0)
	public BigDecimal getPassengerNum() {
		return this.passengerNum;
	}

	public void setPassengerNum(BigDecimal passengerNum) {
		this.passengerNum = passengerNum;
	}

	@Column(name = "START_PLACE", length = 100)
	public String getStartPlace() {
		return this.startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	@Column(name = "DESTINATION", length = 100)
	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "START_TIME", length = 7)
	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "END_TIME", length = 7)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "EMERGENCY_LEVEL", precision = 22, scale = 0)
	public BigDecimal getEmergencyLevel() {
		return this.emergencyLevel;
	}

	public void setEmergencyLevel(BigDecimal emergencyLevel) {
		this.emergencyLevel = emergencyLevel;
	}

	@Column(name = "STATE", length = 3)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "MEMO", length = 200)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}