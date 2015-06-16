package com.studium.joda.converters.example;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.joda.time.*;

/**
 * Test Entity which includes the org.joda.time.DateTime object
 */
@Entity
public class DateTimeContainingEntity implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    //@Convert(converter = JodaDateTimeConverter.class) <--don't need to do this, autoApply is true
    private DateTime dateTime;

    private LocalDate localDate;

    private LocalDateTime localDateTime;

    private Duration duration;

    private Instant instant;

    private Interval interval;

    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDate getLocalDate()
    {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate)
    {
        this.localDate = localDate;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Duration getDuration()
    {
        return duration;
    }

    public void setDuration(Duration duration)
    {
        this.duration = duration;
    }

    public Instant getInstant()
    {
        return instant;
    }

    public void setInstant(Instant instant)
    {
        this.instant = instant;
    }

    public Interval getInterval()
    {
        return interval;
    }

    public void setInterval(Interval interval)
    {
        this.interval = interval;
    }
}
