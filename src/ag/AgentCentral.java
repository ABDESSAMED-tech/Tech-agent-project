package ag;

import Projet.MAINFrame;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTable;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class AgentCentral extends Agent {

    String livre;
    int cp = 1;
   
    public static boolean qt = false;
    public static String bought = "";
    public int x = 1;

    public static int qtBought = 1;

    protected void setup() {

        addBehaviour(new TickerBehaviour(this, 1000) {
            @Override
            protected void onTick() {
                if (qt == true) {

                    int selectedProduct = MAINFrame.table.getSelectedRow();
                    String pp = MAINFrame.table.getValueAt(selectedProduct, 3).toString();

                    System.out.println(pp);
                    if (pp.equals("Magasin 1")) {
                        pp = "Magasin1";
                    }
                    if (pp.equals("Magasin 2")) {
                        pp = "Magasin2";
                    }
                    if (pp.equals("Magasin 3")) {
                        pp = "Magasin3";
                    }

                    jade.lang.acl.ACLMessage msg = new jade.lang.acl.ACLMessage(jade.lang.acl.ACLMessage.INFORM);
                    msg.addReceiver(new AID(pp, AID.ISLOCALNAME));
                    ArrayList<String> l = new ArrayList<String>();
                    l.add(String.valueOf(qtBought));
                    l.add(bought);
                    x++;
                    try {
                        msg.setContentObject(l);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    try {
                        MAINFrame.textPane.setText(MAINFrame.textPane.getText() + "\nAgent Central: Sending message to Agent " + pp + " Content:" + msg.getContentObject().toString());
                    } catch (UnreadableException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    send(msg);
                    qt = false;
                }

              if (cp != 0) {

                    if (data.Magasin1.size() > 0) {
                        System.out.println("MMMM1");
                        MAINFrame. tableModel.addRow(new Object[]{data.infoMagasin1.get(data.Magasin1.get(0)).name, data.infoMagasin1.get(data.Magasin1.get(0)).price, data.infoMagasin1.get(data.Magasin1.get(0)).quantity, "Magasin 1"});

                        cp = 0;
                    }

                    if (data.Magasin2.size() > 0) {
                        System.out.println("MMMM2");
                        MAINFrame. tableModel.addRow(new Object[]{data.infoMagasin2.get(data.Magasin2.get(0)).name, data.infoMagasin2.get(data.Magasin2.get(0)).price, data.infoMagasin2.get(data.Magasin2.get(0)).quantity, "Magasin 2"});

                        cp = 0;
                    }

                    if (data.Magasin3.size() > 0) {
                        System.out.println("MMMM2");
                        MAINFrame. tableModel.addRow(new Object[]{data.infoMagasin3.get(data.Magasin3.get(0)).name, data.infoMagasin3.get(data.Magasin3.get(0)).price, data.infoMagasin3.get(data.Magasin3.get(0)).quantity, "Magasin 3"});

                        cp = 0;
                    }

                } else {
                    block();
                }
            }
        });

        MAINFrame.textPane.setText(MAINFrame.textPane.getText() + "\nAgent Central: Sending to Magasins Agents inputs");

        addBehaviour(new CyclicBehaviour() {

            @Override
            public void action() {

                ACLMessage message = receive();
               
                if (message != null) {
                    try {

                        if (message.getSender().toString().equals("( agent-identifier :name Magasin1@localhost:1099/JADE  :addresses (sequence http://ABDESSAMED:7778/acc ))")) {
                            for (String x : (ArrayList<String>) message.getContentObject()) {
                                System.out.println("CENTRAL MSG: " + x);
                                data.Magasin1.clear();
                                data.Magasin1.add(x);
                                MAINFrame.textPane.setText(MAINFrame.textPane.getText() + "\nAgent Central: Message received from Agent Magasin1\nContent:" + message.getContentObject().toString());
                            }
                        } else if (message.getSender().toString().equals("( agent-identifier :name Magasin2@localhost:1099/JADE  :addresses (sequence http://ABDESSAMED:7778/acc ))")) {
                            for (String x : (ArrayList<String>) message.getContentObject()) {
                                System.out.println("CENTRAL MSG: " + x);
                                data.Magasin2.clear();
                                data.Magasin2.add(x);
                                MAINFrame.textPane.setText(MAINFrame.textPane.getText() + "\nAgent Central: Message received from Agent Magasin2\nContent:" + message.getContentObject().toString());
                            }
                        } else if (message.getSender().toString().equals("( agent-identifier :name Magasin3@localhost:1099/JADE  :addresses (sequence http://ABDESSAMED:7778/acc ))")) {
                            for (String x : (ArrayList<String>) message.getContentObject()) {
                                System.out.println("CENTRAL MSG: " + x);
                                data.Magasin3.clear();
                                data.Magasin3.add(x);
                                MAINFrame.textPane.setText(MAINFrame.textPane.getText() + "\nAgent Central: Message received from Agent Magasin3\nContent:" + message.getContentObject().toString());
                            }
                        }
                    } catch (UnreadableException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    block();
                }
            }

        });

        /*
		addBehaviour (new CyclicBehaviour () {

			@Override
			public void action() {
				if (qt==true) {
					System.out.println("SENDIND "+x);
					ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
					msg.addReceiver(new AID("Magasin1",AID.ISLOCALNAME));
					ArrayList<String> l = new ArrayList <String>();
					l.add("1");
					l.add(bought);
					x++;
					try {
						msg.setContentObject(l);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					send(msg);
					qt=false;
				}
				else block ();
				
			}
			
		});*/
    }

}
