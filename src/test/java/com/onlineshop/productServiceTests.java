package com.onlineshop;

import com.onlineshop.model.product;
import com.onlineshop.repository.ProductRepository;
import com.onlineshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class productServiceTests {

  @Mock
  private ProductRepository productRepository;
  @InjectMocks
  private ProductService productService;
  private product product;

  @BeforeEach
  public void setup() {
    product = product.builder().id("0001").name("Shirts").price(200L).availabilityStock(10).categoryid(1).deliveryTime(10).description("Shirts for women").enabled(true).build();
  }

  // Junit test for saveProduct method
  @DisplayName("saveProduct")
  @Test
  public void saveProductTest() {

    given(productRepository.save(product)).willReturn(product);

    product savedProduct = productService.createProduct(product);
    assertThat(savedProduct).isNotNull();
  }

  @DisplayName("getProduct")
  @Test
  public void getProductTest() {
    given(productRepository.findAll()).willReturn(List.of(product));
    List<product> products = productService.findAll();
    assertThat(products).isNotNull();
  }

  /* @DisplayName("updateProduct")
  @Test
  public void updateProductTest(){

    given(productRepository.save(product)).willReturn(product);
    String productID=product.getId();
  //  List<product> productRepositoryById= productService.findAll();
   // String pID= productRepositoryById.stream().map(p -> p.getId()).toString();
    product.setDescription("Formal shirts");
    product updatedProduct = productService.updateProduct(product,productID) ;
    assertThat(updatedProduct.getDescription()).contains("Formal") ;
  }
*/
}