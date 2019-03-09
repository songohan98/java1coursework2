package uk.ac.ucl.patient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCSV
{
    public ArrayList<Patient> readCSV(String path)
    {
        //list
        Patient newPatient = null;
        //------------------------
        String[] values = new String[20];
        //String file = "C:\\Users\\sciso\\IdeaProjects\\CourseWork2\\src\\main\\java\\uk\\ac\\ucl\\patient\\book.csv";
        String file = path;
        BufferedReader br = null;
        final String DELIMITER = ",";


        try
        {
            String line = "";
            br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null)
            {
                values = line.split(DELIMITER);
//                for(int i=0;i<values.length;i++)
//                {  //Testing
//                    System.out.println(values[i]);
//                }
            }
            newPatient = new Patient(values[0],values[1],values[2],values[3],
            values[4],values[5],values[6],values[7],values[8],values[9],
            values[10],values[11],values[12],values[13],values[14],values[15],
            values[16],values[17],values[18],values[19]);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


        return newPatient.patient;
    }

}
