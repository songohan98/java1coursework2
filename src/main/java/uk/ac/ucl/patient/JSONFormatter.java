package uk.ac.ucl.patient;

public class JSONFormatter
{
    
    public void getJSONFormat(Patient patient){

        Patient holdData = new Patient();
        holdData = patient;
        
        
        StringBuilder str= new StringBuilder();
        str.append("{Patient:\n\t{");
        str.append("\tID : "+ holdData.getID() + ",\n");
        str.append("\tBIRTHDATE : "+ holdData.getBIRTHDATE() +",\n");
        str.append("\tDEATHDATE : "+ holdData.getDEATHDATE() +",\n");
        str.append("\tSSN : "+ holdData.getSSN()+",\n");
        str.append("\tDRIVERS : "+ holdData.getDRIVERS() +",\n");
        str.append("\tPASSPORT : "+ holdData.getPASSPORT() +",\n");
        str.append("\tPREFIX : "+ holdData.getPREFIX() +",\n");
        str.append("\tFIRST : "+ holdData.getFIRST() +",\n");
        str.append("\tLAST : "+ holdData.getLAST() +",\n");
        str.append("\tSUFFIX : "+ holdData.getSUFFIX() +",\n");
        str.append("\tMAIDEN : "+ holdData.getMAIDEN() +",\n");
        str.append("\tMARITAL : "+holdData.getMARITAL()  +",\n");
        str.append("\tRACE : " + holdData.getRACE() +",\n");
        str.append("\tETHNICITY : "+ holdData.getETHNICITY() +",\n");
        str.append("\tGENDER : "+ holdData.getGENDER() +",\n");
        str.append("\tBIRTHPLACE : " + holdData.getBIRTHPLACE() +",\n");
        str.append("\tADDRESS : " + holdData.getADDRESS() +",\n");
        str.append("\tCITY : "+ holdData.getCITY() +",\n");
        str.append("\tSTATE : "+holdData.getSTATE()  +",\n");
        str.append("\tZIP : "+ holdData.getZIP() +",\n");
        str.append("\t}\n");
        str.append("}\n");

        //printing
        str.toString();

    }
}





//changes////rough work

//	"Patients":
//            [
//	        {
//            str.append("ID : "+ + ",")
//            str.append("BIRTHDATE : "+ +",")
//            str.append("DEATHDATE : "+ +","
//            str.append("SSN : "+ +",")
//            str.append("DRIVERS : "+ +",")
//            str.append("PASSPORT : "+ +",")
//            str.append("PREFIX : "+ +",")
//            str.append("FIRST : "+ +",")
//            str.append("LAST : "+ +",")
//            str.append("SUFFIX : "+ +",")
//            str.append("MAIDEN : "+ +",")
//            str.append("MARITAL : "+ +",")
//            str.append("RACE : " + +",")
//            str.append("ETHNICITY : "+ +",")
//            str.append("GENDER : "+ +",")
//            str.append("BIRTHPLACE : " + +",")
//            str.append("ADDRESS : " + +",")
//            str.append("CITY : "+ +",")
//            str.append("STATE : "+ +",")
//            str.append("ZIP : "+ +",")
//	        }
//	        ]
