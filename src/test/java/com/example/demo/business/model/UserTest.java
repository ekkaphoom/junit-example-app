package com.example.demo.business.model;

import static io.github.benas.randombeans.EnhancedRandomBuilder.aNewEnhancedRandom;
import static io.github.benas.randombeans.EnhancedRandomBuilder.aNewEnhancedRandomBuilder;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.benas.randombeans.api.EnhancedRandom;
import io.github.benas.randombeans.api.Randomizer;

@RunWith(SpringRunner.class)
public class UserTest {
	private EnhancedRandom enhancedRandom = aNewEnhancedRandom();
	private EnhancedRandom enhancedRandomBuilder = aNewEnhancedRandomBuilder()
			.randomize(OffsetDateTime.class, (Randomizer<OffsetDateTime>) this::getOffsetDateTime)//
			.randomize(Integer.class, (Randomizer<Integer>) this::getInteger)//
			.build();

	@Test
	public void generateUser() {
		User user = enhancedRandom.nextObject(User.class);
		System.out.println("######### UserClass #############");
		System.out.println(user.toString());
	}

	@Test
	public void generateUser_WithBuilder() {
		User user = enhancedRandomBuilder.nextObject(User.class);
		System.out.println("######### UserClass with Builder #############");
		System.out.println(user.toString());
	}

	private OffsetDateTime getOffsetDateTime() {
		LocalDateTime localDate = LocalDateTime.now();
		OffsetDateTime offsetDateTime = OffsetDateTime.now();
		ZoneId systemZone = ZoneOffset.systemDefault();
		ZoneOffset offset = systemZone.getRules().getOffset(localDate);
		System.out.println("localDate: " + localDate);
		System.out.println("systemZone: " + systemZone);
		System.out.println("offset: " + offset);
		System.out.println("offsetDateTime: " + offsetDateTime);
		return OffsetDateTime.of(localDate, offset);
	}

	private Integer getInteger() {
		int min = 20;
		int max = 40;
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
}