package uk.ac.ucl.patient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV
{
    public String[] readCSV(String path)
    {
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
          
            return values;
            
        }
    }
}
