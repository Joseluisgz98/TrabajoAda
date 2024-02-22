package com.example.trabajoada.Controller

import com.example.trabajoada.Servicios.PaqueteService
import com.example.trabajoada.Servicios.RepartidorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(path=["/paquete"])
class PaqueteController {

    @Autowired
    private val paqueteService: PaqueteService? = null


}