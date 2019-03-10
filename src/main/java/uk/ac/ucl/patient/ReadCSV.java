package uk.ac.ucl.patient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCSV {

    //    public static void main(String[] args)
    //    {
    public ArrayList<Patient> readCSV(String path)
    {
        //list
        ArrayList<Patient> PatientList = new ArrayList<Patient>();
        //individual patient
        Patient newPatient;
        //------------------------
        String[] values;
//        String file = "C:\\Users\\sciso\\IdeaProjects\\CourseWork2\\src\\main\\java\\uk\\ac\\ucl\\patient\\book.csv";
        String file = path;
        BufferedReader br = null;
        final String DELIMITERComma = ",";


        try {
            String line;
            br = new BufferedReader(new FileReader(file));
            //int j=0; test counter

            while ((line = br.readLine()) != null) {
                values = line.split(DELIMITERComma);
                for (int i = 0; i < values.length; i++) {
                    //Testing
                    //System.out.println(values[i] + " line number: " + i+" record no: "+ j);
                    if (values.length==19 && i == 0) {
                        //This is incase the last Zip is missing
                        newPatient = new Patient(values[0], values[1], values[2], values[3],
                                values[4], values[5], values[6], values[7], values[8], values[9],
                                values[10], values[11], values[12], values[13], values[14], values[15],
                                values[16], values[17], values[18], "");
                        PatientList.add(newPatient);
                    }
                    if(values.length!=19 && i==0){
                        newPatient = new Patient(values[0], values[1], values[2], values[3],
                                values[4], values[5], values[6], values[7], values[8], values[9],
                                values[10], values[11], values[12], values[13], values[14], values[15],
                                values[16], values[17], values[18], values[19]);
                        PatientList.add(newPatient);
                    }
                    //j++;
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

//changes done
        }
        PatientList.remove(0);
//        for (int i = 0; i < PatientList.size(); i++)
//        {
//            System.out.println(PatientList.get(i).patient);
//        }


        return PatientList;

    }
}

