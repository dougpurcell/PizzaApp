import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PizzaApp {

    private JLabel sizeLabel;
    private JLabel toppingsLabel;
    private JLabel priceLabel;

    private JRadioButton sizeSmall;
    private JRadioButton sizeMed;
    private JRadioButton sizeLarge;

    private JCheckBox sausage;
    private JCheckBox pepperoni;
    private JCheckBox salami;
    private JCheckBox olives;
    private JCheckBox mushrooms;
    private JCheckBox anchovies;

    private JTextField price;

    private JButton calculateButton;
    private JButton exitButton;

    private JPanel mainPanel;

    private double totalCost = 0;
    private double size;
    private double topping;
    private double toppingCost;

    ButtonGroup sizeRadioGroup;

    public PizzaApp() {
        price.setEditable(false);

        sizeRadioGroup = new ButtonGroup();
        sizeRadioGroup.add(sizeSmall);
        sizeRadioGroup.add(sizeMed);
        sizeRadioGroup.add(sizeLarge);

        // set calculate button to display the text and run the calculation
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate(size, toppingCost);
                System.out.println(totalCost);
                System.out.println(toppingCost);
                price.setText("$ "+ String.format("%.2f", totalCost));
            }
        });

        // clear all the options and reset the calculators.
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toppingCost = 0;
                totalCost = 0;
                size = 0;
                price.setText(" ");
                clearOptions();
            }
        });

        // Size radios
        sizeSmall.addActionListener(new ActionListener() { //add small price to total.
            @Override
            public void actionPerformed(ActionEvent e) {
                setSmall();
            }
        });
        sizeMed.addActionListener(new ActionListener() { //add medium price to total.
            @Override
            public void actionPerformed(ActionEvent e) {
                setMedium();
            }
        });
        sizeLarge.addActionListener(new ActionListener() { //add large price to total.
            @Override
            public void actionPerformed(ActionEvent e) {
                setLarge();
            }
        });
        // End size radios

        // Start toppings checkboxes
        sausage.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setToppingOne();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    toppingCalc(topping);
                }
                else {
                    toppingSubtract(topping);
                }
            }
        });
        pepperoni.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setToppingOne();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    toppingCalc(topping);
                }
                else {
                    toppingSubtract(topping);
                }
            }
        });
        salami.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setToppingOne();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    toppingCalc(topping);
                }
                else {
                    toppingSubtract(topping);
                }
            }
        });
        olives.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setToppingTwo();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    toppingCalc(topping);
                }
                else {
                    toppingSubtract(topping);
                }
            }
        });
        mushrooms.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setToppingTwo();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    toppingCalc(topping);
                }
                else {
                    toppingSubtract(topping);
                }
            }
        });
        anchovies.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setToppingTwo();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    toppingCalc(topping);
                }
                else {
                    toppingSubtract(topping);
                }
            }
        });
    }

    // Size setters
    public double setSmall() {
        return size = 6.99;
    }
    public double setMedium() {
        return size = 8.99;
    }
    public double setLarge() {
        return size = 10.99;
    }
    // End Size Setters

    // Start Toppings Setters
    public double setToppingOne() {
        return topping = 1.49;
    }
    public double setToppingTwo(){
        return topping = 0.99;
    }
    // End Toppings Setters

    // Calculator to figure out topping total
    public double toppingCalc (double topping) {
        toppingCost = toppingCost + topping;
        return toppingCost;
    }

    // Calculator for deselecting checkboxes so total stays right
    public double toppingSubtract(double topping) {
        toppingCost = toppingCost - topping;
        return toppingCost;
    }

    // Calculator to figure out the total.
    public double calculate(double size, double toppingCost) {
        totalCost = size + toppingCost;
        return totalCost;
    }

    // Reset all checkboxes & radio buttons
    public void clearOptions() {
        sizeRadioGroup.clearSelection();
        sausage.setSelected(false);
        pepperoni.setSelected(false);
        salami.setSelected(false);
        olives.setSelected(false);
        mushrooms.setSelected(false);
        anchovies.setSelected(false);
    }

    // Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pizza App");
        frame.setContentPane(new PizzaApp().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
