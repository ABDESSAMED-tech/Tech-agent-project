package ag;
import jade.core.AgentContainer;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;


public class Magasin3Container {
	public static void main(String[] args) {
		try {
			Runtime rt=Runtime.instance();
			ProfileImpl pc = new ProfileImpl(false);
			pc.setParameter(ProfileImpl.MAIN_HOST, "localhost");
			jade.wrapper.AgentContainer ac = rt.createAgentContainer(pc);
			AgentController agentController = ac.createNewAgent("Magasin3", "ag.Magasin3", new Object[] {"XML"});
			agentController.start();
			
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
