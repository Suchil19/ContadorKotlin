content = """# Guía de Diseño Instruccional: Práctica Básica en Android Studio (Kotlin)
## Proyecto: Contador Interactivo con Vistas Tradicionales (Sin Modificación de Imports)

---

## 1. Ficha Técnica y Contextualización

| Atributo | Detalle |
| :--- | :--- |
| **Nivel Educativo** | Introductorio / Principiante |
| **Audiencia** | Estudiantes de desarrollo móvil y programadores novatos en Android |
| **Entorno de Desarrollo (IDE)** | Android Studio (versión Dolphin, Flamingo, Hedgehog o superior) |
| **Lenguaje de Programación** | Kotlin |
| **Modelo de UI** | Sistema de Vistas Tradicional (`XML` + `View Binding` / `findViewById`) |
| **Tiempo Estimado** | 45 a 60 minutos |
| **Requisito Previsto** | Instalación funcional de Android Studio y emulador o dispositivo físico configurado |

### 1.1 Objetivo General de Aprendizaje
El estudiante comprenderá y aplicará el flujo fundamental del desarrollo de aplicaciones en Android mediante el acoplamiento de una interfaz gráfica estructurada en XML con una capa lógica reactiva en Kotlin, controlando el ciclo de vida básico de una actividad (`Activity`) y gestionando eventos de interacción de usuario sin alterar los paquetes de cabecera predeterminados.

### 1.2 Objetivos Específicos
- **Diseñar** una interfaz de usuario lineal responsiva usando `LinearLayout`, `TextView` y componentes `Button`.
- **Comprender** el mecanismo de resolución de nombres y paquetes (`Fully Qualified Class Names`) en Kotlin/Java para interactuar con componentes del SDK sin directivas `import` adicionales.
- **Implementar** escuchadores de eventos táctiles (`View.OnClickListener` / lambdas) para mutar el estado de la aplicación en memoria.
- **Personalizar** la apariencia visual de los componentes a través de atributos de estilo y colores hexadecimales en XML.

---

## 2. Fundamentación Teórica

Antes de iniciar con la codificación, es indispensable comprender los tres pilares sobre los que se sustenta esta práctica:

### 2.1 El Archivo de Layout (`XML`)
Android separa estrictamente el diseño de la lógica. Los archivos `.xml` en `res/layout` describen la jerarquía de vistas (árbol de elementos visuales). Cada vista cuenta con atributos dimensionales (`layout_width`, `layout_height`), de posición (`gravity`, `orientation`) e identificadores únicos (`android:id="@+id/..."`).

### 2.2 El Enlace de Recursos (`R.id`)
Durante la compilación, Android genera automáticamente una clase de indexación llamada `R`. Al declarar un identificador como `@+id/btnIncrementar`, el sistema crea una constante entera (`R.id.btnIncrementar`) que permite a la lógica en Kotlin buscar y referenciar ese componente exacto en memoria.

### 2.3 Resolución de Paquetes (`FQN` - Fully Qualified Name)
Cuando usamos una clase como `Button` o `TextView`, el compilador necesita saber su ubicación exacta en el SDK de Android. 
- La forma habitual es declarar: `import android.widget.Button`.
- La alternativa directa sin modificar cabeceras es usar su nombre canónico completo: `android.widget.Button`. Esto evita conflictos de importación en proyectos iniciales y aclara el origen de cada API.

---

## 3. Guía Paso a Paso de Implementación

### Paso 1: Creación del Proyecto
1. Abre **Android Studio** y selecciona **New Project**.
2. En la ventana de plantillas, selecciona **Empty Views Activity** (asegúrate de que **no** sea *Empty Activity* de Jetpack Compose).
3. Configura los parámetros:
   - **Name:** `ContadorBasico`
   - **Package name:** `com.ejemplo.contadorbasico`
   - **Language:** `Kotlin`
   - **Minimum SDK:** `API 24` (Android 7.0) o superior.
   - **Build Configuration Language:** `Kotlin DSL (build.gradle.kts)` o `Groovy DSL`.
4. Haz clic en **Finish** y espera a que Gradle finalice la sincronización.

---

### Paso 2: Construcción de la Interfaz Visual (`activity_main.xml`)
Dirígete a la ruta `app > res > layout > activity_main.xml`. Cambia la vista al modo **Code** (esquina superior derecha) y sustituye el código existente por la siguiente estructura:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="[http://schemas.android.com/apk/res/android](http://schemas.android.com/apk/res/android)"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="24dp"
    android:background="#F5F5F5">

    <!-- Pantalla del Contador -->
    <TextView
        android:id="@+id/tvContador"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:textSize="56sp"
        android:textStyle="bold"
        android:textColor="#212121"
        android:layout_marginBottom="32dp" />

    <!-- Botón para Incrementar (+1) -->
    <Button
        android:id="@+id/btnIncrementar"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:text="Sumar +1"
        android:textSize="18sp"
        android:backgroundTint="#4CAF50"
        android:textColor="#FFFFFF"
        android:layout_marginBottom="12dp" />

    <!-- Botón para Reiniciar (Reset) -->
    <Button
        android:id="@+id/btnReset"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:text="Reiniciar"
        android:textSize="16sp"
        android:backgroundTint="#F44336"
        android:textColor="#FFFFFF" />

</LinearLayout>
