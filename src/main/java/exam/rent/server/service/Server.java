package exam.rent.server.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import exam.rent.server.exception.*;

@WebService
public interface Server {

    @WebMethod
    Integer getClientIdentifier(@WebParam(name = "ClientName") String clientName,
                            @WebParam(name = "CustomerName") String customerName);

    @WebMethod
    Integer getDesktopId(@WebParam(name = "Address") String address);

    @WebMethod
    Boolean registerRental(@WebParam(name = "RentingClientId") Integer rentingClientId,
                              @WebParam(name = "OfficeId") Integer officeId);

    @WebMethod
    void registerHandover(@WebParam(name = "RentingCustomerId") Integer rentingCustomerId,
                              @WebParam(name = "RentedOfficeId") Integer rentedOfficeId)
            throws CustomException;
}

