package com.se.Tlog.domain.Travle.Entity;

import java.util.ArrayList;
import java.util.List;
import com.se.Tlog.domain.User.Entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TravelCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@OneToMany
	private List<Destination> course = new ArrayList<Destination>();
	
	public void addDestination(Destination destination) {
		course.add(destination);
	}
	
	@Builder
	public TravelCourse(User user) {
		this.user = user;
	}
}
