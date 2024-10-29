# dvd-java
 
to change the logo, go to `Dvd.java` and replace this line:
```java
this.img = Toolkit.getDefaultToolkit().getImage("./src/logo/dvd-logo.png");
```
with this line:

```java
this.img = Toolkit.getDefaultToolkit().getImage("./src/logo/dvd-logo-white.png");
```

if you want to use Dvd2.java:
change the following:
in Main.java:
```java
Dvd d = new Dvd(661, 375, 50, 100, 2, 2, Color.blue);
```
to:
```java 
Dvd2 d = new Dvd(661, 375, 50, 100, 2, 2, Color.blue);
```

in DvdPanel.java:
```java
private Dvd dvd;
```
to:
```java
 private Dvd2 dvd;
``` 
and
```java
 public DvdPanel(Dvd d, Color backgroundColor) {...}
```
 to:
```java
public DvdPanel(Dvd2 d, Color backgroundColor) {...}
```
