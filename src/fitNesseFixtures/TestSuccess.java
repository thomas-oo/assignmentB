package fitNesseFixtures;
import stepDefinition.Test_Steps;


public class TestSuccess{
	Test_Steps testSteps;
	public TestSuccess(){
		testSteps = new Test_Steps();
	}
	
	public Boolean startLoggedIn(){
		try {
			testSteps.user_is_on_home_page_and_logged_in();
		} catch (Throwable e) {

			return false;
		}
		return true;
	}
	
	public Boolean navigateProductPage(){
		return false;
	}
	public Boolean selectProduct(){
		return false;
	}
	public Boolean selectSize(){
		return false;
	}
	public Boolean addToBag(){
		return false;
	}
	public Boolean goToBag(){
		return false;
	}
	public Boolean seesItemInBag(){
		return false;
	}
	public Boolean seesCheckoutButton(){
		return false;
	}
}
