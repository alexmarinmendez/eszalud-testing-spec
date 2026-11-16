# EsZalud – Reference Application

![EsZalud](./reference-app/EsZalud_logo.png)

## 1. Descripción

EsZalud es una aplicación de escritorio desarrollada en Java para la gestión de consultas médicas. Este proyecto contiene una implementación funcional que se proporciona como referencia para el desarrollo de la **[Especificación Formal de Pruebas Unitarias (EFP)](EFP_Pruebas_Unitarias_EsZalud.md)**.

## 2. Propósito

El objetivo de este proyecto es servir como material de consulta durante el desarrollo de las pruebas unitarias de la capa Model.

Los desarrolladores podrán revisar la implementación de referencia para comprender:

- La estructura de los modelos.
- Los atributos y responsabilidades de cada clase.
- Las reglas de validación implementadas.
- La organización del código fuente.
- La interacción de la aplicación con MongoDB.

## 3. Tecnologías utilizadas

- Java 25
- Gradle
- JavaFX
- MongoDB

## 4. Consideraciones para los desarrolladores

**Importante:** Esta aplicación es una implementación de referencia, no una solución para copiar y entregar.

El trabajo consiste en desarrollar la capa Model aplicando la metodología **Test-Driven Development (TDD)** y siguiendo la [EFP proporcionada](EFP_Pruebas_Unitarias_EsZalud.md).

Se espera que cada desarrollador:

1. Escriba las pruebas unitarias utilizando JUnit 6.
2. Aplique el ciclo RED – GREEN – REFACTOR.
3. Utilice Mockito cuando sea necesario aislar dependencias.
4. Registre los cambios mediante commits siguiendo las convenciones establecidas en la EFP.

## 5. Ejecución de la aplicación en Windows

### 5.1. Requisitos previos

Antes de ejecutar la aplicación, verifica que tu computadora cuente con lo siguiente:

- Sistema operativo Windows 10 o Windows 11.
- Java Runtime Environment (JRE) o Java Development Kit (JDK) 25.
- MongoDB instalado y ejecutándose localmente, o acceso a una instancia remota de MongoDB.

### 5.2. Verificar la instalación de Java

1. Abre el menú Inicio de Windows.
2. Escribe `cmd` y ejecuta el Símbolo del sistema.
3. Ejecuta el siguiente comando:

```bash
java -version
```

Si Java está correctamente instalado, aparecerá información similar a esta:

```text
java version "25..."
```

Si Windows muestra el mensaje `'java' no se reconoce como un comando interno o externo`, debes instalar Java y configurar la variable de entorno `PATH`.

### 5.3. Preparar MongoDB

La aplicación utiliza MongoDB para almacenar la información.

Antes de ejecutar EsZalud:

1. Verifica que el servicio de MongoDB esté iniciado.
2. Si utilizas una instalación local, comprueba que esté disponible en:

```text
mongodb://localhost:27017
```

3. La aplicación utiliza la base de datos:

```text
salud_publica
```

Si utilizas una instancia remota, configura la cadena de conexión correspondiente según las variables de entorno que espera la aplicación.

## Configuración previa: conexión a MongoDB

**¡Importante!** Antes de ejecutar la aplicación, es necesario crear la variable de entorno `MONGODB_URI`, que contiene la cadena de conexión a la base de datos MongoDB.

Para realizar esta configuración, sigue las instrucciones del siguiente documento:

📄 **[Guía de configuración de MONGODB](./MONGODB_SETUP.md)**

El documento explica paso a paso cómo crear esta variable tanto en **PowerShell** como en **Command Prompt (CMD)**.

Una vez configurada la variable de entorno, podrás continuar con las instrucciones de ejecución de la aplicación.

### 5.4. Ejecutar la aplicación

1. Ubica el archivo JAR de EsZalud.
2. Abre el Explorador de archivos de Windows.
3. Ingresa a la carpeta donde se encuentra el archivo.
4. Haz clic en la barra de direcciones, escribe `cmd` y presiona Enter.
5. En la consola, ejecuta:

```bash
java -jar ./salud-publica-all.jar
```

Si todo está correctamente configurado, se iniciará la aplicación.

### 5.5. Solución de problemas

### Java no está instalado o no se reconoce

Verifica la instalación de Java y que su carpeta `bin` esté incluida en la variable de entorno `PATH`.

### No se puede establecer conexión con MongoDB

Comprueba que MongoDB esté iniciado y que la cadena de conexión sea correcta.

### Error: UnsupportedClassVersionError

Este error indica que la versión de Java utilizada para ejecutar la aplicación es anterior a la versión con la que fue compilada.

Instala la versión 25 (o superior) de Java y vuelve a ejecutar el comando.

> **Nota:** Al ejecutar la aplicación, es posible que aparezcan algunos _warnings_ (advertencias) en la consola de Windows. No deben alarmarse por ello, ya que estos mensajes pueden estar relacionados con las librerías o componentes utilizados por la aplicación y no necesariamente indican que exista un problema en su funcionamiento. Mientras la aplicación se inicie correctamente y sus funcionalidades operen con normalidad, pueden continuar utilizándola.

## 6. Consideraciones finales

- No es necesario tener Gradle instalado para ejecutar el JAR.
- MongoDB debe estar disponible para que funcionen las operaciones que requieren acceso a la base de datos.
- No compartas cadenas de conexión que contengan credenciales.

---

## 7. Material relacionado

Consulta la especificación ubicada en la raíz del repositorio:

- [`EFP_Pruebas_Unitarias_EsZalud.md`](EFP_Pruebas_Unitarias_EsZalud.md)

Este documento contiene los casos de prueba, los criterios de aceptación y las convenciones de commits que deberán seguirse durante el desarrollo.

---

**EsZalud – Aplicación de referencia para el desarrollo de pruebas unitarias mediante TDD.**


## Decisiones de negocio

### CIT-006: Estado de una cita médica

Cuando se crea una cita médica con estado null,
el sistema asigna automáticamente EstadoCita.PROGRAMADA.

Si se proporciona un estado válido, se conserva el
valor recibido.

Esta regla se establece para cumplir el caso CIT-006
de la especificación de pruebas unitarias.

