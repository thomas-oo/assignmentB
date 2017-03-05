package fitNesseFixtures;
import stepDefinition.Test_Steps;

/*
    Fixture Class for FitNesse script table in FrontPage.TestSuiteAssignmentB.TestAnErrorFlow
    Each function represent a row in the table.
    Each function calls the appropriate function within Test_Steps to perform the actual code.
    Return either True or False if the function completed successfully or not.
 */
public class TestError {
    Test_Steps testSteps;
    public TestError(){
        testSteps = new Test_Steps();
    }

    public Boolean startLoggedOut(){
        try {
            testSteps.user_is_on_home_page_and_logged_out();
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
    public Boolean addToShoppingCart(){
        try {
            testSteps.user_clicks_add_to_bag();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean goToShoppingCart(){
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
            return false;
        }
        return true;
    }
    public Boolean doesNotSeeCheckout(){
        try {
            testSteps.user_does_not_see_the_checkout_button();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean promptedToLogin(){
        try {
            testSteps.user_is_prompted_to_login_or_create_an_account();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean loginThroughPrompt(){
        try {
            testSteps.user_logs_in_thru_the_prompt();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean seeSameItemInCart(){
        try {
            testSteps.user_sees_the_same_item_in_cart();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean seesCheckoutButton(){
        try {
            testSteps.user_sees_checkout_button();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

}
