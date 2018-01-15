/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

//import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author lober
 */
public class GUI extends JFrame{
    
    //Decleration of HASHMAP and ONE ARRAY LIST as well as global variables
    private static HashMap<String, ArrayList<Integer>> moneyMap = new HashMap<String, ArrayList<Integer>>();
    private static ArrayList<Investment> investment = new ArrayList<Investment>();
    public static int mapSizeInt = 0;
    public static int location = 0;
    
    /**
     * GUI for start page
     * @param filename - file name that was passed through
     */
    public GUI(String filename){
        
        JFrame window = new JFrame("Investment Portfolio");
        JMenuBar menuBar = new JMenuBar();
        JMenu commands = new JMenu("Commands");
        JMenuItem buy = new JMenuItem("Buy");
        JMenuItem sell = new JMenuItem("Sell");
        JMenuItem update = new JMenuItem("Update");
        JMenuItem getGain = new JMenuItem("GetGain");
        JMenuItem search = new JMenuItem("Search");
        JLabel welcome1 = new JLabel("Welcome to Investment Portfolio.");
        JLabel welcome2 = new JLabel("<HTML>Chose a command from the \"Commands\" menu to buy or sell<BR>an investment, update prices for all investments, get gain for<BR>the portfolio, search for relevent investments, or quit the<BR>program.");
        
        window.setSize(500,400);
        window.setLayout(null);
        window.setResizable(false);
        
        menuBar.add(commands);
        commands.add(buy);
        commands.add(sell);
        commands.add(update);
        commands.add(getGain);
        commands.add(search);
        
        welcome1.setBounds(15,50,300,10);
        welcome2.setBounds(15,60,450,150);
        
        window.setJMenuBar(menuBar);
        window.add(welcome1);
        window.add(welcome2);
        
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.setVisible(true);
        window.repaint();
        
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                window.dispose();
                buy(filename);
            }
        });
        
        sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                window.dispose();
                sell(filename);
            }
        });
        
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                window.dispose();
                update(filename);
            }
        });
        
        getGain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                window.dispose();
                getGain(filename);
            }
        });
        
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                window.dispose();
                search(filename);
            }
        });
        
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               
                save(filename);
                System.exit(0);
            }
        });
    }
    
    /**
     * GUI for buying investments
     * @param filename - file name that was passed through
     */
    public void buy(String filename) {
        
        String[] comboStr = {"Stock", "Mutual Fund"};
        
        JFrame buyFrame = new JFrame("Investment Portfolio");
        JMenuBar menuBar = new JMenuBar();
        JMenu commands = new JMenu("Commands");
        JMenuItem buy = new JMenuItem("Buy");
        JMenuItem sell = new JMenuItem("Sell");
        JMenuItem update = new JMenuItem("Update");
        JMenuItem getGain = new JMenuItem("GetGain");
        JMenuItem search = new JMenuItem("Search");
        JButton buttonBuy = new JButton("Buy");
        JButton buttonReset = new JButton("Reset");
        JComboBox investmentType = new JComboBox(comboStr);
        JTextField userSymbol = new JTextField();
        JTextField userName = new JTextField();
        JTextField userQuantity = new JTextField();
        JTextField userPrice = new JTextField();
        JTextArea messageDisplay = new JTextArea();
        JLabel info = new JLabel("Buying an investment");
        JLabel type = new JLabel("Type");
        JLabel symbol = new JLabel("Symbol");
        JLabel name = new JLabel("Name");
        JLabel quantity = new JLabel("Quantity");
        JLabel price = new JLabel("Price");
        JLabel message = new JLabel("Message");
        //JScrollPane scroll = new JScrollPane (messageDisplay, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        buyFrame.setSize(500,400);
        buyFrame.setLayout(null);
        buyFrame.setResizable(false);
        
        menuBar.add(commands);
        commands.add(buy);
        commands.add(sell);
        commands.add(update);
        commands.add(getGain);
        commands.add(search);
        
        investmentType.setBounds(100,30,150,20);
        
        buttonBuy.setBounds(325,90,120,30);
        buttonReset.setBounds(325,30,120,30);
        
        userSymbol.setBounds(100,50,100,20);
        userName.setBounds(100,70,150,20);
        userQuantity.setBounds(100,90,50,20);
        userPrice.setBounds(100,110,50,20);
        //scroll.setBounds(15,180,455,150);
        messageDisplay.setBounds(15,180,455,150);
        
        info.setBounds(15,10,300,20);
        type.setBounds(45,30,100,20);
        symbol.setBounds(45,50,100,20);
        name.setBounds(45,70,100,20);
        quantity.setBounds(45,90,100,20);
        price.setBounds(45,110,100,20);
        message.setBounds(15,150,100,20);
        
        messageDisplay.setEditable(false);
        
        buyFrame.setJMenuBar(menuBar);
        buyFrame.add(investmentType);
        buyFrame.add(buttonBuy);
        buyFrame.add(buttonReset);
        buyFrame.add(userSymbol);
        buyFrame.add(userName);
        buyFrame.add(userQuantity);
        buyFrame.add(userPrice);
        buyFrame.add(messageDisplay);
        //buyFrame.add(scroll);
        buyFrame.add(info);
        buyFrame.add(type);
        buyFrame.add(symbol);
        buyFrame.add(name);
        buyFrame.add(quantity);
        buyFrame.add(price);
        buyFrame.add(message);
                
        //buyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        buyFrame.setVisible(true);
        
        buttonReset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                investmentType.setSelectedIndex(0);
                userSymbol.setText("");
                userName.setText("");
                userQuantity.setText("");
                userPrice.setText("");
                messageDisplay.setText("");
            }
        });
        
        buttonBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                messageDisplay.setText("");
                
                Investment newTempInvestment = new Investment();
                
                int flavor = 0;
                int quantity = 0;
                double price = 0;
                
                String type = investmentType.getSelectedItem().toString();
                String symbol = userSymbol.getText();
                String name = userName.getText();
                String quantityStr = userQuantity.getText();
                String priceStr = userPrice.getText();
                
                if (type.equals("Mutual Fund")) {
                    
                    flavor = 1;
                }
                
                if (symbol.length() == 0) {
                    
                    messageDisplay.setText("Please enter a \"Symbol\".");
                    return;
                }
                
                for (int i = 0; i < mapSizeInt; i++) {
        
                    newTempInvestment = investment.get(i);
            
                    for (int x = 0; x < mapSizeInt; x++) {
                
                        String symbol2 = newTempInvestment.symbolString();
                    
                        if (symbol.equals(symbol2)) {
                    
                            messageDisplay.setText("Investment already exists.\nPlease try again.");
                            return;
                        }
                    }
                }
                
                if (name.length() == 0) {
                    
                    messageDisplay.setText("Please enter a \"Name\".");
                    return;
                }
                
                if (quantityStr.length() != 0) {
                    
                    try {
                    
                        quantity = Integer.parseInt(quantityStr);
                    }
                    catch (NumberFormatException exception) {
                    
                        quantity = -1;
                    }
                    
                    if (quantity <= 0) {
                        
                        messageDisplay.setText("Invalid Quantity.");
                        return;
                    }
                }
                else {
                    
                    messageDisplay.setText("Please enter a Quantity.");
                    return;
                }
                
                if (priceStr.length() != 0) {
                    
                    try {
                    
                        price = Double.parseDouble(priceStr);
                    }
                    catch (NumberFormatException exception) {
                    
                        price = -1;
                    }
                    
                    if (price <= 0) {
                        
                        messageDisplay.setText("Invalid Price.");
                        return;
                    }
                }
                else {
                    
                    messageDisplay.setText("Please enter a price.");
                    return;
                }
                
                buyFunc(symbol, name, quantity, price, flavor);
                if (flavor == 0) {
                    
                    messageDisplay.setText("Stock bought successfully.");
                }
                else {
                    
                    messageDisplay.setText("Mutual Fund bought successfully.");
                }
            }
        });
        
        sell.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                buyFrame.dispose();
                sell(filename);
            }
        });
        
        update.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                buyFrame.dispose();
                update(filename);
            }
        });
        
        getGain.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                buyFrame.dispose();
                getGain(filename);
            }
        });
        
        search.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                buyFrame.dispose();
                search(filename);
            }
        });
        
        buyFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               
                save(filename);
                System.exit(0);
            }
        });
    }
    
    /**
     * GUI for selling investments
     * @param filename 
     */
    public void sell(String filename) {
        
        JFrame sellFrame = new JFrame("Investment Portfolio");
        JMenuBar menuBar = new JMenuBar();
        JMenu commands = new JMenu("Commands");
        JMenuItem buy = new JMenuItem("Buy");
        JMenuItem sell = new JMenuItem("Sell");
        JMenuItem update = new JMenuItem("Update");
        JMenuItem getGain = new JMenuItem("GetGain");
        JMenuItem search = new JMenuItem("Search");
        JButton buttonSell = new JButton("Sell");
        JButton buttonReset = new JButton("Reset");
        JTextField userSymbol = new JTextField();
        JTextField userQuantity = new JTextField();
        JTextField userPrice = new JTextField();
        JTextArea messageDisplay = new JTextArea();
        JLabel info = new JLabel("Selling an investment");
        JLabel symbol = new JLabel("Symbol");
        JLabel quantity = new JLabel("Quantity");
        JLabel price = new JLabel("Price");
        JLabel message = new JLabel("Message");
        
        sellFrame.setSize(500,400);
        sellFrame.setLayout(null);
        sellFrame.setResizable(false);
        
        menuBar.add(commands);
        commands.add(buy);
        commands.add(sell);
        commands.add(update);
        commands.add(getGain);
        commands.add(search);
        
        
        buttonSell.setBounds(325,90,120,30);
        buttonReset.setBounds(325,30,120,30);
        
        userSymbol.setBounds(100,50,100,20);
        userQuantity.setBounds(100,90,50,20);
        userPrice.setBounds(100,130,50,20);
        messageDisplay.setBounds(15,185,455,150);
        
        messageDisplay.setEditable(false);
        
        info.setBounds(15,10,300,20);
        symbol.setBounds(45,50,100,20);
        quantity.setBounds(45,90,100,20);
        price.setBounds(45,130,100,20);
        message.setBounds(15,160,100,20);
        
        sellFrame.setJMenuBar(menuBar);
        sellFrame.add(buttonSell);
        sellFrame.add(buttonReset);
        sellFrame.add(userSymbol);
        sellFrame.add(userQuantity);
        sellFrame.add(userPrice);
        sellFrame.add(messageDisplay);
        sellFrame.add(info);
        sellFrame.add(symbol);
        sellFrame.add(quantity);
        sellFrame.add(price);
        sellFrame.add(message);
                
        //sellFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        sellFrame.setVisible(true);
        
        buttonReset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                userSymbol.setText("");
                userQuantity.setText("");
                userPrice.setText("");
                messageDisplay.setText("");
            }
        });
        
        buttonSell.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                messageDisplay.setText("");
                
                Investment newTempInvestment = new Investment();
                
                double price = 0;
                int quantity = 0;
                int fail = 0;
                
                String symbol = userSymbol.getText();
                String quantityStr = userQuantity.getText();
                String priceStr = userPrice.getText();
                
                if (symbol.length() == 0) {
                    
                    messageDisplay.setText("Please enter a \"Symbol\".");
                    return;
                }
                
                if (quantityStr.length() != 0) {
                    
                    try {
                    
                        quantity = Integer.parseInt(quantityStr);
                    }
                    catch (NumberFormatException exception) {
                    
                        quantity = -1;
                    }
                    
                    if (quantity <= 0) {
                        
                        messageDisplay.setText("Invalid Quantity.");
                        return;
                    }
                }
                else {
                    
                    messageDisplay.setText("Please enter a Quantity.");
                    return;
                }
                
                if (priceStr.length() != 0) {
                    
                    try {
                    
                        price = Double.parseDouble(priceStr);
                    }
                    catch (NumberFormatException exception) {
                    
                        price = -1;
                    }
                    
                    if (price <= 0) {
                        
                        messageDisplay.setText("Invalid Price.");
                        return;
                    }
                }
                else {
                    
                    messageDisplay.setText("Please enter a price.");
                    return;
                }
                
                fail = sellFunc(symbol, quantity, price);
                
                if (fail == 1) {
                    
                    messageDisplay.setText("Investment does not exist.\nPlease try a different investment.");
                }
                else if (fail == 2) {
                    
                    messageDisplay.setText("Investment found but no matching price.\nPlease check price.");
                }
                else if (fail == 3) {
                    
                    messageDisplay.setText("You do not own that quantity.\nPlease enter a different quantity.");
                }
                else{
                    messageDisplay.setText("Investment sold successfully.");
                }
            }
        });
        
        buy.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                sellFrame.dispose();
                buy(filename);
            }
        });
        
        update.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                sellFrame.dispose();
                update(filename);
            }
        });
        
        getGain.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                sellFrame.dispose();
                getGain(filename);
            }
        });
        
        search.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                sellFrame.dispose();
                search(filename);
            }
        });
        
        sellFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               
                save(filename);
                System.exit(0);
            }
        });
    }
    
    /**
     * GUI for updating investments
     * @param filename - file name that was passed through
     */
    public void update(String filename) {
        
        JFrame updateFrame = new JFrame("Investment Portfolio");
        JMenuBar menuBar = new JMenuBar();
        JMenu commands = new JMenu("Commands");
        JMenuItem buy = new JMenuItem("Buy");
        JMenuItem sell = new JMenuItem("Sell");
        JMenuItem update = new JMenuItem("Update");
        JMenuItem getGain = new JMenuItem("GetGain");
        JMenuItem search = new JMenuItem("Search");
        JButton buttonSave = new JButton("Save");
        JButton buttonPrev = new JButton("Prev");
        JButton buttonNext = new JButton("Next");
        JTextField userSymbol = new JTextField();
        JTextField userName = new JTextField();
        JTextField userPrice = new JTextField();
        JTextArea messageDisplay = new JTextArea();
        JLabel info = new JLabel("Updating investment");
        JLabel symbol = new JLabel("Symbol");
        JLabel name = new JLabel("Name");
        JLabel price = new JLabel("Price");
        JLabel message = new JLabel("Message");
        
        updateFrame.setSize(500,400);
        updateFrame.setLayout(null);
        updateFrame.setResizable(false);
        
        menuBar.add(commands);
        commands.add(buy);
        commands.add(sell);
        commands.add(update);
        commands.add(getGain);
        commands.add(search);
        
        
        buttonSave.setBounds(325,120,120,30);
        buttonNext.setBounds(325,40,120,30);
        buttonPrev.setBounds(325,80,120,30);
        
        userSymbol.setBounds(100,50,100,20);
        userName.setBounds(100,90,150,20);
        userPrice.setBounds(100,130,50,20);
        messageDisplay.setBounds(15,185,455,150);
        
        userSymbol.setEditable(false);
        userName.setEditable(false);
        messageDisplay.setEditable(false);
        
        info.setBounds(15,10,300,20);
        symbol.setBounds(45,50,100,20);
        name.setBounds(45,90,100,20);
        price.setBounds(45,130,100,20);
        message.setBounds(15,160,100,20);
        
        updateFrame.setJMenuBar(menuBar);
        updateFrame.add(buttonSave);
        updateFrame.add(buttonNext);
        updateFrame.add(buttonPrev);
        
        updateFrame.add(userSymbol);
        updateFrame.add(userName);
        updateFrame.add(userPrice);
        updateFrame.add(messageDisplay);
        updateFrame.add(info);
        updateFrame.add(symbol);
        updateFrame.add(name);
        updateFrame.add(price);
        updateFrame.add(message);
        
        if (mapSizeInt != 0) {
            
            Investment newTempInvestment = new Investment();
            
            newTempInvestment = investment.get(location);
            userSymbol.setText(newTempInvestment.symbolString());
            userName.setText(newTempInvestment.nameString());
            userPrice.setText(Double.toString(newTempInvestment.priceDouble()));
        }
        
        //updateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        updateFrame.setVisible(true);
        
        buttonNext.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Investment newTempInvestment = new Investment();
                
                if (location < mapSizeInt - 1) {
                    
                    location++;
                    
                    newTempInvestment = investment.get(location);
                    
                    userSymbol.setText(newTempInvestment.symbolString());
                    userName.setText(newTempInvestment.nameString());
                    userPrice.setText(Double.toString(newTempInvestment.priceDouble()));
                    
                }
            }
        });
        
        buttonPrev.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Investment newTempInvestment = new Investment();
                
                if (location > 0 ) {
                    
                    location--;
                    
                    newTempInvestment = investment.get(location);
                    
                    userSymbol.setText(newTempInvestment.symbolString());
                    userName.setText(newTempInvestment.nameString());
                    userPrice.setText(Double.toString(newTempInvestment.priceDouble()));
                    
                }
            }
        });
        
        buttonSave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Investment newTempInvestment = new Investment();
                
                String priceStr;
                double price = 0;
                
                newTempInvestment = investment.get(location);
                    
                priceStr = userPrice.getText();
                
                if (priceStr.length() != 0) {
                    
                    try {
                    
                        price = Double.parseDouble(priceStr);
                    }
                    catch (NumberFormatException exception) {
                    
                        price = -1;
                    }
                    
                    if (price <= 0) {
                        
                        messageDisplay.setText("Invalid Price.");
                        return;
                    }
                    else {
                        
                        newTempInvestment.setPrice(price);
                        messageDisplay.setText("Price updated.");
                    }
                }
                else {
                    
                    messageDisplay.setText("Please enter a price.");
                    return;
                }
                
                
            }
        });
        
        buy.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                updateFrame.dispose();
                buy(filename);
            }
        });
        
        sell.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                updateFrame.dispose();
                sell(filename);
            }
        });
        
        getGain.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                updateFrame.dispose();
                getGain(filename);
            }
        });
        
        search.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                updateFrame.dispose();
                search(filename);
            }
        });
        
        updateFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               
                save(filename);
                System.exit(0);
            }
        });
    }
    
    /**
     * GUI for getting gain from investments
     * @param filename - file name that was passed through
     */
    public void getGain(String filename) {
        
        Investment newTempInvestment = new Investment();
        
        double stockGain = 0;
        double mutualFundGain = 0;
        double gain = 0;
        
        JFrame getGainFrame = new JFrame("Investment Portfolio");
        JMenuBar menuBar = new JMenuBar();
        JMenu commands = new JMenu("Commands");
        JMenuItem buy = new JMenuItem("Buy");
        JMenuItem sell = new JMenuItem("Sell");
        JMenuItem update = new JMenuItem("Update");
        JMenuItem getGain = new JMenuItem("GetGain");
        JMenuItem search = new JMenuItem("Search");
        JTextField userTotal = new JTextField();
        JTextArea messageDisplay = new JTextArea();
        //JScrollPane scroll = new JScrollPane(messageDisplay);
        JLabel info = new JLabel("Getting total gain");
        JLabel total = new JLabel("TotalGain");
        JLabel message = new JLabel("Individual gains");
        
        getGainFrame.setSize(500,400);
        getGainFrame.setLayout(null);
        getGainFrame.setResizable(false);
        
        menuBar.add(commands);
        commands.add(buy);
        commands.add(sell);
        commands.add(update);
        commands.add(getGain);
        commands.add(search);
        
        userTotal.setBounds(100,50,100,20);
        messageDisplay.setBounds(15,125,455,210);
        messageDisplay.setLineWrap(true);
        messageDisplay.setVisible(true);
        
        userTotal.setEditable(false);
        messageDisplay.setEditable(false);
        
        info.setBounds(15,10,300,20);
        total.setBounds(45,50,100,20);
        message.setBounds(15,100,100,20);
        
        //scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        getGainFrame.setJMenuBar(menuBar);
        getGainFrame.add(userTotal);
        getGainFrame.add(messageDisplay);
        getGainFrame.add(info);
        getGainFrame.add(total);
        getGainFrame.add(message);
        
        messageDisplay.setText("");
        
        //checks if a stock exists and if not, displays apropriate message
        if (mapSizeInt == 0) {
        
            messageDisplay.setText("No existing Investments");
        }
        
        //calculation for stock gain
        else {
            
            messageDisplay.setText("Individual Stock book values:\n");
            for (int i = 0; i < mapSizeInt; i++) {
        
                newTempInvestment = investment.get(i);
            
                
                String type = newTempInvestment.typeString();
                    
                if (type.equals("S")) {
                        
                    messageDisplay.append(newTempInvestment.symbolString() + ", " + newTempInvestment.nameString() + " - " + Double.toString(newTempInvestment.bookValueDouble()) + "\n");
                    stockGain += ((newTempInvestment.getQuantity() * newTempInvestment.getPrice()) - 9.99) - newTempInvestment.getBookValue();
                }
            }
            
            messageDisplay.append("Total Stock gain: " + stockGain + "\n\n");
            messageDisplay.append("Individual Mutual Fund book values:\n");
            for (int i = 0; i < mapSizeInt; i++) {
        
                newTempInvestment = investment.get(i);
            
                
                
                String type = newTempInvestment.typeString();
                        
                if (type.equals("MF")) {
                        
                    messageDisplay.append(newTempInvestment.symbolString() + ", " + newTempInvestment.nameString() + ": " + Double.toString(newTempInvestment.bookValueDouble()) + "\n");
                    mutualFundGain += (((newTempInvestment.getQuantity() * newTempInvestment.getPrice()) - 45) - newTempInvestment.getBookValue());
                }
            }
            messageDisplay.append("Total Mutual Fund Gain: " + mutualFundGain);
        }
    
        gain = stockGain + mutualFundGain;
    
        userTotal.setText(Double.toString(gain));
        
        //updateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        getGainFrame.setVisible(true);
        
        buy.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                getGainFrame.dispose();
                buy(filename);
            }
        });
        
        sell.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                getGainFrame.dispose();
                sell(filename);
            }
        });
        
        update.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                getGainFrame.dispose();
                update(filename);
            }
        });
        
        search.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                getGainFrame.dispose();
                search(filename);
            }
        });
        
        getGainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               
                save(filename);
                System.exit(0);
            }
        });
    }
    
    /**
     * GUI for searching for investments
     * @param filename 
     */
    public void search(String filename) {
        
        JFrame searchFrame = new JFrame("Investment Portfolio");
        JMenuBar menuBar = new JMenuBar();
        JMenu commands = new JMenu("Commands");
        JMenuItem buy = new JMenuItem("Buy");
        JMenuItem sell = new JMenuItem("Sell");
        JMenuItem update = new JMenuItem("Update");
        JMenuItem getGain = new JMenuItem("GetGain");
        JMenuItem search = new JMenuItem("Search");
        JButton buttonSearch = new JButton("Search");
        JButton buttonReset = new JButton("Reset");
        JTextField userSymbol = new JTextField();
        JTextField userName = new JTextField();
        JTextField userLow = new JTextField();
        JTextField userHigh = new JTextField();
        JTextArea messageDisplay = new JTextArea();
        JLabel info = new JLabel("Searching investments");
        JLabel symbol = new JLabel("Symbol");
        JLabel name = new JLabel("Name");
        JLabel lowPrice = new JLabel("Low price");
        JLabel highPrice = new JLabel("High price");
        JLabel message = new JLabel("Search results");
        //JScrollPane scroll = new JScrollPane (messageDisplay, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        searchFrame.setSize(500,400);
        searchFrame.setLayout(null);
        searchFrame.setResizable(false);
        
        menuBar.add(commands);
        commands.add(buy);
        commands.add(sell);
        commands.add(update);
        commands.add(getGain);
        commands.add(search);
        
        buttonSearch.setBounds(325,90,120,30);
        buttonReset.setBounds(325,30,120,30);
        
        userSymbol.setBounds(105,40,100,20);
        userName.setBounds(105,75,150,20);
        userLow.setBounds(105,110,50,20);
        userHigh.setBounds(105,140,50,20);
        //scroll.setBounds(15,180,455,150);
        messageDisplay.setBounds(15,180,455,150);
        
        info.setBounds(15,10,300,20);
        symbol.setBounds(45,40,100,20);
        name.setBounds(45,75,100,20);
        lowPrice.setBounds(45,110,100,20);
        highPrice.setBounds(45,140,125,20);
        message.setBounds(15,155,100,20);
        
        messageDisplay.setEditable(false);
        
        searchFrame.setJMenuBar(menuBar);
        searchFrame.add(buttonSearch);
        searchFrame.add(buttonReset);
        searchFrame.add(userSymbol);
        searchFrame.add(userName);
        searchFrame.add(userLow);
        searchFrame.add(userHigh);
        searchFrame.add(messageDisplay);
        //buyFrame.add(scroll);
        searchFrame.add(info);
        searchFrame.add(symbol);
        searchFrame.add(name);
        searchFrame.add(lowPrice);
        searchFrame.add(highPrice);
        searchFrame.add(message);
                
        //buyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        searchFrame.setVisible(true);
        
        buttonReset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                userSymbol.setText("");
                userName.setText("");
                userLow.setText("");
                userHigh.setText("");
                messageDisplay.setText("");
            }
        });
        
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                searchFrame.dispose();
                buy(filename);
            }
        });
        
        sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                searchFrame.dispose();
                sell(filename);
            }
        });
        
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                searchFrame.dispose();
                update(filename);
            }
        });
        
        getGain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                searchFrame.dispose();
                getGain(filename);
            }
        });
        
        searchFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               
                save(filename);
                System.exit(0);
            }
        });
    }
    
    /**
     * Main class
     * @param args - file passed through 
     */
    public static void main(String[] args) {
       
        load(args[0]);
        new GUI(args[0]);
    }

