plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.testng:testng:7.7.0")
    implementation("com.microsoft.playwright:playwright:1.34.0")
    testImplementation("org.projectlombok:lombok:1.18.26")
    compileOnly("org.projectlombok:lombok:1.18.28")
    implementation("com.typesafe:config:1.4.2")
    testImplementation("com.codeborne:selenide-selenoid:6.15.0")
//    annotationProcessor("org.projectlombok:lombok:1.18.28")


}

tasks.test {
    useTestNG()

//    useJUnitPlatform()
}
