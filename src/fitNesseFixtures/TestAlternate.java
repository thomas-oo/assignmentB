package fitNesseFixtures;
import stepDefinition.Test_Steps;

/*
    Fixture Class for FitNesse script table in FrontPage.TestSuiteAssignmentB.TestAnAlternateFlow
    Each function represent a row in the table.
    Each function calls the appropriate function within Test_Steps to perform the actual code.
    Return either True or False if the function completed successfully or not.
 */
public class TestAlternate {
    Test_Steps testSteps;
    public TestAlternate(){
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
    public Boolean goToShoppingCart(){
        try {
            testSteps.user_goes_to_shopping_bag();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean seeProductTheyWantAnotherOf(){
        try {
            testSteps.user_finds_the_product_they_want_another_of();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean clickProduct(){
        try {
            testSteps.user_clicks_on_the_product();
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
    public Boolean seeAdditionalItemInCart(){
        try {
            testSteps.user_sees_an_additional_item_in_bag();
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