/*****************************************************************************************************/   
    
    /**
     * method to add a new investment to the investment array list as well as key words to the hash map
     * @param symbol - symbol investment
     * @param name - name of investment
     * @param quantity - number of investments
     * @param price - price of investments
     * @param flavor  - type of investment
     */
    public void buyFunc(String symbol, String name, int quantity, Double price, int flavor) {
        
        String diff = "";
        double bookValue = 0;
        
        //gets the book value
        bookValue = BookValue(quantity, price, flavor);
        
        //adds the stock to the array list
        if (flavor == 0) {
            
            diff = "S";
            
            Stock newStock = new Stock(symbol, name, quantity, price, bookValue, diff);
            Investment investmentToAdd = (Investment) newStock;
            investment.add(investmentToAdd);
            
            for (String i : name.split(" ")) {
                
                if (moneyMap.containsKey(i)) {
                    
                    moneyMap.get(i).add(mapSizeInt);
                }
                else {
                    
                    ArrayList<Integer> numArray = new ArrayList<Integer>();
                    numArray.add(mapSizeInt);
                    moneyMap.put(i, numArray);
                }
            } 
            
            mapSizeInt++;   
        }
        //adds the mutualfund to the array list
        else if (flavor == 1) {
            
            diff = "MF";
            
            MutualFund newMutualFund = new MutualFund(symbol, name, quantity, price, bookValue, diff);
            Investment investmentToAdd = (Investment) newMutualFund;
            investment.add(investmentToAdd);
            for (String i : name.split(" ")) {
                
                if (moneyMap.containsKey(i)) {
                    
                    moneyMap.get(i).add(mapSizeInt);
                }
                else {
                    
                    ArrayList<Integer> numArray = new ArrayList<Integer>();
                    numArray.add(mapSizeInt);
                    moneyMap.put(i, numArray);
                }
            }
            
            mapSizeInt++;   
        }
        
    }
    
