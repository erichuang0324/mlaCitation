plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.jsoup:jsoup:1.20.1")
    implementation("org.openjfx:javafx-controls:24.0.1")
    implementation("org.openjfx:javafx-fxml:24.0.1")
}

tasks.test {
    useJUnitPlatform()
}