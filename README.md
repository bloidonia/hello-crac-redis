Steps to run (on an x86 machine)

- Create a docker network
    ```
    docker network create redis
    ```
- Run Redis on this network
  ```
  docker run -d --network redis -p 6379:6379 redis
  ```
- Build the checkpointed image
  ```
  ./gradlew app:dockerBuildCrac
  ```
- Run the Generated checkpointed app
  ```
  docker run --network redis -p 8080:8080 app
  ```
- Add some data
  ```
  curl -X POST -H "Content-Type: text/plain" -d Yates localhost:8080/tim
  ```
- Check it's there
  ```
  curl localhost:8080/tim
  ```
  