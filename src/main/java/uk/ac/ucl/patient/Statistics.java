package uk.ac.ucl.patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;


public class Statistics {
    public Statistics(ArrayList<Integer> ages,ArrayList<Integer> birthyears)
    {
        int agelist[] = convertIntegers(ages);
        int birthlist[] = convertIntegers(birthyears);

        double avgAge = round(getmean(agelist),2);
        int  commonAge = getmode(agelist);
        int commonBirthyear = getmode(birthlist);

        final JFrame f5 = new JFrame("Statistics");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        JLabel label1 = new JLabel();
        label1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        JLabel label2 = new JLabel();
        label2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        JLabel label3 = new JLabel();
        label3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label1.setText("The average age among the patients is: "+avgAge);
        label2.setText("The common age among the patients is: "+commonAge);
        label3.setText("The common birth year among patients is: "+commonBirthyear);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);

        JButton b5 = new JButton("Back");
        b5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                new PatientFinder(1);
                f5.setVisible(false);
            }
        });

        panel.add(b5);

        f5.add(panel);
        f5.setPreferredSize(new Dimension(500,250));
        f5.pack();
        f5.setLocationRelativeTo(null);
        f5.setVisible(true);

    }

    public static double round(double value, int decimalplaces) {
        //this rounding method is taken from an online source
        if (decimalplaces < 0)
        {
            decimalplaces =0;
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(decimalplaces, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static int[] convertIntegers(ArrayList<Integer> integers)
    {
        int[] ages = new int[integers.size()];
        for (int i=0; i < ages.length; i++)
        {
            ages[i] = integers.get(i).intValue();
        }
        return ages;
    }

    public static double getmean(int[] list)
    {
        double sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        return (sum / list.length);

    }

    public static int getmode(int[] list) {
        int maximumValue=0;
        int maximumCount=0;

        for (int i = 0; i < list.length; ++i) {
            int count = 0;
            for (int j = 0; j < list.length; ++j) {
                if (list[j] == list[i]) ++count;
            }
            if (count > maximumCount) {
                maximumCount = count;
                maximumValue = list[i];
            }
        }

        return maximumValue;
    }
}
