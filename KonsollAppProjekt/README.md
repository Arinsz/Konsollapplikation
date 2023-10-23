# Konsollapplikation README

Beskrivning
Denna konsollapplikation �r ett anv�ndarhanteringsverktyg som l�ter anv�ndare l�gga till, ta bort, h�mta och lista
anv�ndare. Den erbjuder
funktioner som att sortera anv�ndare efter namn eller ID och �r utformad f�r enkel anv�ndning.

## Funktioner

L�gg till nya anv�ndare med anpassade detaljer.
Ta bort anv�ndare efter anv�ndarnamn eller ID.
H�mta anv�ndarinformation efter ID.
Lista alla anv�ndare sorterade efter namn eller ID.

## F�ruts�ttningar

Innan du k�r denna applikation m�ste du se till att du har f�ljande:

Java Development Kit (JDK)
Apache Maven (f�r att bygga projektet)
Git (f�r versionshantering)

## Beroenden

JUnit - Version 4.13.1

## Installation (Linux/Ubuntu)

![Sk�rmbild av min applikation](https://github.com/Arinsz/Konsollapplikation/blob/379093071e198ab7652b62982d4564147f571969/KonsollAppLinux.jpg)

F�r att installera och k�ra denna konsollapplikation p� ett Linux-baserat operativsystem, f�lj dessa steg:

1. Klona projektet fr�n f�rr�det:

   git clone https://github.com/Arinsz/Konsollapplikation-Github.git


2. Navigera f�rst till den mapp som inneh�ller dina Java-k�llkodsfiler: src\main\java\KonsollAppGroup


3. Kompilera din kod : javac *.java

N�r koden har kompilerats framg�ngsrikt kan du navigera tillbaka till :

/KonsollAppProjekt/src/main/java

4. Skriv :  java -cp . KonsollAppGroup.Main f�r att k�ra programmet.

### Anv�ndning

N�r applikationen k�rs, f�lj anvisningarna p� sk�rmen f�r att interagera med programmet. Till exempel:

F�r att l�gga till en anv�ndare, v�lj "add new user" genom att ange siffran 1 fr�n menyn och f�lj anvisningarna.
F�r att lista anv�ndare sorterade efter namn, v�lj "List all users sorted by name."
Konfiguration
Ingen specifik konfiguration kr�vs f�r denna applikation. Den anv�nder en inbyggd databas f�r anv�ndardata.

#### Min objektorienterade analys och reflektion �ver principer f�r ren kod:

L�sbarhet: Jag har f�rs�kt g�ra koden s� l�sbar som m�jligt. Variabelnamn, funktionsnamn och klassnamn �r klara och
beskrivande. Kommentarer anv�nds f�r att f�rklara och g�ra det tydligt vad koden g�r.

Tydlighet: Koden �r tydlig och f�ljer en enkel struktur.

DRY (Don't Repeat Yourself): Jag har f�rs�kt undvika kodupprepning s� mycket som m�jligt, till exempel genom att skapa
en inputhanterare.

Single Responsibility Principle (SRP): Varje funktion, klass eller modul b�r ha en enda uppgift. Detta �r n�got jag har
t�nkt p� och f�rs�kt f�lja n�r jag arbetade med projektet.

Liskov Substitution Principle: F�r att f�lja LSP b�r till exempel AdminUser vara en subtyp av User, vilket inneb�r att
AdminUser �r en specialisering av User.

Dependency Inversion Principle: I min kod finns det potential att f�lja DIP, s�rskilt n�r jag t�nker p� principen under
den vidare utvecklingen av denna applikation. Jag har skapat gr�nssnitt som UserList, InputHandler och User. Dessa
gr�nssnitt �r abstraktioner som kan anv�ndas f�r att minska beroenden mellan olika delar av min kod.

Testbarhet: Koden b�r vara enkel att testa med enhetstester. Jag har inkluderat enhetstester som UserListTest och
UserTest f�r att
testa specifika delar av min kod.

KISS (Keep It Simple, Stupid): Att h�lla koden s� enkel som m�jligt och undvika on�dig komplexitet eller �verdesign.
Genom att anv�nda inbyggda datastrukturer som TreeMap och HashMap utnyttjar jag befintlig funktionalitet ist�llet f�r
att skapa en egen komplex logik. Det g�r koden mer l�sbar och minskar risken f�r buggar som orsakas av felaktig
implementation.

Robusthet och felhantering: Koden b�r hantera fel och undantag p� ett robust s�tt. Det inkluderar att inte ignorera fel
och tillhandah�lla meningsfulla felmeddelanden. Jag har implementerat detta i metoderna och i huvudprogrammet.

Refaktorering: Jag har arbetat med att omstrukturera och f�rb�ttra koden utan att �ndra dess externa beteende.

Dokumentation: Koden b�r vara v�l kommenterad, och i varje klass beskriver jag vad klassen g�r och lagt till kommentarer
d�r jag anser att det �r n�dv�ndigt.