grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.repos.default = 'repo.thehyve.nl-snapshots'
grails.project.repos."${grails.project.repos.default}".url = 'https://repo.thehyve.nl/content/repositories/snapshots/'

grails.project.dependency.resolution = {
    log "warn"
    legacyResolve false

    repositories {
        mavenLocal()
        mavenRepo 'https://repo.thehyve.nl/content/repositories/public/'
    }

    dependencies {
        compile('org.transmartproject:transmart-core-api:1.0-SNAPSHOT')
        compile group: 'com.google.guava', name: 'guava', version: '14.0.1'

        runtime('org.postgresql:postgresql:9.3-1100-jdbc41') {
            transitive = false
            export     = false
        }
    }

    plugins {
        compile(':db-reverse-engineer:0.5') {
            export = false
        }

        build(':tomcat:2.2.4',
              ":release:2.2.1",
              ":rest-client-builder:1.0.3",
              ) {
            export = false
        }

        test ":code-coverage:1.2.6", {
            export = false
        }
    }
}
