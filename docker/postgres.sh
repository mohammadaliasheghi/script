#create volume for save data
sudo docker volume create pg-data
#create network for connect backend to database
sudo docker network create pg-net
#run postgres database with docker
sudo docker run --name pg --volume pg-data --network pg-net -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
#after running database for exec psql
sudo docker exec -it pg psql -U postgres
#for restore data on docker postgres database (with sudo)
cat bu.sql | docker exec -i pg psql -U postgres -d version
#create superuser for postgres
CREATE USER cloud WITH SUPERUSER PASSWORD 'cloud';