SET enginePath=D:\QualityEngine
SET serverPath=D:\NewQualitySystem

DEL %serverPath%\lib\qualityengine-1.0.jar
CALL ant -buildfile %enginePath%\build.xml
COPY %enginePath%\dist\qualityengine.jar %serverPath%\lib\qualityengine-1.0.jar
PING -w 10 923.45.67.89 >nul
CALL %serverPath%\installLib.bat