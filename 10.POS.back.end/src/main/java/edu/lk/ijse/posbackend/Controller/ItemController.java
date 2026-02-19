package edu.lk.ijse.posbackend.Controller;

import edu.lk.ijse.posbackend.Service.ItemService;
import edu.lk.ijse.posbackend.dto.ItemDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<String> saveItem(@RequestBody @Valid ItemDTO itemDTO) {
        itemService.saveItem(itemDTO);
        return ResponseEntity.ok("Item Saved Successfully!");
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getItems() {
        return ResponseEntity.ok(itemService.getItems());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable String id) {
        itemService.deleteItemById(id);
        return ResponseEntity.ok("Item Deleted Successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateItem(@PathVariable String id,
                                             @RequestBody @Valid ItemDTO itemDTO) {

        itemDTO.setItemId(id);
        itemService.updateItem(itemDTO);
        return ResponseEntity.ok("Item Updated Successfully!");
    }
}
