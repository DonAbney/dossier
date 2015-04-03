package com.pillartechnology.dossier

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Blog)
class BlogSpec extends Specification {

    def blog

    void "blog should always have a uri"() {
        when:
            blog = new Blog("Some URL")
        then: 
            blog.uri == "Some URL"
    }
}
