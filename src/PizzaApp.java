import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaApp {
    private JLabel sizeLabel;
    private JRadioButton sizeSmall;
    private JRadioButton sizeMed;
    private JRadioButton sizeLarge;
    private JCheckBox sausage;
    private JCheckBox pepperoni;
    private JCheckBox salami;
    private JLabel toppingsLabel;
    private JCheckBox olives;
    private JCheckBox mushrooms;
    private JCheckBox anchovies;
    private JTextField price;
    private JLabel priceLabel;
    private JButton calculateButton;
    private JButton exitButton;
    private JPanel mainPanel;

//    final double smallCost = 6.99;
//    final double mediumCost = 8.99;
//    final double largeCost = 10.99;
//    private double sausageCost = 1.49;
//    private double pepperoniCost = 1.49;
//    private double salamiCost = 1.49;
//    private double olivesCost = 0.99;
//    private double mushroomsCost = 0.99;
//    private double anchoviesCost = 0.99;

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

        calculateButton.addActionListener(new ActionListener() { // set calculate button to display the text
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate(size, toppingCost);
                System.out.println(totalCost);
                System.out.println(toppingCost);

                price.setText("$ "+ totalCost);
            }
        });

        exitButton.addActionListener(new ActionListener() { // close the application
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Finish Exit.
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
        sizeLarge.addActionListener(new ActionListener() { //add medium price to total.
            @Override
            public void actionPerformed(ActionEvent e) {
                setLarge();
            }
        });
        // End size radios.

        // Start toppings checkboxes
        sausage.addActionListener(new ActionListener() { //add medium price to total.
            @Override
            public void actionPerformed(ActionEvent e) {
                setToppingOne();
                toppingCalc(topping);
            }
        });
        pepperoni.addActionListener(new ActionListener() { //add medium price to total.
            @Override
            public void actionPerformed(ActionEvent e) {
                setToppingOne();
                toppingCalc(topping);
            }
        });
        salami.addActionListener(new ActionListener() { //add medium price to total.
            @Override
            public void actionPerformed(ActionEvent e) {
                setToppingOne();
                toppingCalc(topping);
            }
        });
        olives.addActionListener(new ActionListener() { //add medium price to total.
            @Override
            public void actionPerformed(ActionEvent e) {
                setToppingTwo();
                toppingCalc(topping);
            }
        });
        mushrooms.addActionListener(new ActionListener() { //add medium price to total.
            @Override
            public void actionPerformed(ActionEvent e) {
                setToppingTwo();
                toppingCalc(topping);
            }
        });
        anchovies.addActionListener(new ActionListener() { //add medium price to total.
            @Override
            public void actionPerformed(ActionEvent e) {
                setToppingTwo();
                toppingCalc(topping);
            }
        });
        //TODO: calculator must remove toppings cost if checkbox is unchecked by user.
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
        return topping = .99;
    }
    // End Toppings Setters

    // Calculator to figure out topping total
    public double toppingCalc (double topping) {
        toppingCost = toppingCost + topping;
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
