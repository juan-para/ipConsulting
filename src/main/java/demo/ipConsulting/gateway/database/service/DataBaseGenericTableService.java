package demo.ipConsulting.gateway.database.service;

import demo.ipConsulting.gateway.database.repository.DataBaseGenericTableRepository;
import demo.ipConsulting.model.dataBase.DataBaseGenericTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DataBaseGenericTableService {

    @Autowired
    private DataBaseGenericTableRepository repository;

    public List<DataBaseGenericTable> retrieveAllBlockedIPs() {
        List<DataBaseGenericTable> blockedIPs = new ArrayList<>();
        for (DataBaseGenericTable adressIP : repository.findAll()) {
            if (adressIP.isBlocked()){
                blockedIPs.add(adressIP);
            }
        }
        return blockedIPs;
    }

    public DataBaseGenericTable findByIP(String ip) {
        for (DataBaseGenericTable adressIP : repository.findAll()) {
            if (adressIP.getIp().equals(ip)){
                return adressIP;
            }
        }
        return null;
    }

    public DataBaseGenericTable save(DataBaseGenericTable dataBaseGenericTable) {
        return repository.save(dataBaseGenericTable);
    }

    public DataBaseGenericTable updateData(DataBaseGenericTable dataBaseGenericTable) {
        Optional<DataBaseGenericTable> temporal = repository.findById(dataBaseGenericTable.getId());
        if(!temporal.isPresent()){
            return null;
        }
        repository.delete(temporal.get());
        return repository.save(dataBaseGenericTable);
    }
}
