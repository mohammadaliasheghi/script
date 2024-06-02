#maven path on linux (add to /etc/profile.d/)
export M2_HOME=/opt/maven
export MAVEN_HOME=/opt/maven
export PATH=${M2_HOME}/bin:${PATH}
#after create file and add text run this command
sudo chmod 755 maven.sh
