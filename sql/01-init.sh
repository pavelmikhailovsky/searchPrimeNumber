#!/bin/bash
set -e
export PGPASSWORD=$POSTGRES_PASSWORD;
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
  \connect $POSTGRES_DB
  BEGIN;
    CREATE TABLE IF NOT EXISTS prime_numbers (
      prime_numbers_id BIGSERIAL PRIMARY KEY,
      prime_number INTEGER UNIQUE NOT NULL
	  );
  COMMIT;
EOSQL
