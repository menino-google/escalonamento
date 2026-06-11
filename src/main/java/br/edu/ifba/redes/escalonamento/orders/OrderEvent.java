package br.edu.ifba.redes.escalonamento.orders;

public record OrderEvent(Long orderId, Long userId, Long productId) {
}