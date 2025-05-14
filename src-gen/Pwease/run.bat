echo SELECT 'CREATE DATABASE healthcare_product_pwease' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'healthcare_product_pwease') \gexec | psql "postgresql://:@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://:@localhost/healthcare_product_pwease"

java -cp healthcare.product.pwease --module-path healthcare.product.pwease -m healthcare.product.pwease