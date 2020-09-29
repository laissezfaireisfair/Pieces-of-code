JC = javac
CFLAGS = -source 8 -d build -g:none
SOURCES = src/Encoder/Loginer.java src/Encoder/Container.java src/Encoder/Ui.java src/Encoder/FileMode.java

# Inside build/
EXPECTED_CLASSES = Encoder/Loginer.class Encoder/Ui.class Encoder/Container.class Encoder/FileMode.class
JAR_NAME = Encoder.jar

build: $(SOURCES)
	$(JC) $(CFLAGS) $(SOURCES)
	cd build && jar cmvf ../META-INF/MANIFEST.MF $(JAR_NAME) $(EXPECTED_CLASSES)
