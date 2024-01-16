package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.edu.uptc.view.MyFrame;

public class Presenter implements ActionListener {

    private MyFrame view;
    private List<String> years;
    private List<String> quantities;
    private List<String> percentages;

    public Presenter() {
        years = new ArrayList<>();
        quantities = new ArrayList<>();
        percentages = new ArrayList<>();

        setDataTable();
        view = new MyFrame(years, quantities, percentages);
        view.setActionListener(this);
    }

    public void setDataTable() {
        setYears();
        setQuantities();
        calculatePercentages();
    }

    private void setYears() {
        String[] years = { "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022",
                "2023" };
        this.years.addAll(Arrays.asList(years));
    }

    private void setQuantities() {
        String[] quantity = { "300", "200", "1200", "400", "500", "2500", "700", "800", "900", "1000", "1100", "3000" };
        this.quantities.addAll(Arrays.asList(quantity));
    }

    private void calculatePercentages() {
        int total = quantities.stream().mapToInt(Integer::parseInt).sum();
        for (String value : quantities) {
            double percent = (Double.parseDouble(value) / total) * 100;
            this.percentages.add(String.valueOf(percent));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Cake")) {
            view.setCake();
        } else if (command.equals("Bar")) {
            view.setBar();
        }
    }

    public static void main(String[] args) {
        new Presenter();
    }

}
