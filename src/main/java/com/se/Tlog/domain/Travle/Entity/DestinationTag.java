package com.se.Tlog.domain.Travle.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DestinationTag {
	@EmbeddedId
	private DestinationTagPK id;

	@ManyToOne
	@MapsId("destination_id")
	@JoinColumn
	private Destination destination;
	
	@ManyToOne
	@MapsId("tag_id")
	@JoinColumn
	private Tag tag;
	
	@Builder
	public DestinationTag(Destination destination, Tag tag) {
		this.destination = destination;
		this.tag = tag;
		this.id = new DestinationTagPK(destination.getId(), tag.getId());
	}
}
