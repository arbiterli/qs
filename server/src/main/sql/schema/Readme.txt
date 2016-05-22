Database schema update sql must be put into update folder. 
And the name of sql file must match the specify pattern. 
e.g. 20120101_01.sql, 20120101_02.sql

Pattern unmatched sql file will be ignore.

The less order of the sql file name, the higher execution priority.
e.g. As "20120101_01.sql" < "20120101_02.sql", 20120101_01.sql execute first.