echo SELECT 'CREATE DATABASE healthcare_product_default' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'healthcare_product_default') \gexec | psql "postgresql://:@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://:@localhost/healthcare_product_default"

java -cp healthcare.product.default --module-path healthcare.product.default -m healthcare.product.default