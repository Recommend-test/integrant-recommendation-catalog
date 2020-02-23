FROM mongo:3.4.24
ADD mongodb-setup-js /docker-entrypoint-initdb.d/mongodb-setup-js
ADD mongodb-setup.sh /docker-entrypoint-initdb.d/mongodb-setup.sh
EXPOSE 27017