package org.example.redis;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Language {
    private String language;
    private Boolean isOfficial;
    private BigDecimal percentage;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Language language1 = (Language) o;
        return Objects.equals(language, language1.language) && Objects.equals(isOfficial, language1.isOfficial) && Objects.equals(percentage, language1.percentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, isOfficial, percentage);
    }
}
