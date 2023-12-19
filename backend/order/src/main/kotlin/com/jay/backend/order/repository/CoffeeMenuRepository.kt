package com.jay.backend.order.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CoffeeMenuRepository : JpaRepository<> {

}