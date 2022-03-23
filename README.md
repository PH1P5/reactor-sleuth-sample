# reactor sleuth tracing error sample app
This sample application reproduces not working log tracing with sleuth and project reactor Flux publisher.

## run with the following configuration enabled to see access logs

````
-Dreactor.netty.http.server.accessLogEnabled=true
````

````
// paths:
hhtp://localhost:8080/sample (see trace id in access log)
hhtp://localhost:8080/samples (no trace id)
````
