sudo docker build -t rod/banco .
sudo docker run -p 5432:5432 -d --name banco rod/banco
