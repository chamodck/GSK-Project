package gskproject;

public class Action {
    private int actionID;
    private String actionStatus;
    private String actionDescription;
    private int observationID;
    private int priorityNumber;

    /**
     * @return the actionID
     */
    public int getActionID() {
        return actionID;
    }

    /**
     * @param actionID the actionID to set
     */
    public void setActionID(int actionID) {
        this.actionID = actionID;
    }

    /**
     * @return the actionStatus
     */
    public String getActionStatus() {
        return actionStatus;
    }

    /**
     * @param actionStatus the actionStatus to set
     */
    public void setActionStatus(String actionStatus) {
        this.actionStatus = actionStatus;
    }

    /**
     * @return the actionDescription
     */
    public String getActionDescription() {
        return actionDescription;
    }

    /**
     * @param actionDescription the actionDescription to set
     */
    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
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
     * @return the priorityNumber
     */
    public int getPriorityNumber() {
        return priorityNumber;
        
    }

    /**
     * @param priorityNumber the priorityNumber to set
     */
    public void setPriorityNumber(int priorityNumber) {
        this.priorityNumber = priorityNumber;
    }
}
