cd /d %~dp0
cd ..\..
javac -d classes src\com\jiuchou\demo\file_jiuchou\ReadAndWrite.java
cd classes
jar cfe ReadAndWrite.jar com.jiuchou.demo.file_jiuchou.ReadAndWrite com
move ReadAndWrite.jar ..\target
