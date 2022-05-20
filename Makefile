### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS = 

### REGLES ESSENTIELLES ###

Main.class : Main.java Fenetre.class
	${JC} ${JCFLAGS} Main.java

Fenetre.class : Fenetre.java Controleur.class
	${JC} ${JCFLAGS} Fenetre.java

Controleur.class : Controleur.java
	${JC} ${JCFLAGS} Controleur.java

### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###