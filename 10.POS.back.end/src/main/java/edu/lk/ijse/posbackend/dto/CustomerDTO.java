package edu.lk.ijse.posbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CustomerDTO {
    @NotNull
    private String id;
    @NotBlank(message = "Name cannot be blank")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Customer name is incorrect!")
    private String name;
  @NotBlank
    private String address;
  @Size(min = 10, max = 100,message = "min 10 max 100")
    private String phone;

    public CustomerDTO(String id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
