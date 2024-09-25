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
	
	//Client Request Page(actionPage)를 받아 처리 Controller 생성 return
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
		//추가 사항이 발생할 경우 elseif 추가....
		System.out.println("[ ControllerMapping.getController() end......]");
		
		return controller;
	}

}
