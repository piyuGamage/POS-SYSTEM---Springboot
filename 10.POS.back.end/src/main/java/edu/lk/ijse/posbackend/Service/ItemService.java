package edu.lk.ijse.posbackend.Service;

import edu.lk.ijse.posbackend.dto.ItemDTO;
import java.util.List;

public interface ItemService {

    void saveItem(ItemDTO itemDTO);

    List<ItemDTO> getItems();

    void deleteItemById(String id);

    void updateItem(ItemDTO itemDTO);
}
