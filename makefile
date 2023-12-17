SRC_DIR=./src
OUT_DIR=./bin
LIB_DIR=./lib
DOC_DIR=./html
JAR_FILE = Main.jar
P=Main
MAIN_CLASS=app.$(P)

all: compilar jar

compilar: limpiar
	mkdir -p $(OUT_DIR)
	find $(SRC_DIR) -name *.java | xargs javac -cp $(OUT_DIR):$(LIB_DIR) -d $(OUT_DIR)

jar: compilar
	@echo "Manifest-Version: 1.0" > manifest.txt
	@echo "Main-Class:" $(MAIN_CLASS) >> manifest.txt
	@echo "Class-Path: . ">> manifest.txt
	@echo "" >> manifest.txt
	jar cvfm $(JAR_FILE) manifest.txt  -C $(OUT_DIR) .

ejecutar: compilar
	java -cp $(OUT_DIR) $(MAIN_CLASS)

limpiar:
	rm -rf $(OUT_DIR)
	rm -rf $(DOC_DIR)
	rm -f $(JAR_FILE)

javadoc: compilar
	mkdir -p $(DOC_DIR)
	find $(SRC_DIR) -type f -name "*.java" | xargs javadoc -d $(DOC_DIR) -encoding utf-8 -charset utf-8

ejecutar-con-argumentos: compilar
	java -cp $(OUT_DIR) $(MAIN_CLASS) arg1 arg2

debug: compilar
	find $(SRC_DIR) -name *.java | xargs javac -g -cp $(OUT_DIR):$(LIB_DIR) -d $(OUT_DIR)
	cd $(OUT_DIR); jdb -sourcepath ../$(SRC_DIR) $(MAIN_CLASS)
