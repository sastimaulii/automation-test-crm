# 🚀 Automation Test for CRM Operational System

Automation Test Framework ini dibuat untuk menguji **Web UI dan API** dalam satu repository menggunakan pendekatan **Behavior Driven Development (BDD)** dengan **Cucumber**.

Framework ini mensimulasikan sistem **CRM (Customer Relationship Management)** yang digunakan dalam operasional bisnis sehari-hari.

---

# 📌 Table of Contents
- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Test Coverage](#test-coverage)
- [How to Run](#how-to-run)
- [Test Tagging](#test-tagging)
- [Cucumber Report](#cucumber-report)
- [CI/CD](#cicd)
- [Best Practices Implemented](#best-practices-implemented)

---

# 🧠 Overview

Framework ini mencakup:

- ✅ Web UI Testing (Selenium)
- ✅ API Testing (RestAssured)
- ✅ BDD dengan Gherkin & Cucumber
- ✅ Modular structure (Web & API dipisah)
- ✅ CI/CD dengan GitHub Actions

Simulasi CRM meliputi:
- Login user
- Pengelolaan data customer
- Validasi API backend

---

# 🛠 Tech Stack

| Tools | Description |
|------|------------|
| Java | Programming Language |
| Gradle | Build Tool |
| Selenium | Web UI Automation |
| RestAssured | API Automation |
| Cucumber | BDD Framework |
| JUnit | Test Runner |
| GitHub Actions | CI/CD |

---

# 📁 Project Structure

```
automation-test-crm/
│── src/test/java/
│   ├── web/
│   │   ├── pages/        → Page Object Model
│   │   ├── steps/        → Step Definitions Web
│   │   └── runners/      → Test Runner Web
│   │
│   ├── api/
│   │   ├── steps/        → Step Definitions API
│   │   └── runners/      → Test Runner API
│   │
│   └── utils/            → Driver & Utility
│
│── src/test/resources/
│   ├── web/features/     → Gherkin Web
│   └── api/features/     → Gherkin API
│
└── .github/workflows/    → CI/CD Pipeline
```

---

# 🧪 Test Coverage

## 🌐 Web UI Testing
Target: https://www.saucedemo.com/

Scenario yang diuji:
- Login valid
- Login invalid
- Navigasi dashboard

---

## 🔌 API Testing
Target: https://dummyapi.io/

Scenario yang diuji:
- Get User by ID
- Invalid User Request
- Validasi response status

Authentication menggunakan header:

```
app-id: 63a804408eb0cb069b57e43a
```

---

# ▶️ How to Run

## 🔹 Clone Repository
```bash
git clone <your-repo-url>
cd automation-test-crm
```

## 🔹 Jalankan API Test
```bash
./gradlew apiTest
```

## 🔹 Jalankan Web Test
```bash
./gradlew webTest
```

---

# 🏷 Test Tagging

Framework menggunakan tagging Cucumber:

| Tag | Description |
|-----|------------|
| @web | Menjalankan Web UI test |
| @api | Menjalankan API test |

---

# 📊 Cucumber Report

Framework ini menggunakan **Cucumber Reporting** untuk menghasilkan hasil eksekusi test dalam format **HTML** dan **JSON**.

---

## 📍 Lokasi Report

Setelah test dijalankan, report akan otomatis tersimpan di folder:

```
reports/
├── web.html
├── web.json
├── api.html
└── api.json
```

---

## 🧪 Jenis Report

### 🔹 HTML Report
File:
```
reports/web.html
reports/api.html
```

Berfungsi untuk:
- Melihat hasil test secara visual di browser
- Menampilkan:
    - Scenario
    - Step (Given / When / Then)
    - Status (PASSED / FAILED)
    - Error message (jika gagal)

Cara membuka:
- Klik file `.html`
- Atau buka dengan browser

---

### 🔹 JSON Report
File:
```
reports/web.json
reports/api.json
```

Berfungsi untuk:
- Integrasi dengan tools lain (Allure, Jenkins, dll)
- Parsing hasil test automation

---

## ⚙️ Konfigurasi Report

Report dikonfigurasi di **Cucumber Runner Class**:

```java
@CucumberOptions(
    features = "src/test/resources/web/features",
    glue = "web.steps",
    tags = "@web",
    plugin = {
        "pretty",
        "html:reports/web.html",
        "json:reports/web.json"
    }
)
```

---

## ▶️ Cara Generate Report

Report akan otomatis dibuat setelah menjalankan test:

### Web Test
```bash
./gradlew webTest
```

### API Test
```bash
./gradlew apiTest
```

---

# 🤖 CI/CD

Pipeline menggunakan **GitHub Actions**

### Trigger:
- Pull Request
- Manual Trigger (workflow_dispatch)

### Workflow:
1. Checkout code
2. Setup Java
3. Run API Test
4. Run Web Test

---

# ✅ Best Practices Implemented

- Page Object Model (POM)
- Separation of concerns (Web vs API)
- Reusable Step Definitions
- Clean project structure
- Tag-based execution
- CI/CD Integration
- Maintainable & scalable framework

---

# 🚀 Future Improvements

- Parallel execution
- Allure Reporting
- Test data management
- Environment config (dev/staging/prod)
- Docker integration

---

# 👨‍💻 Author

Automation Test Framework ini dibuat untuk keperluan:
- Pembelajaran QA Automation
- Technical Assessment
- Portfolio QA Engineer