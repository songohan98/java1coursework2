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
        holdData = listOfPatients;
        //System.out.println(listOfPatients.get(1).patient+"..."+ listOfPatients.get(2).patient);
//        for(int i = 0;i<listOfPatients.size();i++){
//            store.patient=listOfPatients.get(i).patient;
//            holdData.add(store);

//        }
        //System.out.println(listOfPatients.get(1). +" .."+ listOfPatients.get(2).patient);

    }

    public void printSinglePatient(int PatientNo)
    {
        int index = PatientNo-1;
        System.out.print("{\n\t\"patients\":[");

            holdNewPaient.patient = holdData.get(index).patient;
            JSONFormatter printRec = new JSONFormatter(holdNewPaient.patient);
            printRec.printAll();

        System.out.print("\n\t]\n}");
    }

    public String storeSinglePatient(int PatientNo)
    {
        int index = PatientNo-1;
        String s="";

        holdNewPaient.patient = holdData.get(index).patient;
        JSONFormatter printRec = new JSONFormatter(holdNewPaient.patient);
        s+=printRec.storeAll();

        return s;

    }

    public void printAllPatient()
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

    public String storetextAllPatient()
    {
        String a =null;
        a="{\n\t\"patients\":[";
        for (int j = 0; j < holdData.size(); j++) {
            holdNewPaient.patient = holdData.get(j).patient;
            JSONFormatter printRec = new JSONFormatter(holdNewPaient.patient);
            a += printRec.storeAll();
            if(holdData.size()>1)
            {
                if(j!=holdData.size()-1)
                {
                    a+=",\n";
                }
            }
        }
        a+="\n\t]\n}";

        return a;
    }

        public void printAllID()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
            System.out.print("\"ID\" : \""+holdNewPaient.patient.get(0)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllBIRTHDATE()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"BIRTHDATE\" : \""+holdData.get(j).patient.get(1)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllDEATHDATE()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"DEATHDATE\" : \""+holdData.get(j).patient.get(2)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllSSN()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"SSN\" : \""+holdData.get(j).patient.get(3)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllDRIVERS()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"DRIVERS\" : \""+holdData.get(j).patient.get(4)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllPASSPORT()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"PASSPORT\" : \""+holdData.get(j).patient.get(5)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllPREFIX()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"PREFIX\" : \""+holdData.get(j).patient.get(6)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }

        public void printAllFIRST()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"FIRST\" : \""+holdData.get(j).patient.get(7)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }

        public ArrayList<String> storeListAllFirst()
        {
            ArrayList<String> list = new ArrayList<String>();
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                list.add(String.valueOf(holdData.get(j).patient.get(7)));


            }
            return list;
        }

        public void printAllLAST()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"LAST\" : \""+holdData.get(j).patient.get(8)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public ArrayList<String> storeListAllLast()
        {
            ArrayList<String> list = new ArrayList<String>();
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                list.add(String.valueOf(holdData.get(j).patient.get(8)));


            }
            return list;
        }


        public void printAllSUFFIX()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"SUFFIX\" : \""+holdData.get(j).patient.get(9)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllMAIDEN()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"MAIDEN\" : \""+holdData.get(j).patient.get(10)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllMARITAL()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"MARITAL\" : \""+holdData.get(j).patient.get(11)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllRACE()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"RACE\" : \""+holdData.get(j).patient.get(12)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllETHNICITY()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"ETHNICITY\" : \""+holdData.get(j).patient.get(13)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllGENDER()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"GENDER\" : \""+holdData.get(j).patient.get(14)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllBIRTHPLACE()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"BIRTHPLACE\" : \""+holdData.get(j).patient.get(15)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllADDRESS()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"ADDRESS\" : \""+holdData.get(j).patient.get(16)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllCITY()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"CITY\" : \""+holdData.get(j).patient.get(17)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllSTATE()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"STATE\" : \""+holdData.get(j).patient.get(18)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllZIP()
        {
            for (int j = 0; j < holdData.size(); j++) {
                holdNewPaient.patient = holdData.get(j).patient;
                System.out.print("\"ZIP\" : \""+holdData.get(j).patient.get(19)+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }
        }
        public void printAllAge()
        {
            for (int j = 0; j < holdData.size(); j++) {
                int lastrecordedyear;
                holdNewPaient.patient = holdData.get(j).patient;
                String objecttoString = ""+holdData.get(j).patient.get(1);
                String sr1[]=objecttoString.split("-");
                int birthyear=Integer.parseInt(sr1[0]);

                String s =""+holdData.get(j).patient.get(2);

                if(!s.equals(""))
                {
                String objecttoString2 =""+holdData.get(j).patient.get(2);
                String sr2[]=objecttoString2.split("-");
                lastrecordedyear=Integer.parseInt(sr2[0]);
                }
                else{
                    lastrecordedyear=2019;
                }
                int age = lastrecordedyear - birthyear;

                System.out.print("\"AGE\" : \""+age+"\"");
                if(holdData.size()>1)
                {
                    if(j!=holdData.size()-1)
                    {
                        System.out.print(",\n");
                    }
                }
            }



        }

        public ArrayList<Integer> storeAllAge()
        {
            ArrayList<Integer> agelist = new ArrayList<Integer>();
            for (int j = 0; j < holdData.size(); j++) {
                int lastrecordedyear;
                holdNewPaient.patient = holdData.get(j).patient;
                String objecttoString = ""+holdData.get(j).patient.get(1);
                String sr1[]=objecttoString.split("-");
                int birthyear=Integer.parseInt(sr1[0]);

                String s =""+holdData.get(j).patient.get(2);

                if(!s.equals(""))
                {
                    String objecttoString2 =""+holdData.get(j).patient.get(2);
                    String sr2[]=objecttoString2.split("-");
                    lastrecordedyear=Integer.parseInt(sr2[0]);
                }
                else{
                    lastrecordedyear=2019;
                }
                int age = lastrecordedyear - birthyear;
                agelist.add(age);

            }
            return agelist;
        }

        public ArrayList<Integer> storeAllBirthyear()
        {
            ArrayList<Integer> birthyearlist = new ArrayList<Integer>();
            for (int j = 0; j < holdData.size(); j++) {
                int lastrecordedyear;
                holdNewPaient.patient = holdData.get(j).patient;
                String objecttoString = ""+holdData.get(j).patient.get(1);
                String sr1[]=objecttoString.split("-");
                int birthyear=Integer.parseInt(sr1[0]);

                birthyearlist.add(birthyear);

            }
            return birthyearlist;
        }

        public void showGUI()
        {
            new PatientFinder("");
        }


}
