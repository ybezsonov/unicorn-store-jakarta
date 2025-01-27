# cd unicorn-store-jakarta

docker build -f Dockerfile-crac -t unicorn-store-quarkus-crac:latest --progress plain \
  --build-arg QUARKUS_DATASOURCE_JDBC_URL=jdbc:postgresql://host.docker.internal:5432/unicorns \
  --build-arg QUARKUS_DATASOURCE_PASSWORD=postgres \
  --build-arg QUARKUS_DATASOURCE_USERNAME=postgres .
