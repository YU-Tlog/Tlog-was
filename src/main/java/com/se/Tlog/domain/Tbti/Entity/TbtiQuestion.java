package com.se.Tlog.domain.Tbti.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class TbtiQuestion {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String content;

    @Enumerated(EnumType.STRING)
    private TraitCategory traitCategory;

    @Builder
    public TbtiQuestion(String content, TraitCategory traitCategory) {
        this.content = content;
        this.traitCategory = traitCategory;
    }
}
