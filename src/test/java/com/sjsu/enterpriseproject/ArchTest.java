package com.sjsu.enterpriseproject;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.sjsu.enterpriseproject");

        noClasses()
            .that()
                .resideInAnyPackage("com.sjsu.enterpriseproject.service..")
            .or()
                .resideInAnyPackage("com.sjsu.enterpriseproject.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.sjsu.enterpriseproject.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
