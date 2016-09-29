# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM payara/server-full
ENV DOMAIN domain1
ENV LIB /opt/payara41/glassfish/domains/${DOMAIN}/lib/
ENV DEPLOY ${PAYARA_PATH}/glassfish/domains/${DOMAIN}/autodeploy/
ADD HUB-REST/target/HUB-REST/WEB-INF/lib/ ${LIB}
ADD HUB-UI/target/HUB-UI/WEB-INF/lib/ ${LIB}
ENTRYPOINT $PAYARA_PATH/bin/asadmin start-domain --verbose ${DOMAIN}
ADD HUB-REST/target/HUB-REST.war  ${DEPLOY}
ADD HUB-UI/target/HUB-UI.war  ${DEPLOY}
