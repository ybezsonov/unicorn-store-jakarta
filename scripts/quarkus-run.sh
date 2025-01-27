# cd unicorn-store-jakarta

docker compose up
docker rm $(docker ps -a | grep "quarkus" | awk '{print $1}')
