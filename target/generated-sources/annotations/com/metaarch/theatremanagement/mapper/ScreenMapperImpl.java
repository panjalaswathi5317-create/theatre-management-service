package com.metaarch.theatremanagement.mapper;

import com.metaarch.theatremanagement.dto.request.ScreenRequest;
import com.metaarch.theatremanagement.dto.response.ScreenResponse;
import com.metaarch.theatremanagement.entity.Screen;
import com.metaarch.theatremanagement.entity.Theatre;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-02T12:22:57+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class ScreenMapperImpl implements ScreenMapper {

    @Override
    public Screen toEntity(ScreenRequest request) {
        if ( request == null ) {
            return null;
        }

        Screen screen = new Screen();

        screen.setScreenName( request.getScreenName() );
        screen.setScreenType( request.getScreenType() );
        screen.setTotalSeats( request.getTotalSeats() );
        screen.setStatus( request.getStatus() );

        return screen;
    }

    @Override
    public void updateEntity(ScreenRequest request, Screen screen) {
        if ( request == null ) {
            return;
        }

        if ( request.getScreenName() != null ) {
            screen.setScreenName( request.getScreenName() );
        }
        if ( request.getScreenType() != null ) {
            screen.setScreenType( request.getScreenType() );
        }
        if ( request.getTotalSeats() != null ) {
            screen.setTotalSeats( request.getTotalSeats() );
        }
        if ( request.getStatus() != null ) {
            screen.setStatus( request.getStatus() );
        }
    }

    @Override
    public ScreenResponse toResponse(Screen screen) {
        if ( screen == null ) {
            return null;
        }

        ScreenResponse screenResponse = new ScreenResponse();

        screenResponse.setTheatreId( screenTheatreId( screen ) );
        screenResponse.setId( screen.getId() );
        screenResponse.setScreenName( screen.getScreenName() );
        screenResponse.setScreenType( screen.getScreenType() );
        screenResponse.setTotalSeats( screen.getTotalSeats() );
        screenResponse.setStatus( screen.getStatus() );
        screenResponse.setLayoutId( screen.getLayoutId() );

        return screenResponse;
    }

    private Long screenTheatreId(Screen screen) {
        if ( screen == null ) {
            return null;
        }
        Theatre theatre = screen.getTheatre();
        if ( theatre == null ) {
            return null;
        }
        Long id = theatre.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
