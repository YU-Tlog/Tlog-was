package com.se.Tlog.domain.Travle.Entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class DestinationTagPK implements Serializable {
	private int destination_id;
	private int tag_id;
}
