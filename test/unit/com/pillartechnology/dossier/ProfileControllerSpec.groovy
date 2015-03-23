package com.pillartechnology.dossier



import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.test.mixin.*
import groovy.json.JsonSlurper

import spock.lang.*

@TestFor(ProfileController)
@Mock(Profile)
class ProfileControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params['name'] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The response is correct"
            def jsonSlurper = new JsonSlurper()
            def actualProfile = jsonSlurper.parseText(response.text)

            //actualProfile instanceof Profile
            actualProfile.name == "Test"
            response.status == OK.value
    }
}
