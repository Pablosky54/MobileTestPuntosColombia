Feature: Login en la app Frisby
  Como usuario de la app
  Quiero poder iniciar sesión con usuario y contraseña
  Para acceder a la pantalla principal

  Background:
    Given la aplicación está abierta en el emulador

  @login
  Scenario Outline: Login con diferentes credenciales
    When intento iniciar sesión con usuario "<usuario>" y contraseña "<contrasena>"
    Then debería ver la pantalla principal

    Examples:
      | usuario          | contrasena         |
      | usuario_valido   | contrasena_valida  |
      | usuario_invalido | contrasena_invalida|