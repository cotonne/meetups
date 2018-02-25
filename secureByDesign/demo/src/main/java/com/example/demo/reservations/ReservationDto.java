package com.example.demo.reservations;

public class ReservationDto {
    public Long getIdDvd() {
        return idDvd;
    }

    public void setIdDvd(Long idDvd) {
        this.idDvd = idDvd;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    private Long idDvd;

    private Long idUser;
    private Long quantity;

}
