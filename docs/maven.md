## JDK 和 Maven 的版本问题

```
Exception in thread "main" java.lang.UnsupportedClassVersionError: org/codehaus/plexus/classworlds/launcher/Launcher : Unsupported major.minor version 51.0
	at java.lang.ClassLoader.defineClass1(Native Method)
	at java.lang.ClassLoader.defineClass(ClassLoader.java:648)
	at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142)
	at java.net.URLClassLoader.defineClass(URLClassLoader.java:272)
	at java.net.URLClassLoader.access$000(URLClassLoader.java:68)
	at java.net.URLClassLoader$1.run(URLClassLoader.java:207)
	at java.net.URLClassLoader$1.run(URLClassLoader.java:201)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.net.URLClassLoader.findClass(URLClassLoader.java:200)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:325)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:270)
	at org.apache.maven.wrapper.BootstrapMainStarter.start(BootstrapMainStarter.java:33)
	at org.apache.maven.wrapper.WrapperExecutor.execute(WrapperExecutor.java:122)
	at org.apache.maven.wrapper.MavenWrapperMain.main(MavenWrapperMain.java:61)
The command "./mvnw --version" failed and exited with 1 during .
```

## 特定版本 Maven

```
mvn -N io.takari:maven:wrapper -Dmaven=3.3.3
```
