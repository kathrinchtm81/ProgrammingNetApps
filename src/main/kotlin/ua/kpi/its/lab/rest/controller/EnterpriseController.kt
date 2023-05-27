package ua.kpi.its.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.EnterpriseRequest
import ua.kpi.its.lab.rest.dto.EnterpriseResponse
import ua.kpi.its.lab.rest.svc.impl.EnterpriseServiceImpl


@RestController
@RequestMapping("/api/enterprise")
class EnterpriseController {

    private final lateinit var enterpriseServiceImpl1: EnterpriseServiceImpl;

    @Autowired
    fun EnterpriseController(enterpriseServiceImpl: EnterpriseServiceImpl) {
        this.enterpriseServiceImpl1 = enterpriseServiceImpl;
    }

    @GetMapping("/{id}")
    fun getEnterpriseById(@PathVariable Long id): ResponseEntity<EnterpriseResponse>? {
        val enterpriseResponse: EnterpriseResponse = enterpriseServiceImpl1.getEnterpriseById(id);
        if (enterpriseResponse == null) {
            println("Enterprise with id " + id + " not found")
        }
        return ResponseEntity.ok(enterpriseResponse);
    }

    @PostMapping("/")
    fun createEnterprise(@Valid @RequestBody enterpriseRequest: EnterpriseRequest?): ResponseEntity<EnterpriseResponse>? {
        val enterpriseResponse: EnterpriseResponse? = enterpriseRequest?.let { enterpriseServiceImpl1.createEnterprise(it) }
        return ResponseEntity.status(HttpStatus.CREATED).body<EnterpriseResponse>(enterpriseResponse)
    }

    @PutMapping("/{id}")
    fun updateEnterprise(
        @PathVariable id: Long,
        @Valid @RequestBody enterpriseRequest: EnterpriseRequest?
    ): ResponseEntity<EnterpriseResponse>? {
        val enterpriseResponse: EnterpriseResponse? = enterpriseRequest?.let { enterpriseServiceImpl1.updateEnterprise(id, it) }
        return ResponseEntity.ok<EnterpriseResponse>(enterpriseResponse)
    }

    @DeleteMapping("/{id}")
    fun deleteEnterprise(@PathVariable id: Long): ResponseEntity<Void?>? {
        val isDeleted: Boolean = enterpriseServiceImpl1.deleteEnterprise(id)
        if (!isDeleted) {
            println("Enterprise with id $id not found")
        }
        return ResponseEntity.noContent().build()
    }
}