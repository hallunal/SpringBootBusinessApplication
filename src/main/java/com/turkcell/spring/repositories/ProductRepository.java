package com.turkcell.spring.repositories;

import com.turkcell.spring.entities.concretes.Product;
import com.turkcell.spring.entities.dtos.product.ProductForGetByIdDto;
import com.turkcell.spring.entities.dtos.product.ProductForListingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Short> {

    //Derived
    //findByProductNameContaining,girilen değer product tablosu içinde varsa getir.
    List<Product> findByProductNameContaining(String productName);

    //findByUnitPriceGreaterThan,verilen fiyatın üzerindekileri getir
    List<Product> findByUnitPriceGreaterThan(float unitPrice);

    //findByUnitsInStockLessThan, belirli bir stok miktarının altında bulunan ürünleri getirmek için
    List<Product> findByUnitsInStockLessThan(short unitsInStock);
    Product findByProductName(String productName);

    @Query(value = "Select new com.turkcell.spring.entities.dtos.product.ProductForListingDto" +
            "(p.productId,p.productName,p.unitPrice,p.quantityPerUnit,p.unitsInStock,p.unitsOnOrder,p.discontinued,od.quantity,od.discount) " +
            "from Product p Inner join p.orderDetails od")
    List<ProductForListingDto> getAllForListing();


    @Query(value = "Select new com.turkcell.spring.entities.dtos.product.ProductForGetByIdDto" +
            "(p.productId,p.unitPrice,p.productName,p.quantityPerUnit,p.unitsInStock,p.unitsOnOrder,p.reorderLevel) " +
            "from Product p Where p.productId = :productId")
    ProductForGetByIdDto getForById(short productId);

    @Query(value = "SELECT p FROM Product p Order By p.productName Desc", nativeQuery = false)
    List<Product> findByProductOrderByProductNameDesc();

    //findProductsOutOfStock,stokta bulunmayan ürünleri getirmek için
    @Query(value = "SELECT p FROM Product p WHERE p.unitsInStock = 0", nativeQuery = false)
    List<Product> findProductsOutOfStock();

    //findProductsByPriceRange,belirli bir fiyat aralığına düşen ürünleri getirmek için
    @Query(value = "SELECT p FROM Product p WHERE p.unitPrice BETWEEN :deger1 and :deger2", nativeQuery = false)
    List<Product> findProductsByUnitPriceRange(float deger1,float deger2);

    @Query(value = "Select * from products Where discontinued = 1  ",nativeQuery = true)
    List<Product> findProductsByDiscontinuedTrueNativeSQL();

    //findProductsByUnitsOnOrderNativeSql,girilen sayı kadar siparişte olan ürünleri getir.
    @Query(value = "Select * from products Where units_on_order = :unitsOnOrder",nativeQuery = true)
    List<Product> findProductsByUnitsOnOrderNativeSql(short unitsOnOrder);

    @Query(value = "Select * from products Where unit_price > 100",nativeQuery = true)
    List<Product> findProductsByUnitPriceGreaterThan100();
}
