# Variables
SRC_DIR = java/src
BIN_DIR = bin
LIB_DIR = lib
RES_DIR = java/resources
TEST_DIR = java/test
CLASSPATH = $(LIB_DIR)/*

# Trouver tous les fichiers .java dans le répertoire src
SOURCES := $(shell find $(SRC_DIR) -name "*.java")
# Convertir les fichiers .java en fichiers .class dans le répertoire bin
CLASSES := $(SOURCES:$(SRC_DIR)/%.java=$(BIN_DIR)/%.class)

# Cible principale
all: $(CLASSES)

# Règle pour compiler les fichiers .java
$(BIN_DIR)/%.class: $(SRC_DIR)/%.java
	@mkdir -p $(dir $@)
	javac -d $(BIN_DIR) -cp $(CLASSPATH) $<

# Cible pour nettoyer les fichiers compilés
clean:
	rm -rf $(BIN_DIR)

# Cible pour exécuter l'application
run: all
	java -cp $(BIN_DIR):$(CLASSPATH) model.Launcher

# Cible pour exécuter les tests
test: all
	# Ajoutez ici la commande pour exécuter vos tests, par exemple:
	# java -cp $(BIN_DIR):$(CLASSPATH):$(TEST_DIR) org.junit.runner.JUnitCore <NomDuTest>

# Cible phony pour éviter les conflits avec des fichiers du même nom
.PHONY: all clean run test