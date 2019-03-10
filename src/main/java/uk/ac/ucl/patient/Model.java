package uk.ac.ucl.patient;


import java.util.ArrayList;

public class Model {

    ArrayList<Patient> listOfPatients;
    Patient recordof = new Patient();

    Patient holdNewPaient = new Patient();
    Patient store = new Patient();

    ReadCSV csvfile = new ReadCSV();

    ArrayList<Patient> holdData = new ArrayList<Patient>();



    public void ReadFile(String patientcsv)
    {
        listOfPatients = csvfile.readCSV(patientcsv);
    }

    public void holdPatient()
    {
        for(int i = 0;i<listOfPatients.size();i++){
            store.patient=listOfPatients.get(i).patient;
            holdData.add(store);
        }

    }

    public void printAllData()
    {
        System.out.print("{\n\t\"patients\":[");
        for (int j = 0; j < holdData.size(); j++) {
            holdNewPaient.patient = holdData.get(j).patient;
            JSONFormatter printRec = new JSONFormatter(holdNewPaient.patient);
            printRec.printAll();
            if(holdData.size()>1)
            {
                if(j!=holdData.size()-1)
                {
                    System.out.print(",\n");
                }
            }
        }
        System.out.print("\n\t]\n}");
    }
//            printRec.getID();
//            printRec.getBIRTHDATE();
//            printRec.getDEATHDATE();
//            printRec.getSSN();
//            printRec.getDRIVERS();
//            printRec.getPASSPORT();
//            printRec.getPREFIX();
//            printRec.getFIRST();
//            printRec.getLAST();
//            printRec.getSUFFIX();
//            printRec.getMAIDEN();
//            printRec.getMARITAL();
//            printRec.getRACE();
//            printRec.getETHNICITY();
//            printRec.getGENDER();
//            printRec.getBIRTHPLACE();
//            printRec.getADDRESS();
//            printRec.getCITY();
//            printRec.getSTATE();
//            printRec.getZIP();







}
