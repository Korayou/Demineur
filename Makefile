### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS = 

### REGLES ESSENTIELLES ###

Main.class : Main.java FrameMenu.class
	${JC} ${JCFLAGS} Main.java

FrameMenu.class : FrameMenu.java SettingsListener.class NewGameListener.class Chargement.class
	${JC} ${JCFLAGS} FrameMenu.java

SettingsListener.class : SettingsListener.java
	${JC} ${JCFLAGS} SettingsListener.java

NewGameListener.class : NewGameListener.java FrameJeu.class 
	${JC} ${JCFLAGS} NewGameListener.java

Chargement.class : Chargement.java FrameJeu.class
	${JC} ${JCFLAGS} Chargement.java

FrameJeu.class : FrameJeu.java Grille.class
	${JC} ${JCFLAGS} FrameJeu.java

Grille.class : Grille.java Banniere.class Case.class
	${JC} ${JCFLAGS} Grille.java

Banniere.class : Banniere.java MenuListener.class SaveListener.class
	${JC} ${JCFLAGS} Banniere.java

Case.class : Case.java ListenerCase.class Entourage.class Etoile.class Doute.class
	${JC} ${JCFLAGS} Case.java

MenuListener.class : MenuListener.java
	${JC} ${JCFLAGS} MenuListener.java

SaveListener.class : SaveListener.java SaveManager.class
	${JC} ${JCFLAGS} SaveListener.java

SaveManager.class : SaveManager.java
	${JC} ${JCFLAGS} SaveManager.java

ListenerCase.class : ListenerCase.java
	${JC} ${JCFLAGS} ListenerCase.java

Entourage.class : Entourage.java
	${JC} ${JCFLAGS} Entourage.java

Etoile.class : Etoile.java
	${JC} ${JCFLAGS} Etoile.java

Doute.class : Doute.java
	${JC} ${JCFLAGS} Doute.java




### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###