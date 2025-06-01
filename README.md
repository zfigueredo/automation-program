# 📌 Quality Stream Ptactice Site

UI Automated regression test.

---

## 🚀 Características principales


- ✅ **Page Object Model**: cada página (Home, Course, Alerts, Product Details, Credit Cards, Actions, WebElements) está encapsulada en su propio class.
- ✅ **Acciones avanzadas** con `Actions`: escritura con `SHIFT`, copiar/pegar entre campos, hover y selección de menú.
- ✅ **Manejo de elementos dinámicos**: alerts de JavaScript, iframes, tablas, checkboxes, radio buttons y enlaces.
- ✅ **Data‑Driven Testing**: parametrización de escenarios mediante lectura de datos externos (CSV) en `DDT_Tests.java`.
- ✅ **Framework modular** y extensible: agrega nuevas páginas o tests sin tocar la infraestructura básica.
- ✅ **Reportes HTML** con ExtentReports y logging con SLF4J + Logback.
- ✅ **Integración CI/CD**: preparado para ejecutarse en Jenkins

---

## 🛠 Tecnologías usadas

- **Java 17**  
- **Maven** (gestión de dependencias, `pom.xml`)  
- **JUnit 5** (librería de pruebas)  
- **Selenium WebDriver** (UI automation)   
- **ExtentReports** (reportes HTML)  
- **SLF4J + Logback** (logging)  
- **Jenkins** (CI/CD)

---

# Clonar el repositorio
git clone git@github-kramosqa:kramosqa/api_automation.git

# Navegar al proyecto
cd api_automation

# Ejecutar toda la suite
mvn clean test

# Ejecutar solo el grupo "Action_Regression"

mvn clean test -Dgroups="Action_Regression"

## 📊 Reportes

Los reportes HTML se generan en la carpeta `/reports`.

Abre `ExtentReport.html` en tu navegador para ver los resultados.

## 👩‍💻 Autor(a)

**Karine Ramos**

📧 qualitystream@email.com
