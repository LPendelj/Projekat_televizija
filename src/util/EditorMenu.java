package util;

public class EditorMenu {
	
	
	public static void startEditorMenu() {
		System.out.println("Editor menu has started.");
		try {
			Thread.sleep(2000);
			System.exit(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	};
	
	
	
}
