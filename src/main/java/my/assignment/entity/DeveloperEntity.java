package my.assignment.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id", "stories", "bugs"})
@Table(name = "DEVELOPER")
public class DeveloperEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "developer")
    private List<StoryEntity> stories;

    @OneToMany(mappedBy = "developer")
    private List<BugEntity> bugs;
}
