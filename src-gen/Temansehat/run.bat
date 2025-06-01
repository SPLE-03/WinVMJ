echo SELECT 'CREATE DATABASE healthcare_product_temansehat' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'healthcare_product_temansehat') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/healthcare_product_temansehat"

java -cp healthcare.product.temansehat --module-path healthcare.product.temansehat -m healthcare.product.temansehat