# language: es
@registro
Característica: Registro de usuario en Demo Guru99 New Tours
  Como visitante del sitio Mercury Tours
  Quiero registrarme con mis datos personales
  Para poder crear una cuenta y acceder al sistema

  Antecedentes:
    Dado que estoy en la página de registro de New Tours

  @registro-exitoso
  Escenario: Registro exitoso de un nuevo usuario
    Cuando completo el formulario de registro con datos válidos
    Y envío el formulario de registro
    Entonces debería ver el mensaje de confirmación de registro

  @registro-desde-home
  Escenario: Acceder al registro desde la página de inicio
    Dado que estoy en la página de inicio de New Tours
    Cuando navego a la página de registro desde el enlace principal
    Y completo el formulario de registro con datos válidos
    Y envío el formulario de registro
    Entonces debería ver el mensaje de confirmación de registro
