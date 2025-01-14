package com.se.Tlog.domain.Travle.Entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
public class TravelCourseDestination {
	@Embeddable
	@EqualsAndHashCode
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	@Getter
	public static class PK {
		private int travelCourseId;
		private int destinationId;
	}
	
	@EmbeddedId
	private PK id;
	
	@ManyToOne
	@JoinColumn
	@MapsId("travelCourseId")
	private TravelCourse travelCourse;

	@ManyToOne
	@JoinColumn
	@MapsId("destinationId")
	private Destination destination;
	
	@Builder
	public TravelCourseDestination(@NonNull TravelCourse travelCourse, @NonNull Destination destination) {
		this.travelCourse = travelCourse;
		this.destination = destination;
		this.id = new PK(travelCourse.getId(), destination.getId());
	}
}
