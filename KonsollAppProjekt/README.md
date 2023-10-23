# Konsollapplikation README

# Beskrivning
<<<<<<< HEAD

Denna konsollapplikation �r ett anv�ndarhanteringsverktyg som l�ter anv�ndare l�gga till, ta bort, h�mta och lista
anv�ndare. Den erbjuder
funktioner som att sortera anv�ndare efter namn eller ID och �r utformad f�r enkel anv�ndning.
=======
Denna konsollapplikation är ett användarhanteringsverktyg som låter användare lägga till, ta bort, hämta och lista
användare. Den erbjuder
funktioner som att sortera användare efter namn eller ID och är utformad för enkel användning.
>>>>>>> c0815abd2535494b7bfa66fbedc97529880df23c

## Funktioner

Lägg till nya användare med anpassade detaljer.
Ta bort användare efter användarnamn eller ID.
Hämta användarinformation efter ID.
Lista alla användare sorterade efter namn eller ID.

## Förutsättningar

Innan du kör denna applikation måste du se till att du har följande:

Java Development Kit (JDK)
Apache Maven (för att bygga projektet)
Git (för versionshantering)

## Beroenden

JUnit - Version 4.13.1

## Installation (Linux/Ubuntu)

<<<<<<< HEAD
![Sk�rmbild av min applikation i linux milj�](https://github.com/Arinsz/Konsollapplikation/raw/main/KonsollAppLinux.jpg
=======
![Skärmbild av min applikation](https://github.com/Arinsz/Konsollapplikation/raw/main/KonsollAppLinux.jpg)
>>>>>>> c0815abd2535494b7bfa66fbedc97529880df23c

För att installera och köra denna konsollapplikation på ett Linux-baserat operativsystem, följ dessa steg:

1. Klona projektet från förrådet:

   git clone https://github.com/Arinsz/Konsollapplikation-Github.git


2. Navigera först till den mapp som innehåller dina Java-källkodsfiler: src\main\java\KonsollAppGroup


3. Kompilera din kod : javac *.java

När koden har kompilerats framgångsrikt kan du navigera tillbaka till :

/KonsollAppProjekt/src/main/java

4. Skriv :  java -cp . KonsollAppGroup.Main för att köra programmet.

### Användning

När applikationen körs, följ anvisningarna på skärmen för att interagera med programmet. Till exempel:

<<<<<<< HEAD
F�r att l�gga till en anv�ndare, v�lj "add new user" genom att ange siffran 1 fr�n menyn och f�lj anvisningarna.
F�r att lista anv�ndare sorterade efter namn, v�lj "List all users sorted by name."

Ingen specifik konfiguration kr�vs f�r denna applikation. Den anv�nder en inbyggd databas f�r anv�ndardata.
=======
För att lägga till en användare, välj "add new user" genom att ange siffran 1 från menyn och följ anvisningarna.
För att lista användare sorterade efter namn, välj "List all users sorted by name."
Konfiguration
Ingen specifik konfiguration krävs för denna applikation. Den använder en inbyggd databas för användardata.
>>>>>>> c0815abd2535494b7bfa66fbedc97529880df23c

#### Min objektorienterade analys och reflektion över principer för ren kod:

Läsbarhet: Jag har försökt göra koden så läsbar som möjligt. Variabelnamn, funktionsnamn och klassnamn är klara och
beskrivande. Kommentarer används för att förklara och göra det tydligt vad koden gör.

Tydlighet: Koden är tydlig och följer en enkel struktur.

DRY (Don't Repeat Yourself): Jag har försökt undvika kodupprepning så mycket som möjligt, till exempel genom att skapa
en inputhanterare.

Single Responsibility Principle (SRP): Varje funktion, klass eller modul bör ha en enda uppgift. Detta är något jag har
tänkt på och försökt följa när jag arbetade med projektet.

Liskov Substitution Principle: För att följa LSP bör till exempel AdminUser vara en subtyp av User, vilket innebär att
AdminUser är en specialisering av User.

Dependency Inversion Principle: I min kod finns det potential att följa DIP, särskilt när jag tänker på principen under
den vidare utvecklingen av denna applikation. Jag har skapat gränssnitt som UserList, InputHandler och User. Dessa
gränssnitt är abstraktioner som kan användas för att minska beroenden mellan olika delar av min kod.

Testbarhet: Koden bör vara enkel att testa med enhetstester. Jag har inkluderat enhetstester som UserListTest och
UserTest för att
testa specifika delar av min kod.

KISS (Keep It Simple, Stupid): Att hålla koden så enkel som möjligt och undvika onödig komplexitet eller överdesign.
Genom att använda inbyggda datastrukturer som TreeMap och HashMap utnyttjar jag befintlig funktionalitet istället för
att skapa en egen komplex logik. Det gör koden mer läsbar och minskar risken för buggar som orsakas av felaktig
implementation.

Robusthet och felhantering: Koden bör hantera fel och undantag på ett robust sätt. Det inkluderar att inte ignorera fel
och tillhandahålla meningsfulla felmeddelanden. Jag har implementerat detta i metoderna och i huvudprogrammet.

Refaktorering: Jag har arbetat med att omstrukturera och förbättra koden utan att ändra dess externa beteende.

Dokumentation: Koden bör vara väl kommenterad, och i varje klass beskriver jag vad klassen gör och lagt till kommentarer
där jag anser att det är nödvändigt.
