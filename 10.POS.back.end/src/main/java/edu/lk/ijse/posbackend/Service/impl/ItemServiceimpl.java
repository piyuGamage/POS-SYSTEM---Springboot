package edu.lk.ijse.posbackend.Service.impl;

import edu.lk.ijse.posbackend.Entity.Item;
import edu.lk.ijse.posbackend.Service.ItemService;
import edu.lk.ijse.posbackend.dto.ItemDTO;
import edu.lk.ijse.posbackend.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceimpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        itemRepository.save(
                modelMapper.map(itemDTO, Item.class)
        );
    }

    @Override
    public List<ItemDTO> getItems() {
        return itemRepository.findAll()
                .stream()
                .map(item -> modelMapper.map(item, ItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteItemById(String id) {
        itemRepository.deleteById(id);
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {

        if (itemRepository.existsById(itemDTO.getItemId())) {

            itemRepository.save(
                    modelMapper.map(itemDTO, Item.class)
            );

        } else {
            throw new RuntimeException("Item not found!");
        }
    }
}
