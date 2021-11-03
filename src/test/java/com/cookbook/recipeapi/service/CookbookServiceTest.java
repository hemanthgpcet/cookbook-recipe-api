package com.cookbook.recipeapi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cookbook.recipeapi.dto.IngredientsDTO;
import com.cookbook.recipeapi.dto.RecipeDTO;
import com.cookbook.recipeapi.model.Ingredients;
import com.cookbook.recipeapi.model.Recipe;
import com.cookbook.recipeapi.repository.RecipeRepository;
import com.cookbook.recipeapi.exception.ResourceNotFoundException;

/**
 * This class is for CookbookServiceTest test with Junit 
 * 
 * @author heman
 *
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CookbookServiceTest {
	
	@InjectMocks
	private CookbookServiceImp cookbookServiceImp;
	
	@Mock
	private RecipeRepository recipeRepository;
	
	@Mock
	private ModelMapper modelMapper;
	
	/**
	 * Test case to check getAllRecipes
	 */
	@Test
	@DisplayName("Test case for getAllRecipes")
	public void testgetAllRecipes() {
		when(recipeRepository.findAll()).thenReturn(Arrays.asList(entityData()));
		when(modelMapper.map(Mockito.any(), Mockito.eq(RecipeDTO.class))).thenReturn(dtoData());
		List<RecipeDTO> expecteddata = cookbookServiceImp.getAllRecipes();
		assertThat(expecteddata).hasSize(1);
		assertEquals(1, expecteddata.get(0).getId());
		assertEquals("Cook on low flame", expecteddata.get(0).getMastercheftips());
	}
	
	
	/**
	 * Test case to check recipe by ID
	 */
	@Test
	@DisplayName("Test case for findRecipeById")
	public void testfindRecipeById()
	{
		when(recipeRepository.findById(1l)).thenReturn(Optional.of(entityData()));
		when(modelMapper.map(Mockito.any(), Mockito.eq(RecipeDTO.class))).thenReturn(dtoData());
		RecipeDTO expecteddata = cookbookServiceImp.findRecipeById(1L);
		assertThat(expecteddata.getId()).isEqualTo(1);
		assertThat(expecteddata.getName()).isEqualTo("Rayalaseema chicken gravy");
		assertNotNull(expecteddata);
	}
	
	/**
	 * Test case to check else condition in findByRecipeId
	 */
	@Test
	@DisplayName("Test case for findByRecipe Exception")
	public void testfindRecipeByIdException() {
		when(recipeRepository.findById(5l))
				.thenThrow(new ResourceNotFoundException("No Record Found With Given ID: 5"));
		Throwable exception = assertThrows(ResourceNotFoundException.class,
				() -> cookbookServiceImp.findRecipeById(5l));
		assertEquals("No Record Found With Given ID: 5", exception.getMessage());
	}
	
	/**
	 * Test case to check recipe by rating
	 */
	
	@Test
	@DisplayName("Test case for findByCustomerrating")
	public void testfindByCustomerrating()
	{
		when(recipeRepository.findByrating(3)).thenReturn(Arrays.asList(entityData()));
		when(modelMapper.map(Mockito.any(), Mockito.eq(RecipeDTO.class))).thenReturn(dtoData());
		List<RecipeDTO> expecteddata = cookbookServiceImp.findByCustomerrating(3);
		assertThat(expecteddata.get(0).getName()).isEqualTo("Rayalaseema chicken gravy");
		assertNotNull(expecteddata);
	}
	
	/**
	 * Test case to check recipe by sufficient fot number of people
	 */
	
	@Test
	@DisplayName("Test case for findBySufficiency")
	public void testfindBySufficiency()
	{
		when(recipeRepository.findBynumberOfPeople(2)).thenReturn(Arrays.asList(entityData()));
		when(modelMapper.map(Mockito.any(), Mockito.eq(RecipeDTO.class))).thenReturn(dtoData());
		List<RecipeDTO> expecteddata = cookbookServiceImp.findBySufficiency(2);
		assertThat(expecteddata.get(0).getNumberOfPeople()).isEqualTo(2);
		assertNotNull(expecteddata);
	}
	

	
	/**
	 * Test case to check create Recipe
	 */
	
	@Test
	public void testSaveRecipe() {
		Recipe recentity = entityData();
		when(modelMapper.map(Mockito.any(), Mockito.eq(Recipe.class))).thenReturn(recentity);
		String msg=cookbookServiceImp.saveRecipe(dtoData());
		assertNotNull(msg);
		assertEquals("Your recipe has been saved", msg);	
		
	}

	/**
	 * Test case to check updateRecipe
	 */
	@Test
	@DisplayName("Test case for updateRecipe")
	public void testUpdateRecipe() {
		Ingredients ing = new Ingredients(1l, "Fish");
		given(recipeRepository.findById(1l)).willReturn(Optional.of(entityData()));
		when(modelMapper.map(Mockito.any(), Mockito.eq(Ingredients.class))).thenReturn(ing);
		when(recipeRepository.save(Mockito.any())).thenReturn(entityData());
		when(modelMapper.map(Mockito.any(), Mockito.eq(RecipeDTO.class))).thenReturn(dtoData());
		RecipeDTO recipeDTO = cookbookServiceImp.updateRecipe(dtoData(), 1l);
		assertNotNull(recipeDTO);
		assertThat(recipeDTO.getId()).isEqualTo(1);
	}
	
	/**
	 * Test case to check deleteRecipe
	 */
	@Test
	@DisplayName("Test case for deleteRecipe")
	public void testDeleteRecipe() {
		when(recipeRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(entityData()));
		String msg = cookbookServiceImp.deleteRecipeById(1l);
		assertEquals("Recipe deleted from cookbook", msg);
	}
	
	
	
	
	
	/**
	 * mock data for recipe entity
	 */
	private static Recipe entityData() {
		Recipe recipe = new Recipe();
		List<Ingredients> ingredientList = new ArrayList<>();
		Ingredients ingredientOne = new Ingredients(1l, "Chicken");
		Ingredients ingredientTwo = new Ingredients(2l, "Onions");
		ingredientList.add(ingredientOne);
		ingredientList.add(ingredientTwo);
		recipe.setId(1l);
		recipe.setCookingInstructions(
				"Fry onion then add chilli,ginger garlic and add marinate chicken");
		recipe.setCreatedDateTime("02-11-2021 09:30");
		recipe.setIngredientsList(ingredientList);
		recipe.setMastercheftips("Cook on low flame");
		recipe.setRating(3);
		recipe.setIsVegetarian(true);
		recipe.setName("Rayalaseema chicken gravy");
		recipe.setNumberOfPeople(2);
		return recipe;
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
