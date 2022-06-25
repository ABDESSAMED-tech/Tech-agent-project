/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ag;

import jade.core.ProfileImpl;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;

/**
 *
 * @author ABEDSSAMED
 */
public class MainContainer {

    public static void main(String[] args) {
        try {
            jade.core.Runtime rt = jade.core.Runtime.instance();
            Properties p = new ExtendedProperties();
            p.setProperty("gui", "true");
            ProfileImpl pc = new ProfileImpl(p);
            jade.wrapper.AgentContainer container = rt.createMainContainer(pc);
            container.start();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
