package se331.lab.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Org;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrgRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;


    final OrgRepository orgRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;
    @Override
     @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Participant p1,p2,p3,p4,p5;
        p1=participantRepository.save(Participant.builder()
                .name("Kan")
                .telNo("0811111111")
                .build());
        p2=participantRepository.save(Participant.builder()
                .name("Nan")
                .telNo("0822222222")
                .build());
        p3=participantRepository.save(Participant.builder()
                .name("Mint")
                .telNo("0833333333")
                .build());
        p4=participantRepository.save(Participant.builder()
                .name("Ploy")
                .telNo("0844444444")
                .build());
        p5=participantRepository.save(Participant.builder()
                .name("Ploy")
                .telNo("0844444444")
                .build());


                Organizer org1,org2,org3;
                org1=organizerRepository.save(Organizer.builder()
                        .name("CAMT").build());
                org2=organizerRepository.save(Organizer.builder()
                        .name("CMU").build());
                org3=organizerRepository.save(Organizer.builder()
                        .name("Chiang Mai").build());
                Event tempEvent;
                tempEvent = eventRepository.save(Event.builder()
                                .category("Academic")
                                .title("Midterm Exam")
                                .description("A time for taking the exam")
                                .location("CAMT Building")
                                .date("3rd Sept")
                                .time("3.00-4.00 pm.")
                                .petsAllowed(false)
                                .build());
               tempEvent.setOrganizer(org1);
               tempEvent.setParticipants(List.of(p1, p2, p3));
        p1.getEventHistory().add(tempEvent);
        p2.getEventHistory().add(tempEvent);
        p3.getEventHistory().add(tempEvent);
        org1.getOwnEvents().add(tempEvent);
               tempEvent = eventRepository.save(Event.builder()
                                .category("Academic")
                                .title("Commencement Day")
                                .description("A time for celebration")
                                .location("CMU Convention hall")
                                .date("21th Jan")
                                .time("8.00am-4.00 pm.")
                                .petsAllowed(false)
                                .build());
                tempEvent.setOrganizer(org1);
                tempEvent.setParticipants(List.of( p2, p3, p4));
                p2.getEventHistory().add(tempEvent);
                p3.getEventHistory().add(tempEvent);
                p4.getEventHistory().add(tempEvent);
                org1.getOwnEvents().add(tempEvent);

                tempEvent = eventRepository.save(Event.builder()
                                .category("Cultural")
                                .title("Loy Krathong")
                                .description("A time for Krathong")
                                .location("Ping River")
                                .date("21th Nov")
                                .time("8.00-10.00 pm.")
                                .petsAllowed(false)
                                .build());
                tempEvent.setOrganizer(org2);
                tempEvent.setParticipants(List.of( p3, p4, p5));
                p3.getEventHistory().add(tempEvent);
                p4.getEventHistory().add(tempEvent);
                p5.getEventHistory().add(tempEvent);
                org2.getOwnEvents().add(tempEvent);
                tempEvent = eventRepository.save(Event.builder()
                                .category("Cultural")
                                .title("Songkran")
                                .description("Let's Play Water")
                                .location("Chiang Mai Moat")
                                .date("13th April")
                                .time("10.00am - 6.00 pm.")
                                .petsAllowed(true)
                                .build());
                tempEvent.setOrganizer(org3);
                tempEvent.setParticipants(List.of( p1, p2, p3));
                p1.getEventHistory().add(tempEvent);
                p2.getEventHistory().add(tempEvent);
                p3.getEventHistory().add(tempEvent);
                org3.getOwnEvents().add(tempEvent);
                orgRepository.save(Org.builder()
                                .name("CMU")
                                .address("239 Huay Kaew Rd., Muang District, Chiang Mai 50200")
                                .build());
                orgRepository.save(Org.builder()
                                .name("CAMT")
                                .address("abc 4L")
                                .build());
                orgRepository.save(Org.builder()
                                .name("X")
                                .address("abc 1L")
                                .build());
                 orgRepository.save(Org.builder()
                                 .name("N")
                                 .address("abc 2L")
                                 .build());

            }



}


