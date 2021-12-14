# seleniumJava e2e test for ECS Digital

- java based selenium test
- set up and tested on mac

### Requirements

- Intellij
- Java (developed with JDK 1.8)
- chromedriver - https://chromedriver.chromium.org/downloads (verify your chrome browser version in chrome settings and download correct version) (included in project repo)
- selenium-server-4.1.0.jar (included in project repo)

### Setup

- clone repo
- in intellij project structure, ensure selenium-server-4.1.0.jar is added as a dependency and java version selected as module SDK

### Running test

- ensure your app is running then start http://localhost:3000/
- change chromedriver path in src/techTest
- right click then run techTest.main()

### Troubleshooting

Ensure you have allowed your mac to allow apps downloaded from app store and identified developers otherwise you will get an error related to chromedriver.
