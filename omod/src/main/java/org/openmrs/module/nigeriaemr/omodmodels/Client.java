/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.omodmodels;

import java.util.Date;

/**
 * @author MORRISON.I
 */
public class Client {
	
	private String Id;
	
	private String FirstName;
	
	private String Surname;
	
	//same as ClientCode
	private String Code;
	
	private String Age;
	
	private String Sex;
	
	private Date Date;
	
	private String Address;
	
	private String PhoneNumber;
	
	private String ContactPerson;
	
	private Boolean DeletFlag;
	
	private String CreateDate;
	
	private String CurrentResult;
	
	private String ResultDate;
	
	private Date UpdateDate;
	
	private String FacilityId;
	
	private String Comment;
	
	private String RefferredTo;
	
	private String RefferredFrom;
	
	private Boolean Received;
	
	private Boolean Acknowledged;
	
	private String PreviouslyTested;
	
	private String Result;
	
	private Date DateOfTest;
	
	private Date Estimated;
	
	private String HivTesting;
	
	private Date HivTestDate;
	
	private Date DateClientReported;
	
	private Date DateOfEnrollment;
	
	private String EnrolmentNumber;
	
	private Boolean Enrolled;
	
	private Boolean StartedART;
	
	private Date DateOfArt;
	
	private String SessionType;
	
	private String IndexClient;
	
	private String IndexClientId;
	
	private String IndexType;
	
	private Date ReferralDate;
	
	private Boolean Notification;
	
	private String Status;
	
	private String HospitalNumber;
	
	private String ClientIdentifier;
	
	private String ClientState;
	
	private String ClientLga;
	
	private String ClientVillage;
	
	private String ClientGeoCode;
	
	private String MaritalStatus;
	
	private String EmployementStatus;
	
	private String Religion;
	
	private String EducutionLevel;
	
	private String OfferedPartnerNotification;
	
	private String AcceptedPartnerNotification;
	
	private String HivRecencyTestType;
	
	private Date HivRecencyTestDate;
	
	private String FinalRecencyTestResult;
	
	private String NumberOfIndexTypePartners;
	
	private String NamesOfIndexTypePartners;
	
	private String AddressOfIndexTypePartners;
	
	private String IndexTypeNotificationMethod;
	
	private PreTestCouncel PreTestCouncel;
	
	private PostTestCouncel PostTestCouncel;
	
	public String getId() {
		return Id;
	}
	
