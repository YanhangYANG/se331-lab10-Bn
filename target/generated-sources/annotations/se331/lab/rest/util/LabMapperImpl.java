package se331.lab.rest.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.EventDTO;
import se331.lab.rest.entity.EventOrganizerDTO;
import se331.lab.rest.entity.EventParticipantDTO;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.OrganizerDTO;
import se331.lab.rest.entity.OrganizerOwnEventsDTO;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.entity.ParticipantDTO;
import se331.lab.rest.entity.ParticipantOwnEventsDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-12T11:21:50+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class LabMapperImpl implements LabMapper {

    @Override
    public EventDTO getEventDto(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDTO.EventDTOBuilder eventDTO = EventDTO.builder();

        eventDTO.id( event.getId() );
        eventDTO.title( event.getTitle() );
        eventDTO.description( event.getDescription() );
        eventDTO.location( event.getLocation() );
        eventDTO.date( event.getDate() );
        eventDTO.time( event.getTime() );
        eventDTO.petsAllowed( event.getPetsAllowed() );
        eventDTO.organizer( organizerToEventOrganizerDTO( event.getOrganizer() ) );
        eventDTO.participants( participantListToEventParticipantDTOList( event.getParticipants() ) );

        return eventDTO.build();
    }

    @Override
    public List<EventDTO> getEventDto(List<Event> events) {
        if ( events == null ) {
            return null;
        }

        List<EventDTO> list = new ArrayList<EventDTO>( events.size() );
        for ( Event event : events ) {
            list.add( getEventDto( event ) );
        }

        return list;
    }

    @Override
    public OrganizerDTO getOrganizerDto(Organizer organizer) {
        if ( organizer == null ) {
            return null;
        }

        OrganizerDTO.OrganizerDTOBuilder organizerDTO = OrganizerDTO.builder();

        organizerDTO.id( organizer.getId() );
        organizerDTO.name( organizer.getName() );
        organizerDTO.ownEvents( eventListToOrganizerOwnEventsDTOList( organizer.getOwnEvents() ) );

        return organizerDTO.build();
    }

    @Override
    public List<OrganizerDTO> getOrganizerDto(List<Organizer> organizers) {
        if ( organizers == null ) {
            return null;
        }

        List<OrganizerDTO> list = new ArrayList<OrganizerDTO>( organizers.size() );
        for ( Organizer organizer : organizers ) {
            list.add( getOrganizerDto( organizer ) );
        }

        return list;
    }

    @Override
    public List<ParticipantDTO> getParticipantDto(List<Participant> participants) {
        if ( participants == null ) {
            return null;
        }

        List<ParticipantDTO> list = new ArrayList<ParticipantDTO>( participants.size() );
        for ( Participant participant : participants ) {
            list.add( getParticipantDto( participant ) );
        }

        return list;
    }

    @Override
    public ParticipantDTO getParticipantDto(Participant participant) {
        if ( participant == null ) {
            return null;
        }

        ParticipantDTO.ParticipantDTOBuilder participantDTO = ParticipantDTO.builder();

        participantDTO.id( participant.getId() );
        participantDTO.name( participant.getName() );
        participantDTO.telNo( participant.getTelNo() );
        participantDTO.eventHistory( eventListToParticipantOwnEventsDTOList( participant.getEventHistory() ) );

        return participantDTO.build();
    }

    protected EventOrganizerDTO organizerToEventOrganizerDTO(Organizer organizer) {
        if ( organizer == null ) {
            return null;
        }

        EventOrganizerDTO.EventOrganizerDTOBuilder eventOrganizerDTO = EventOrganizerDTO.builder();

        eventOrganizerDTO.id( organizer.getId() );
        eventOrganizerDTO.name( organizer.getName() );

        return eventOrganizerDTO.build();
    }

    protected EventParticipantDTO participantToEventParticipantDTO(Participant participant) {
        if ( participant == null ) {
            return null;
        }

        EventParticipantDTO.EventParticipantDTOBuilder eventParticipantDTO = EventParticipantDTO.builder();

        eventParticipantDTO.id( participant.getId() );
        eventParticipantDTO.name( participant.getName() );
        eventParticipantDTO.telNo( participant.getTelNo() );

        return eventParticipantDTO.build();
    }

    protected List<EventParticipantDTO> participantListToEventParticipantDTOList(List<Participant> list) {
        if ( list == null ) {
            return null;
        }

        List<EventParticipantDTO> list1 = new ArrayList<EventParticipantDTO>( list.size() );
        for ( Participant participant : list ) {
            list1.add( participantToEventParticipantDTO( participant ) );
        }

        return list1;
    }

    protected OrganizerOwnEventsDTO eventToOrganizerOwnEventsDTO(Event event) {
        if ( event == null ) {
            return null;
        }

        OrganizerOwnEventsDTO.OrganizerOwnEventsDTOBuilder organizerOwnEventsDTO = OrganizerOwnEventsDTO.builder();

        organizerOwnEventsDTO.id( event.getId() );
        organizerOwnEventsDTO.category( event.getCategory() );
        organizerOwnEventsDTO.title( event.getTitle() );
        organizerOwnEventsDTO.description( event.getDescription() );
        organizerOwnEventsDTO.location( event.getLocation() );
        organizerOwnEventsDTO.date( event.getDate() );
        organizerOwnEventsDTO.time( event.getTime() );
        organizerOwnEventsDTO.petsAllowed( event.getPetsAllowed() );
        List<Participant> list = event.getParticipants();
        if ( list != null ) {
            organizerOwnEventsDTO.participants( new ArrayList<Participant>( list ) );
        }

        return organizerOwnEventsDTO.build();
    }

    protected List<OrganizerOwnEventsDTO> eventListToOrganizerOwnEventsDTOList(List<Event> list) {
        if ( list == null ) {
            return null;
        }

        List<OrganizerOwnEventsDTO> list1 = new ArrayList<OrganizerOwnEventsDTO>( list.size() );
        for ( Event event : list ) {
            list1.add( eventToOrganizerOwnEventsDTO( event ) );
        }

        return list1;
    }

    protected ParticipantOwnEventsDTO eventToParticipantOwnEventsDTO(Event event) {
        if ( event == null ) {
            return null;
        }

        ParticipantOwnEventsDTO.ParticipantOwnEventsDTOBuilder participantOwnEventsDTO = ParticipantOwnEventsDTO.builder();

        participantOwnEventsDTO.id( event.getId() );
        participantOwnEventsDTO.category( event.getCategory() );
        participantOwnEventsDTO.title( event.getTitle() );
        participantOwnEventsDTO.description( event.getDescription() );
        participantOwnEventsDTO.location( event.getLocation() );
        participantOwnEventsDTO.date( event.getDate() );
        participantOwnEventsDTO.time( event.getTime() );

        return participantOwnEventsDTO.build();
    }

    protected List<ParticipantOwnEventsDTO> eventListToParticipantOwnEventsDTOList(List<Event> list) {
        if ( list == null ) {
            return null;
        }

        List<ParticipantOwnEventsDTO> list1 = new ArrayList<ParticipantOwnEventsDTO>( list.size() );
        for ( Event event : list ) {
            list1.add( eventToParticipantOwnEventsDTO( event ) );
        }

        return list1;
    }
}
