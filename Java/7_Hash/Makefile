JC = javac
CFLAGS = -source 8 -d build -g:none
SOURCES = src/Loginer.java src/RestrictedContainer/Container.java src/Ui.java

# Inside build/
EXPECTED_CLASSES = Loginer.class Ui.class Ui$$FileMode.class RestrictedContainer/Container.class
JAR_NAME = Loginer.jar

build: $(SOURCES)
	$(JC) $(CFLAGS) $(SOURCES)
	cd build && jar cvf $(JAR_NAME) $(EXPECTED_CLASSES)