	public void setId(String Id) {
		this.Id = Id;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	
	public String getSurname() {
		return Surname;
	}
	
	public void setSurname(String Surname) {
		this.Surname = Surname;
	}
	
	public String getCode() {
		return Code;
	}
	
	public void setCode(String Code) {
		this.Code = Code;
	}
	
	public String getAge() {
		return Age;
	}
	
	public void setAge(String Age) {
		this.Age = Age;
	}
	
	public String getSex() {
		return Sex;
	}
	
	public void setSex(String Sex) {
		this.Sex = Sex;
	}
	
	public Date getDate() {
		return Date;
	}
	
	public void setDate(Date Date) {
		this.Date = Date;
	}
	
	public String getAddress() {
		return Address;
	}
	
	public void setAddress(String Address) {
		this.Address = Address;
	}
	
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	
	public void setPhoneNumber(String PhoneNumber) {
		this.PhoneNumber = PhoneNumber;
	}
	
	public String getContactPerson() {
		return ContactPerson;
	}
	
	public void setContactPerson(String ContactPerson) {
		this.ContactPerson = ContactPerson;
	}
	
	public Boolean getDeletFlag() {
		return DeletFlag;
	}
	
	public void setDeletFlag(Boolean DeletFlag) {
		this.DeletFlag = DeletFlag;
	}
	
	public String getCreateDate() {
		return CreateDate;
	}
	
	public void setCreateDate(String CreateDate) {
		this.CreateDate = CreateDate;
	}
	
	public String getCurrentResult() {
		return CurrentResult;
	}
	
	public void setCurrentResult(String CurrentResult) {
		this.CurrentResult = CurrentResult;
	}
	
	public String getResultDate() {
		return ResultDate;
	}
	
	public void setResultDate(String ResultDate) {
		this.ResultDate = ResultDate;
	}
	
	public Date getUpdateDate() {
		return UpdateDate;
	}
	
	public void setUpdateDate(Date UpdateDate) {
		this.UpdateDate = UpdateDate;
	}
	
	public String getFacilityId() {
		return FacilityId;
	}
	
	public void setFacilityId(String FacilityId) {
		this.FacilityId = FacilityId;
	}
	
	public String getComment() {
		return Comment;
	}
	
	public void setComment(String Comment) {
		this.Comment = Comment;
	}
	
	public String getRefferredTo() {
		return RefferredTo;
	}
	
	public void setRefferredTo(String RefferredTo) {
		this.RefferredTo = RefferredTo;
	}
	
	public String getRefferredFrom() {
		return RefferredFrom;
	}
	
	public void setRefferredFrom(String RefferredFrom) {
		this.RefferredFrom = RefferredFrom;
	}
	
	public Boolean getReceived() {
		return Received;
	}
	
	public void setReceived(Boolean Received) {
		this.Received = Received;
	}
	
	public Boolean getAcknowledged() {
		return Acknowledged;
	}
	
	public void setAcknowledged(Boolean Acknowledged) {
		this.Acknowledged = Acknowledged;
	}
	
	public String getPreviouslyTested() {
		return PreviouslyTested;
	}
	
	public void setPreviouslyTested(String PreviouslyTested) {
		this.PreviouslyTested = PreviouslyTested;
	}
	
	public String getResult() {
		return Result;
	}
	
	public void setResult(String Result) {
		this.Result = Result;
	}
	
	public Date getDateOfTest() {
		return DateOfTest;
	}
	
	public void setDateOfTest(Date DateOfTest) {
		this.DateOfTest = DateOfTest;
	}
	
	public Date getEstimated() {
		return Estimated;
	}
	
	public void setEstimated(Date Estimated) {
		this.Estimated = Estimated;
	}
	
	public String getHivTesting() {
		return HivTesting;
	}
	
	public void setHivTesting(String HivTesting) {
		this.HivTesting = HivTesting;
	}
	
	public Date getHivTestDate() {
		return HivTestDate;
	}
	
	public void setHivTestDate(Date HivTestDate) {
		this.HivTestDate = HivTestDate;
	}
	
	public Date getDateClientReported() {
		return DateClientReported;
	}
	
	public void setDateClientReported(Date DateClientReported) {
		this.DateClientReported = DateClientReported;
	}
	
	public Date getDateOfEnrollment() {
		return DateOfEnrollment;
	}
	
	public void setDateOfEnrollment(Date DateOfEnrollment) {
		this.DateOfEnrollment = DateOfEnrollment;
	}
	
	public String getEnrolmentNumber() {
		return EnrolmentNumber;
	}
	
	public void setEnrolmentNumber(String EnrolmentNumber) {
		this.EnrolmentNumber = EnrolmentNumber;
	}
	
	public Boolean getEnrolled() {
		return Enrolled;
	}
	
	public void setEnrolled(Boolean Enrolled) {
		this.Enrolled = Enrolled;
	}
	
	public Boolean getStartedART() {
		return StartedART;
	}
	
	public void setStartedART(Boolean StartedART) {
		this.StartedART = StartedART;
	}
	
	public Date getDateOfArt() {
		return DateOfArt;
	}
	
	public void setDateOfArt(Date DateOfArt) {
		this.DateOfArt = DateOfArt;
	}
	
	public String getSessionType() {
		return SessionType;
	}
	
	public void setSessionType(String SessionType) {
		this.SessionType = SessionType;
	}
	
	public String getIndexClient() {
		return IndexClient;
	}
	
	public void setIndexClient(String IndexClient) {
		this.IndexClient = IndexClient;
	}
	
	public String getIndexClientId() {
		return IndexClientId;
	}
	
	public void setIndexClientId(String IndexClientId) {
		this.IndexClientId = IndexClientId;
	}
	
	public String getIndexType() {
		return IndexType;
	}
	
	public void setIndexType(String IndexType) {
		this.IndexType = IndexType;
	}
	
	public Date getReferralDate() {
		return ReferralDate;
	}
	
	public void setReferralDate(Date ReferralDate) {
		this.ReferralDate = ReferralDate;
	}
	
	public Boolean getNotification() {
		return Notification;
	}
	
	public void setNotification(Boolean Notification) {
		this.Notification = Notification;
	}
	
	public String getStatus() {
		return Status;
	}
	
	public void setStatus(String Status) {
		this.Status = Status;
	}
	
	public String getHospitalNumber() {
		return HospitalNumber;
	}
	
	public void setHospitalNumber(String HospitalNumber) {
		this.HospitalNumber = HospitalNumber;
	}
	
	public String getClientIdentifier() {
		return ClientIdentifier;
	}
	
	public void setClientIdentifier(String ClientIdentifier) {
		this.ClientIdentifier = ClientIdentifier;
	}
	
	public String getClientState() {
		return ClientState;
	}
	
	public void setClientState(String ClientState) {
		this.ClientState = ClientState;
	}
	
	public String getClientLga() {
		return ClientLga;
	}
	
	public void setClientLga(String ClientLga) {
		this.ClientLga = ClientLga;
	}
	
	public String getClientVillage() {
		return ClientVillage;
	}
	
	public void setClientVillage(String ClientVillage) {
		this.ClientVillage = ClientVillage;
	}
	
	public String getClientGeoCode() {
		return ClientGeoCode;
	}
	
	public void setClientGeoCode(String ClientGeoCode) {
		this.ClientGeoCode = ClientGeoCode;
	}
	
	public String getMaritalStatus() {
		return MaritalStatus;
	}
	
	public void setMaritalStatus(String MaritalStatus) {
		this.MaritalStatus = MaritalStatus;
	}
	
	public String getEmployementStatus() {
		return EmployementStatus;
	}
	
	public void setEmployementStatus(String EmployementStatus) {
		this.EmployementStatus = EmployementStatus;
	}
	
	public String getReligion() {
		return Religion;
	}
	
	public void setReligion(String Religion) {
		this.Religion = Religion;
	}
	
	public String getEducutionLevel() {
		return EducutionLevel;
	}
	
	public void setEducutionLevel(String EducutionLevel) {
		this.EducutionLevel = EducutionLevel;
	}
	
	public String getOfferedPartnerNotification() {
		return OfferedPartnerNotification;
	}
	
	public void setOfferedPartnerNotification(String OfferedPartnerNotification) {
		this.OfferedPartnerNotification = OfferedPartnerNotification;
	}
	
	public String getAcceptedPartnerNotification() {
		return AcceptedPartnerNotification;
	}
	
	public void setAcceptedPartnerNotification(String AcceptedPartnerNotification) {
		this.AcceptedPartnerNotification = AcceptedPartnerNotification;
	}
	
	public String getHivRecencyTestType() {
		return HivRecencyTestType;
	}
	
	public void setHivRecencyTestType(String HivRecencyTestType) {
		this.HivRecencyTestType = HivRecencyTestType;
	}
	
	public Date getHivRecencyTestDate() {
		return HivRecencyTestDate;
	}
	
	public void setHivRecencyTestDate(Date HivRecencyTestDate) {
		this.HivRecencyTestDate = HivRecencyTestDate;
	}
	
	public String getFinalRecencyTestResult() {
		return FinalRecencyTestResult;
	}
	
	public void setFinalRecencyTestResult(String FinalRecencyTestResult) {
		this.FinalRecencyTestResult = FinalRecencyTestResult;
	}
	
	public String getNumberOfIndexTypePartners() {
		return NumberOfIndexTypePartners;
	}
	
	public void setNumberOfIndexTypePartners(String NumberOfIndexTypePartners) {
		this.NumberOfIndexTypePartners = NumberOfIndexTypePartners;
	}
	
	public String getNamesOfIndexTypePartners() {
		return NamesOfIndexTypePartners;
	}
	
	public void setNamesOfIndexTypePartners(String NamesOfIndexTypePartners) {
		this.NamesOfIndexTypePartners = NamesOfIndexTypePartners;
	}
	
	public String getAddressOfIndexTypePartners() {
		return AddressOfIndexTypePartners;
	}
	
	public void setAddressOfIndexTypePartners(String AddressOfIndexTypePartners) {
		this.AddressOfIndexTypePartners = AddressOfIndexTypePartners;
	}
	
	public String getIndexTypeNotificationMethod() {
		return IndexTypeNotificationMethod;
	}
	
	public void setIndexTypeNotificationMethod(String IndexTypeNotificationMethod) {
		this.IndexTypeNotificationMethod = IndexTypeNotificationMethod;
	}
	
	public PreTestCouncel getPreTestCouncel() {
		return PreTestCouncel;
	}
	
	public void setPreTestCouncel(PreTestCouncel PreTestCouncel) {
		this.PreTestCouncel = PreTestCouncel;
	}
	
	public PostTestCouncel getPostTestCouncel() {
		return PostTestCouncel;
	}
	
	public void setPostTestCouncel(PostTestCouncel PostTestCouncel) {
		this.PostTestCouncel = PostTestCouncel;
	}
	
}
