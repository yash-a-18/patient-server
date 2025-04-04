package com.axiom.patienttracker.http

import com.axiom.patienttracker.http.controllers.*

object HttpApi:
    def gatherRoutes(controllers: List[BaseController]) =
        controllers.flatMap(_.routes)

    def makeControllers = for {
        patients <- PatientController.makeZIO
        reports <- ReportController.makeZIO
        users <- UserController.makeZIO
        files <- FileController.makeZIO
        // Keep adding controllers here
    } yield List(patients, reports, users, files)

    val endpointsZIO = makeControllers.map(gatherRoutes)

