# Proyecto de Automatización Móvil con Serenity BDD

Este proyecto utiliza el patrón Screenplay de Serenity BDD para automatizar pruebas en aplicaciones móviles, siguiendo principios de POO, BDD y Gherkin.

## Estructura del Proyecto

- `src/test/java/starter/`: Código fuente de las pruebas
  - `navigation/`: Tareas de navegación y apertura de app
  - `tasks/`: Tareas de interacción
  - `questions/`: Preguntas para verificaciones
  - `stepdefinitions/`: Definiciones de pasos de Cucumber
  - `runners/`: Runners de pruebas
- `src/test/resources/`: Recursos de pruebas
  - `features/`: Archivos .feature de Gherkin
  - `serenity.conf`: Configuración de Serenity

## Requisitos

- Java 11+
- Gradle
- Appium Server corriendo en localhost:4723
- Dispositivo móvil o emulador configurado
- APK de la app Frisby Colombia (descárgalo y actualiza la ruta en `serenity.conf`)

## Configuración

1. Descarga el APK de Frisby Colombia desde la Play Store o fuente oficial.
2. Actualiza la ruta en `src/test/resources/serenity.conf`:
   ```
   app = /ruta/absoluta/a/frisby-colombia.apk
   ```
3. Asegúrate de que el emulador esté corriendo y Appium esté configurado.

## Ejecutar las Pruebas

```bash
./gradlew test
```

## Reportes

Los reportes se generan en `target/site/serenity/` después de ejecutar las pruebas.
