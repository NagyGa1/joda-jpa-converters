package com.studium.joda.converters;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.joda.time.*;
import org.junit.Test;

import com.studium.joda.converters.example.DateTimeContainingEntity;

/**
 * Created by nagygabor on 6/15/15.
 */
public class JodaPersistenceTest {

	private void testPersistEntity(final EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();

		DateTimeContainingEntity entity = new DateTimeContainingEntity();
		entity.setDateTime(DateTime.now());
		entity.setDuration(Duration.standardDays(2));
		entity.setInstant(Instant.now());
		entity.setInterval(new Interval(new DateTime(2011, 1, 1, 0, 0),
				new DateTime(2012, 1, 1, 0, 0)));
		entity.setLocalDate(LocalDate.now());
		entity.setLocalDateTime(LocalDateTime.now());

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(entity);
		tx.commit();

		tx = em.getTransaction();
		tx.begin();
		DateTimeContainingEntity result = em.find(
				DateTimeContainingEntity.class, entity.getId());
		tx.commit();

		assertEquals(entity.getDateTime(), result.getDateTime());
		assertEquals(entity.getDuration(), result.getDuration());
		assertEquals(entity.getInstant(), result.getInstant());
		assertEquals(entity.getInterval(), result.getInterval());
		assertEquals(entity.getLocalDate(), result.getLocalDate());
		assertEquals(entity.getLocalDateTime(), result.getLocalDateTime());

        em.close();
        emf.close();
	}

	@Test
	public void testEclipseLink() {
		testPersistEntity(Persistence
				.createEntityManagerFactory("jodaConverterTestPU_EclipseLink"));
	}

	@Test
	public void testHibernate() {
		testPersistEntity(Persistence
				.createEntityManagerFactory("jodaConverterTestPU_Hibernate"));
	}

}
