# consul-request-service

Solicita información a consul-response-service preguntando a Consul su dirección por nombre de servicio. No se registra en Consul como miembro y recupera sus propiedades de él.

## Arrancar el docker

Desde la raiz del proyecto:

./gradlew clean build

docker build -f Dockerfile .

docker run <ID_DOCKER>