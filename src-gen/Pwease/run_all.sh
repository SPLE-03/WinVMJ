#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE healthcare_product_pwease' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'healthcare_product_pwease') \gexec" | psql "postgresql://:@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://:@localhost/healthcare_product_pwease"
done

java -cp healthcare.product.pwease --module-path healthcare.product.pwease -m healthcare.product.pwease &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait