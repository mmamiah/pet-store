package com.mms.rbc.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.mms.rbc.dao.PetDao;
import com.mms.rbc.model.pet.Pet;
import com.mms.rbc.service.PetService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

/**
 * PetServiceImpl unit test
 */
@RunWith(MockitoJUnitRunner.class)
public class PetServiceImplTest {

	private PetService petService;

	@Mock
	private PetDao petDaoMock;
	
	@Mock
	private Pet petMock;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		petService = new PetServiceImpl(petDaoMock);
		
		Mockito.when(petDaoMock.save(petMock)).thenAnswer(new Answer<Pet>() {
			@Override
			public Pet answer(InvocationOnMock invocation) throws Throwable {
				Pet result = (Pet) invocation.getArguments()[0];
				result.setId(123l);
				return result;
			}
		});

		Mockito.when(petDaoMock.findOne(Matchers.anyLong())).thenAnswer(new Answer<Pet>() {
			@Override
			public Pet answer(InvocationOnMock invocation) throws Throwable {
				return petMock;
			}
		});
	}
	
	@Test
	public void shouldSavePet(){
		// Act
		Pet result = petService.save(petMock);
		
		// Assert
		Mockito.verify(petDaoMock).save(petMock);
		assertThat(result, is(petMock));
		Mockito.verify(petMock).setId(123l);
	}
	
	@Test
	public void shouldFindPet(){
		// Arrange
		long petId = 456;
		
		// Act
		Pet result = petService.findById(petId);

		// Assert
		Mockito.verify(petDaoMock).findOne(petId);
		assertThat(result, is(petMock));
	}
}