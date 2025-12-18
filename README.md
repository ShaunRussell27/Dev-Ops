# 🎮 Demon Slayer DevOps Pipeline
**Student:** Shaun Russell

This repository demonstrates a complete DevOps pipeline for a Demon Slayer API application, showcasing modern software development practices including CI/CD, automated testing, containerization, and monitoring.

---

## 📋 Project Overview

A Java 21 application demonstrating DevOps best practices with:
- Automated CI/CD pipeline
- Comprehensive unit testing
- Code quality enforcement
- Containerization with Docker
- Logging and monitoring
- Automated documentation generation

---

## 🛠️ Tools & Technologies

- **Java 21** – Latest LTS version with modern language features
- **Maven 3.9.9** – Build automation and dependency management
- **JUnit 5** – Unit testing framework
- **SLF4J + Logback** – Logging framework
- **Micrometer** – Application metrics and monitoring
- **Checkstyle** – Code quality and style enforcement (Google Java Style Guide)
- **GitHub Actions** – CI/CD pipeline automation
- **Docker** – Application containerization
- **GitHub Pages** – Automated Javadoc documentation hosting

---

## 🚀 Getting Started

### Prerequisites

- Java 21 or higher ([Download here](https://adoptium.net/))
- Maven 3.6+ ([Download here](https://maven.apache.org/download.cgi))
- Docker (optional, for containerization) ([Download here](https://www.docker.com/products/docker-desktop))

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/ShaunRussell27/Dev-Ops.git
   cd Dev-Ops-2
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn exec:java -Dexec.mainClass="App"
   ```

---

## 🧪 Testing

### Run All Tests
```bash
mvn test
```

### Run Checkstyle Linting
```bash
mvn checkstyle:check
```

### Generate Javadoc
```bash
mvn javadoc:javadoc
```
Documentation will be available in `target/site/apidocs/index.html`

---

## 🐳 Docker Deployment

### Build Docker Image
```bash
docker build -t demon-slayer-api:latest .
```

### Run Docker Container
```bash
docker run --rm demon-slayer-api:latest
```

### Docker Image Features
- Multi-stage build for optimized image size (~200-250 MB)
- Based on Eclipse Temurin JRE 21 Alpine
- Runs as non-root user for enhanced security
- Optimized layer caching for faster builds

---

## 🔄 CI/CD Pipeline

The project includes a comprehensive GitHub Actions workflow that automatically:

1. **Builds** the project on every push/PR to `main` or `dev` branches
2. **Runs unit tests** to ensure code quality
3. **Executes Checkstyle** to enforce coding standards
4. **Generates Javadoc** documentation
5. **Deploys documentation** to GitHub Pages

### Pipeline Triggers
- Push to `main` or `dev` branches
- Pull requests targeting `main` or `dev`

### View Pipeline Status
Check the [Actions tab](../../actions) to see pipeline runs and results.

---

## 📊 Monitoring & Logging

The application includes built-in monitoring and logging:

### Logging (SLF4J + Logback)
- Structured logging with timestamps
- Configurable log levels
- Thread information tracking

### Metrics (Micrometer)
- **Invocation counter** (`app.invocations`) - Tracks method calls
- **Execution timer** (`app.execution.time`) - Measures performance
  - Count of executions
  - Total execution time
  - Maximum execution time

### Example Output
```
19:42:26.986 [App.main()] INFO App -- Application started
19:42:26.990 [App.main()] INFO App -- Welcome to the Demon Slayer API!
19:42:26.995 [App.main()] INFO App -- Meter: app.invocations - Count: 1.0
19:42:26.997 [App.main()] INFO App -- Meter: app.execution.time - Count: 1.0
19:42:26.997 [App.main()] INFO App -- Application finished
```

---

## 📁 Project Structure

```
Dev-Ops-2/
├── .github/
│   └── workflows/
│       └── maven.yml          # CI/CD pipeline configuration
├── src/
│   ├── main/
│   │   └── java/
│   │       └── App.java       # Main application class
│   └── test/
│       └── java/
│           └── AppTest.java   # Unit tests (6 test cases)
├── Checkstyle/
│   └── google_checks.xml      # Checkstyle configuration
├── Dockerfile                 # Multi-stage Docker build
├── .dockerignore             # Docker build exclusions
├── pom.xml                   # Maven configuration
└── README.md                 # This file
```

---

## ✅ Testing Coverage

The project includes 6 comprehensive unit tests:
- ✅ Welcome message validation
- ✅ Non-null message check
- ✅ Non-empty message verification
- ✅ Main method execution
- ✅ Null argument handling
- ✅ Message content validation

**Test Results:** 6/6 passing ✓

---

## 📝 Code Quality

- **Checkstyle Violations:** 0
- **Test Coverage:** 100% of public methods
- **Coding Standard:** Google Java Style Guide

---

## 🔗 Links

- **Repository:** [github.com/ShaunRussell27/Dev-Ops](https://github.com/ShaunRussell27/Dev-Ops)
- **Documentation:** [GitHub Pages Javadoc](https://shaunrussell27.github.io/Dev-Ops/)
- **CI/CD Pipeline:** [GitHub Actions](../../actions)

---

## 📄 License

See [LICENSE](LICENSE) file for details.

---

## 👤 Author

**Shaun Russell**  
DevOps Module - 3rd Year  
Atlantic Technological University   




