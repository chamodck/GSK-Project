package gskproject;

import java.util.Date;

public class Observation {
    private Date date;
    private int observationID;
    private String observationType;
    private String kindOfSource;
    private String description;
    private int departmentID;
    private int observerID;
    private int responsiblePartyID;
    private Date closeDate;
    private Date targetDate;
    private String zapStatus;
    private int x;
    private int y;
    private String accidentType;

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the observationID
     */
    public int getObservationID() {
        return observationID;
    }

    /**
     * @param observationID the observationID to set
     */
    public void setObservationID(int observationID) {
        this.observationID = observationID;
    }

    /**
     * @return the observationType
     */
    public String getObservationType() {
        return observationType;
    }

    /**
     * @param observationType the observationType to set
     */
    public void setObservationType(String observationType) {
        this.observationType = observationType;
    }

    /**
     * @return the kindOfSource
     */
    public String getKindOfSource() {
        return kindOfSource;
    }

    /**
     * @param kindOfSource the kindOfSource to set
     */
    public void setKindOfSource(String kindOfSource) {
        this.kindOfSource = kindOfSource;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the observerID
     */
    public int getObserverID() {
        return observerID;
    }

    /**
     * @param observerID the observerID to set
     */
    public void setObserverID(int observerID) {
        this.observerID = observerID;
    }

    /**
     * @return the responsiblePartyID
     */
    public int getResponsiblePartyID() {
        return responsiblePartyID;
    }

    /**
     * @param responsiblePartyID the responsiblePartyID to set
     */
    public void setResponsiblePartyID(int responsiblePartyID) {
        this.responsiblePartyID = responsiblePartyID;
    }

    /**
     * @return the zapStatus
     */
    public String getZapStatus() {
        return zapStatus;
    }

    /**
     * @param zapStatus the zapStatus to set
     */
    public void setZapStatus(String zapStatus) {
        this.zapStatus = zapStatus;
    }

    /**
     * @return the departmentID
     */
    public int getDepartmentID() {
        return departmentID;
    }

    /**
     * @param departmentID the departmentID to set
     */
    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    
    public String getAccidentType() {
        return accidentType;
    }

    /**
     * @param accidentType the accidentType to set
     */
    public void setAccidentType(String accidentType) {
        this.accidentType = accidentType;
    }

    /**
     * @return the closeDate
     */
    public Date getCloseDate() {
        return closeDate;
    }

    /**
     * @param closeDate the closeDate to set
     */
    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    /**
     * @return the targetDate
     */
    public Date getTargetDate() {
        return targetDate;
    }

    /**
     * @param targetDate the targetDate to set
     */
    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }
}
