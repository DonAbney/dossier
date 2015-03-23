package com.pillartechnology.dossier

import grails.test.spock.IntegrationSpec
import groovy.json.JsonSlurper

class ProfileControllerIntegrationSpec extends IntegrationSpec {

    void "test profile controller returns a profile with a blog"() {
        ProfileController profileController

        setup:
            profileController = new ProfileController()
        when:
            profileController.index()

        then:
            def jsonSlurper = new JsonSlurper()
            def actualProfile = jsonSlurper.parseText(profileController.response.text)
            actualProfile.blog != null
    }
}
