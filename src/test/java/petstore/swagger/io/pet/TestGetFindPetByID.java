package petstore.swagger.io.pet;

import domainentitites.PetMethods;
import org.junit.Test;

public class TestGetFindPetByID {
    PetMethods petMethods = new PetMethods();

    @Test
    public void searchWithExistingPetID() {
        petMethods.canFindPetByIDAndAssertStatus("pet","1",200);
    }
    @Test
    public void searchWithNonExistingPetID() {
        petMethods.canFindPetByIDAndAssertStatus("pet","123211",404);
    }
    @Test
    public void searchWithInvalidPetID() {
        petMethods.canFindPetByIDAndAssertStatus("pet","abd#$%",400);
    }
    @Test
    public void searchWithEmptyPetID() {
        petMethods.canFindPetByIDAndAssertStatus("pet","",405);
    }
}
