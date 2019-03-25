package uk.ac.ucl.patient;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public WriteFile(String s,String c)
    {
        final String path = s;

        BufferedWriter br = null;

        try {
            String content = c;

            br = new BufferedWriter(new FileWriter(path));
            br.write(content);

            System.out.println("Done");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (br != null)
                    br.close();

            } catch (IOException x)
            {
                x.printStackTrace();
            }

        }

    }
}
