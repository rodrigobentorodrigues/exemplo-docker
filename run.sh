mvn clean install
sudo docker build -t rod/app .
sudo docker run -p 8080:8080 -d --name app --link banco:host-banco rod/app
