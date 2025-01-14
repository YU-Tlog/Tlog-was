package com.se.Tlog.domain.Travel.Entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class DestinationTagPK implements Serializable {
	private Long destination_id;
	private Long tag_id;
}
