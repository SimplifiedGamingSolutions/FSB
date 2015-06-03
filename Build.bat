call gradlew build
copy /y build\libs\*.jar ..\SimplifiedGamingSolutions\MCMA\Server\mods\
copy /y build\libs\*.jar %appdata%\.minecraft\mods\
copy /y build\libs\*.jar C:\MCMA\Server\mods
PAUSE