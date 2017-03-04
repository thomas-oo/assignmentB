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
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
	}
	
	public Boolean navigateProductPage(){
        try {
            testSteps.user_navigates_to_product_page();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
	}
	public Boolean selectProduct(){
        try {
            testSteps.user_selects_a_product();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
	}
	public Boolean selectSize(){
        try {
            testSteps.user_selects_a_size();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
	}
	public Boolean addToBag(){
        try {
            testSteps.user_clicks_add_to_bag();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
	}
	public Boolean goToBag(){
        try {
            testSteps.user_goes_to_shopping_bag();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
	}
	public Boolean seesItemInBag(){
        try {
            testSteps.user_sees_item_in_bag();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return true;
	}
	public Boolean seesCheckoutButton(){
        try {
            testSteps.user_sees_checkout_button();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return true;
	}
}
