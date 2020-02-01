IMAGE_NAME=gitproject:alpha
CONTAINER_NAME=git-api

{
  docker stop $CONTAINER_NAME
}
{
  docker rm git-api
  docker image rm $IMAGE_NAME
}
{
  docker build -t $IMAGE_NAME .
  docker run -d --name $CONTAINER_NAME -p 8888:8888 $IMAGE_NAME
}
