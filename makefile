JFLAGS = -g
JC = javac
JVM= java 
INPUT = "labyrinthe.txt"

.SUFFIXES: .java .class




.java.class:
	$(JC) $(JFLAGS) $*.java



CLASSES = Emplacement.java \
	Parser.java \
	Chemin.java \
	Labyrinthe.java 


MAIN = Labyrinthe



default: classes run




classes: $(CLASSES:.java=.class)



run: $(MAIN).class
	$(JVM) $(MAIN) $(INPUT)



clean:
	$(RM) *.class

