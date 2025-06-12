plugins {
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "org.example"
version = "1.0"

application{
    mainClass="dam.tema8.ejercicio6.kiosko.modelo.Programa"
}

javafx{
    modules("javafx.controls","javafx.fxml")
    version="21"
}

repositories {
    mavenCentral()
}
