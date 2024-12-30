package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "application_dtls")
public class ApplicationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long StudentId;

	private String studentName;

	private String email;

	@Size(max = 255, message = "packageInfo size should not exceed 255 characters")
	private String packageInfo;

	@Column(nullable = false)
	private String interest;

	@Column(nullable = false)
	private String country;

	@Column(nullable = false)
	@Size(max = 500, message = "Purpose size should not exceed 255 characters")
	private String purpose;

	@Column(nullable = false)
	@Size(max = 500, message = "career Goal size should not exceed 255 characters")
	private String careerGoal;

	@Column(nullable = false)
	private Long phoneNumber;

	@Column(nullable = false)
	private String citizenShip;

	@Column(nullable = false)
	private String college;

	@Column(nullable = false)
	private String gradCourse;

	@Column(nullable = false)
	private int acadamicPercentage;

	@Column(nullable = false)
	private String activity;

	@Column(nullable = false)
	private String summary;

	@Column(nullable = false)
	private String engProficiency;

	@Column(nullable = false)
	private String testResult;

	@Column(nullable = false)
	private String documents;

	@Column(nullable = false)
	private String sop;

	public Long getStudentId() {
		return StudentId;
	}

	public void setStudentId(Long studentId) {
		StudentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPackageInfo() {
		return packageInfo;
	}

	public void setPackageInfo(String packageInfo) {
		this.packageInfo = packageInfo;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getCareerGoal() {
		return careerGoal;
	}

	public void setCareerGoal(String careerGoal) {
		this.careerGoal = careerGoal;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCitizenShip() {
		return citizenShip;
	}

	public void setCitizenShip(String citizenShip) {
		this.citizenShip = citizenShip;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getGradCourse() {
		return gradCourse;
	}

	public void setGradCourse(String gradCourse) {
		this.gradCourse = gradCourse;
	}

	public int getAcadamicPercentage() {
		return acadamicPercentage;
	}

	public void setAcadamicPercentage(int acadamicPercentage) {
		this.acadamicPercentage = acadamicPercentage;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getEngProficiency() {
		return engProficiency;
	}

	public void setEngProficiency(String engProficiency) {
		this.engProficiency = engProficiency;
	}

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public String getDocuments() {
		return documents;
	}

	public void setDocuments(String documents) {
		this.documents = documents;
	}

	public String getSop() {
		return sop;
	}

	public void setSop(String sop) {
		this.sop = sop;
	}

}