package com.example.programmingnetapps

import AppConfig
import Container
import Employee
import Enterprise
import EnterpriseContainer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.time.LocalDate

@SpringBootApplication
class ProgrammingNetAppsApplication

fun main() {
    val context = AnnotationConfigApplicationContext(AppConfig::class.java)
    val enterpriseContainer = context.getBean(Container::class.java) as EnterpriseContainer

    val employees1 = listOf<Employee>(
        Employee("Serhii Sternenko", LocalDate.of(2022, 2, 24), 4, "Middle", "Speaker", 10000.0, false),
        Employee("Serhii Prytula", LocalDate.of(2022, 2, 24), 4, "Max", "Ambassador", 20000.0, false),
    )

    val employees2 = listOf<Employee>(
        Employee("Volodymyr Zelensky", LocalDate.of(2019, 5, 20), 4, "Max", "President of Ukraine", 25000.0, false),
        Employee(
            "Valeriy Zaluzhniy",
            LocalDate.of(2021, 7, 27),
            4,
            "Max",
            "Commander-in-Chief of the Armed Forces of Ukraine",
            20000.0,
            false
        ),
    )

    enterpriseContainer.add(
        Enterprise(
            "Serhii Prytula Fund",
            "Ukrainian Armed Force, Drones",
            "Ukraine",
            1,
            LocalDate.of(2022, 2, 24),
            35000000,
            true,
            employees1
        ),
    )

    enterpriseContainer.add(
        Enterprise(
            "Government",
            "Policy ",
            "Ukraine",
            1,
            LocalDate.of(1991, 8, 24),
            35000000,
            true,
            employees2
        ),
    )
}
