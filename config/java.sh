#java path and m2 directory on linux (add to /etc/profile.d/)
JAVA_HOME=/opt/java/jdk-17.0.10
PATH=$PATH:$HOME/bin:$JAVA_HOME/bin
export JAVA_HOME
export PATH
#after create file and add text run this command
sudo chmod 755 java.sh