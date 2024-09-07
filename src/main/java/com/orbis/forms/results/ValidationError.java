package com.orbis.forms.results;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public record ValidationError(String field, String message) {
}