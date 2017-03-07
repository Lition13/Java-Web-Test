package com.lition.po;

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
 * OwnedVehicle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "OWNED_VEHICLE", schema = "CAR")
public class OwnedVehicle implements java.io.Serializable {

	// Fields

	private Integer id;
	private String vehicleId;
	private String vehicleUsageId;
	private String model;
	private String licenseCode;
	private String engineCode;
	private String frameCode;
	private Date buyDate;
	private Double originalValue;
	private String regCertId;
	private Double drivingKm;
	private Date drivingUpdateTime;
	private String payRoadMaintenanceCost;
	private String payVehicleInsurance;
	private String payTravelTax;
	private String driver;
	private String capacity;
	private String state;
	private String memo;
	private String depid;

	// Constructors

	/** default constructor */
	public OwnedVehicle() {
	}

	/** minimal constructor */
	public OwnedVehicle(Integer id, String vehicleId) {
		this.id = id;
		this.vehicleId = vehicleId;
	}

	/** full constructor */
	public OwnedVehicle(Integer id, String vehicleId, String vehicleUsageId,
			String model, String licenseCode, String engineCode,
			String frameCode, Date buyDate, Double originalValue,
			String regCertId, Double drivingKm, Date drivingUpdateTime,
			String payRoadMaintenanceCost, String payVehicleInsurance,
			String payTravelTax, String driver, String capacity, String state,
			String memo) {
		this.id = id;
		this.vehicleId = vehicleId;
		this.vehicleUsageId = vehicleUsageId;
		this.model = model;
		this.licenseCode = licenseCode;
		this.engineCode = engineCode;
		this.frameCode = frameCode;
		this.buyDate = buyDate;
		this.originalValue = originalValue;
		this.regCertId = regCertId;
		this.drivingKm = drivingKm;
		this.drivingUpdateTime = drivingUpdateTime;
		this.payRoadMaintenanceCost = payRoadMaintenanceCost;
		this.payVehicleInsurance = payVehicleInsurance;
		this.payTravelTax = payTravelTax;
		this.driver = driver;
		this.capacity = capacity;
		this.state = state;
		this.memo = memo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_owneded")
	@SequenceGenerator(name = "seq_owneded", sequenceName = "seq_t_owner", initialValue = 1, allocationSize = 1, schema = "car")
	@Column(name = "ID", unique = true, nullable = false, length = 20)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "VEHICLE_ID", nullable = false, length = 10)
	public String getVehicleId() {
		return this.vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Column(name = "VEHICLE_USAGE_ID", length = 20)
	public String getVehicleUsageId() {
		return this.vehicleUsageId;
	}

	public void setVehicleUsageId(String vehicleUsageId) {
		this.vehicleUsageId = vehicleUsageId;
	}

	@Column(name = "MODEL", length = 50)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "LICENSE_CODE", length = 20)
	public String getLicenseCode() {
		return this.licenseCode;
	}

	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}

	@Column(name = "ENGINE_CODE", length = 20)
	public String getEngineCode() {
		return this.engineCode;
	}

	public void setEngineCode(String engineCode) {
		this.engineCode = engineCode;
	}

	@Column(name = "FRAME_CODE", length = 20)
	public String getFrameCode() {
		return this.frameCode;
	}

	public void setFrameCode(String frameCode) {
		this.frameCode = frameCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BUY_DATE", length = 7)
	public Date getBuyDate() {
		return this.buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	@Column(name = "ORIGINAL_VALUE", precision = 20)
	public Double getOriginalValue() {
		return this.originalValue;
	}

	public void setOriginalValue(Double originalValue) {
		this.originalValue = originalValue;
	}

	@Column(name = "REG_CERT_ID", length = 50)
	public String getRegCertId() {
		return this.regCertId;
	}

	public void setRegCertId(String regCertId) {
		this.regCertId = regCertId;
	}

	@Column(name = "DRIVING_KM", precision = 20)
	public Double getDrivingKm() {
		return this.drivingKm;
	}

	public void setDrivingKm(Double drivingKm) {
		this.drivingKm = drivingKm;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DRIVING_UPDATE_TIME", length = 7)
	public Date getDrivingUpdateTime() {
		return this.drivingUpdateTime;
	}

	public void setDrivingUpdateTime(Date drivingUpdateTime) {
		this.drivingUpdateTime = drivingUpdateTime;
	}

	@Column(name = "PAY_ROAD_MAINTENANCE_COST", length = 1)
	public String getPayRoadMaintenanceCost() {
		return this.payRoadMaintenanceCost;
	}

	public void setPayRoadMaintenanceCost(String payRoadMaintenanceCost) {
		this.payRoadMaintenanceCost = payRoadMaintenanceCost;
	}

	@Column(name = "PAY_VEHICLE_INSURANCE", length = 1)
	public String getPayVehicleInsurance() {
		return this.payVehicleInsurance;
	}

	public void setPayVehicleInsurance(String payVehicleInsurance) {
		this.payVehicleInsurance = payVehicleInsurance;
	}

	@Column(name = "PAY_TRAVEL_TAX", length = 1)
	public String getPayTravelTax() {
		return this.payTravelTax;
	}

	public void setPayTravelTax(String payTravelTax) {
		this.payTravelTax = payTravelTax;
	}

	@Column(name = "DRIVER", length = 20)
	public String getDriver() {
		return this.driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	@Column(name = "CAPACITY", length = 20)
	public String getCapacity() {
		return this.capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
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

	@Column(name = "DEPID", length = 200)
	public String getDepid() {
		return depid;
	}

	public void setDepid(String depid) {
		this.depid = depid;
	}

	@Override
	public String toString() {
		return "OwnedVehicle [id=" + id + ", vehicleId=" + vehicleId
				+ ", vehicleUsageId=" + vehicleUsageId + ", model=" + model
				+ ", licenseCode=" + licenseCode + ", engineCode=" + engineCode
				+ ", frameCode=" + frameCode + ", buyDate=" + buyDate
				+ ", originalValue=" + originalValue + ", regCertId="
				+ regCertId + ", drivingKm=" + drivingKm
				+ ", drivingUpdateTime=" + drivingUpdateTime
				+ ", payRoadMaintenanceCost=" + payRoadMaintenanceCost
				+ ", payVehicleInsurance=" + payVehicleInsurance
				+ ", payTravelTax=" + payTravelTax + ", driver=" + driver
				+ ", capacity=" + capacity + ", state=" + state + ", memo="
				+ memo + ", depid=" + depid + "]";
	}
}