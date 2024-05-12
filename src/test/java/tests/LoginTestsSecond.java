package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;

public class LoginTestsSecond extends AppiumConfig {

    @Test
    public void loginSuccess(){
        new AuthenticationScreen(driver)
                .fillEmail("mara@gmail.com")
                .fillPassword("Mmar123456$")
                .submitLogin()
                .isAccountOpened()
                .logout();
    }

    @Test
    public void loginSuccessModel(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("mara@gmail.com").password("Mmar123456$").build())
                .submitLogin()
                .isAccountOpened()
                .logout();
    }

    @Test
    public void loginWrongEmail(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("maragmail.com").password("Mmar123456$").build())
                .submitLoginNegative()
                .isErrorMessageContainsText("Login or Password incorrect");

    }


}
