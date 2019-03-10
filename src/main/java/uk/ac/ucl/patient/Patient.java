package uk.ac.ucl.patient;

import java.util.ArrayList;

public class Patient<String>{

    ArrayList<String> patient =new ArrayList<String>();



    private String ID ;
    private String BIRTHDATE;
    private String DEATHDATE;
    private String SSN;
    private String DRIVERS;
    private String PASSPORT;
    private String PREFIX;
    private String FIRST;
    private String LAST;
    private String SUFFIX;
    private String MAIDEN;
    private String MARITAL;
    private String RACE;
    private String ETHNICITY;
    private String GENDER;
    private String BIRTHPLACE;
    private String ADDRESS;
    private String CITY;
    private String STATE;
    private String ZIP;

    public Patient(){}

    public Patient(String ID, String BIRTHDATE,String DEATHDATE,String SSN,String DRIVERS,
                   String PASSPORT,String PREFIX,String FIRST,String LAST,String SUFFIX,
                   String MAIDEN,String MARITAL,String RACE,String ETHNICITY,String GENDER,
                   String BIRTHPLACE,String ADDRESS,String CITY,String STATE,String ZIP)
    {
        setID(ID);
        setBIRTHDATE(BIRTHDATE);
        setDEATHDATE(DEATHDATE);
        setSSN(SSN);
        setDRIVERS(DRIVERS);
        setPASSPORT(PASSPORT);
        setPREFIX(PREFIX);
        setFIRST(FIRST);
        setLAST(LAST);
        setSUFFIX(SUFFIX);
        setMAIDEN(MAIDEN);
        setMARITAL(MARITAL);
        setRACE(RACE);
        setETHNICITY(ETHNICITY);
        setGENDER(GENDER);
        setBIRTHPLACE(BIRTHPLACE);
        setADDRESS(ADDRESS);
        setCITY(CITY);
        setSTATE(STATE);
        setZIP(ZIP);

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
        patient.add(ID);
    }

    public String getBIRTHDATE() { return BIRTHDATE;
    }

    public void setBIRTHDATE(String BIRTHDATE) {
        this.BIRTHDATE = BIRTHDATE;
        patient.add(BIRTHDATE);
    }

    public String getDEATHDATE() {
        return DEATHDATE;
    }

    public void setDEATHDATE(String DEATHDATE) {
        this.DEATHDATE = DEATHDATE;
        patient.add(DEATHDATE);
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
        patient.add(SSN);
    }

    public String getDRIVERS() {
        return DRIVERS;
    }

    public void setDRIVERS(String DRIVERS) {
        this.DRIVERS = DRIVERS;
        patient.add(DRIVERS);
    }

    public String getPASSPORT() {
        return PASSPORT;
    }

    public void setPASSPORT(String PASSPORT) {
        this.PASSPORT = PASSPORT;
        patient.add(PASSPORT);
    }

    public String getPREFIX() {
        return PREFIX;
    }

    public void setPREFIX(String PREFIX) {
        this.PREFIX = PREFIX;
        patient.add(PREFIX);
    }

    public String getFIRST() {
        return FIRST;
    }

    public void setFIRST(String FIRST) {
        this.FIRST = FIRST;
        patient.add(FIRST);
    }

    public String getLAST() {
        return LAST;
    }

    public void setLAST(String LAST) {
        this.LAST = LAST;
        patient.add(LAST);
    }

    public String getSUFFIX() { return SUFFIX;
    }

    public void setSUFFIX(String SUFFIX) {
        this.SUFFIX = SUFFIX;
        patient.add(SUFFIX);
    }

    public String getMAIDEN() {
        return MAIDEN;
    }

    public void setMAIDEN(String MAIDEN) {
        this.MAIDEN = MAIDEN;
        patient.add(MAIDEN);
    }

    public String getMARITAL() {
        return MARITAL;
    }

    public void setMARITAL(String MARITAL) {
        this.MARITAL = MARITAL;
        patient.add(MARITAL);
    }

    public String getRACE() {
        return RACE;
    }

    public void setRACE(String RACE) {
        this.RACE = RACE;
        patient.add(RACE);
    }

    public String getETHNICITY() {
        return ETHNICITY;
    }

    public void setETHNICITY(String ETHNICITY) {
        this.ETHNICITY = ETHNICITY;
        patient.add(ETHNICITY);
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
        patient.add(GENDER);
    }

    public String getBIRTHPLACE() {
        return BIRTHPLACE;
    }

    public void setBIRTHPLACE(String BIRTHPLACE) {
        this.BIRTHPLACE = BIRTHPLACE;
        patient.add(BIRTHPLACE);
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
        patient.add(ADDRESS);
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
        patient.add(CITY);
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
        patient.add(STATE);
    }

    public String getZIP() {
        return ZIP;
    }

    public void setZIP(String ZIP) {
        this.ZIP = ZIP;
        patient.add(ZIP);
    }
}
