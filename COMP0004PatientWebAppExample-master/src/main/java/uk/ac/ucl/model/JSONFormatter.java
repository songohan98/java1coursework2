package uk.ac.ucl.model;

import java.util.ArrayList;

public class JSONFormatter
{
    StringBuilder str= new StringBuilder();
    StringBuilder strnew = new StringBuilder();
    Patient holdData;
    
    ArrayList<String> DataListFormat = new ArrayList<>();

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


        strnew.append("        ID : "+ patient.get(0) + "\n");
        strnew.append(" BIRTHDATE : "+ patient.get(1) +"\n");
        strnew.append(" DEATHDATE : "+ patient.get(2) +"\n");
        strnew.append("       SSN : "+ patient.get(3)+"\n");
        strnew.append("   DRIVERS : "+ patient.get(4) +"\n");
        strnew.append("  PASSPORT : "+ patient.get(5) +"\n");
        strnew.append("    PREFIX : "+ patient.get(6) +"\n");
        strnew.append("    SUFFIX : "+ patient.get(9) +"\n");
        strnew.append("    MAIDEN : "+ patient.get(10) +"\n");
        strnew.append("   MARITAL : "+patient.get(11)  +"\n");
        strnew.append("      RACE : " + patient.get(12) +"\n");
        strnew.append(" ETHNICITY : "+ patient.get(13) +"\n");
        strnew.append("    GENDER : "+ patient.get(14) +"\n");
        strnew.append("BIRTHPLACE : " + patient.get(15) +"\n");
        strnew.append("   ADDRESS : " + patient.get(16) +"\n");
        strnew.append("      CITY : "+ patient.get(17) +"\n");
        strnew.append("     STATE : "+patient.get(18)  +"\n");
        strnew.append("       ZIP : "+ patient.get(19) +"\n");


        DataListFormat.add("      Name : "+ patient.get(7)+" "+patient.get(8));
        DataListFormat.add("        ID : "+ patient.get(0) );
        DataListFormat.add(" BIRTHDATE : "+ patient.get(1) );
        DataListFormat.add(" DEATHDATE : "+ patient.get(2) );
        DataListFormat.add("       SSN : "+ patient.get(3));
        DataListFormat.add("   DRIVERS : "+ patient.get(4) );
        DataListFormat.add("  PASSPORT : "+ patient.get(5) );
        DataListFormat.add("    PREFIX : "+ patient.get(6) );
        DataListFormat.add("    SUFFIX : "+ patient.get(9) );
        DataListFormat.add("    MAIDEN : "+ patient.get(10) );
        DataListFormat.add("   MARITAL : "+patient.get(11)  );
        DataListFormat.add("      RACE : " + patient.get(12) );
        DataListFormat.add(" ETHNICITY : "+ patient.get(13) );
        DataListFormat.add("    GENDER : "+ patient.get(14) );
        DataListFormat.add("BIRTHPLACE : " + patient.get(15) );
        DataListFormat.add("   ADDRESS : " + patient.get(16) );
        DataListFormat.add("      CITY : "+ patient.get(17) );
        DataListFormat.add("     STATE : "+patient.get(18)  );
        DataListFormat.add("       ZIP : "+ patient.get(19) );



    }


    public void printAll()
    {
        //printing
        System.out.print(str.toString());

    }

    public String storeAll()
    {
        String s ;
        s = String.valueOf(str);
        return s;
    }

    public String storeAllnotJSON()
    {
        String s;
        s = String.valueOf(strnew);
        return s;
    }

    public ArrayList<String> getDataListFormat()
    {
        return DataListFormat;
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
