package my.assignment.entity;

import lombok.*;
import my.assignment.entity.enumeration.StoryStatus;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "STORY")
public class StoryEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private StoryStatus status;

    private Integer points;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private DeveloperEntity developer;

    @CreatedDate
    private ZonedDateTime createdDate;
}
