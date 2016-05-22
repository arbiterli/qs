#!/bin/bash

echo "------------------------------------------------------"
echo "               Update Database schema                 "
echo "------------------------------------------------------"

#change current dir to this file dir
cd $(dirname $0)

DB_USERNAME=root
DB_PASSWORD=${DB_PASSWORD:-glority}
SQL_DIR=update
DATABASE=qualitysystem
DB_VERSION_INIT_SQL=init_DB_Version.sql
MYSQL_PORT=${MYSQL_PORT:-3306}

if [ ! -d $SQL_DIR ]; then
  echo "[ERROR]: '$SQL_DIR' dir does not exists!"
  exit 1
fi

#the function to excute sql and return result.
excute_sql() {
  if [ -f "$1" ]; then
    mysql -u$DB_USERNAME -p$DB_PASSWORD $DATABASE -P $MYSQL_PORT --protocol=TCP < "$1"
  else
    echo "$1" | mysql -u$DB_USERNAME -p$DB_PASSWORD $DATABASE -P $MYSQL_PORT --protocol=TCP 
  fi
}

table=$(excute_sql "select * from information_schema.TABLES where TABLE_SCHEMA = '$DATABASE' and TABLE_NAME = 'db_version'")

#create table if db_version not exists
if [ "$table" = "" ]; then
  echo "Initailize db version..."
  if [ -e $DB_VERSION_INIT_SQL ]; then
    echo "Excute $DB_VERSION_INIT_SQL..."
    excute_sql $DB_VERSION_INIT_SQL
  else
    echo "[ERROR]: $DB_VERSION_INIT_SQL does not exists!"
    exit 1
  fi
else
  echo "$DATABASE.db_version already exists..."
fi

db_version=$(excute_sql "select version from db_version limit 1" | tail -1)

if [ "$(echo $db_version | grep -E '[0-9]{8}_[0-9]{2}')" = "" ]; then
  echo "[ERROR]: Invalid db_version '$db_version'"
  exit 1
fi

version_pattern=$db_version

#select property sql files to excute
for file in $(ls $SQL_DIR | grep -E '[0-9]{8}_[0-9]{2}.sql')
do
  if [ -f "$SQL_DIR/$file" ]; then
    if [ "${last_sql=$file}" '<' "$file" ]; then
	  last_sql=$file
    fi
    file_version=`echo $file | sed -e s/\.sql//`
    if [ "$file_version" '>' "$version_pattern" ]; then
      echo "Excute $SQL_DIR/$file..."
      if excute_sql "$SQL_DIR/$file"; then
        db_version=${file:0:11}
      else
        echo "[ERROR]: excute $SQL_DIR/$file fail!"
        result=FAILED
        break
      fi
    fi
  fi
done

if [ ! -z "$last_sql" -a "$last_sql" '<' $version_pattern ]; then
  echo "[Error]: sql file error. The version of last sql file($last_sql) must equal or great than database current version($version_pattern)!"
  exit 1
fi

if [ ! "$version_pattern" = $db_version.sql ]; then
  echo "Update db_version to $db_version..."
  excute_sql "update db_version set version='$db_version'"
else
  echo "No database schema update"
fi

#revert dir
cd -

#print script excute result. If result is undifined, print SUCCESS
echo "Update database schema ${result-SUCCESS}!"
echo ""

if [ "$result" = "FAILED" ]; then
  exit 1
fi