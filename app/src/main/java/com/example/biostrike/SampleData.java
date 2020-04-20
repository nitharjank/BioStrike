package com.example.biostrike;

/**
 * This class help to parse the data given by the sensors
 */
public class SampleData {
    private int sessionID;
    private String sessionDate;
    private int leftHandStrike;
    private int rightHandStrike;
    private int leftLegStrike;
    private int rightLegStrike;

    /**
     * This method will get the session ID from the CSV file
     * @return session ID
     */
    public int getSessionID() {
        return sessionID;
    }

    /**
     * This method will set the session ID
     * @param sessionID id for the session
     */
    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    /**
     * This method will get the session date
     * @return session date
     */
    public String getSessionDate() {
        return sessionDate;
    }

    /**
     * This method will set the session date
     * @param sessionDate date of the session
     */
    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }

    /**
     * This method will get the left hand strike
     * @return left hand strike
     */
    public int getLeftHandStrike() {
        return leftHandStrike;
    }

    /**
     * This method will set the left hand strike
     * @param leftHandStrike left hand strike info
     */
    public void setLeftHandStrike(int leftHandStrike) {
        this.leftHandStrike = leftHandStrike;
    }

    /**
     * This method will get the right hand strike
     * @return right hand strike
     */
    public int getRightHandStrike() {
        return rightHandStrike;
    }

    /**
     * This method will set the right hand strike
     * @param rightHandStrike right hand strike info
     */
    public void setRightHandStrike(int rightHandStrike) {
        this.rightHandStrike = rightHandStrike;
    }

    /**
     * This method will get the right hand strike
     * @return left leg strike
     */
    public int getLeftLegStrike() {
        return leftLegStrike;
    }

    /**
     * This method will set the right hand strike
     * @param leftLegStrike left leg strike info
     */
    public void setLeftLegStrike(int leftLegStrike) {
        this.leftLegStrike = leftLegStrike;
    }

    /**
     * This method will get the right leg strike
     * @return right leg strike
     */
    public int getRightLegStrike() {
        return rightLegStrike;
    }

    /**
     * This method will set the right leg strike
     * @param rightLegStrike right leg strike info
     */
    public void setRightLegStrike(int rightLegStrike) {
        this.rightLegStrike = rightLegStrike;
    }
}
