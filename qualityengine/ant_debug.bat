cd C:\Sandbox\QualitySystem\qualityengine\testtasks
set ANT_OPTS=-Xrunjdwp:transport=dt_socket,address=5050,server=y,suspend=y
call ant ftp-tp-download