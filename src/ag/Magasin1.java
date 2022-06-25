/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ag;

import ag.data;
import Projet.MAINFrame;
import Projet.PizzaType;
import inference.BooleanRuleBase;
import inference.Clause;
import inference.Condition;
import inference.Rule;
import inference.RuleBase;
import inference.RuleVariable;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.ParseException;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ABEDSSAMED
 */
public class Magasin1 extends Agent {

    static RuleBase currentRuleBase;
    static BooleanRuleBase pizza;
    ArrayList<String> livre = new ArrayList<String>();

    public void initPizza(BooleanRuleBase rb) {
        RuleVariable Pizza = new RuleVariable(rb, "pizza");
        Pizza.setLabels("Margherita White_Pizza White_Spinach White_Broccoli  Eggplant_Tomato Supreme Ziti_Pizza Veggie");

        RuleVariable Mozzarella = new RuleVariable(rb, "Mozzarella");
        Mozzarella.setLabels("yes no");

        RuleVariable Fresh_Basil = new RuleVariable(rb, "Fresh_Basil");
        Fresh_Basil.setLabels("yes no");

        RuleVariable CheeseRomano = new RuleVariable(rb, "CheeseRomano");
        CheeseRomano.setLabels("yes no");

        RuleVariable Spinach = new RuleVariable(rb, "Spinach");
        Spinach.setLabels("yes no");

        RuleVariable Broccoli = new RuleVariable(rb, "Broccoli");
        Broccoli.setLabels("yes no");

        RuleVariable tomato = new RuleVariable(rb, "tomato");
        tomato.setLabels("yes no");

        RuleVariable Sausage = new RuleVariable(rb, "Sausage");
        Sausage.setLabels("yes no");

        RuleVariable Pepper = new RuleVariable(rb, "Pepper");
        Pepper.setLabels("yes no");

        RuleVariable Onion = new RuleVariable(rb, "Onion");
        Onion.setLabels("yes no");

        RuleVariable ziti = new RuleVariable(rb, "ziti");
        ziti.setLabels("yes no");

        RuleVariable Mushroom = new RuleVariable(rb, "Mushroom");
        Mushroom.setLabels("yes no");

        RuleVariable Black_Olives_Red_Sauce = new RuleVariable(rb, "Black_Olives_Red_Sauce");
        Black_Olives_Red_Sauce.setLabels("yes no");

        RuleVariable Ricotta = new RuleVariable(rb, "Ricotta");
        Ricotta.setLabels("yes no");

        RuleVariable Eggplant = new RuleVariable(rb, "Eggplant");
        Eggplant.setLabels("yes no");

        Condition cEquals = new Condition("=");

        new Rule(rb, "Margherita", new Clause[]{new Clause(tomato, cEquals, "yes"),
            new Clause(Mozzarella, cEquals, "yes"),
            new Clause(Fresh_Basil, cEquals, "yes ")},
                new Clause(Pizza, cEquals, "Margherita"));
        new Rule(rb, "White_Pizza", new Clause[]{new Clause(Ricotta, cEquals, "yes"),
            new Clause(Mozzarella, cEquals, "yes"),
            new Clause(CheeseRomano, cEquals, "yes ")},
                new Clause(Pizza, cEquals, "White_Pizza"));
        new Rule(rb, "White_Spinach", new Clause[]{new Clause(Pizza, cEquals, "White_Pizza"),
            new Clause(Spinach, cEquals, "yes"),},
                new Clause(Pizza, cEquals, "White_Spinach"));

        new Rule(rb, "White_Broccoli", new Clause[]{new Clause(Pizza, cEquals, "White_Pizza"),
            new Clause(Broccoli, cEquals, "yes")},
                new Clause(Pizza, cEquals, "White_Broccoli"));
        new Rule(rb, "Eggplant_Tomato", new Clause[]{new Clause(Pizza, cEquals, "White_Pizza"),
            new Clause(tomato, cEquals, "yes"),
            new Clause(Eggplant, cEquals, "yes")},
                new Clause(Pizza, cEquals, "Eggplant_Tomato"));
        new Rule(rb, "Supreme", new Clause[]{new Clause(Sausage, cEquals, "yes"),
            new Clause(Pepper, cEquals, "yes"),
            new Clause(Onion, cEquals, "yes"),
            new Clause(Mozzarella, cEquals, "yes")},
                new Clause(Pizza, cEquals, "Supreme"));
        new Rule(rb, "Ziti_Pizza", new Clause[]{new Clause(Ricotta, cEquals, "yes"),
            new Clause(CheeseRomano, cEquals, "yes"),
            new Clause(ziti, cEquals, "yes"),
            new Clause(Mozzarella, cEquals, "yes")},
                new Clause(Pizza, cEquals, "Ziti_Pizza"));
        new Rule(rb, "Ziti", new Clause[]{
            new Clause(ziti, cEquals, "yes"),},
                new Clause(Pizza, cEquals, "Ziti_Pizza"));
        new Rule(rb, "Veggie", new Clause[]{new Clause(Mushroom, cEquals, "yes"),
            new Clause(Pepper, cEquals, "yes"),
            new Clause(Onion, cEquals, "yes"),
            new Clause(Black_Olives_Red_Sauce, cEquals, "yes"),
            new Clause(Mozzarella, cEquals, "yes")},
                new Clause(Pizza, cEquals, "Veggie"));
        new Rule(rb, "Black_Olives", new Clause[]{
            new Clause(Black_Olives_Red_Sauce, cEquals, "yes"),},
                new Clause(Pizza, cEquals, "Black_Olives"));
    }

