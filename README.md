# Sistema para Auxílio aos Desabrigados das Enchentes

Esse projeto, implementado em Java, foi desenvolvido durante estágio na Compass UOL em desafio proposto.

## Como subir o banco de dados

```sh
docker build -t sistema-ad:latest .

docker run -d --rm --name sistemadb -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_DB=sistema-ad -e POSTGRES_PASSWORD=1234 sistema-ad:latest
```
