#config manual java in linux with terminal
. /etc/profile
sudo update-alternatives --install "/usr/bin/java" "java" "/opt/java/jdk-17.0.10/bin/java" 1
sudo update-alternatives --install "/usr/bin/javac" "javac" "/opt/java/jdk-17.0.10/bin/javac" 1
sudo update-alternatives --set java /opt/java/jdk-17.0.10/bin/java
#choose java
sudo update-alternatives --config java
java --version
#source files
source /etc/profile.d/java.sh
source /etc/profile.d/maven.sh