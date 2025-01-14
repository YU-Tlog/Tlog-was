package com.se.Tlog.domain.Travel.Entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;

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
public class Destination {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String location;

	@OneToMany(mappedBy = "destination")
	private List<DestinationTag> tagList = new ArrayList<>();
	
	private int rating;
	
	@ColumnDefault("false")
	private boolean verified;
	
	public void addTag(Tag tag) {
		tagList.add(
				DestinationTag.builder()
				.destination(this)
				.tag(tag)
				.build());
	}
	
	public void verify() {
		this.verified = true;
	}
	
	@Builder
	public Destination(String name, String location, int rating) {
		this.name = name;
		this.location = location;
		this.rating = rating;
	}
}