/*****************************************************************************************************/    

    /**
     * function for selling investments
     * @param symbol - symbol of investment
     * @param quantity - number of stocks
     * @param price - price of investments
     * @return 
     */
    public int sellFunc(String symbol, int quantity, double price) {
    
        Investment newTempInvestment = new Investment();

        String type;
        int flavor = 0;
        int stop = 0;
   
        //checks if the Investment is owned
        for (int i = 0; i < mapSizeInt; i++) {
            
            newTempInvestment = investment.get(i);
            
            for (int x = 0; x < mapSizeInt; x++) {
                
                String symbol2 = newTempInvestment.symbolString();
                
                if (symbol.equals(symbol2)) {
                    
                    //Checks if the price matches
                    for (int l = 0; l < mapSizeInt; l++) {
            
                        //newTempInvestment = investment.get(l);
            
                        for (int n = 0; n < mapSizeInt; n++) {
                
                            double price2 = newTempInvestment.priceDouble();
                
                            if (price == price2) {
                                
                                type = newTempInvestment.typeString();
                                
                                if (type.equals("S")) {
                                    
                                    flavor = 0;
                                }
                                else {
                                    
                                    flavor = 1;
                                }
                                
                                    //checks if the user has enough stock to sell, if no, stops
                                    System.out.println(newTempInvestment.getQuantity());
                                    quantity = newTempInvestment.getQuantity() - quantity;
                                    System.out.println(quantity);
                                    if (quantity < 0) {
                    
                                        stop = 3;
                                        return stop;
                                    }
                                    //else, sells the Stock and sets new book value
                                    else if (flavor == 0) {
                    
                                        newTempInvestment.setBookValue(newTempInvestment.getBookValue() * quantity/newTempInvestment.getQuantity());
                                        newTempInvestment.setQuantity(quantity);
                                        return 0;
                                    }
                                    //else, sells the MutualFund and sets new book value
                                    else if (flavor == 1) {
                    
                                        newTempInvestment.setBookValue((newTempInvestment.getBookValue() * (quantity/newTempInvestment.getQuantity())) - 45);
                                        newTempInvestment.setQuantity(quantity);
                                        
                                        return 0;
                                    }
                                
                            }
                            else {
                                
                                stop = 2;
                                return stop;
                            }
                        }
                    }
                }
                else {
                    
                    stop = 1;
                    //return stop;
                }
            }
        }
        
        return stop;
    }

