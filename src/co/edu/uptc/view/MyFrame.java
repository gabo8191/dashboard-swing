package co.edu.uptc.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class MyFrame extends JFrame {

    private TablePanel tablePanel;
    private BarPanel barPanel;
    private CakePanel cakePanel;

    public MyFrame(List<String> years, List<String> quantities, List<String> percentages) {
        setTitle("Dashboard- Computadores vendidos del 2012 al 2023");
        setSize(800, 800);
        setLayout(new GridBagLayout());
        initComponents(years, quantities, percentages);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents(List<String> years, List<String> quantities, List<String> percentages) {
        addTittle();
        addTable(years, quantities);
        addGraph(quantities, percentages, years);
    }

    private void addTittle() {
        JPanel tittlePanel = new JPanel();
        JLabel tittle = new JLabel("2012-2023 - CANTIDADES VENDIDAS DE COMPUTADORES");
        tittle.setFont(new Font("Arial", Font.BOLD, 25));
        tittle.setForeground(Color.BLACK);
        tittle.setHorizontalAlignment(SwingConstants.CENTER);
        tittlePanel.add(tittle);
        GridBagConstraints constraints = SetTittleFeatures();
        getContentPane().add(tittlePanel, constraints);
    }

    private GridBagConstraints SetTittleFeatures() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.insets = new Insets(10, 10, 10, 10);
        return constraints;
    }

    private void addTable(List<String> years, List<String> quantities) {
        tablePanel = new TablePanel(years, quantities);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.weighty = 0.2;

        add(tablePanel, constraints);
    }

    private void addGraph(List<String> quantities, List<String> percentages, List<String> years) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;

        barPanel = new BarPanel(quantities, percentages, years);
        barPanel.setPreferredSize(new Dimension(400, 400));
        getContentPane().add(barPanel, constraints);

        constraints.insets = new Insets(10, 10, 10, 10);
        cakePanel = new CakePanel(quantities, percentages, years);
        cakePanel.setPreferredSize(new Dimension(400, 400));
        constraints.gridx = 1;
        getContentPane().add(cakePanel, constraints);

        barPanel.setVisible(false);
    }

    public void setCake() {
        barPanel.setVisible(false);
        cakePanel.setVisible(true);
    }

    public void setBar() {
        cakePanel.setVisible(false);
        barPanel.setVisible(true);
    }

    public void setActionListener(ActionListener listener) {
        tablePanel.setActionListener(listener);
    }

}
