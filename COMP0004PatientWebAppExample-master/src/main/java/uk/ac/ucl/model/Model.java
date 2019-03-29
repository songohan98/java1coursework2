package uk.ac.ucl.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


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

  public void readFile(File file)
  {
    // Read a patient .csv data file and create the patient objects.
    String path = file.getPath();
    ReadFile(path);
  }

  public void holdPatient()
  {
    holdData = listOfPatients;


  }

  public List<String> getNames()
  {
    ArrayList<String> fullnamelist = new ArrayList<>();

    ArrayList<String> list1 = storeListAllFirst();
    ArrayList<String> list2 = storeListAllLast();

    int i = Math.max(list1.size(),list2.size());

    for(int j = 0;j<i;j++)
    {
      fullnamelist.add(j, list1.get(j)+" "+list2.get(j));
    }

    return fullnamelist;
  }
  public String getNamesByIndex(int a)
  {
    ArrayList<String> list1 = storeListAllFirst();
    ArrayList<String> list2 = storeListAllLast();

    String name = list1.get(a)+" "+list2.get(a);

    return name;
  }


  public ArrayList<String> storeSinglePatientnotJSON(int PatientNo)
  {
    ArrayList<String> patients;
    int index = PatientNo;

    holdNewPaient.patient = holdData.get(index).patient;
    JSONFormatter printRec = new JSONFormatter(holdNewPaient.patient);
    patients = printRec.getDataListFormat();

    return patients;

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


  public ArrayList<String> storeListAllLast()
  {
    ArrayList<String> list = new ArrayList<String>();
    for (int j = 0; j < holdData.size(); j++) {
      holdNewPaient.patient = holdData.get(j).patient;
      list.add(String.valueOf(holdData.get(j).patient.get(8)));


    }
    return list;
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


  public int searchint(String token)
  {
    int g=0;
    String key="";
    String keyList[] = token.split("-");
    for(String o:keyList )
    {
      key += o;
      System.out.println(g++);
    }
    System.out.println("key : "+key);
    key.toLowerCase();
    int length = key.length();
    for(int i = 0;i<holdData.size();i++)
    {
      holdNewPaient.patient = holdData.get(i).patient;
      String first = String.valueOf(holdData.get(i).patient.get(7)).toLowerCase();
      String last = String.valueOf(holdData.get(i).patient.get(8)).toLowerCase();
      String id="";
      String idWithDash = String.valueOf(holdData.get(i).patient.get(0)).toLowerCase();
      String[] idlist = idWithDash.split("-");
      for(String o:idlist)
      {
        id+=o;
      }

      if(key.substring(0,length-1).matches(id.substring(0,length-1)))
      {
        return i;
      }
      if(length<=first.length() || length<=last.length()) {
        if (key.substring(0, length - 1).matches(first.substring(0, length - 1))) {
          return i;
        }
        if (key.substring(0, length - 1).matches(last.substring(0, length - 1))) {
          return i;
        }
      }


    }
    return -1;
  }

  public ArrayList<String> search(String token)
  {

    ArrayList<String> patients= new ArrayList<>();
    int index = searchint(token);
    if(index == -1)
    {
      return patients;
    }

    holdNewPaient.patient = holdData.get(index).patient;
    JSONFormatter printRec = new JSONFormatter(holdNewPaient.patient);
    patients = printRec.getDataListFormat();

    return patients;

  }

  public ArrayList<String> searchMultiple(String ageStart2,String ageEnd2,
                                          String age2,String Gender2,
                                          String City2,String Ethnicity2,
                                          String Race2)
  {
    System.out.println(":"+ageStart2+":"+ageEnd2+":"+age2+":"+Gender2+":"+City2+":"+Ethnicity2+":"+Race2+":");
    int ageStart=0,ageEnd=0,age=0;
    if(!ageStart2.matches("")) {
      ageStart = Integer.parseInt(ageStart2);
    }
    if(!ageEnd2.matches("")) {
      ageEnd = Integer.parseInt(ageEnd2);
    }
    if(!age2.matches("")){
      age = Integer.parseInt(age2);
    }

    String gender = Gender2;
    if(gender.toLowerCase().matches("male"))
    {
      gender ="M";
    }
    if(gender.toLowerCase().matches("female"))
    {
      gender ="F";
    }
    String city = City2;
    String ethnicity = Ethnicity2;
    String race = Race2;
    ArrayList<String> patients= new ArrayList<>();
    ArrayList<Integer> index = new ArrayList<>();
    ArrayList<Integer> patientsAgeRange= new ArrayList<>();
    ArrayList<Integer> patientsByAge= new ArrayList<>();
    ArrayList<Integer> patientsGenderWise= new ArrayList<>();
    ArrayList<Integer> patientsCityWise= new ArrayList<>();
    ArrayList<Integer> patientsEthnicityWise= new ArrayList<>();
    ArrayList<Integer> patientsRaceWise= new ArrayList<>();
    for (int j = 0; j < holdData.size(); j++) {
      holdNewPaient.patient = holdData.get(j).patient;
      if (!ageStart2.matches("") && !ageEnd2.matches(""))
      {
        if (ageStart<=storeAllAge().get(j) && ageEnd>=storeAllAge().get(j))
        {
            System.out.println("1");
          patientsAgeRange.add(j);
        }
      }
      if (!age2.matches(""))
      {
        if (age==storeAllAge().get(j))
        {
            System.out.println("2");
          patientsByAge.add(j);
        }
      }
      if (!gender.matches(""))
      {
        if(gender.matches(String.valueOf(holdData.get(j).patient.get(14))))
        {
            System.out.println("3");
          patientsGenderWise.add(j);
        }
      }
      if (!city.matches(""))
      {
        if(city.matches(String.valueOf(holdData.get(j).patient.get(17))))
        {
            System.out.println("4");
          patientsCityWise.add(j);
        }
      }
      if (!ethnicity.matches(""))
      {
        if(ethnicity.matches(String.valueOf(holdData.get(j).patient.get(13))))
        {
            System.out.println("5");
          patientsEthnicityWise.add(j);
        }
      }
      if (!race.matches(""))
      {
        if(race.matches(String.valueOf(holdData.get(j).patient.get(12))))
        {
            System.out.println("6");
          patientsRaceWise.add(j);
        }
      }
    }
      System.out.println("g");
      System.out.println(patientsAgeRange);
      System.out.println("g");
    if (patientsAgeRange!=null && patientsByAge.isEmpty() && patientsCityWise.isEmpty() && patientsGenderWise.isEmpty() &&
            patientsRaceWise.isEmpty() && patientsEthnicityWise.isEmpty())
    {
        System.out.println("11");
      index = patientsAgeRange;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange.isEmpty() && patientsByAge!=null && patientsCityWise.isEmpty() && patientsGenderWise.isEmpty() &&
              patientsRaceWise.isEmpty() && patientsEthnicityWise.isEmpty())    {
          System.out.println("22");
      index = patientsByAge;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange.isEmpty() && patientsByAge.isEmpty() && patientsCityWise!=null && patientsGenderWise.isEmpty() &&
              patientsRaceWise.isEmpty() && patientsEthnicityWise.isEmpty())    {
          System.out.println("33");
      index = patientsCityWise;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange.isEmpty() && patientsByAge.isEmpty() && patientsCityWise.isEmpty() && patientsGenderWise.isEmpty() &&
              patientsRaceWise!=null && patientsEthnicityWise.isEmpty())    {
          System.out.println("44");
      index = patientsRaceWise;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange.isEmpty() && patientsByAge.isEmpty() && patientsCityWise.isEmpty() && patientsGenderWise!=null &&
              patientsRaceWise.isEmpty() && patientsEthnicityWise.isEmpty())    {
          System.out.println("55");
      index = patientsGenderWise;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange.isEmpty() && patientsByAge.isEmpty() && patientsCityWise.isEmpty() && patientsGenderWise.isEmpty() &&
              patientsRaceWise.isEmpty() && patientsEthnicityWise!=null)    {
          System.out.println("66");
      index = patientsEthnicityWise;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange!=null && patientsByAge!=null && patientsCityWise.isEmpty() && patientsGenderWise.isEmpty() &&
              patientsRaceWise.isEmpty() && patientsEthnicityWise.isEmpty())    {
      patientsAgeRange.retainAll(patientsByAge);
      index = patientsAgeRange;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange!=null && patientsByAge.isEmpty() && patientsCityWise!=null && patientsGenderWise.isEmpty() &&
              patientsRaceWise.isEmpty() && patientsEthnicityWise.isEmpty())    {
      patientsAgeRange.retainAll(patientsCityWise);
      index = patientsAgeRange;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange!=null && patientsByAge.isEmpty() && patientsCityWise.isEmpty() && patientsGenderWise!=null &&
              patientsRaceWise.isEmpty() && patientsEthnicityWise.isEmpty())    {
      patientsAgeRange.retainAll(patientsGenderWise);
      index = patientsAgeRange;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange!=null && patientsByAge.isEmpty() && patientsCityWise.isEmpty() && patientsGenderWise.isEmpty() &&
              patientsRaceWise!=null && patientsEthnicityWise.isEmpty())    {
      patientsAgeRange.retainAll(patientsRaceWise);
      index = patientsAgeRange;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange!=null && patientsByAge.isEmpty() && patientsCityWise.isEmpty() && patientsGenderWise.isEmpty() &&
              patientsRaceWise.isEmpty() && patientsEthnicityWise!=null)    {
      patientsAgeRange.retainAll(patientsEthnicityWise);
      index = patientsAgeRange;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange!=null && patientsByAge!=null && patientsCityWise!=null && patientsGenderWise.isEmpty() &&
              patientsRaceWise.isEmpty() && patientsEthnicityWise.isEmpty())    {
      patientsAgeRange.retainAll(patientsByAge);
      patientsAgeRange.retainAll(patientsCityWise);
      index = patientsAgeRange;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange!=null && patientsByAge!=null && patientsCityWise.isEmpty() && patientsGenderWise!=null &&
              patientsRaceWise.isEmpty() && patientsEthnicityWise.isEmpty())    {
      patientsAgeRange.retainAll(patientsByAge);
      patientsAgeRange.retainAll(patientsGenderWise);
      index = patientsAgeRange;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange!=null && patientsByAge!=null && patientsCityWise.isEmpty() && patientsGenderWise.isEmpty() &&
              patientsRaceWise!=null && patientsEthnicityWise.isEmpty())    {
      patientsAgeRange.retainAll(patientsByAge);
      patientsAgeRange.retainAll(patientsRaceWise);
      index = patientsAgeRange;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange!=null && patientsByAge!=null && patientsCityWise.isEmpty() && patientsGenderWise.isEmpty() &&
              patientsRaceWise.isEmpty() && patientsEthnicityWise!=null)    {
      patientsAgeRange.retainAll(patientsByAge);
      patientsAgeRange.retainAll(patientsEthnicityWise);
      index = patientsAgeRange;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange!=null && patientsByAge!=null && patientsCityWise!=null && patientsGenderWise!=null &&
              patientsRaceWise.isEmpty() && patientsEthnicityWise.isEmpty())    {
      patientsAgeRange.retainAll(patientsByAge);
      patientsAgeRange.retainAll(patientsCityWise);
      patientsAgeRange.retainAll(patientsGenderWise);
      index = patientsAgeRange;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange!=null && patientsByAge!=null && patientsCityWise!=null && patientsGenderWise.isEmpty() &&
              patientsRaceWise.isEmpty() && patientsEthnicityWise!=null)    {
      patientsAgeRange.retainAll(patientsByAge);
      patientsAgeRange.retainAll(patientsCityWise);
      patientsAgeRange.retainAll(patientsEthnicityWise);
      index = patientsAgeRange;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange!=null && patientsByAge!=null && patientsCityWise!=null && patientsGenderWise.isEmpty() &&
              patientsRaceWise!=null && patientsEthnicityWise.isEmpty())    {
      patientsAgeRange.retainAll(patientsByAge);
      patientsAgeRange.retainAll(patientsCityWise);
      patientsAgeRange.retainAll(patientsRaceWise);
      index = patientsAgeRange;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange!=null && patientsByAge!=null && patientsCityWise!=null && patientsGenderWise!=null &&
              patientsRaceWise!=null && patientsEthnicityWise.isEmpty())    {
      patientsAgeRange.retainAll(patientsByAge);
      patientsAgeRange.retainAll(patientsCityWise);
      patientsAgeRange.retainAll(patientsGenderWise);
      patientsAgeRange.retainAll(patientsRaceWise);
      index = patientsAgeRange;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange!=null && patientsByAge!=null && patientsCityWise!=null && patientsGenderWise!=null &&
              patientsRaceWise.isEmpty() && patientsEthnicityWise!=null)    {
      patientsAgeRange.retainAll(patientsByAge);
      patientsAgeRange.retainAll(patientsCityWise);
      patientsAgeRange.retainAll(patientsGenderWise);
      patientsAgeRange.retainAll(patientsEthnicityWise);
      index = patientsAgeRange;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }
      if (patientsAgeRange!=null && patientsByAge!=null && patientsCityWise!=null && patientsGenderWise!=null &&
              patientsRaceWise!=null && patientsEthnicityWise!=null)    {
      patientsAgeRange.retainAll(patientsByAge);
      patientsAgeRange.retainAll(patientsCityWise);
      patientsAgeRange.retainAll(patientsGenderWise);
      patientsAgeRange.retainAll(patientsRaceWise);
      patientsAgeRange.retainAll(patientsEthnicityWise);
      index = patientsAgeRange;
      if (index !=null)
      {
        for (int l:index)
        {
          patients.add(getNamesByIndex(l));
        }
      }
      return patients;
    }




    return patients;

  }
}