/*****************************************************************************************************/ 

    /**
     * Function used to search
     */
    public void searchFunc() {
    
    
    }

/*****************************************************************************************************/    

    /**
     * Function used to get book value
     * @param quantity - number of stocks
     * @param price - price of investments
     * @param flavor - type of investment
     * @return 
     */
    public static double BookValue(int quantity, double price, int flavor) {
    
        double newBookValue = 0;
        if (flavor == 1) {
            
            newBookValue = (quantity * price) + 9.99; 
        }
        else {
            
            newBookValue = (quantity * price);
        }
        
        return newBookValue;
    }

/*****************************************************************************************************/ 

    /**
     * Function used to read in file to array and hash map
     * @param fileName - name of file passed in
     */
    private static void load(String fileName) {
        
        try {
            
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            
            while (line != null) {
                
                String[] splitLine = line.split(", ");
                
                if (splitLine[5].equals("S")) {
                    
                    Stock stockToAdd = new Stock(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]), Double.parseDouble(splitLine[3]), Double.parseDouble(splitLine[4]), splitLine[5]);
                    Investment investmentToAdd = (Investment) stockToAdd;
                    investment.add(investmentToAdd);
                    for (String i : splitLine[1].split(" ")) {
                
                        if (moneyMap.containsKey(i)) {
                    
                            moneyMap.get(i).add(mapSizeInt);
                        }
                        else {
                    
                            ArrayList<Integer> numArray = new ArrayList<Integer>();
                            numArray.add(mapSizeInt);
                            moneyMap.put(i, numArray);
                        }
                    } 
                    
                    mapSizeInt++;
                }
                if (splitLine[5].equals("MF")) {
                    
                    MutualFund mutualFundToAdd = new MutualFund(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]), Double.parseDouble(splitLine[3]), Double.parseDouble(splitLine[4]), splitLine[5]);
                    Investment investmentToAdd = (Investment) mutualFundToAdd;
                    investment.add(investmentToAdd);
                    for (String i : splitLine[1].split(" ")) {
                
                        if (moneyMap.containsKey(i)) {
                    
                            moneyMap.get(i).add(mapSizeInt);
                        }
                        else {
                    
                            ArrayList<Integer> numArray = new ArrayList<Integer>();
                            numArray.add(mapSizeInt);
                            moneyMap.put(i, numArray);
                        }
                    } 

                    mapSizeInt++;
                }
                
               line = reader.readLine();
            }
            if (!investment.isEmpty()) {
                
                System.out.println("File loaded successfully!");
            }
            else if (investment.isEmpty()) {
                
                System.out.println("File is empty.");
            }
            else {
                
                System.out.println("File loaded incorrectly");
            }
        }
        catch(Exception e) {
            //System.out.println(e);
            System.out.println("File not Found.\nCreating new file");
        }
    }
    
/*****************************************************************************************************/   
    
    /**
     * Function used to write array to a file and save it
     * @param fileName 
     */
    private static void save(String fileName) {
        
        try {
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            
            for(Investment temp : investment) {
                //Integer key2 = entry2.getKey();
                //Investment i = entry2.getValue();
                String fout = temp.getSymbol() + ", " + temp.getName() + ", " + temp.getQuantity() + ", " + temp.getPrice() + ", " + temp.getBookValue() + ", " + temp.getType();
                writer.write(fout.toString());
                writer.newLine();
            }
            writer.close();
            System.out.println("File Saved!");
        }
        catch(IOException e) {
            
            System.out.println("Failed to write to file!");
        }
    }
}
