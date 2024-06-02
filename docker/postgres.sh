#create volume for save data
sudo docker volume create pg-data
#create network for connect backend to database
sudo docker network create pg-net
#run postgres database with docker
docker run --name pg --volume pg-data --network pg-net -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
#after running database for exec psql
docker exec -it pg psql -U postgres
#for restore data on docker postgres database
cat bu.sql | docker exec -i pg psql -U postgres -d version