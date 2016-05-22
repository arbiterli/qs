# This script is used to init the db schema in dev environment.
# It will be executed before the testing.

# Note, the parameter might contain space
workingdir=$(dirname "$0")
cd "$workingdir"

# Import the init data
mysql -uroot -pglority qualitysystem < testdbdump.sql

# Update the db schema
bash updateDBSchema.sh
