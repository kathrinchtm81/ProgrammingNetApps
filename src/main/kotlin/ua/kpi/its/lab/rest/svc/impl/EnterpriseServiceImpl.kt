package ua.kpi.its.lab.rest.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.dto.EnterpriseRequest
import ua.kpi.its.lab.rest.dto.EnterpriseResponse
import ua.kpi.its.lab.rest.entity.Enterprise
import ua.kpi.its.lab.rest.repository.EnterpriseRepository
import ua.kpi.its.lab.rest.svc.EnterpriseService

@Service
class EnterpriseServiceImpl(private val enterpriseRepository: EnterpriseRepository) : EnterpriseService {
    override fun createEnterprise(enterpriseRequest: EnterpriseRequest): EnterpriseResponse {
        val enterprise = Enterprise(name = enterpriseRequest.name, industry = enterpriseRequest.industry)
        val savedEnterprise = enterpriseRepository.save(enterprise)
        return EnterpriseResponse.fromEntity(savedEnterprise)
    }

    override fun getEnterpriseById(id: Long): EnterpriseResponse {
        val enterprise = enterpriseRepository.findById(id).orElseThrow()
        return EnterpriseResponse.fromEntity(enterprise)
    }

    override fun updateEnterprise(id: Long, enterpriseRequest: EnterpriseRequest): EnterpriseResponse {
        val enterprise = enterpriseRepository.findById(id).orElseThrow()
        enterprise.model = enterpriseRequest.name
        enterprise.manufacturer = enterpriseRequest.industry
        val updatedEnterprise = enterpriseRepository.save(enterprise)
        return EnterpriseResponse.fromEntity(updatedEnterprise)
    }

    override fun deleteEnterprise(id: Long): Boolean {
        enterpriseRepository.deleteById(id)
        return true
    }
}