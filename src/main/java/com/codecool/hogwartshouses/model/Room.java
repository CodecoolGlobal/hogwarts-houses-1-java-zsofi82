package com.codecool.hogwartshouses.model;

import lombok.*;
import java.util.Set;

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
    private Long id;
    private int capacity;
    @Singular
    private Set<Student> residents;

}
