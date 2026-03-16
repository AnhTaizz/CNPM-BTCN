package com.tai.code.entity.ticketing;

import java.math.BigDecimal;

import com.tai.code.entity.catalog.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "invoice_item",

        uniqueConstraints = {
                // Ràng buộc: Tránh cùng 1 sản phẩm bị lặp dòng trong 1 hoá đơn
                @UniqueConstraint(name = "uk_invoice_item_product", columnNames = {"invoice_id", "product_id"})
        }
)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id; // Dùng BigInt theo thiết kế

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="invoice_id", nullable=false, insertable=false, updatable=false)
    Invoice invoice;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id", insertable=false, updatable=false)
    Product product;

    @Column(name = "quantity", nullable = false)
    Integer quantity;

    @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    BigDecimal unitPrice;
}