    @SuppressWarnings("serial")
    protected void setup() {

        pizza = new BooleanRuleBase("Pizza Rule Base");
        initPizza(pizza);
        String selectedRule;
        String Mozzarella = MAINFrame.Mozzarella.getSelectedItem().toString();
        String CheeseRomano = MAINFrame.CheeseRomano.getSelectedItem().toString();
        String Black_Olives_Red_Sauce = MAINFrame.Black_Olives_Red_Sauce.getSelectedItem().toString();
        String Broccoli = MAINFrame.Broccoli.getSelectedItem().toString();
        String Eggplant = MAINFrame.Eggplant.getSelectedItem().toString();
        String tomato = MAINFrame.tomato.getSelectedItem().toString();
        String Ricotta = MAINFrame.Ricotta.getSelectedItem().toString();
        String Sausage = MAINFrame.Sausage.getSelectedItem().toString();
        String Spinach = MAINFrame.Spinach.getSelectedItem().toString();
        String Onion = MAINFrame.Spinach.getSelectedItem().toString();
        String Fresh_Basil = MAINFrame.Fresh_Basil1.getSelectedItem().toString();
        String Pepper = MAINFrame.Pepper.getSelectedItem().toString();
        String Mushroom = MAINFrame.Mushroom.getSelectedItem().toString();
        String Ziti = MAINFrame.Ziti.getSelectedItem().toString();

        pizza.setVariableValue("Mozzarella", (String) Mozzarella);
        pizza.setVariableValue("Fresh_Basil", (String) Fresh_Basil);
        pizza.setVariableValue("Ricotta", (String) Ricotta);
        pizza.setVariableValue("CheeseRomano", (String) CheeseRomano);
        pizza.setVariableValue("Spinach", (String) Spinach);
        pizza.setVariableValue("Broccoli", (String) Broccoli);
        pizza.setVariableValue("tomato", (String) tomato);
        pizza.setVariableValue("Eggplant", (String) Eggplant);
        pizza.setVariableValue("Sausage", (String) Sausage);
        pizza.setVariableValue("Pepper", (String) Pepper);
        pizza.setVariableValue("Onion", (String) Onion);
        pizza.setVariableValue("ziti", (String) Ziti);
        pizza.setVariableValue("Mushroom", (String) Mushroom);
        pizza.setVariableValue("Black_Olives_Red_Sauce", Black_Olives_Red_Sauce);
        currentRuleBase = pizza;
        currentRuleBase.forwardChain();
        selectedRule = pizza.getVariable("pizza").getValue();

        System.out.println("Pizza name  " + selectedRule);
        if (selectedRule != null) {
            // System.out.println("Pizza name Ziti_Pizza qte M1  " + data.infoMagasin1.get(selectedRule).quantity);
  
            if (data.infoMagasin1.get(selectedRule).quantity > 0 && selectedRule != null) {
                livre.add(selectedRule);

                ////////////////
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.addReceiver(new AID("Central", AID.ISLOCALNAME));
                System.out.println(livre.toString());
                try {

                    msg.setContentObject(livre);
                } catch (IOException e) {

                    e.printStackTrace();
                }
                send(msg);
                MAINFrame.textPane.setText(MAINFrame.textPane.getText() + "\nAgent Magasin1: Sending message to Central Agent\nInfo: " + "Selected product : " + selectedRule + "\n");
            } else {
                System.out.println("NO QUANTITY");
           
            }
        } else {
            System.out.println("NO DATA");
            
        }
        Date d = null;
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            d = dateformat3.parse("08/06/2022");
        } catch (java.text.ParseException ex) {
            Logger.getLogger(Magasin1.class.getName()).log(Level.SEVERE, null, ex);
        }

        addBehaviour(new WakerBehaviour(this, d) {
            @Override
            protected void onWake() {
                System.out.println("WAKE UP");
                for (Map.Entry<String, ag.Produit> entry : data.infoMagasin1.entrySet()) {
                    ag.Produit p = entry.getValue();
                    p.price = (int) (p.price - (p.price * 0.1));
                    data.infoMagasin1.put(entry.getKey(), p);
                }
            }
        });

        addBehaviour(new CyclicBehaviour() {

            @Override
            public void action() {
                ACLMessage message = receive();

                if (message != null) {
                    try {
                        MAINFrame.textPane.append("\nAgent Magasin1: Received msg from Agent Central\n Content:" + message.getContentObject().toString());
                        System.out.println("hello 1");
                        ArrayList<String> l = (ArrayList<String>) message.getContentObject();
                        ag.Produit p = data.infoMagasin1.get(l.get(1));

                        if (p.quantity >= Integer.parseInt(l.get(0))) {
                            p.quantity = p.quantity - Integer.parseInt(l.get(0));
                            data.infoMagasin1.put(l.get(1), p);

                            if (Integer.parseInt(l.get(0)) > 1) {

                                MAINFrame.priceLabel.setText(" " + ((data.infoMagasin1.get(l.get(1)).price * (Integer.parseInt(l.get(0)))) - ((data.infoMagasin1.get(l.get(1)).price * (Integer.parseInt(l.get(0)))) * Integer.parseInt(l.get(0)) * 5 / 100)));
                                MAINFrame.promoLabel.setText(" " + Integer.parseInt(l.get(0)) * 5 + "%");
                                MAINFrame.priceLabel.setVisible(true);
                                MAINFrame.promoLabel.setVisible(true);

                            } else {
                                MAINFrame.priceLabel.setText("" + ((data.infoMagasin1.get(l.get(1)).price * (Integer.parseInt(l.get(0))))));
                                MAINFrame.priceLabel.setVisible(true);
                            }
                        } else {
                            MAINFrame.priceLabel.setText("pas de quantity");
                            System.out.println("QUANTITY NO");
                        }
                        message = null;
                    } catch (UnreadableException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    block();
                }

            }
        });

    }

}
