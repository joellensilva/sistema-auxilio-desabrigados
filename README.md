# sistema-auxilio-desabrigados

docker build -t sistema-ad:latest .

docker run -d --rm --name sistemadb -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_DB=sistema-ad -e POSTGRES_PASSWORD=1234 sistema-ad:latest

PGPASSWORD=1234 psql -h localhost -p "5432" -U postgres -d sistema-ad