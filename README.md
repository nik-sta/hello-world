# hello-world
Java hello-world application with spring boot for remote debugging purposes with spring boot dev tools.

## Remote Debugging
```
oc port-forward <POD_NAME> -n hello-world 8000:8000
```

### Releasing on OpenShift
1. oc login (copy login command from your browser login in openshift)
2. docker login <REGISTRY> -u <USER> -p <PASSWORD>
3. run docker/build-and-push.sh and follow instructions
_*Hint:* Your local current branch will be deployed._