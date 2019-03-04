package uk.ac.ucl.patient;

public class Patient {

    private String ID;
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
    }

    public String getBIRTHDATE() {
        return BIRTHDATE;
    }

    public void setBIRTHDATE(String BIRTHDATE) {
        this.BIRTHDATE = BIRTHDATE;
    }

    public String getDEATHDATE() {
        return DEATHDATE;
    }

    public void setDEATHDATE(String DEATHDATE) {
        this.DEATHDATE = DEATHDATE;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getDRIVERS() {
        return DRIVERS;
    }

    public void setDRIVERS(String DRIVERS) {
        this.DRIVERS = DRIVERS;
    }

    public String getPASSPORT() {
        return PASSPORT;
    }

    public void setPASSPORT(String PASSPORT) {
        this.PASSPORT = PASSPORT;
    }

    public String getPREFIX() {
        return PREFIX;
    }

    public void setPREFIX(String PREFIX) {
        this.PREFIX = PREFIX;
    }

    public String getFIRST() {
        return FIRST;
    }

    public void setFIRST(String FIRST) {
        this.FIRST = FIRST;
    }

    public String getLAST() {
        return LAST;
    }

    public void setLAST(String LAST) {
        this.LAST = LAST;
    }

    public String getSUFFIX() {
        return SUFFIX;
    }

    public void setSUFFIX(String SUFFIX) {
        this.SUFFIX = SUFFIX;
    }

    public String getMAIDEN() {
        return MAIDEN;
    }

    public void setMAIDEN(String MAIDEN) {
        this.MAIDEN = MAIDEN;
    }

    public String getMARITAL() {
        return MARITAL;
    }

    public void setMARITAL(String MARITAL) {
        this.MARITAL = MARITAL;
    }

    public String getRACE() {
        return RACE;
    }

    public void setRACE(String RACE) {
        this.RACE = RACE;
    }

    public String getETHNICITY() {
        return ETHNICITY;
    }

    public void setETHNICITY(String ETHNICITY) {
        this.ETHNICITY = ETHNICITY;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getBIRTHPLACE() {
        return BIRTHPLACE;
    }

    public void setBIRTHPLACE(String BIRTHPLACE) {
        this.BIRTHPLACE = BIRTHPLACE;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public String getZIP() {
        return ZIP;
    }

    public void setZIP(String ZIP) {
        this.ZIP = ZIP;
    }
}
