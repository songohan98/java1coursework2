package uk.ac.ucl.patient;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListView {

    JFrame f31;
    JList list;

    public ListView(ArrayList<String> listgiven,String path1) {

        String[] names = listgiven.toArray(new String[listgiven.size()]);
        final String path = path1;
        f31 = new JFrame("ListView");
        this.list = new JList(names);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("SELECT A PATIENT TO VIEW RECORD:");
        final JTextArea area = new JTextArea();
        area.setPreferredSize(new Dimension(300,300));



        final JLabel label1 = new JLabel("No one selected");
        label1.setPreferredSize(new Dimension(70,30));

        list.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    label1.setText(list.getSelectedValue().toString());
                    int i = list.getSelectedIndex();
                    i+=1;

                    Model m = new Model();
                    m.ReadFile(path);
                    m.holdPatient();

                    String a="";
                    a= m.storeSinglePatient(i);
                    area.setText(a);

                }
            }
        });

        area.setEditable(false);
        panel.add(area,BorderLayout.CENTER);

        panel.add(new JScrollPane(list),BorderLayout.LINE_START);
        panel.add(label,BorderLayout.PAGE_START);

        panel.add(label1,BorderLayout.PAGE_START);

        JButton b31 = new JButton("Back");
        b31.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PatientFinder(1);
                f31.setVisible(false);
            }
        });

        panel.add(b31,BorderLayout.PAGE_END);

        f31.add(panel);

        f31.setPreferredSize(new Dimension(600,500));
        f31.pack();
        f31.setLocationRelativeTo(null);
        f31.setVisible(true);

    }
}
