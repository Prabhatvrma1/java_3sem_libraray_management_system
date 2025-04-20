@echo off
cls
echo === Compiling Java Files for Library Management System ===

:: Set working directory
cd /d E:\java_project

:: Create bin folder if it doesn't exist
if not exist bin (
    mkdir bin
)

:: Compile all .java files
javac -d bin src\models\*.java src\services\*.java src\utils\*.java src\LibraryManagementSystem.java

IF %ERRORLEVEL% NEQ 0 (
    echo ❌ Compilation failed. Check for errors above.
    pause
    exit /b
)

echo ✅ Compilation successful!
echo Running Library Management System...
echo ------------------------------------------------------
java -cp bin LibraryManagementSystem
echo ------------------------------------------------------

pause
