package rentcar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rentcar.dao.BookingDataDAO;
import rentcar.data.BookingData;
import rentcar.data.BranchData;
import rentcar.data.CarData;
import rentcar.data.CarTypeData;
import rentcar.dto.BookingDataDTO;
import rentcar.utils.BookingDatesConverter;

import java.util.List;
import java.util.Set;

@Service
public class BookingDataService {

    @Autowired
    BookingDataDAO bookingDataDAO;

    public List<CarData> getCarDataFromBookingInterval(BookingData bookingData)
    {
        return bookingDataDAO.getCarDataFromBookingInterval(bookingData);
    }

    public List<CarTypeData> getAllCarTypesData(List<CarData> excludedCarDatas)
    {
        return bookingDataDAO.getAllCarTypesData(excludedCarDatas);
    }

    public boolean setBooking(BookingData bookingData)
    {

        return bookingDataDAO.setBooking(bookingData);
    }

    public List<BranchData> getAllBranches()
    {
        return bookingDataDAO.getAllBranches();
    }
}
