FROM tomcat
ENV DEPLOY_DIR ${CATALINA_HOME}/webapps
COPY target/exemplo-segunda-aula-2 ${DEPLOY_DIR}/exemplo-segunda-aula-2
#/docker-entrypoint-initdb.d/
# Criar imagem / Atribuir Variaveis / Copiar SQLs / Utilizar link
