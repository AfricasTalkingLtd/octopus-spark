## Spark micro-framework demo


### About

spark is a sample Java project that demonstrates how to interact with the AT API's.

The user ineracts with the ussd where they can choose whether to receive a message or phone call

### Depends

```bash
install gradle
install java 8
```

### run

```bash
./gradlew build # gradle build
gradle run
```

### 
> ##### place your africastalking username, virtual number, and apikey in src/main/com/africastalking/app/config.json file.

> ##### ensure that you tunnel **/ussd/** and **/voice/** routes, then register the resulting callback urls
