# language: es
@login
Característica: Login en Demo Guru99 New Tours
  Como usuario registrado de Mercury Tours
  Quiero iniciar sesión en el sitio
  Para acceder a las funcionalidades de reserva de vuelos

  Antecedentes:
    Dado que estoy en la página de inicio de New Tours

  @login-exitoso
  Escenario: Login exitoso con credenciales válidas
    Dado que me he registrado con un usuario nuevo
    Cuando inicio sesión con el usuario registrado
    Entonces debería ver el mensaje de bienvenida por el login exitoso

  @login-fallido
  Escenario: Login fallido con credenciales inválidas
    Cuando inicio sesión con usuario "usuario_invalido" y contraseña "clave_invalida"
    Entonces debería ver un mensaje de error de credenciales
