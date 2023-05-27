import java.time.LocalDate

data class Enterprise(
    val name: String,
    val industry: String,
    val legalAddress: String,
    val numberOfDivisions: Int,
    val dateOfEstablishment: LocalDate,
    val numberOfEmployees: Int,
    val VATPayer: Boolean,
    val employees: List<Employee>
) : Comparable<Enterprise> {
    override fun compareTo(enterprise: Enterprise): Int {
        val compare = name.compareTo(enterprise.name)
        return if (compare != 0) compare else legalAddress.compareTo(enterprise.legalAddress)
    }
}