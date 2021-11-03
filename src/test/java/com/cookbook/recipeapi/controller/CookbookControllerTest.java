/**
 * 
 */
package com.cookbook.recipeapi.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cookbook.recipeapi.service.CookbookService;
import com.cookbook.recipeapi.dto.IngredientsDTO;
import com.cookbook.recipeapi.dto.RecipeDTO;
import com.cookbook.recipeapi.repository.RecipeRepository;


/**
 * This test class contains CookbookController Junit test cases.
 * 
 * @author heman
 *
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CookbookControllerTest {
	

	@InjectMocks
	private CookbookController cookbookController;

	@Mock
	private CookbookService  cookbookService;

	@Mock
	private RecipeRepository recipeRepository;

	@Mock
	private ModelMapper modelMapper;
	
	List<RecipeDTO> recipeDTOList = null;
	RecipeDTO recipeDTO1 = null;
	
	/**
	 * mock data for recipe dto using parameterized constrcutor
	 */
	
	@BeforeEach
	public void init() {
		List<IngredientsDTO> ingredientDTOList = new ArrayList<>();
		IngredientsDTO ingredientDTO1 = new IngredientsDTO(Long.valueOf("1"), "Fish");
		IngredientsDTO ingredientDTO2 = new IngredientsDTO();
		ingredientDTO2.setId(Long.valueOf("2"));
		ingredientDTO2.setName("salt");
		ingredientDTO2.getId();
		ingredientDTO2.getName();
		ingredientDTOList.add(ingredientDTO1);
		ingredientDTOList.add(ingredientDTO2);
		recipeDTO1 = new RecipeDTO(Long.valueOf("1"), "Fish curry", 10,3, "02-11-2021 22:28", true,
				ingredientDTOList,
				"Add marinated fish,add tamarind juice,fried onion,tomatoes,salt,coriander leaves","wash fishes with salt");
		RecipeDTO recipeDTO2 = new RecipeDTO();
		recipeDTO2.setCookingInstructions(
				"Add marinated fish,add tamarind juice,fried onion,tomatoes,salt,coriander leaves");
		recipeDTO2.setCreatedDateTime("02-11-2021 22:28");
		recipeDTO2.setId(Long.valueOf("2"));
		recipeDTO2.setIngredientsList(ingredientDTOList);
		recipeDTO2.setIsVegetarian(true);
		recipeDTO2.setMastercheftips("wash fish with salt");
		recipeDTO2.setName("Test Recipe");
		recipeDTO2.setNumberOfPeople(12);
		recipeDTO2.setRating(3);
		recipeDTO2.getCookingInstructions();
		recipeDTO2.getMastercheftips();
		recipeDTO2.getRating();
		recipeDTO2.getCreatedDateTime();
		recipeDTO2.getId();
		recipeDTO2.getIngredientsList();
		recipeDTO2.getIsVegetarian();
		recipeDTO2.getName();
		recipeDTO2.getNumberOfPeople();

	    recipeDTOList = new ArrayList<>();
		recipeDTOList.add(recipeDTO1);
		recipeDTOList.add(recipeDTO2);
	}
	
	/**
	 * Test case to test  get all recipes in controller
	 */
	
	@Test
	void getAllRecipeTest()
	{
		when(cookbookService.getAllRecipes()).thenReturn(recipeDTOList);
		List<RecipeDTO> recipeList = cookbookController.getAllRecipe();
		assertThat(recipeList).hasSize(2);
		assertNotNull(recipeList);
	}
	
	/**
	 * This test case to check get recipe by Id
	 */
	@Test
	 void FindByRecipeIdTest() {
		when(cookbookService.findRecipeById(Mockito.anyLong())).thenReturn(dtoData());
		RecipeDTO recipe = cookbookController.findRecipe(1L);
		assertNotNull(recipe);
		assertThat(recipe.getId()).isEqualTo(1);
	}
	
	/**
	 * This test case to check get recipe by rating
	 */
	@Test
	 void findByIdratingTest() {
		when(cookbookService.findByCustomerrating(Mockito.any())).thenReturn(Arrays.asList(dtoData()));
		List<RecipeDTO> recipeList = cookbookController.findByIdrating(3);
		assertNotNull(recipeList);
		assertThat(recipeList).hasSize(1);
	}
	
	/**
	 * This test case to check get recipe by succes
	 */
	@Test
	 void findBySufficiencyTest() {
		when(cookbookService.findBySufficiency(2)).thenReturn(Arrays.asList(dtoData()));
		List<RecipeDTO> recipeList = cookbookController.findBySufficiency(2);
		assertNotNull(recipeList);
		assertThat(recipeList).hasSize(1);
	}
	
	
	/**
	 * This test case for insert Recipe
	 */
	@Test
	 void testCreateRecipe() {
		when(cookbookService.saveRecipe(Mockito.any())).thenReturn("Your recipe has been saved");
		String message = cookbookController.insertRecipe(dtoData());
		assertEquals("Your recipe has been saved", message);
	}
	
	/**
	 * This test case for update recipe
	 */
	@Test
	public void testUpdateRecipe() {
		when(cookbookService.updateRecipe(Mockito.any(), Mockito.anyLong())).thenReturn(dtoData());
		RecipeDTO updatedRecipe = cookbookController.updateRecipe(dtoData(), 1l);
		assertEquals(updatedRecipe.getName(), dtoData().getName());
	}

	/**
	 * This test case for delete recipe
	 */
	@Test
	public void testDeleteRecipe() {
		ResponseEntity<RecipeDTO> response = cookbookController.deleteRecipe(1l);
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	/**
	 * mock data for recipe dto
	 */
	private static RecipeDTO dtoData() {
		RecipeDTO recipeDTO = new RecipeDTO();
		List<IngredientsDTO> ingredientList = new ArrayList<>();
		IngredientsDTO ingredientOne = new IngredientsDTO(1l, "Chicken");
		IngredientsDTO ingredientTwo = new IngredientsDTO(2l, "Onions");
		ingredientList.add(ingredientOne);
		ingredientList.add(ingredientTwo);
		recipeDTO.setId(1l);
		recipeDTO.setCookingInstructions(
				"Fry onion then add chilli,ginger garlic and add marinate chicken");
		recipeDTO.setCreatedDateTime("02-11-2021 09:30");
		recipeDTO.setIngredientsList(ingredientList);
		recipeDTO.setMastercheftips("Cook on low flame");
		recipeDTO.setRating(3);
		recipeDTO.setIsVegetarian(true);
		recipeDTO.setName("Rayalaseema chicken gravy");
		recipeDTO.setNumberOfPeople(2);
		return recipeDTO;
	}
	
	
	
	

}
