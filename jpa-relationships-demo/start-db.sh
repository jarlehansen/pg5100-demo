#!/bin/sh
# jdbc:h2:tcp://localhost/mem:jpa-relationships-demo
java -cp ~/tools/server/wildfly-9.0.1.Final/modules/system/layers/base/com/h2database/h2/main/h2-1.3.173.jar org.h2.tools.Server
