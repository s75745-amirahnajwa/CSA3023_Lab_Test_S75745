package com.Model;

public class SessionBean {
    

    protected int sessionId;
    protected String studentName;
    protected String branchLocation;
    protected String lessonType;
    protected String status;

    public SessionBean() {}

    public SessionBean(String studentName, String branchLocation,
                       String lessonType, String status) {
        this.studentName = studentName;
        this.branchLocation = branchLocation;
        this.lessonType = lessonType;
        this.status = status;
    }

    public SessionBean(int sessionId, String studentName,
                       String branchLocation, String lessonType,
                       String status) {
        this.sessionId = sessionId;
        this.studentName = studentName;
        this.branchLocation = branchLocation;
        this.lessonType = lessonType;
        this.status = status;
    }

    public int getSessionId() { return sessionId; }
    public void setSessionId(int sessionId) { this.sessionId = sessionId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getBranchLocation() { return branchLocation; }
    public void setBranchLocation(String branchLocation) { this.branchLocation = branchLocation; }

    public String getLessonType() { return lessonType; }
    public void setLessonType(String lessonType) { this.lessonType = lessonType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}