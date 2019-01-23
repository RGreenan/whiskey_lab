package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findWhiskyByYear(){
		List<Whisky> found = whiskyRepository.findWhiskyByYear(2018);
		assertEquals(2, found.size());
	}

	@Test
	public void findDistilleryByRegion(){
		List<Distillery> found = distilleryRepository.findDistilleryByRegion("Speyside");
		assertEquals(2, found.size());
	}

	@Test
	public void findWhiskyByDistilleryAndAge(){
		List<Whisky> found = whiskyRepository.findWhiskyByDistilleryAndAge( 1L, 12 );
		assertEquals(1, found.size());
	}

	@Test
	public void findWhiskyWithRegionNamed(){
		List<Whisky> found = whiskyRepository.findWhiskyWithRegionNamed("Highland");
		assertEquals(2, found.size());
	}

	@Test
	public void findDistilleryWithWhiskyAged(){
		List<Distillery> found = distilleryRepository.findDistilleryWithWhiskyAged(12);
		assertEquals(2, found.size());
	}

}
