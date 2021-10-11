package TMSserver.Services;

import TMSserver.DAO.ComputersDAO;
import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.SQL.Entities.ComputerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComputersService {
    private final ComputersDAO computersDAO;

    public List<ComputerDTO> findAll() {
        return new ArrayList<>(computersDAO.findAll());
    }

    public void save(ComputerDTO computerDTO) {
        computersDAO.save(computerDTO);
    }


    public void deleteAll() {
        computersDAO.deleteAll();
    }


}
