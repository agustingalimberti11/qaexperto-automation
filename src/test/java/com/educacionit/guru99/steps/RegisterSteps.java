package com.educacionit.guru99.steps;

import com.educacionit.guru99.pages.HomePage;
import com.educacionit.guru99.pages.RegisterPage;
import com.educacionit.guru99.utils.DriverManager;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterSteps {

    private final WebDriver driver = DriverManager.getDriver();
    private RegisterPage registerPage;
    private String generatedUsername;

    @Dado("que estoy en la página de registro de New Tours")
    public void queEstoyEnLaPaginaDeRegistroDeNewTours() {
        registerPage = new RegisterPage(driver).open();
    }

    @Cuando("navego a la página de registro desde el enlace principal")
    public void navegoALaPaginaDeRegistroDesdeElEnlacePrincipal() {
        registerPage = new HomePage(driver).goToRegister();
    }

    @Cuando("completo el formulario de registro con datos válidos")
    public void completoElFormularioDeRegistroConDatosValidos() {
        generatedUsername = "user_" + System.currentTimeMillis();

        registerPage
                .fillContactInformation("Maria", "Gomez", "1199887766",
                        generatedUsername + "@test.com")
                .fillMailingInformation("Calle Falsa 123", "Cordoba", "CB",
                        "5000", "ARGENTINA")
                .fillUserInformation(generatedUsername, "Pass123!", "Pass123!");
    }

    @Y("envío el formulario de registro")
    public void envioElFormularioDeRegistro() {
        registerPage.submitRegistration();
    }

    @Entonces("debería ver el mensaje de confirmación de registro")
    public void deberiaVerElMensajeDeConfirmacionDeRegistro() {
        assertTrue(registerPage.isRegistrationSuccessful(),
                "Se esperaba el mensaje de registro exitoso");
        assertTrue(registerPage.getSuccessMessage().contains("Thank you for registering"),
                "El mensaje de confirmación no es el esperado");
    }
}
