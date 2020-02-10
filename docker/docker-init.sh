#docker-compose rm -f
#docker-compoes down
#docker image rm -f custom-mongo
docker-compose up -d
sleep 4
docker exec mongo bash -c "mongo -u root -p example admin /setup/mongodb-setup.js"