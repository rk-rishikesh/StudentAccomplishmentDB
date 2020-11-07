package studentregister;

import java.io.Serializable;

class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private String STU_NAME = null;
	private String STU_ID = null;
	private int CRN_SEM = 0;
	private int SHIFT = 0;
	private float S1_GPA =0;
	private float S2_GPA =0;
	private float S3_GPA =0;
	private float S4_GPA =0;
	private float S5_GPA =0;
	private float S6_GPA =0;
	private float S7_GPA =0;
	private float S8_GPA =0;
	private String NAME_OF_EVENT = null;
	private String ACCOMPLISHMENT = null;
	private String STU_PW = null;

	public String getStudentName() {
		return STU_NAME;
	}

	public void setStudentName(String studentName) {
		this.STU_NAME = studentName;
	}

	public String getStudentId() {
		return STU_ID;
	}

	public void setStudentId(String studentId) {
		this.STU_ID = studentId;
	}
	
	public int getCurrSem() {
		return CRN_SEM;
	}

	public void setCurrSem(int CRN_SEM) {
		this.CRN_SEM = CRN_SEM;
	}
	
	public int getShift() {
		return SHIFT;
	}

	public void setShift(int SHIFT) {
		this.SHIFT = SHIFT;
	}
	
	public String getPassWord()
	{
		return STU_PW;
	}
	
	public void setPassWord(String STU_PW) {
		this.STU_PW = STU_PW;
	}
	
	public float getSGPA(int sem) {
		switch(sem){
			case 1:
				return S1_GPA;
			case 2:
				return S2_GPA;
			case 3:
				return S3_GPA;
			case 4:
				return S4_GPA;
			case 5:
				return S5_GPA;
			case 6:
				return S6_GPA;
			case 7:
				return S7_GPA;
			case 8:
				return S8_GPA;
		}
		return 0;
	}
	
	public void setSGPA(int sem,float sgpa) {
		switch(sem){
			case 1:
				this.S1_GPA = sgpa;
				break;
			case 2:
				this.S2_GPA = sgpa;
				break;
			case 3:
				this.S3_GPA = sgpa;
				break;
			case 4:
				this.S4_GPA = sgpa;
				break;
			case 5:
				this.S5_GPA = sgpa;
				break;
			case 6:
				this.S6_GPA = sgpa;
				break;
			case 7:
				this.S7_GPA = sgpa;
				break;
			case 8:
				this.S8_GPA = sgpa;
				break;
		}
	}

	
	public String getNameOfEvent() {
		return NAME_OF_EVENT;
	}

	public void setNameOfEvent(String NAME_OF_EVENT) {
		this.NAME_OF_EVENT = NAME_OF_EVENT;
	}
	
	public String getAccomplishment() {
		return ACCOMPLISHMENT;
	}

	public void setAccomplishment(String ACCOMPLISHMENT) {
		this.ACCOMPLISHMENT = ACCOMPLISHMENT;
	}

	public Student() {
	}

	public Student(String studentName, String studentId,int CRN_SEM,int SHIFT,float S1_GPA,float S2_GPA,float S3_GPA,float S4_GPA,float S5_GPA,
				float S6_GPA,float S7_GPA,float S8_GPA,String NAME_OF_EVENT,String ACCOMPLISHMENT, String STU_PW) {
		super();
		this.STU_NAME = studentName;
		this.STU_ID = studentId;
		this.CRN_SEM = CRN_SEM;
		this.SHIFT = SHIFT;
		this.S1_GPA = S1_GPA;
		this.S2_GPA = S2_GPA;
		this.S3_GPA = S3_GPA;
		this.S4_GPA = S4_GPA;
		this.S5_GPA = S5_GPA;
		this.S6_GPA = S6_GPA;
		this.S7_GPA = S7_GPA;
		this.S8_GPA = S8_GPA;
		this.NAME_OF_EVENT = NAME_OF_EVENT;
		this.ACCOMPLISHMENT = ACCOMPLISHMENT;
		this.STU_PW = STU_PW;
	}
	
	@Override
	public String toString() {

		return "\nStudent Name     : " + this.STU_NAME + "\nStudent ID       : " + this.STU_ID + "\nCurrent Semester : " + this.CRN_SEM;
	}
}
