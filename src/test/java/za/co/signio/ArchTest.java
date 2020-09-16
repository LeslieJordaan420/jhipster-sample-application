package za.co.signio;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("za.co.signio");

        noClasses()
            .that()
            .resideInAnyPackage("za.co.signio.service..")
            .or()
            .resideInAnyPackage("za.co.signio.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..za.co.signio.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
