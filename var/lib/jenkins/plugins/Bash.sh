# 1. Build the plugin locally
mvn clean package

# 2. Push the .hpi file directly into the Incus container
incus file push target/credentials.hpi jenkins-test-container/var/lib/jenkins/plugins/credentials.hpi

# 3. Set correct ownership (Jenkins user usually owns the plugins directory)
incus exec jenkins-test-container -- ash -c "chown jenkins:jenkins /var/lib/jenkins/plugins/credentials.hpi"

# 4. Restart Jenkins to load the new plugin version
incus exec jenkins-test-container -- ash -c "systemctl restart jenkins || service jenkins restart"
