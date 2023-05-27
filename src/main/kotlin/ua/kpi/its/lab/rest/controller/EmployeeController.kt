package ua.kpi.its.lab.rest.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.EmployeeRequest
import ua.kpi.its.lab.rest.dto.EmployeeResponse
import ua.kpi.its.lab.rest.svc.impl.EmployeeServiceImpl

@RestController
@RequestMapping("/way")
class EmployeeController(private val employeeServiceImpl: EmployeeServiceImpl) {
    @PostMapping
    fun createEmployee(@RequestBody req: EmployeeRequest): ResponseEntity<EmployeeResponse> {
        val employeeResponse = employeeServiceImpl.createEmployee(req)
        return ResponseEntity(employeeResponse, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: Long): ResponseEntity<EmployeeResponse> {
        val employeeResponse = employeeServiceImpl.getEmployeeById(id)
        return ResponseEntity(employeeResponse, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateEmployee(@PathVariable id: Long, @RequestBody req: EmployeeRequest): ResponseEntity<EmployeeResponse> {
        val employeeResponse = employeeServiceImpl.updateEmployee(id, req)
        return ResponseEntity(employeeResponse, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: Long): ResponseEntity<Void> {
        employeeServiceImpl.deleteEmployee(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}