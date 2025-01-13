package com.se.Tlog.domain.Travle.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy = "tag")
	private List<DestinationTag> destinationList = new ArrayList<>();
	
	@Builder
	public Tag(String name) {
		this.name = name;
	}
}
