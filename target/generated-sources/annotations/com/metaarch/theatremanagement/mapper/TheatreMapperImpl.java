package com.metaarch.theatremanagement.mapper;

import com.metaarch.theatremanagement.dto.request.TheatreAddressRequest;
import com.metaarch.theatremanagement.dto.request.TheatreRequest;
import com.metaarch.theatremanagement.dto.response.ScreenResponse;
import com.metaarch.theatremanagement.dto.response.TheatreAddressResponse;
import com.metaarch.theatremanagement.dto.response.TheatreResponse;
import com.metaarch.theatremanagement.entity.Screen;
import com.metaarch.theatremanagement.entity.Theatre;
import com.metaarch.theatremanagement.entity.TheatreAddress;
import com.metaarch.theatremanagement.enums.FacilityType;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-02T12:22:57+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class TheatreMapperImpl implements TheatreMapper {

    @Autowired
    private ScreenMapper screenMapper;

    @Override
    public Theatre toEntity(TheatreRequest request) {
        if ( request == null ) {
            return null;
        }

        Theatre theatre = new Theatre();

        theatre.setName( request.getName() );
        theatre.setDescription( request.getDescription() );
        theatre.setContactNumber( request.getContactNumber() );
        theatre.setContactEmail( request.getContactEmail() );
        theatre.setStatus( request.getStatus() );
        Set<FacilityType> set = request.getFacilities();
        if ( set != null ) {
            theatre.setFacilities( new LinkedHashSet<FacilityType>( set ) );
        }

        return theatre;
    }

    @Override
    public void updateEntity(TheatreRequest request, Theatre theatre) {
        if ( request == null ) {
            return;
        }

        if ( request.getName() != null ) {
            theatre.setName( request.getName() );
        }
        if ( request.getDescription() != null ) {
            theatre.setDescription( request.getDescription() );
        }
        if ( request.getContactNumber() != null ) {
            theatre.setContactNumber( request.getContactNumber() );
        }
        if ( request.getContactEmail() != null ) {
            theatre.setContactEmail( request.getContactEmail() );
        }
        if ( request.getStatus() != null ) {
            theatre.setStatus( request.getStatus() );
        }
        if ( theatre.getFacilities() != null ) {
            Set<FacilityType> set = request.getFacilities();
            if ( set != null ) {
                theatre.getFacilities().clear();
                theatre.getFacilities().addAll( set );
            }
        }
        else {
            Set<FacilityType> set = request.getFacilities();
            if ( set != null ) {
                theatre.setFacilities( new LinkedHashSet<FacilityType>( set ) );
            }
        }
    }

    @Override
    public TheatreAddress toAddressEntity(TheatreAddressRequest request) {
        if ( request == null ) {
            return null;
        }

        TheatreAddress theatreAddress = new TheatreAddress();

        theatreAddress.setAddressLine1( request.getAddressLine1() );
        theatreAddress.setAddressLine2( request.getAddressLine2() );
        theatreAddress.setCity( request.getCity() );
        theatreAddress.setState( request.getState() );
        theatreAddress.setCountry( request.getCountry() );
        theatreAddress.setPincode( request.getPincode() );
        theatreAddress.setLatitude( request.getLatitude() );
        theatreAddress.setLongitude( request.getLongitude() );

        return theatreAddress;
    }

    @Override
    public void updateAddressEntity(TheatreAddressRequest request, TheatreAddress address) {
        if ( request == null ) {
            return;
        }

        if ( request.getAddressLine1() != null ) {
            address.setAddressLine1( request.getAddressLine1() );
        }
        if ( request.getAddressLine2() != null ) {
            address.setAddressLine2( request.getAddressLine2() );
        }
        if ( request.getCity() != null ) {
            address.setCity( request.getCity() );
        }
        if ( request.getState() != null ) {
            address.setState( request.getState() );
        }
        if ( request.getCountry() != null ) {
            address.setCountry( request.getCountry() );
        }
        if ( request.getPincode() != null ) {
            address.setPincode( request.getPincode() );
        }
        if ( request.getLatitude() != null ) {
            address.setLatitude( request.getLatitude() );
        }
        if ( request.getLongitude() != null ) {
            address.setLongitude( request.getLongitude() );
        }
    }

    @Override
    public TheatreAddressResponse toAddressResponse(TheatreAddress address) {
        if ( address == null ) {
            return null;
        }

        TheatreAddressResponse theatreAddressResponse = new TheatreAddressResponse();

        theatreAddressResponse.setId( address.getId() );
        theatreAddressResponse.setAddressLine1( address.getAddressLine1() );
        theatreAddressResponse.setAddressLine2( address.getAddressLine2() );
        theatreAddressResponse.setCity( address.getCity() );
        theatreAddressResponse.setState( address.getState() );
        theatreAddressResponse.setCountry( address.getCountry() );
        theatreAddressResponse.setPincode( address.getPincode() );
        theatreAddressResponse.setLatitude( address.getLatitude() );
        theatreAddressResponse.setLongitude( address.getLongitude() );

        return theatreAddressResponse;
    }

    @Override
    public TheatreResponse toResponse(Theatre theatre) {
        if ( theatre == null ) {
            return null;
        }

        TheatreResponse theatreResponse = new TheatreResponse();

        theatreResponse.setId( theatre.getId() );
        theatreResponse.setName( theatre.getName() );
        theatreResponse.setDescription( theatre.getDescription() );
        theatreResponse.setContactNumber( theatre.getContactNumber() );
        theatreResponse.setContactEmail( theatre.getContactEmail() );
        theatreResponse.setStatus( theatre.getStatus() );
        Set<FacilityType> set = theatre.getFacilities();
        if ( set != null ) {
            theatreResponse.setFacilities( new LinkedHashSet<FacilityType>( set ) );
        }
        theatreResponse.setAddress( toAddressResponse( theatre.getAddress() ) );
        theatreResponse.setScreens( screenSetToScreenResponseSet( theatre.getScreens() ) );
        theatreResponse.setCreatedAt( theatre.getCreatedAt() );
        theatreResponse.setUpdatedAt( theatre.getUpdatedAt() );

        return theatreResponse;
    }

    protected Set<ScreenResponse> screenSetToScreenResponseSet(Set<Screen> set) {
        if ( set == null ) {
            return null;
        }

        Set<ScreenResponse> set1 = new LinkedHashSet<ScreenResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Screen screen : set ) {
            set1.add( screenMapper.toResponse( screen ) );
        }

        return set1;
    }
}
