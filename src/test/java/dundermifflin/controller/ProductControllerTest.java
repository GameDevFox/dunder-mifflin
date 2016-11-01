package dundermifflin.controller;

import dundermifflin.bean.LocalProduct;
import dundermifflin.bean.Product;
import dundermifflin.bean.TargetProduct;
import dundermifflin.service.LocalProductService;
import dundermifflin.service.TargetProductService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductControllerTest {

    @Test
    public void testGet() {
        // Setup
        TargetProductService targetMock = Mockito.mock(TargetProductService.class);
        LocalProductService localMock = Mockito.mock(LocalProductService.class);
        ProductController productController = new ProductController(targetMock, localMock);

        TargetProduct targetProduct = buildDummyTargetProduct();
        when(targetMock.getTargetProduct("12345")).thenReturn(targetProduct);

        LocalProduct localProduct = buildDummyLocalProduct();
        when(localMock.get("12345")).thenReturn(localProduct);

        // Test
        Product product = productController.get("12345");

        // Verify
        assertThat(product.getId()).isEqualTo("12345");
        assertThat(product.getName()).isEqualTo("targetName");
        assertThat(product.getBasePrice()).isEqualTo(12.34f);
        assertThat(product.getPageUrl()).isEqualTo("pageUrl");
        assertThat(product.getImageUrl()).isEqualTo("imageUrl");
        assertThat(product.getPrice()).isEqualTo(56.78f);
        assertThat(product.getRating()).isEqualTo(1.23f);
    }

    @Test
    public void testPut() {
        // Setup
        TargetProductService targetMock = Mockito.mock(TargetProductService.class);
        LocalProductService localMock = Mockito.mock(LocalProductService.class);
        ProductController productController = new ProductController(targetMock, localMock);

        Product product = buildDummyProduct();

        // Test
        productController.put("11111", product);

        // Verify
        ArgumentCaptor<LocalProduct> arg = ArgumentCaptor.forClass(LocalProduct.class);
        verify(localMock).save(arg.capture());

        LocalProduct localProduct = arg.getValue();
        assertThat(localProduct.getId()).isEqualTo("11111");
        assertThat(localProduct.getPrice()).isEqualTo(54.32f);
        assertThat(localProduct.getRating()).isEqualTo(3.21f);
    }

    private TargetProduct buildDummyTargetProduct() {
        TargetProduct targetProduct = new TargetProduct();
        targetProduct.setId("12345");
        targetProduct.setName("targetName");
        targetProduct.setPrice(12.34f);
        targetProduct.setPageUrl("pageUrl");
        targetProduct.setImageUrl("imageUrl");
        return targetProduct;
    }

    private LocalProduct buildDummyLocalProduct() {
        LocalProduct localProduct = new LocalProduct();
        localProduct.setId("12345");
        localProduct.setPrice(56.78f);
        localProduct.setRating(1.23f);
        return localProduct;
    }

    private Product buildDummyProduct() {
        Product product = new Product();
        product.setId("56789");
        product.setName("name");
        product.setBasePrice(98.76f);
        product.setPageUrl("page");
        product.setImageUrl("image");
        product.setPrice(54.32f);
        product.setRating(3.21f);
        return product;
    }
}
