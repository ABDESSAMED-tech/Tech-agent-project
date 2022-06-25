/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ag;

import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

/**
 *
 * @author ABEDSSAMED
 */
public class CentralContainer {

    public static void main(String[] args) {
        try {
            jade.core.Runtime rt = jade.core.Runtime.instance();
            ProfileImpl pc = new ProfileImpl(false);
            pc.setParameter(ProfileImpl.MAIN_HOST, "localhost");
            jade.wrapper.AgentContainer ac = rt.createAgentContainer(pc);
            AgentController agentController = ac.createNewAgent("Central", "ag.AgentCentral", new Object[]{"XML"});
            agentController.start();

        } catch (ControllerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
