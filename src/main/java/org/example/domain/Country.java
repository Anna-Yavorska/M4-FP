package org.example.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(schema = "world", name = "country")
@Getter
@Setter
@NoArgsConstructor
public class Country {
    @Id
    @Column(name = "id")
    private Integer id;

    private String code;

    @Column(name = "code_2")
    private String alternativeCode;

    private String name;

    @Column(name = "continent")
    @Enumerated(EnumType.ORDINAL)
    private Continent continent;

    private String region;

    @Column(name = "surface_area")
    private BigDecimal surfaceArea;

    @Column(name = "indep_year")
    private Short independenceYear;

    private Integer population;

    @Column(name = "life_expectancy")
    private BigDecimal lifeExpectancy;

    @Column(name = "gnp")
    private BigDecimal GNP;

    @Column(name = "gnpo_id")
    private BigDecimal GNPOId;

    @Column(name = "local_name")
    private String localName;

    @Column(name = "government_form")
    private String governmentForm;

    @Column(name = "head_of_state")
    private String headOfState;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "capital")
    private City city;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Set<CountryLanguage> languages;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id) && Objects.equals(code, country.code) && Objects.equals(alternativeCode, country.alternativeCode) && Objects.equals(name, country.name) && Objects.equals(region, country.region) && Objects.equals(surfaceArea, country.surfaceArea) && Objects.equals(independenceYear, country.independenceYear) && Objects.equals(population, country.population) && Objects.equals(lifeExpectancy, country.lifeExpectancy) && Objects.equals(GNP, country.GNP) && Objects.equals(GNPOId, country.GNPOId) && Objects.equals(localName, country.localName) && Objects.equals(governmentForm, country.governmentForm) && Objects.equals(headOfState, country.headOfState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, alternativeCode, name, region, surfaceArea, independenceYear, population, lifeExpectancy, GNP, GNPOId, localName, governmentForm, headOfState);
    }
}
