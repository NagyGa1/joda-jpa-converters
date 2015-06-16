package com.studium.joda.converters;

import java.sql.Timestamp;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.joda.time.LocalDateTime;

/**
 * Joda DateTime <-> JPA 2.1 converter
 */
@Converter(autoApply = true)
public class JodaLocalDateTimeConverter
		implements
			AttributeConverter<LocalDateTime, Timestamp> {

	public Timestamp convertToDatabaseColumn(LocalDateTime dateTime) {
		return dateTime == null ? null : new Timestamp(dateTime.toDate()
				.getTime());
	}

	public LocalDateTime convertToEntityAttribute(Timestamp date) {
		return date == null ? null : new LocalDateTime(date);
	}
}
