package com.example.trabajoada.Servicios

import com.example.trabajoada.Repository.CompradorRepository
import com.example.trabajoada.Repository.PaqueteRepository
import com.example.trabajoada.Repository.RepartidorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PaqueteService {
    @Autowired
    private val compradorRepository: CompradorRepository? = null
    @Autowired
    private val paqueteRepository: PaqueteRepository? = null
    @Autowired
    private val repartidorRepository: RepartidorRepository?= null

}