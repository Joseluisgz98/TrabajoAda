package com.example.trabajoada.Repository

import com.example.trabajoada.Clases.Comprador
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CompradorRepository: CrudRepository<Comprador?, Int?> {
}