package petstore.swagger.io.pet;

import domainentitites.PetMethods;
import org.junit.Test;

public class TestDeleteDeletesAPet {
    PetMethods petMethods = new PetMethods();

    @Test
    public void deleteExistingPetID() {
        petMethods.canFindPetByIDAndAssertStatus("pet","1010",200);
    }
    @Test
    public void tryDeleteingNonExistingPetID() {
        petMethods.canFindPetByIDAndAssertStatus("pet","6281930314171690275",200);
    }
}
