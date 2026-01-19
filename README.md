# MobileTestPuntosColombia - Automatización móvil (Frisby)

Este repositorio contiene una prueba de automatización móvil básica para la aplicación Frisby usando:

- Java
- Screenplay Pattern (Serenity Screenplay)
- BDD con Cucumber (Gherkin)
- Appium como cliente para interactuar con la app Android

Descripción

- Se abre la apk `frisby_v128.apk` en un emulador Android mediante Appium.
- Hay un Scenario Outline en Gherkin que realiza intentos de login con diferentes credenciales.
- El test usa un Task (Screenplay) para ejecutar el login y una Question para validar la pantalla principal.

Cómo ejecutar

1. Asegúrate de tener un emulador Android disponible y Appium corriendo (por ejemplo en http://localhost:4723/wd/hub).
2. Coloca `frisby_v128.apk` en la raíz del proyecto o establece la variable de entorno `FRISBY_APK_PATH` con la ruta al apk.
3. Opcionalmente configura las variables de entorno:
   - `APPIUM_SERVER` (por defecto: http://localhost:4723/wd/hub)
   - `DEVICE_NAME` (nombre del emulador)
   - `PLATFORM_VERSION` (opcional)
   - `FRISBY_USER`, `FRISBY_PASS` (si quieres pasar credenciales por variables)
4. Ejecuta los tests con Maven:

```bash
mvn test
```

Notas

- Actualiza los resource-ids en `LoginPage.java` si difieren de los reales.
- Reemplaza las esperas implícitas (`Thread.sleep`) por esperas explícitas en producción.
