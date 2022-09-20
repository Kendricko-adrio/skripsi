# how to migrate db from flyway:

configure flyway.conf sesuai dengan url dan username password sesuai local

.\mvnw -Dflyway.configFiles=flyway.conf flyway:migrate

# how to clean all db from flyway:
.\mvnw -Dflyway.configFiles=flyway.conf flyway:clean

# Graphql playground:
### url:
http://localhost:8080/graphiql
