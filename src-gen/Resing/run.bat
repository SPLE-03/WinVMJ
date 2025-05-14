echo SELECT 'CREATE DATABASE healthcare_product_resing' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'healthcare_product_resing') \gexec | psql "postgresql://postgres:MacKebun134@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:MacKebun134@localhost/healthcare_product_resing"

java -cp healthcare.product.resing --module-path healthcare.product.resing -m healthcare.product.resing