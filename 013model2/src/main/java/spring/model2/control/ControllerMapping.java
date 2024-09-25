package spring.model2.control;

public class ControllerMapping {

	//field
	private static ControllerMapping controllerMapping;
	
	//constructor
	private ControllerMapping() {
		// TODO Auto-generated constructor stub
	}
	
	//method
	public static ControllerMapping getInstance() {
		if (controllerMapping == null) {
			controllerMapping = new ControllerMapping();
		}
		return controllerMapping;
	}
	
	//Client Request Page(actionPage)�� �޾� ó�� Controller ���� return
	public Controller getController(String actionPage) {
		System.out.println("[ ControllerMapping.getController() start...... ]");
		Controller controller = null;
		
		if (actionPage.equals("logon")) {
			controller = new LogonController();
		}else if (actionPage.equals("logonAction")) {
			controller = new LogonActionController();
		}else if (actionPage.equals("home")) {
			controller = new HomeController();
		}
		//�߰� ������ �߻��� ��� elseif �߰�....
		System.out.println("[ ControllerMapping.getController() end......]");
		
		return controller;
	}

}
