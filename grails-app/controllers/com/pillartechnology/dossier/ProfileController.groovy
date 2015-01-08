package com.pillartechnology.dossier



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProfileController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        //respond Profile.list(params), [status: OK]
        respond new Profile(), [status: OK]
    }

    @Transactional
    def save(Profile profileInstance) {
        if (profileInstance == null) {
            render status: NOT_FOUND
            return
        }

        profileInstance.validate()
        if (profileInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        profileInstance.save flush:true
        respond profileInstance, [status: CREATED]
    }

    @Transactional
    def update(Profile profileInstance) {
        if (profileInstance == null) {
            render status: NOT_FOUND
            return
        }

        profileInstance.validate()
        if (profileInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        profileInstance.save flush:true
        respond profileInstance, [status: OK]
    }

    @Transactional
    def delete(Profile profileInstance) {

        if (profileInstance == null) {
            render status: NOT_FOUND
            return
        }

        profileInstance.delete flush:true
        render status: NO_CONTENT
    }
}
