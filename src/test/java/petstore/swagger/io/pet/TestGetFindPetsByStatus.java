package petstore.swagger.io.pet;

import domainentitites.PetMethods;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestGetFindPetsByStatus {
    PetMethods petMethods = new PetMethods();

    @Test
    public void searchWithStatusAvailable() {
        List<String> arguments = new ArrayList<>();
        arguments.add("available");
        petMethods.canFindPetByStatusAndAssertStatus("pet/findByStatus","status",arguments,200);
    }
    @Test
    public void searchWithStatusPending() {
        List<String> arguments = new ArrayList<>();
        arguments.add("pending");
        petMethods.canFindPetByStatusAndAssertStatus("pet/findByStatus","status",arguments,200);
    }
    @Test
    public void searchWithStatusSold() {
        List<String> arguments = new ArrayList<>();
        arguments.add("sold");
        petMethods.canFindPetByStatusAndAssertStatus("pet/findByStatus","status",arguments,200);
    }
    @Test
    public void searchWithAllThreeStatus() {
        List<String> arguments = new ArrayList<>();
        arguments.add("available");
        arguments.add("pending");
        arguments.add("sold");
        petMethods.canFindPetByStatusAndAssertStatus("pet/findByStatus","status",arguments,200);
    }
    @Test
    public void searchWithAvailableAndPending() {
        List<String> arguments = new ArrayList<>();
        arguments.add("available");
        arguments.add("pending");
        petMethods.canFindPetByStatusAndAssertStatus("pet/findByStatus","status",arguments,200);
    }
    @Test
    public void searchWithAvailableAndSold() {
        List<String> arguments = new ArrayList<>();
        arguments.add("available");
        arguments.add("sold");
        petMethods.canFindPetByStatusAndAssertStatus("pet/findByStatus","status",arguments,200);
    }
    @Test
    public void searchWithPendingAndSold() {
        List<String> arguments = new ArrayList<>();
        arguments.add("pending");
        arguments.add("sold");
        petMethods.canFindPetByStatusAndAssertStatus("pet/findByStatus","status",arguments,200);
    }

    @Test
    public void searchWithEmptyArgument() {
        List<String> arguments = new ArrayList<>();
        petMethods.canFindPetByStatusAndAssertStatus("pet/findByStatus","status",arguments,404);
    }
    @Test
    public void searchWithInvalidArgument() {
        List<String> arguments = new ArrayList<>();
        arguments.add("random");
        petMethods.canFindPetByStatusAndAssertStatus("pet/findByStatus","status",arguments,404);
    }
}
