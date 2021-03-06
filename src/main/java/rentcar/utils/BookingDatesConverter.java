package rentcar.utils;

import org.springframework.stereotype.Service;
import rentcar.data.BookingData;
import rentcar.dto.BookingDataDTO;

@Service
public class BookingDatesConverter {

    public BookingData convertBookingDataDatesDTOtoData (BookingDataDTO bookingDataDTO)
    {
        BookingData bookingData = new BookingData();
        bookingData.setBookingDate(bookingDataDTO.getBookingDate());
        bookingData.setReturnDate(bookingDataDTO.getReturnDate());
        bookingData.setCustomer(bookingDataDTO.getCustomer());
        bookingData.setCar(bookingDataDTO.getCar());
        bookingData.setAgency(bookingDataDTO.getBranchData().getAgency());
        return bookingData;
    }
}
