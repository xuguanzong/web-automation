pipeline {
  agent none
  stages {
    stage('Build') {
      steps {
        build(propagate: true, job: 'pipeline')
      }
    }
  }
}