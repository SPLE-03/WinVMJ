echo SELECT 'CREATE DATABASE healthcare_product_hell' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'healthcare_product_hell') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/healthcare_product_hell"

java -cp healthcare.product.hell --module-path healthcare.product.hell -m healthcare.product.hell