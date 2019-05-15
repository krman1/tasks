call runcrud
if "%ERRORLEVEL%" == "0" goto startweb
echo.
echo RUNCRUD has errors - breaking work
goto fail

:startweb
start "C:\Program Files\Mozilla Firefox\firefox.exe" http://localhost:8080/crud/v1/task/getTasks
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.