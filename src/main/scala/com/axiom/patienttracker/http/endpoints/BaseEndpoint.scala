package com.axiom.patienttracker.http.endpoints

import sttp.tapir.*
import com.axiom.patienttracker.domain.errors.HttpError

trait BaseEndpoint:
    val baseEndpoint = endpoint
        .errorOut(statusCode and plainBody[String])// returns (StatusCode, String)
        //takes two arugment list
        //signature of argument list is depending upon what we write in errorOut
        .mapErrorOut[Throwable](HttpError.decode)(HttpError.encode)
        
