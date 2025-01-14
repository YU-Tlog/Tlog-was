package com.se.Tlog.domain.Travle.Entity;

import com.se.Tlog.domain.User.Entity.User;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne
	@JoinColumn
	private Destination destination;
	
	private int rating;
	
	private String content;
	
	/*
	@OneToMany(mappedBy = "")
	private List<Media> media;
	*/ 
	
	@Builder
	public Review(
			@NonNull User user,
			@NonNull Destination destination,
			int rating,
			@NonNull String content) {
		this.user = user;
		this.destination = destination;
		this.rating = rating;
		this.content = content;
	}
}
