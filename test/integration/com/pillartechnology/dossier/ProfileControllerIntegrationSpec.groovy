package com.pillartechnology.dossier

import grails.test.spock.IntegrationSpec
import static org.springframework.http.HttpStatus.*
import groovy.json.JsonSlurper

class ProfileControllerIntegrationSpec extends IntegrationSpec {
    ProfileController controller


    def setup() {
    }

    def cleanup() {
    }

    void "test we are less retarded"() {

        when:
            controller = new ProfileController()

        then:
            def jsonSlurper = new JsonSlurper()
            def actualProfile = jsonSlurper.parsetext(response.text)

            actualProfile.name == "Test"
    }
}
