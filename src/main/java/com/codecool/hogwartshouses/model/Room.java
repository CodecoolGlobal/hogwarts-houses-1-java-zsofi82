package com.codecool.hogwartshouses.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data is a convenient shortcut annotation that creates simple POJO’s (Plain Old Java Object)
// @ToString
// @EqualsAndHashCode
// @Getter / @Setter
// @RequiredArgsConstructor
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    Long id;

    public Long getId() {
        return id;
    }
}
