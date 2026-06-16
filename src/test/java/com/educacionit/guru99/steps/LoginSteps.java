package com.educacionit.guru99.steps;

import com.educacionit.guru99.pages.HomePage;
import com.educacionit.guru99.pages.LoginPage;
import com.educacionit.guru99.pages.RegisterPage;
import com.educacionit.guru99.utils.DriverManager;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private final WebDriver driver = DriverManager.getDriver();
    private HomePage homePage;
    private LoginPage loginPage;
    private String registeredUsername;
    private String registeredEmail;
    private String registeredPassword;

    @Dado("que estoy en la página de inicio de New Tours")
    public void queEstoyEnLaPaginaDeInicioDeNewTours() {
        homePage = new HomePage(driver).open();
    }

    @Dado("que me he registrado con un usuario nuevo")
    public void queMeHeRegistradoConUnUsuarioNuevo() {
        registeredUsername = "user_" + System.currentTimeMillis();
        registeredEmail = registeredUsername + "@test.com";
        registeredPassword = "Pass123!";

        RegisterPage registerPage = new RegisterPage(driver).open();
        registerPage
                .fillContactInformation("Juan", "Perez", "1122334455", registeredEmail)
                .fillMailingInformation("Av. Siempre Viva 742", "Buenos Aires", "BA",
                        "1000", "ARGENTINA")
                .fillUserInformation(registeredUsername, registeredPassword, registeredPassword)
                .submitRegistration();

        loginPage = registerPage.goToSignIn();
    }

    @Cuando("inicio sesión con el usuario registrado")
    public void inicioSesionConElUsuarioRegistrado() {
        loginPage.login(registeredEmail, registeredPassword);
    }

    @Cuando("inicio sesión con usuario {string} y contraseña {string}")
    public void inicioSesionConUsuarioYContrasena(String usuario, String contrasena) {
        homePage.login(usuario, contrasena);
    }

    @Entonces("debería ver el mensaje de bienvenida por el login exitoso")
    public void deberiaVerElMensajeDeBienvenidaPorElLoginExitoso() {
        assertTrue(loginPage.isLoginSuccessful(),
                "Se esperaba el mensaje de login exitoso");
    }

    @Entonces("debería ver un mensaje de error de credenciales")
    public void deberiaVerUnMensajeDeErrorDeCredenciales() {
        assertTrue(homePage.isLoginErrorDisplayed(),
                "Se esperaba un mensaje de error por credenciales inválidas");
    }
}
