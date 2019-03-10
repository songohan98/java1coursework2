package uk.ac.ucl.patient;

import java.util.ArrayList;

public class JSONFormatter
{
    StringBuilder str= new StringBuilder();
    Patient holdData;

    public JSONFormatter(ArrayList<Patient> patient ){


        



//changes
//        str.append("{Patient:\n{");
        str.append("\t\t{\n");
        str.append("\t\t\"ID\" : \""+ patient.get(0) + "\",\n");
        str.append("\t\t\"BIRTHDATE\" : \""+ patient.get(1) +"\",\n");
        str.append("\t\t\"DEATHDATE\" : \""+ patient.get(2) +"\",\n");
        str.append("\t\t\"SSN\" : \""+ patient.get(3)+"\",\n");
        str.append("\t\t\"DRIVERS\" : \""+ patient.get(4) +"\",\n");
        str.append("\t\t\"PASSPORT\" : \""+ patient.get(5) +"\",\n");
        str.append("\t\t\"PREFIX\" : \""+ patient.get(6) +"\",\n");
        str.append("\t\t\"FIRST\" : \""+ patient.get(7) +"\",\n");
        str.append("\t\t\"LAST\" : \""+ patient.get(8) +"\",\n");
        str.append("\t\t\"SUFFIX\" : \""+ patient.get(9) +"\",\n");
        str.append("\t\t\"MAIDEN\" : \""+ patient.get(10) +"\",\n");
        str.append("\t\t\"MARITAL\" : \""+patient.get(11)  +"\",\n");
        str.append("\t\t\"RACE\" : \"" + patient.get(12) +"\",\n");
        str.append("\t\t\"ETHNICITY\" : \""+ patient.get(13) +"\",\n");
        str.append("\t\t\"GENDER\" : \""+ patient.get(14) +"\",\n");
        str.append("\t\t\"BIRTHPLACE\" : \"" + patient.get(15) +"\",\n");
        str.append("\t\t\"ADDRESS\" : \"" + patient.get(16) +"\",\n");
        str.append("\t\t\"CITY\" : \""+ patient.get(17) +"\",\n");
        str.append("\t\t\"STATE\" : \""+patient.get(18)  +"\",\n");
        str.append("\t\t\"ZIP\" : \""+ patient.get(19) +"\"\n");
        str.append("\t\t}");
//        str.append("}\n");

    }

//    public void getID()
//    {
//        System.out.println("ID : "+ patient.get(0));
//    }
//    public void getBIRTHDATE()
//    {
//        System.out.println("BIRTHDATE : "+ patient.get(1) +"\",\n");
//    }
//    public void getDEATHDATE()
//    {
//        System.out.println("DEATHDATE : "+ patient.get(2));
//    }
//    public void getSSN()
//    {
//        System.out.println("SSN : "+ patient.get(3));
//    }
//    public void getDRIVERS()
//    {
//        System.out.println("DRIVERS : "+ patient.get(4) );
//    }
//    public void getPASSPORT()
//    {
//        System.out.println("PASSPORT : "+ patient.get(5) );
//    }
//    public void getPREFIX()
//    {
//        System.out.println("PREFIX : "+ patient.get(6));
//    }
//
//    public void getFIRST()
//    {
//        System.out.println("FIRST : "+ patient.get(7) );
//    }
//    public void getLAST()
//    {
//        System.out.println("LAST : "+ patient.get(8) );
//    }
//    public void getSUFFIX()
//    {
//        System.out.println("SUFFIX : "+ patient.get(9) );
//    }
//    public void getMAIDEN()
//    {
//        System.out.println("MAIDEN : "+ patient.get(10) );
//    }
//    public void getMARITAL()
//    {
//        System.out.println("MARITAL : "+patient.get(11)  );
//    }
//    public void getRACE()
//    {
//        System.out.println("RACE : " + patient.get(12) );
//    }
//    public void getETHNICITY()
//    {
//        System.out.println("ETHNICITY : "+ patient.get(13) );
//    }
//    public void getGENDER()
//    {
//        System.out.println("GENDER : "+ patient.get(14) );
//    }
//    public void getBIRTHPLACE()
//    {
//        System.out.println("BIRTHPLACE : " + patient.get(15) );
//    }
//    public void getADDRESS()
//    {
//        System.out.println("ADDRESS : " + patient.get(16) );
//    }
//    public void getCITY()
//    {
//        System.out.println("CITY : "+ patient.get(17));
//    }
//    public void getSTATE()
//    {
//        System.out.println("STATE : "+patient.get(18) );
//    }
//    public void getZIP()
//    {
//        System.out.println("ZIP : "+ patient.get(19) );
//    }



    public void printAll()
    {
        //printing
        System.out.print(str.toString());

    }

}





//changes////rough work

//	"Patients":
//            [
//	        {
//            str.append("ID : "+ + "\",")
//            str.append("BIRTHDATE : "+ +"\",")
//            str.append("DEATHDATE : "+ +"\","
//            str.append("SSN : "+ +"\",")
//            str.append("DRIVERS : "+ +"\",")
//            str.append("PASSPORT : "+ +"\",")
//            str.append("PREFIX : "+ +"\",")
//            str.append("FIRST : "+ +"\",")
//            str.append("LAST : "+ +"\",")
//            str.append("SUFFIX : "+ +"\",")
//            str.append("MAIDEN : "+ +"\",")
//            str.append("MARITAL : "+ +"\",")
//            str.append("RACE : " + +"\",")
//            str.append("ETHNICITY : "+ +"\",")
//            str.append("GENDER : "+ +"\",")
//            str.append("BIRTHPLACE : " + +"\",")
//            str.append("ADDRESS : " + +"\",")
//            str.append("CITY : "+ +"\",")
//            str.append("STATE : "+ +"\",")
//            str.append("ZIP : "+ +"\",")
//	        }
//	        ]
