# Variables
SRC_DIR := src
BUILD_DIR := build/classes
LIB_DIR := lib
RESOURCES_DIR := resources

# On trouve tous les fichiers .java dans le répertoire src/
SRC_FILES := $(shell find $(SRC_DIR) -name "*.java")
CLASS_FILES := $(patsubst $(SRC_DIR)/%.java, $(BUILD_DIR)/%.class, $(SRC_FILES))

# Bibliothèques externes (si nécessaire)
LIBS := $(wildcard $(LIB_DIR)/*.jar)
LIBS_PATH := $(subst $(space),:,$(LIBS))

# Options du compilateur
JC := javac
JFLAGS := -d $(BUILD_DIR) -cp $(LIBS_PATH) -sourcepath $(SRC_DIR)

# Options d'exécution
MAIN_CLASS := model.Main
RUN_FLAGS := -cp $(BUILD_DIR):$(LIBS_PATH)

# Cibles Makefile
.PHONY: all clean run

# Cible par défaut : compile tout
all: $(CLASS_FILES)

# Compilation des fichiers .java
$(BUILD_DIR)/%.class: $(SRC_DIR)/%.java
	@mkdir -p $(dir $@)
	$(JC) $(JFLAGS) $<

# Nettoyage des fichiers compilés
clean:
	@rm -rf $(BUILD_DIR)/*

# Exécution de l'application
run: all
	java $(RUN_FLAGS) $(MAIN_CLASS)

# Copier les ressources dans le répertoire de compilation (si nécessaire)
resources:
	@cp -r $(RESOURCES_DIR)/* $(BUILD_DIR)/