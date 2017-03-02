package fitNesseFixtures;
import stepDefinition.Test_Steps;

public class TestSuccess {
	Test_Steps testSteps;
	public TestSuccess(){
		testSteps = new Test_Steps();
	}
	
	public Boolean start_loggedin(){
		try {
			testSteps.user_is_on_home_page_and_logged_in();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Boolean navigate_product_page(){
		return false;
	}
	public Boolean select_product(){
		return false;
	}
	public Boolean select_size(){
		return false;
	}
	public Boolean add_to_bag(){
		return false;
	}
	public Boolean go_to_bag(){
		return false;
	}
	public Boolean sees_item_in_bag(){
		return false;
	}
	public Boolean sees_checkout_button(){
		return false;
	}
}
