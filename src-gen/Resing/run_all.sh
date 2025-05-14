#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE healthcare_product_resing' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'healthcare_product_resing') \gexec" | psql "postgresql://postgres:MacKebun134@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:MacKebun134@localhost/healthcare_product_resing"
done

java -cp healthcare.product.resing --module-path healthcare.product.resing -m healthcare.product.resing &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait