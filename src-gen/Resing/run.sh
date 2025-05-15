#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    rm java.log
    exit 1
}

trap cleanup SIGINT

java -cp healthcare.product.resing --module-path healthcare.product.resing -m healthcare.product.resing 2>&1 | tee java.log &
JAVA_PID=$!
TEE_PID=$(pgrep -n tee)
tail -f java.log --pid=$TEE_PID | while read -r LINE; do
    if [[ "$LINE" == *"== CREATING OBJECTS AND BINDING ENDPOINTS =="* ]]; then
        break
    fi
done

echo "SELECT 'CREATE DATABASE healthcare_product_resing' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'healthcare_product_resing') \gexec" | psql "postgresql://postgres:MacKebun134@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:MacKebun134@localhost/healthcare_product_resing"
done

wait