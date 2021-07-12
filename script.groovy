def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'DOCKERCREDENTIALS', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t poornambiga/javaapp:jma1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push poornambiga/javaapp:jma1.0'
    }
}

def deployApp() {
    echo 'deploying the application...'
} 

return this
