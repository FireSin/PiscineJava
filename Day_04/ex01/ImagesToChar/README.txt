 # Create target directory
 mkdir target

 # Compiling sourcecode to target directory with compiled .class files
 javac -d target -sourcepath src src/java/edu/school21/printer/app/Program.java src/java/edu/school21/printer/logic/imgToChar.java

 # Copy resources to destination directory
 cp -r src/resources target/

 # Create JAR archive
 jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target/ .

 # Run program from archive with specific parameters:
 # parameter 1 - symbol for white color
 # parameter 2 - symbol for black color
 # parameter 3 - path to image in target/resources
 java -jar target/images-to-chars-printer.jar . o target/resources/image.bmp

 # Clean
 rm -rf ./target