package se331.lab.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {
}
