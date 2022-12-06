
package exam.rent.server.service;

import exam.rent.server.exception.*;

import javax.jws.WebService;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@WebService(endpointInterface = "exam.rent.server.service.Server")
public class ServerImpl implements Server {

    Map<Integer, Integer> registry = new HashMap<Integer, Integer>();

    private Integer random() {
        Random random = new Random();
        int min = 10;
        int max = 100;
        return random.nextInt(max - min + 1) + min;
    }

    @Override
    public Integer getClientIdentifier(String clientName, String customerName) {
        System.out.println("Client Name: " + clientName);
        System.out.println("Customer Name: " + customerName);
        return random();
    }

    @Override
    public Integer getDesktopId(String address) {
        System.out.println("Desktop Address: " + address);
        return random();
    }

    @Override
    public Boolean registerRental(Integer rentingClientId, Integer officeId) {

        if (registry.containsKey(officeId)) {
            return false;
        }
        registry.put(officeId, rentingClientId);
        return true;
    }

    @Override
    public void registerHandover(Integer rentingCustomerId, Integer rentedOfficeId)
            throws CustomException {
        
        if (!registry.containsKey(rentedOfficeId)) {
            throw new CustomException("Office Not Yet Registered");
        } else {
            Integer customerId = registry.get(rentedOfficeId);
            if (customerId.intValue() != rentingCustomerId.intValue()) {
                throw new CustomException("Office Does Not Register To The Given Customer");
            } 
        }
    }
}

