package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    @Test
    public void loginSuccess() {
//        boolean result = new SplashScreen(driver)
//                .checkCurrentVersion("Version 1.0.0")
        boolean result = new AuthenticationScreen(driver)
                .fillEmail("mara@gmail.com")
                .fillPassword("Mmar123456$")
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }

    @Test
    public void loginSuccessModel() {
//        boolean result = new SplashScreen(driver)
//                .checkCurrentVersion("Version 1.0.0")
        boolean result = new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("mara@gmail.com").password("Mmar123456$").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }

    @Test
    public void loginSuccessModel2() {
//        boolean result = new SplashScreen(driver)
//                .checkCurrentVersion("Version 1.0.0")
        Assert.assertTrue(new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("mara@gmail.com").password("Mmar123456$").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list"));
            }

            @Test
            public void loginWrongEmail(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("maragmail.com").password("Mmar123456$").build())
                .submitLoginNegative()
                .isErrorMessageContainsText("Login or Password incorrect");

            }

    @Test
    public void loginWrongPassword(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("mara@gmail.com").password("Mmar123").build())
                .submitLoginNegative()
                .isErrorMessageContainsText("Login or Password incorrect");

    }

    @AfterMethod
    public void postCondition(){
        new ContactListScreen(driver).logout();
    }


}
