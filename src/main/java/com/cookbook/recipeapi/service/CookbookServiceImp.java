/**
 * 
 */
package com.cookbook.recipeapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.recipeapi.dto.RecipeDTO;
import com.cookbook.recipeapi.exception.ResourceNotFoundException;
import com.cookbook.recipeapi.model.Ingredients;
import com.cookbook.recipeapi.model.Recipe;
import com.cookbook.recipeapi.repository.RecipeRepository;
import com.cookbook.recipeapi.util.DateTimeUtility;

/**
 * @author heman
 *
 *Abstract methods are implemented in this class
 */
@Service
public class CookbookServiceImp implements CookbookService {

	@Autowired
	private RecipeRepository recipeRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<RecipeDTO> getAllRecipes() {

		List<Recipe> recipeList = recipeRepository.findAll();
		List<RecipeDTO> recipeDTOList = recipeList.stream().map(recipe -> modelMapper.map(recipe, RecipeDTO.class)).collect(Collectors.toList());

		return recipeDTOList;

	}

	@Override
	public RecipeDTO findRecipeById(Long id) {
		Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Record Found With Given ID: " + id));
		return modelMapper.map(recipe, RecipeDTO.class);
	}

	@Override
	public List<RecipeDTO> findByCustomerrating(Integer rating)
	{
		List<Recipe> recipeList = recipeRepository.findByrating(rating);
		//List<Recipe> recipeList1 = Optional.of(recipeList).filter(a->!a.isEmpty()).orElseThrow(()->new NoContentException("No content"));
		List<RecipeDTO> recipeDTOList = recipeList.stream().map(recipe -> modelMapper.map(recipe, RecipeDTO.class))
				.collect(Collectors.toList());

		return recipeDTOList;	
	}
	
	@Override
	public List<RecipeDTO> findBySufficiency(Integer numberofpeople)
	{
		List<Recipe> recipeList = recipeRepository.findBynumberOfPeople(numberofpeople);
		List<RecipeDTO> recipeDTOList = recipeList.stream().map(recipe -> modelMapper.map(recipe, RecipeDTO.class))
				.collect(Collectors.toList());

		return recipeDTOList;
	}

	@Override
	public String saveRecipe(RecipeDTO recipeDTO) {
		Recipe recipe = modelMapper.map(recipeDTO, Recipe.class);
		recipe.setCreatedDateTime(DateTimeUtility.getLocalDateTime());
		recipeRepository.save(recipe);
		return "Your recipe has been saved";
	}

	@Override
	public RecipeDTO updateRecipe(RecipeDTO recipeDTO, Long id) {
		Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Record Found With Given ID: " + id));
		recipe.setMastercheftips(recipeDTO.getMastercheftips());
		recipe.setCookingInstructions(recipeDTO.getCookingInstructions());
		recipe.setCreatedDateTime(DateTimeUtility.getLocalDateTime());
		List<Ingredients> ingredientList = recipeDTO.getIngredientsList().stream()
				.map(ingredientDto -> modelMapper.map(ingredientDto, Ingredients.class)).collect(Collectors.toList());
		recipe.setIngredientsList(ingredientList);
		recipe.setIsVegetarian(recipeDTO.getIsVegetarian());
		recipe.setRating(recipeDTO.getRating());
		recipe.setNumberOfPeople(recipeDTO.getNumberOfPeople());
		recipe.setName(recipeDTO.getName());
		Recipe updaterecipe = recipeRepository.save(recipe);
		return modelMapper.map(updaterecipe, RecipeDTO.class);
	}

	@Override
	public String deleteRecipeById(Long id) {
		Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Record Found With Given ID: " + id));
		recipeRepository.delete(recipe);
		return "Recipe deleted from cookbook";
	}

}
